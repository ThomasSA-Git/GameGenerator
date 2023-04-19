package com.example.gamegenerator.api;


import com.example.gamegenerator.dto.GameResponse;
import com.example.gamegenerator.entity.GameInfo;
import com.example.gamegenerator.service.GameService;
import com.example.gamegenerator.service.ImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/game-idea")
public class GameController {

    private GameService gameService;
    private ImageService imageService;

    public GameController(GameService gameService, ImageService imageService) {
        this.gameService = gameService;
        this.imageService = imageService;
    }

    @GetMapping("/create")
    public GameInfo createGame() {
        return gameService.createGameInfo();
    }

    @GetMapping("/get/{id}")
    public GameInfo getGame(@PathVariable Long id) {
        return gameService.getGameInfo(id);
    }

    @GetMapping("/get-all")
    public List<GameInfo> getAllGames() {
        return gameService.getAllGameInfo();
    }

    @GetMapping("/image-generator/{prompt}")
    public byte[] getImage(@PathVariable String prompt){
        return imageService.generateImage(prompt);
    }
}
