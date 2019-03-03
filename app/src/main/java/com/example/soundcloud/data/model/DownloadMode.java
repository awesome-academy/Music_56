package com.example.soundcloud.data.model;

import android.support.annotation.IntDef;

import static com.example.soundcloud.data.model.DownloadMode.DOWNLOAD_ABLE;
import static com.example.soundcloud.data.model.DownloadMode.DOWNLOAD_DISABLE;

@IntDef({DOWNLOAD_ABLE, DOWNLOAD_DISABLE})
public @interface DownloadMode {
    int DOWNLOAD_ABLE = 1;
    int DOWNLOAD_DISABLE = 0;
}
