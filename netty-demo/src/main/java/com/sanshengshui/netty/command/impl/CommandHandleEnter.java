package com.sanshengshui.netty.command.impl;

import com.sanshengshui.netty.command.CommandHandle;
import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author HCW
 * @date 2023/3/3 15:04
 * @todo
 */
public class CommandHandleEnter implements CommandHandle {
    private static final Map<String, CommandHandle> COMMAND_HANDLE_MAP = new HashMap<>(16);

    static {
        COMMAND_HANDLE_MAP.put("ptp", new PointToPointHandle());
        COMMAND_HANDLE_MAP.put("cgh", new CreateGroupHandle());
        COMMAND_HANDLE_MAP.put("lch", new LogoutCommandHandle());
        COMMAND_HANDLE_MAP.put("jgh", new JoinGroupHandle());
        COMMAND_HANDLE_MAP.put("lgm", new ListGroupMemberHandle());
        COMMAND_HANDLE_MAP.put("qgh", new QuitGroupHandle());
    }

    @Override
    public void execute(Scanner scanner, Channel channel) {
        System.out.println("Please enter command:");
        String command = scanner.nextLine();
        if (!COMMAND_HANDLE_MAP.containsKey(command)) {
            System.out.println("command error.");
            return;
        }
        COMMAND_HANDLE_MAP.get(command).execute(scanner, channel);
    }
}
