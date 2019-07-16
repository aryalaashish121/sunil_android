package com.example.football_club_app.model;

public class News {
    private String title1;
    private String date;
    private String imgfiles;

    public News(String title1, String date, String imgfiles) {

        this.title1 = title1;
        this.date = date;
        this.imgfiles = imgfiles;
    }

    public String getTitle() {
        return title1;
    }

    public void setTitle(String title1) {
        this.title1 = title1;
    }

    public String getImageName() {
        return imgfiles;
    }

    public void setImageName(String imgfiles) {
        this.imgfiles = imgfiles;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
