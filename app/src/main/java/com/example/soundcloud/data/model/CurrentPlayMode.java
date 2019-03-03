package com.example.soundcloud.data.model;

public class CurrentPlayMode {
    private int mLoopMode;
    private int mShuffleMode;
    private int mFavoriteMode;
    private int mDownloadMode;

    public CurrentPlayMode() {
    }

    public CurrentPlayMode(int loopMode, int shuffleMode, int favoriteMode, int downloadMode) {
        mLoopMode = loopMode;
        mShuffleMode = shuffleMode;
        mFavoriteMode = favoriteMode;
        mDownloadMode = downloadMode;
    }

    public int getLoopMode() {
        return mLoopMode;
    }

    public void setLoopMode(@LoopMode int loopMode) {
        mLoopMode = loopMode;
    }

    public int getShuffleMode() {
        return mShuffleMode;
    }

    public void setShuffleMode(@ShuffleMode int shuffleMode) {
        mShuffleMode = shuffleMode;
    }

    public int getFavoriteMode() {
        return mFavoriteMode;
    }

    public void setFavoriteMode(@FavoriteMode int favoriteMode) {
        mFavoriteMode = favoriteMode;
    }

    public int getDownloadMode() {
        return mDownloadMode;
    }

    public void setDownloadMode(@DownloadMode int downloadMode) {
        mDownloadMode = downloadMode;
    }
}
