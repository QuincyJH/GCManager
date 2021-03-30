package com.global.gcmanager.dao;

import com.global.gcmanager.model.Game;

import java.util.List;

public interface GameDAO {

    public String addNewGame(Game game);

    public List<Game> getAllGames();
}
