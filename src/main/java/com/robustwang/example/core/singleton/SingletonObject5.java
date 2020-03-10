package com.robustwang.example.core.singleton;

public class SingletonObject5 {

    private static volatile  SingletonObject5 instance;

    private SingletonObject5(){

    }

    public static SingletonObject5 getInstance(){

        if(instance == null){
            synchronized (SingletonObject5.class){
                if(instance == null){
                    instance = new SingletonObject5();
                }
            }
        }
        return instance;
    }

}
