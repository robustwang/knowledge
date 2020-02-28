package com.robustwang.example.core.singleton;

public class SingletonObjectl {

    private static final SingletonObjectl instance = new SingletonObjectl();

    private SingletonObjectl() {

    }

    public static SingletonObjectl getInstance() {
        return instance;
    }

}
