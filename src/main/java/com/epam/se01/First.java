package com.epam.se01;

import java.util.Arrays;

public class First {
	public static void main(String[] args){
//        for (int i = 0; i < args.length; ++i) {
//            System.out.println(args[i]);
//        }
        for (String arg : args) {
            if (arg.length() > 2){ //императивный стиль
                System.out.println(arg);
            }
        }

//        Thread.sleep(10_000); кидает InterruptException
	}
}
