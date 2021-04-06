package com.global.gcmanager.service;

import com.global.gcmanager.dao.GameDAO;
import com.global.gcmanager.model.Directory;
import com.global.gcmanager.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service(value = "GCMService")
@Transactional
public class GCMServiceImpl implements GCMService{

    @Autowired
    private GameDAO gameDAO;

    public Directory processNewDirectory(String folder) throws IOException {
        Directory dir = new Directory();
        dir.setDirectory(folder);
        File[] files = findFiles(dir.getDirectory());
        List<Game> games = this.processGames(files);
        dir.setGames(games);
        return dir;
    }

    public List<Game> addMultipleGames(String dir) throws IOException {
        System.out.println("hello");
        List<Game> games = this.processGames(this.findFiles(dir));
        for (Game game : games){
            gameDAO.addNewGame(game);
        }
        //return gameDAO.addMultipleGames(this.processGames(this.findFiles(dir)));
        return gameDAO.getAllGames();
    }

    public File[] findFiles(String dirName){
        File directory = new File(dirName);
        return directory.listFiles(new FilenameFilter(){
            public boolean accept(File directory, String filename){
                return filename.matches(".*\\.(?i)(iso|gcm)$");
            }
        });
    }

    public List<Game> processGames(File[] files) throws IOException {
        List<Game> games = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            byte[] buffer = new byte[96];
            InputStream is = new FileInputStream(files[i]);
            if(is.read(buffer) != buffer.length){

            }
            String idName = byteToString(buffer);
            Game game = new Game(files[i].getName(), idName.substring(0,6), idName.substring(32).trim());
            games.add(game);
            is.close();
        }
        return games;
    }
    
    public String byteToString(byte[] bytes){
        String idName = "";
        char[] chars = new char[96];
        for (int i = 0; i < bytes.length; i++) {
            chars[i] = (char) bytes[i];
        }
        idName = String.valueOf(chars);
        return idName;
    }

    public String addNewGame(Game game) throws Exception{
        String gameID = gameDAO.addNewGame(game);
        return gameID;
    }

    public int addGameList(List<Game> games) throws Exception{
        for(Game game : games){
            String name = addNewGame(game);
        }
        return games.size();
    }

    public List<Game> getAllGames(){
        return gameDAO.getAllGames();
    }

    public String removeGame(Game game){
        return gameDAO.removeGame(game);
    }

    public String removeMultipleGames(List<Game> games){
        return gameDAO.removeMultipleGames(games);
    }
}
