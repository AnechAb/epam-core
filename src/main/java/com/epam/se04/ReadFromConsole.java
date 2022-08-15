package com.epam.se04;

import java.io.*;

public class ReadFromConsole {

    public static void main(String[] args) throws IOException {
        InputStream in = System.in;

        InputStreamReader inputStreamReader = new InputStreamReader(in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        System.out.println(bufferedReader.readLine());
        System.out.println(bufferedReader.readLine());
        System.out.println(bufferedReader.readLine());
    }
}
