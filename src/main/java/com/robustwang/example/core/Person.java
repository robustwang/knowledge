package com.robustwang.example.core;

public abstract class Person {

    protected void runTest() {
        System.out.println("p");
    }

    public static void main(String[] args) {
        Person p = new Person(){
            @Override
            protected void runTest() {
                System.out.println("p");
            }
        };
        p.runTest();


        Person p1  = new Employ();
        p1.runTest();

        Person p2 = new Teacher();
        p2.runTest();

    }

}
