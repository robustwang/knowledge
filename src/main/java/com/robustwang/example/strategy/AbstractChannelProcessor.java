package com.robustwang.example.strategy;

import javax.annotation.Resource;

public abstract class AbstractChannelProcessor implements ChannelProcessor {

    @Resource
    protected  ChannelProcessorFactory channelProcessorFactory;


    @Override
    public void queryTest(String args) {
        System.out.println("this is queryTest method " + args);
    }


}
