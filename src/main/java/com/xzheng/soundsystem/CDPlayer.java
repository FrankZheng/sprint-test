package com.xzheng.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by xzheng on 16/7/9.
 */
@Component
public class CDPlayer implements MediaPlayer {
    @Autowired
    CompatDisc cd;

    @Override
    public void play() {
        cd.play();
    }
}
