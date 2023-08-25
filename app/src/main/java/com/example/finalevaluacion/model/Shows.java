package com.example.finalevaluacion.model;

public class Shows {
    private String url;

    private String name;

    private String season;

    public Shows(String url, String name, String season) {
        this.url = url;
        this.name = name;
        this.season = season;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }
}
