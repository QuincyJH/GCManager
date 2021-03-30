package com.global.gcmanager.model;

import java.util.List;

public class Directory {
    private String directory;
    private List<Game> Games;

    public void setDirectory(String directory){
        this.directory = directory;
    }

    public String getDirectory(){
        return this.directory;
    }

    public void setGames(List<Game> Games){
        this.Games = Games;
    }

    public List<Game> getGames(){
        return this.Games;
    }

}
