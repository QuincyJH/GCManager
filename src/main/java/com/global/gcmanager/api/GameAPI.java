package com.global.gcmanager.api;

import com.global.gcmanager.model.Game;
import com.global.gcmanager.service.GCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("GameAPI")
public class GameAPI {

    @Autowired
    private GCMService gcmService;

    @PostMapping(value = "addGame")
    public ResponseEntity<String> addGame(@RequestBody Game game) throws Exception{
        try{
            gcmService.addNewGame(game);
            return new ResponseEntity<String>(":)", HttpStatus.OK);
        }catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ":(");
        }
    }


    @PostMapping(value = "getGames")
    public ResponseEntity<List<Game>> getGames() throws Exception {
        List<Game> list = null;
        try{
            list = gcmService.getAllGames();
            ResponseEntity<List<Game>> response = new ResponseEntity<List<Game>>(list, HttpStatus.OK);
            return response;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ":(");
        }
    }



}
