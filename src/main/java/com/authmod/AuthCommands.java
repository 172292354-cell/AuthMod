package com.authmod;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class AuthCommands {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("register")
                .then(Commands.argument("password", StringArgumentType.word())
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();
                            String password = StringArgumentType.getString(context, "password");
                            String username = player.getGameProfile().getName().toLowerCase();

                            if (password.length() < 4) {
                                player.sendSystemMessage(Component.literal("§c密码至少需要4个字符！"));
                                return 0;
                            }

                            if (AuthData.getPlayerPasswords().containsKey(username)) {
                                player.sendSystemMessage(Component.literal("§c你已经注册过了！"));
                                player.sendSystemMessage(Component.literal("§e/login <密码>"));
                                return 0;
                            }

                            AuthEventHandler.registerPlayer(username, password);
                            player.sendSystemMessage(Component.literal("§a注册成功！"));
                            player.sendSystemMessage(Component.literal("§a开始游戏吧！"));
                            return 1;
                        })
                )
        );

        dispatcher.register(Commands.literal("login")
                .then(Commands.argument("password", StringArgumentType.word())
                        .executes(context -> {
                            ServerPlayer player = context.getSource().getPlayerOrException();
                            String password = StringArgumentType.getString(context, "password");
                            String username = player.getGameProfile().getName().toLowerCase();

                            if (!AuthData.getPlayerPasswords().containsKey(username)) {
                                player.sendSystemMessage(Component.literal("§c你还没有注册！"));
                                player.sendSystemMessage(Component.literal("§e/register <密码>"));
                                return 0;
                            }

                            if (AuthEventHandler.loginPlayer(username, password)) {
                                player.sendSystemMessage(Component.literal("§a登录成功！"));
                                player.sendSystemMessage(Component.literal("§a欢迎！"));
                                return 1;
                            } else {
                                player.sendSystemMessage(Component.literal("§c密码错误！"));
                                return 0;
                            }
                        })
                )
        );
    }
}