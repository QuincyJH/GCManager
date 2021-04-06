package com.global.gcmanager.dao;

import com.global.gcmanager.model.Game;

import java.util.List;

public interface GameDAO {

    public String addNewGame(Game game);

    public List<Game> addMultipleGames(List<Game> games);

    public List<Game> getAllGames();

    public String removeGame(Game game);

    public String removeMultipleGames(List<Game> games);
}
