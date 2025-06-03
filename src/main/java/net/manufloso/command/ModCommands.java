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

    // Define tus claves de traducción aquí para facilitar su gestión
    private static final String LANG_PREFIX = "commands.supermodreborn.money.";

    private static final String MSG_GET_MONEY_SUCCESS = LANG_PREFIX + "get.success";
    private static final String MSG_SET_MONEY_SUCCESS = LANG_PREFIX + "set.success";
    private static final String MSG_ADD_MONEY_SUCCESS = LANG_PREFIX + "add.success";
    private static final String MSG_REMOVE_MONEY_SUCCESS = LANG_PREFIX + "remove.success";
    private static final String MSG_REMOVE_MONEY_FAILURE_NOT_ENOUGH = LANG_PREFIX + "remove.failure.not_enough";
    private static final String MSG_CHECK_MONEY_SUCCESS_HAS_ENOUGH = LANG_PREFIX + "check.success.has_enough";
    private static final String MSG_CHECK_MONEY_SUCCESS_NOT_ENOUGH = LANG_PREFIX + "check.success.not_enough";


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
                                        .then(Commands.argument("value", IntegerArgumentType.integer()) // Argument for integer value
                                                .executes(context -> addPlayerMoney(context.getSource(),
                                                        EntityArgument.getPlayer(context, "player"),
                                                        IntegerArgumentType.getInteger(context, "value")))))
                        )
                        .then(Commands.literal("remove")
                                .then(Commands.argument("player", EntityArgument.player()) // Argument for player
                                        .then(Commands.argument("value", IntegerArgumentType.integer()) // Argument for integer value
                                                .executes(context -> removePlayerMoney(context.getSource(),
                                                        EntityArgument.getPlayer(context, "player"),
                                                        IntegerArgumentType.getInteger(context, "value")))))
                        )
                        .then(Commands.literal("check")
                                .then(Commands.argument("player", EntityArgument.player()) // Argument for player
                                        .then(Commands.argument("value", IntegerArgumentType.integer()) // Argument for integer value
                                                .executes(context -> checkPlayerMoney(context.getSource(),
                                                        EntityArgument.getPlayer(context, "player"),
                                                        IntegerArgumentType.getInteger(context, "value")))))
                        )
                )
        );
    }

    private static int getPlayerMoney(CommandSourceStack source, ServerPlayer player) {
        int money = ModDataComponents.getMoney(player);
        source.sendSuccess(() -> Component.translatable(MSG_GET_MONEY_SUCCESS, player.getDisplayName(), money), false); // false: don't broadcast to other ops
        return 1;
    }

    private static int setPlayerMoney(CommandSourceStack source, ServerPlayer player, int value) {
        ModDataComponents.setMoney(player, value);
        source.sendSuccess(() -> Component.translatable(MSG_SET_MONEY_SUCCESS, player.getDisplayName(), value), true); // true: notify other ops
        return 1;
    }

    private static int addPlayerMoney(CommandSourceStack source, ServerPlayer player, int value) {
        ModDataComponents.addMoney(player, value);
        int newBalance = ModDataComponents.getMoney(player);
        source.sendSuccess(() -> Component.translatable(MSG_ADD_MONEY_SUCCESS, value, player.getDisplayName(), newBalance), true);
        return 1;
    }

    private static int removePlayerMoney(CommandSourceStack source, ServerPlayer player, int valueToRemove) {
        int result = ModDataComponents.removeMoney(player, valueToRemove);
        int currentMoney = ModDataComponents.getMoney(player);
        if(result == 0){
            source.sendFailure(Component.translatable(MSG_REMOVE_MONEY_FAILURE_NOT_ENOUGH, player.getDisplayName(), currentMoney, valueToRemove));
            return 0;
        }
        source.sendSuccess(() -> Component.translatable(MSG_REMOVE_MONEY_SUCCESS, valueToRemove, player.getDisplayName(), currentMoney), true);
        return 1; // Success
    }

    private static int checkPlayerMoney(CommandSourceStack source, ServerPlayer player, int valueToCheck) {
        int result = ModDataComponents.checkMoney(player, valueToCheck);
        int currentMoney = ModDataComponents.getMoney(player);
        if (result == 1) {
            source.sendSuccess(() -> Component.translatable(MSG_CHECK_MONEY_SUCCESS_HAS_ENOUGH, player.getDisplayName(), currentMoney, valueToCheck), false);
        } else {
            source.sendSuccess(() -> Component.translatable(MSG_CHECK_MONEY_SUCCESS_NOT_ENOUGH, player.getDisplayName(), currentMoney, valueToCheck), false);
        }
        return 1; // The command itself (performing the check and reporting) executed successfully.
    }
}