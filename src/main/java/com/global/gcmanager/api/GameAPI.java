package com.global.gcmanager.api;

import com.global.gcmanager.model.Game;
import com.global.gcmanager.service.GCMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@CrossOrigin(exposedHeaders="Access-Control-Allow-Origin")
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


    @GetMapping(value = "getGames")
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

    @PostMapping(value = "addGameDirectory")
    public ResponseEntity<List<Game>> addGameDirectory(@RequestBody String dir) throws Exception{
        List<Game> list = null;
        try{
            //list = gcmService.processGames(gcmService.findFiles(dir));
            list = gcmService.addMultipleGames(dir);
            //return new ResponseEntity<String>(":)", HttpStatus.OK);
            ResponseEntity<List<Game>> response = new ResponseEntity<List<Game>>(list, HttpStatus.OK);
            return response;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ":(");
        }
    }

    @PostMapping(value = "removeGame")
    public ResponseEntity<String> removeGame(@RequestBody Game game) throws Exception {
        try{
            String gameID = gcmService.removeGame(game);
            ResponseEntity<String> response = new ResponseEntity<String>(gameID, HttpStatus.OK);
            return response;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ":(");
        }
    }

    @PostMapping(value = "removeMultipleGame")
    public ResponseEntity<String> removeMultipleGame(@RequestBody List games) throws Exception {
        try{
            String gameID = gcmService.removeMultipleGames(games);
            ResponseEntity<String> response = new ResponseEntity<String>(gameID, HttpStatus.OK);
            return response;
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ":(");
        }
    }
}
