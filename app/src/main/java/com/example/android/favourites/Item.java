package com.example.android.favourites;

/**
 * Created by Darshan AS on 13-12-2017.
 */

public class Item {
    private String title;
    private String info;
    private int imageResourceId = NO_RESOURCE_PROVIDED;
    private int audioResourceId = NO_RESOURCE_PROVIDED;
    private String url;

    static final int NO_RESOURCE_PROVIDED = -1;

    public Item(String title, String storyline, int imageResourceId, String trailerUrl) {
        this.title = title;
        this.info = storyline;
        this.imageResourceId = imageResourceId;
        this.url = trailerUrl;
    }

    public Item(String title, int imageResourceId, int audioResourceId, String songUrl) {
        this.title = title;
        this.imageResourceId = imageResourceId;
        this.audioResourceId = audioResourceId;
        this.url = songUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getUrl() {
        return url;
    }

    public int getAudioResourceId() {
        return audioResourceId;
    }
}
