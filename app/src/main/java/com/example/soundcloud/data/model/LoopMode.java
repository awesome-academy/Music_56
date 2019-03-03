package com.example.soundcloud.data.model;

import android.support.annotation.IntDef;

import static com.example.soundcloud.data.model.LoopMode.LOOP_ALL;
import static com.example.soundcloud.data.model.LoopMode.LOOP_NONE;
import static com.example.soundcloud.data.model.LoopMode.LOOP_ONE;

@IntDef({LOOP_NONE, LOOP_ALL, LOOP_ONE})
public @interface LoopMode {
    int LOOP_ONE = 2;
    int LOOP_ALL = 1;
    int LOOP_NONE = 0;
}
