package com.example.football_club_app.model;

public class Player {

    private String pname;
    private String game;
    private String goal;
    private String assit;
    private String imgfileplayer;

    public Player(String pname, String game, String goal, String assit, String imgfileplayer) {
        this.pname = pname;
        this.game = game;
        this.goal = goal;
        this.assit = assit;
        this.imgfileplayer = imgfileplayer;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getAssit() {
        return assit;
    }

    public void setAssit(String assit) {
        this.assit = assit;
    }

    public String getImgfileplayer() {
        return imgfileplayer;
    }

    public void setImgfileplayer(String imgfileplayer) {
        this.imgfileplayer = imgfileplayer;
    }
}
