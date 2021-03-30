package com.global.gcmanager.model;

public class Game {
    private String fileName;
    private String gameID;
    private String gameName;

    public Game(){

    }

    public Game(String fileName, String gameID, String gameName){
        this.fileName = fileName;
        this.gameID = gameID;
        this.gameName = gameName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getGameID() {
        return gameID;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameName() {
        return gameName;
    }

    public String getGameNameID(){
        return "[" + getGameID() + "] " + getGameName();
    }
}