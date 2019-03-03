package com.example.soundcloud.play_detail;

import com.example.soundcloud.BasePresenter;
import com.example.soundcloud.BaseView;
import com.example.soundcloud.data.model.CurrentPlayMode;

public interface PlayDetailContract {
    interface View extends BaseView<Presenter> {
        void updateSeekBar();

        void updateArtwork(String url);

        void updateSongInfo(String title, String artist);

        void updateMediaControlButton(int id);

        void updateDuration(String total, String current);
    }

    interface Presenter extends BasePresenter {
        void setCurrentPlayMode(CurrentPlayMode playMode);

        CurrentPlayMode getCurrentPlayMode();

        String convertTime(int time);
    }
}
