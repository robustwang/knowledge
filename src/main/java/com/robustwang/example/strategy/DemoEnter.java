package com.robustwang.example.strategy;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DemoEnter {

    @Resource
    private ChannelProcessorFactory channelProcessorFactory;

    public void testStreat(){

        channelProcessorFactory.getProcessor("a").queryTest("hello world");
    }
}
