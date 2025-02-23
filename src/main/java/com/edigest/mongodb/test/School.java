package com.edigest.mongodb.test;

public class School {

    public static School instance;

    private School() {

    }

    public static School getInstance() {
        if (instance != null) {
            return instance;
        }
        return new School();
    }
}
