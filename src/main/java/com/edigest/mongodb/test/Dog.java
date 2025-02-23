package com.edigest.mongodb.test;

public class Dog extends Animal{
    public Dog(){
        System.out.println("Dog Constructor called....");
    }
    @Override
    public void sayHello() {
        System.out.println("Hello");
    }
}
