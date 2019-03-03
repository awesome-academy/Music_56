package com.example.soundcloud.data.model;

import android.support.annotation.IntDef;

import static com.example.soundcloud.data.model.ShuffleMode.SHUFFLE_OFF;
import static com.example.soundcloud.data.model.ShuffleMode.SHUFFLE_ON;

@IntDef({SHUFFLE_ON, SHUFFLE_OFF})
public @interface ShuffleMode {
    int SHUFFLE_ON = 1;
    int SHUFFLE_OFF = 0;
}
