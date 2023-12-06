
package com.robustwang.example.strategy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.LoggerFactory;

@Component
public class DefaultChannelProcessor extends AbstractChannelProcessor {

    private static final Logger logger = LoggerFactory.getLogger(DefaultChannelProcessor.class);

    @PostConstruct
    @Override
    public void init() {
        channelProcessorFactory.register(this);
    }

    @Override
    public boolean validateChannel(String channel) {
        return Stream.of("a", "b", "c").collect(Collectors.toList()).contains(channel);
    }

}
