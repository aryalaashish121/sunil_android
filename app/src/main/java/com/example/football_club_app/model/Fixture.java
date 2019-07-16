package com.example.football_club_app.model;

public class Fixture {
    private String place;
    private String date;
    private String score;
    private String match;

    public Fixture(String place, String date, String score, String match) {
        this.place = place;
        this.date = date;
        this.score = score;
        this.match = match;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }
}
