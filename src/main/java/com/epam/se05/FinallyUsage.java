package com.epam.se05;

public class FinallyUsage {

    public static void main(String[] args) {
        try {
            procA();
        } catch (Exception e) {
            System.out.println("���������� ���������");
        }
        System.out.println(procB());
        System.out.println(procC());
    }

    // ����� �� ������ ����� ����������
    static void procA() {
        try {
            System.out.println("������ procA");
            if (true) {
                throw new RuntimeException("demo");
            }
        } finally {
            System.out.println("finally ��� procA ");
        }
        System.out.println("procA::after try");
    }
    // ������� ������� try-�����

    static int procB() {
        try {
            System.out.println("������ procB");
            return 10;
        } finally {
            System.out.println("finally ��� procB ");
            return 20;
        }
    }

    // ���������� ���������� try-�����
    static int procC() {
        try {
            System.out.println("������ procC");
            throw new RuntimeException("demo");
        } catch (RuntimeException ex) {
            return 50;
        } finally {
            System.out.println("finally procC");
            throw new RuntimeException("demo2");
        }
    }
}
