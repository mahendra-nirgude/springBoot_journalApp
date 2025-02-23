package com.edigest.mongodb.test;

public class ThreadLambda {
    public static void main(String[] args) {
        Student student = str-> "my name is "+str;

        System.out.println(student.sayName("Mahendra"));
    }
}
