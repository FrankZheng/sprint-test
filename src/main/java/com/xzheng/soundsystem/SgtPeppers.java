package com.xzheng.soundsystem;

import org.springframework.stereotype.Component;

/**
 * Created by xzheng on 16/7/9.
 */
@Component
public class SgtPeppers implements CompatDisc {
    private String title = "Hello World";
    private String artist = "Frank";
    @Override
    public void play() {
        System.out.println("Playing " + title + "by " + artist);
    }

    @Override
    public boolean functional() {
        return true;
    }
}
