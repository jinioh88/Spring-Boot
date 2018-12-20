package com.example.ch04.exception;

public class ThrowsExample {
    int division(int a, int b) throws ArithmeticException {
        int t = a/b;
        return t;
    }

    public static void main(String[] args) {
        ThrowsExample obj = new ThrowsExample();
        try {
            System.out.println(obj.division(15,0));
        } catch (ArithmeticException e) {
            System.out.println("0으로 못나눔!");
        }
    }
}
