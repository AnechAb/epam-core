package com.epam.se04;

import java.io.*;

public class BufferedIOTryWithResources {

    public static void main(String[] args) {
        try {
            doIt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void doIt() throws IOException {
//        String inputFile = "C:\\Users\\Anna\\SomeFilesForTest\\chat.log";
//        String outputFile = "C:\\Users\\Anna\\SomeFilesForTest\\chatOut.log";

        try (InputStream input = new WrongInputStream();
             OutputStream output = new WrongOutputStream()) {
            int countBytes = 0;
            int current;
            while ((current = input.read()) >= 0) {
                System.out.println(current);
                output.write(current);
                ++countBytes;
            }
            System.out.println(countBytes);
        }
//      Больше не нужно:
//        InputStream input = null;
//        OutputStream output = null;
//        try {
//            input = new BufferedInputStream(new FileInputStream(inputFile));
//            output = new BufferedOutputStream(new FileOutputStream(outputFile));
//
//            int countBytes = 0;
//            int current;
//            while ((current = input.read()) >= 0) {
//                System.out.println(current);
//                output.write(current);
//                ++countBytes;
//            }
//            System.out.println(countBytes);
//        } finally {
//            try {
//                if (input != null) {
//                    input.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//                throw e;
//            }
//            try {
//                output.flush();
//            } catch (IOException ex) {
//                throw ex;
//            }
//        }
    }

    private static class WrongInputStream extends InputStream {
        @Override
        public int read() throws IOException {
            throw new IOException("WrongInputStream::read");
        }

        @Override
        public void close() throws IOException {
            System.out.println("WrongInputStream::close");
            throw new IOException("WrongInputStream::close");
        }
    }

    private static class WrongOutputStream extends OutputStream {
        @Override
        public void write(int b) throws IOException {
            throw new IOException("WrongOutputStream::write");
        }

        @Override
        public void close() throws IOException {
            System.out.println("WrongOutputStream::close");
            throw new IOException("WrongOutputStream::close");
        }
    }
}
