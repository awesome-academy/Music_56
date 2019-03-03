package com.example.soundcloud.data.model;

import android.support.annotation.StringDef;

import static com.example.soundcloud.data.model.ActionMode.ACTION_NEXT;
import static com.example.soundcloud.data.model.ActionMode.ACTION_PAUSE;
import static com.example.soundcloud.data.model.ActionMode.ACTION_PLAY;
import static com.example.soundcloud.data.model.ActionMode.ACTION_PREV;
import static com.example.soundcloud.data.model.ActionMode.ACTION_REPEAT_ALL;
import static com.example.soundcloud.data.model.ActionMode.ACTION_REPEAT_OFF;
import static com.example.soundcloud.data.model.ActionMode.ACTION_REPEAT_ONE;
import static com.example.soundcloud.data.model.ActionMode.ACTION_RESUME;
import static com.example.soundcloud.data.model.ActionMode.ACTION_SHUFFLE_OFF;
import static com.example.soundcloud.data.model.ActionMode.ACTION_SHUFFLE_ON;
import static com.example.soundcloud.data.model.ActionMode.ACTION_STOP;

@StringDef({ACTION_PLAY, ACTION_PAUSE, ACTION_NEXT, ACTION_PREV, ACTION_RESUME, ACTION_STOP,
        ACTION_REPEAT_ONE, ACTION_REPEAT_ALL, ACTION_REPEAT_OFF, ACTION_SHUFFLE_ON, ACTION_SHUFFLE_OFF})
public @interface ActionMode {
    String ACTION_PLAY = "ACTION_PLAY";
    String ACTION_PAUSE = "ACTION_PAUSE";
    String ACTION_NEXT = "ACTION_NEXT";
    String ACTION_PREV = "ACTION_PREV";
    String ACTION_RESUME = "ACTION_RESUME";
    String ACTION_REPEAT_ONE = "ACTION_REPEAT_ONE";
    String ACTION_REPEAT_ALL = "ACTION_REPEAT_ALL";
    String ACTION_REPEAT_OFF = "ACTION_REPEAT_OFF";
    String ACTION_SHUFFLE_ON = "ACTION_SHUFFLE_ON";
    String ACTION_SHUFFLE_OFF = "ACTION_SHUFFLE_OFF";
    String ACTION_STOP = "ACTION_STOP";
}
