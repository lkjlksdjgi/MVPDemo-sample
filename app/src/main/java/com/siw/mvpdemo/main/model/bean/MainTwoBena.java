package com.siw.mvpdemo.main.model.bean;


public class MainTwoBena {

    private String name;
    private int age;

    public MainTwoBena(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "MainTwoBena{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
