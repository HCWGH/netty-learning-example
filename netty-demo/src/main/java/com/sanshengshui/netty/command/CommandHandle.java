package com.sanshengshui.netty.command;

import io.netty.channel.Channel;

import java.util.Scanner;

/**
 * @author HCW
 * @date 2023/3/3 14:53
 * @todo
 */
public interface CommandHandle {

    void execute(Scanner scanner, Channel channel);
}
