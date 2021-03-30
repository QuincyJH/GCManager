package com.global.gcmanager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="GAME_LIB")
public class GameEntity {

    @Id
    @Column(name="GAME_ID")
    private String gameID;

    @Column(name="GAME_NAME")
    private String gameName;

    @Column(name="GAME_FILE_NAME")
    private String fileName;

    public String getGameID() {
        return gameID;
    }

    public void setGameID(String gameID) {
        this.gameID = gameID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
