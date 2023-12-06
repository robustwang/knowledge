package com.robustwang.example.strategy;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChannelProcessorFactory {

    private List<ChannelProcessor> processors = Lists.newLinkedList();

    public ChannelProcessor getProcessor(String channel) {
        return processors.stream().filter(i -> i.validateChannel(channel)).findAny().orElseThrow(() -> new RuntimeException());

    }

    void register(ChannelProcessor processor) {
        this.processors.add(processor);
    }
}
