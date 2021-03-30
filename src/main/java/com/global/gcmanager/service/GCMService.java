package com.global.gcmanager.service;

import com.global.gcmanager.model.Directory;
import com.global.gcmanager.model.Game;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface GCMService {

    public Directory processNewDirectory(String folder) throws IOException;

    public File[] findFiles(String dirName);

    public List<Game> processGames(File[] files) throws IOException;

    public String byteToString(byte[] bytes);

    public String addNewGame(Game game) throws Exception;

    public List<Game> getAllGames();

    public int addGameList(List<Game> games) throws Exception;
}
