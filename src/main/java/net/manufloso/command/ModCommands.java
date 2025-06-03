package net.manufloso.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.manufloso.component.ModDataComponents;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class ModCommands {

    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("supermodreborn")
                .requires(source -> source.hasPermission(2)) // Requires permission level 2 (operator)
                .then(Commands.literal("money")
                        .then(Commands.literal("set")
                                .then(Commands.argument("player", EntityArgument.player()) // Argument for player
                                        .then(Commands.argument("value", IntegerArgumentType.integer()) // Argument for integer value
                                                .executes(context -> setPlayerMoney(context.getSource(),
                                                        EntityArgument.getPlayer(context, "player"),
                                                        IntegerArgumentType.getInteger(context, "value")))))
                        )
                        .then(Commands.literal("get")
                                .then(Commands.argument("player", EntityArgument.player()) // Argument for player
                                        .executes(context -> getPlayerMoney(context.getSource(),
                                                EntityArgument.getPlayer(context, "player"))))
                        )
                        .then(Commands.literal("add")
                                .then(Commands.argument("player", EntityArgument.player()) // Argument for player
                                        .then(Commands.argument("value", IntegerArgumentType.integer()) // Argument for integer value (FIXED)
                                                .executes(context -> addPlayerMoney(context.getSource(),
                                                        EntityArgument.getPlayer(context, "player"),
                                                        IntegerArgumentType.getInteger(context, "value")))))
                        )
                        .then(Commands.literal("remove")
                                .then(Commands.argument("player", EntityArgument.player()) // Argument for player
                                        .then(Commands.argument("value", IntegerArgumentType.integer()) // Argument for integer value (FIXED)
                                                .executes(context -> removePlayerMoney(context.getSource(),
                                                        EntityArgument.getPlayer(context, "player"),
                                                        IntegerArgumentType.getInteger(context, "value")))))
                        )
                        .then(Commands.literal("check")
                                .then(Commands.argument("player", EntityArgument.player()) // Argument for player
                                        .then(Commands.argument("value", IntegerArgumentType.integer()) // Argument for integer value (FIXED)
                                                .executes(context -> checkPlayerMoney(context.getSource(),
                                                        EntityArgument.getPlayer(context, "player"),
                                                        IntegerArgumentType.getInteger(context, "value")))))
                        )
                )
        );
    }

    private static int getPlayerMoney(CommandSourceStack source, ServerPlayer player) {
        int money = ModDataComponents.getMoney(player);
        source.sendSuccess(() -> Component.literal(player.getDisplayName().getString() + " has " + money + " money."), false); // false: don't broadcast to other ops
        return 1;
    }

    private static int setPlayerMoney(CommandSourceStack source, ServerPlayer player, int value) {
        ModDataComponents.setMoney(player, value);
        source.sendSuccess(() -> Component.literal("Set " + player.getDisplayName().getString() + "'s money to " + value + "."), true); // true: notify other ops
        return 1;
    }

    private static int addPlayerMoney(CommandSourceStack source, ServerPlayer player, int value) {
        ModDataComponents.addMoney(player, value);
        int newBalance = ModDataComponents.getMoney(player);
        source.sendSuccess(() -> Component.literal("Added " + value + " to " + player.getDisplayName().getString() + "'s money. New balance: " + newBalance + "."), true);
        return 1;
    }

    private static int removePlayerMoney(CommandSourceStack source, ServerPlayer player, int valueToRemove) {
        int result = ModDataComponents.removeMoney(player, valueToRemove);
        int currentMoney = ModDataComponents.getMoney(player);
        if(result == 0){
            source.sendFailure(Component.literal(player.getDisplayName().getString() + " does not have enough money. Has: " + currentMoney + ", Tried to remove: " + valueToRemove + "."));
            return 0;
        }
        source.sendSuccess(() -> Component.literal("Removed " + valueToRemove + " from " + player.getDisplayName().getString() + "'s money. New balance: " + currentMoney + "."), true);
        return 1; // Success
    }

    private static int checkPlayerMoney(CommandSourceStack source, ServerPlayer player, int valueToCheck) {
        int result = ModDataComponents.checkMoney(player, valueToCheck);
        int currentMoney = ModDataComponents.getMoney(player);
        if (result == 1) {
            source.sendSuccess(() -> Component.literal(player.getDisplayName().getString() + " has " + currentMoney + " money (requires " + valueToCheck + "). They have enough."), false);
        } else {
            source.sendSuccess(() -> Component.literal(player.getDisplayName().getString() + " has " + currentMoney + " money (requires " + valueToCheck + "). They do not have enough."), false);
        }
        return 1; // The command itself (performing the check and reporting) executed successfully.
    }
}
