package com.example.soundcloud.data.model;

import android.support.annotation.IntDef;

import static com.example.soundcloud.data.model.FavoriteMode.FAVORITE_OFF;
import static com.example.soundcloud.data.model.FavoriteMode.FAVORITE_ON;

@IntDef({FAVORITE_ON, FAVORITE_OFF})
public @interface FavoriteMode {
    int FAVORITE_ON = 1;
    int FAVORITE_OFF = 0;
}
