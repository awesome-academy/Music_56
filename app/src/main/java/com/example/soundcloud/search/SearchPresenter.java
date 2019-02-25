package com.example.soundcloud.search;

import com.example.soundcloud.data.model.Genre;
import com.example.soundcloud.data.model.History;
import com.example.soundcloud.data.model.Song;
import com.example.soundcloud.data.source.SearchHistoryDataSource;
import com.example.soundcloud.data.source.SearchHistoryRepository;
import com.example.soundcloud.data.source.SongDataSource;
import com.example.soundcloud.data.source.SongRepository;

import java.util.ArrayList;
import java.util.List;

public class SearchPresenter implements SearchContract.Presenter {
    private static final int LIMIT = 50;
    private static final String LIMIT_12 = "12";
    private static final String GENRE = "SEARCH";
    private static final String MSG_SAVED = "Saved data success";
    private static final String MSG_CLEARED = "Clear data success!";
    private SearchHistoryRepository mHistoryRepository;
    private SearchContract.View mView;
    private SongRepository mSearchSongRepository;
    private List<History> mSearchHistories;
    private List<History> mRecentSearch;
    private String searchKey;
    private Genre mGenre;
    private boolean mIsAdding;

    public SearchPresenter(SearchHistoryRepository searchHistoryRepository,
                           SearchContract.View view,
                           SongRepository searchSongRepository) {
        mHistoryRepository = searchHistoryRepository;
        mView = view;
        mSearchSongRepository = searchSongRepository;
        mRecentSearch = new ArrayList<>();
    }

    @Override
    public void loadHistorySearch(String limit) {
        mHistoryRepository.getHistories( limit,
                new SearchHistoryDataSource.HistorySearchCallback() {
                    public void onSuccess(List<History> searchHistories) {
                        mSearchHistories = searchHistories;
                        mView.showSearchHistory(searchHistories);
                    }

                    @Override
                    public void onFailed(Exception e) {
                        mView.showError(e.getMessage());
                    }
                });
    }

    @Override
    public void loadSearchResult(String searchKey) {
        mSearchSongRepository.searchSong(searchKey, LIMIT,
                new SongDataSource.LoadSongCallback() {
                    @Override
                    public void onSongsLoaded(List<Song> songs) {
                        mView.showProgressBar(false);
                        mView.showSearchResult(songs);
                        mGenre = new Genre(GENRE, songs);
                    }

                    @Override
                    public void onDataNotAvailable(Exception e) {
                        mView.showProgressBar(false);
                        mView.showError(e.getMessage());
                    }
                });
    }

    @Override
    public void saveRecentSearch() {
        mHistoryRepository.saveHistories(mRecentSearch,
                new SearchHistoryDataSource.CallBack() {
                    @Override
                    public void onSuccess() {
                        mView.showSuccess(MSG_SAVED);
                    }

                    @Override
                    public void onFailed(Exception e) {
                        mView.showError(e.getMessage());
                    }
                });
    }

    @Override
    public void clearSearchHistory() {
        mHistoryRepository.clearHistories(
                new SearchHistoryDataSource.CallBack() {
                    @Override
                    public void onSuccess() {
                        mSearchHistories.clear();
                        mView.showSearchHistory(mSearchHistories);
                    }

                    @Override
                    public void onFailed(Exception e) {
                        mView.showError(e.getMessage());
                    }
                });
    }

    @Override
    public void start() {
        loadHistorySearch(LIMIT_12);
    }

    @Override
    public List<History> getSearchHistories() {
        return mSearchHistories;
    }

    @Override
    public void addSearchKey(History searchHistory) {
        mSearchHistories.add(searchHistory);
    }

    @Override
    public void addSearchKey(History searchHistory, boolean isAdding) {
        if (isAdding) {
            mRecentSearch.add(searchHistory);
            mSearchHistories.add(searchHistory);
        }
    }

    @Override
    public Genre getGenre() {
        return mGenre;
    }

    @Override
    public void onQueryTextSubmit(String query) {
        setSearchKey(query);
        loadSearchResult(query);
        addSearchKey(new History(query), mIsAdding);
        mView.showProgressBar(true);
    }

    @Override
    public String getSearchKey() {
        return searchKey;
    }

    @Override
    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    @Override
    public void setAddSearchKey(boolean isAdding){
        mIsAdding = isAdding;
    }
}
