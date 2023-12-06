package com.robustwang.example.strategy;

public interface ChannelProcessor {

    void queryTest(String args);


    void init();

    boolean validateChannel(String channel);
}
