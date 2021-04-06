package com.global.gcmanager.dao;

import com.global.gcmanager.entity.GameEntity;
import com.global.gcmanager.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Repository(value = "GameDAO")
@Transactional
public class GameDAOImpl implements GameDAO {

    EntityManagerFactory emf;

    @Override
    public String addNewGame(Game game){
        this.startEntityManager();
        EntityManager em = this.emf.createEntityManager();

        //System.out.println("TEST 1");
        GameEntity newGame = new GameEntity();

        newGame.setFileName(game.getFileName());
        newGame.setGameID(game.getGameID());
        newGame.setGameName(game.getGameName());

        em.getTransaction().begin();
        em.persist(newGame);
        em.getTransaction().commit();

        this.closeEntityManager(em);
        return newGame.getGameID();
    }

    @Override
    public List<Game> addMultipleGames(List<Game> games){
        this.startEntityManager();
        EntityManager em = this.emf.createEntityManager();

        System.out.println(games.size());
        for (int i = 0; i < games.size(); i++) {
            System.out.println(i);
            if(!em.contains(games.get(i))){
                System.out.println("test");
                GameEntity newGame = new GameEntity();

                newGame.setFileName(games.get(i).getFileName());
                newGame.setGameID(games.get(i).getGameID());
                newGame.setGameName(games.get(i).getGameName());

                em.getTransaction().begin();
                em.persist(newGame);
            }else{
                System.out.println("already exists");
            }

        }

        em.getTransaction().commit();

        this.closeEntityManager(em);
        return this.getAllGames();
    }

    @Override
    public List<Game> getAllGames(){

        this.startEntityManager();
        EntityManager em = this.emf.createEntityManager();

        System.out.println("TEST 2");
        em.getTransaction().begin();
        Query query = em.createQuery("select g from GameEntity g");
        List<GameEntity> gameEntityList = query.getResultList();

        List<Game> Games = new ArrayList<Game>();

        for (GameEntity gameEntity : gameEntityList){
            Game game = new Game();
            game.setGameName(gameEntity.getGameName());
            game.setFileName(gameEntity.getFileName());
            game.setGameID(gameEntity.getGameID());

            Games.add(game);
        }
        this.closeEntityManager(em);
        return Games;
    }

    @Override
    public String removeGame(Game game){
        this.startEntityManager();
        EntityManager em = this.emf.createEntityManager();

        GameEntity gameEntityToRemove = null;
        gameEntityToRemove.setGameName(game.getGameName());
        gameEntityToRemove.setGameID(game.getGameID());
        gameEntityToRemove.setFileName(game.getFileName());

        em.remove(gameEntityToRemove);
        this.closeEntityManager(em);
        return game.getGameName();
    }

    @Override
    public String removeMultipleGames(List<Game> games){
        this.startEntityManager();
        EntityManager em = this.emf.createEntityManager();

        GameEntity gameEntityToRemove = null;

        for (int i = 0; i < games.size(); i++) {
            gameEntityToRemove.setGameName(games.get(i).getGameName());
            gameEntityToRemove.setGameID(games.get(i).getGameID());
            gameEntityToRemove.setFileName(games.get(i).getFileName());

            em.remove(gameEntityToRemove);
        }
        this.closeEntityManager(em);
        return games.get(0).getGameID();
    }

    public void startEntityManager(){
        this.emf = Persistence.createEntityManagerFactory("persistence");
    }

    public void closeEntityManager(EntityManager em){
        em.close();
        emf.close();
    }



}
