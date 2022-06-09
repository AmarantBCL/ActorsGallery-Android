package com.example.android.actorsgallery;

import android.net.Uri;

public class Actor {
    private String name;
    private Uri thumbnail;
    private Uri photo;
    private String desc;

    public String getName() {
        return name;
    }

    public Uri getThumbnail() {
        return thumbnail;
    }

    public Uri getPhoto() {
        return photo;
    }

    public String getDesc() {
        return desc;
    }

    public Actor(String name, Uri thumbnail, Uri photo, String desc) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.photo = photo;
        this.desc = desc;
    }
}
