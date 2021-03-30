package com.global.gcmanager.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import com.global.gcmanager.model.Game;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@Rollback(true)
public class GameDAOTest {
    @Autowired
    private GameDAO gameDAO;

    @Test
    public void addNewGame(){
        Game game = new Game("007: Agent Under Fire (tm)", "GW7E69", "007: Agent Under Fire (tm)");
        gameDAO.addNewGame(game);
        Assert.isTrue(true);
    }


    @Test
    public void getAllGames(){
        List<Game> games = new ArrayList<>();
        Game game = new Game();
        games.add(game);
        games = gameDAO.getAllGames();
        for (int i = 0; i < games.size(); i++) {
            System.out.println(games.get(i));
        }
        Assert.noNullElements(gameDAO.getAllGames(), "suuc");
    }
}