package com.example.ch04.exception;

public class ThrowExample {
    void validAge(int age) {
        if(age<19)
            throw new ArithmeticException("술은 안됨!");
        else
            System.out.println("술 구매 됨");
    }

    public static void main(String[] args) {
        ThrowExample obj = new ThrowExample();
        obj.validAge(13);
        System.out.println("end");
    }
}
