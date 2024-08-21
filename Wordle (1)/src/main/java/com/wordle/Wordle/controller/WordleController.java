package com.wordle.Wordle.controller;

import com.wordle.Wordle.model.GuessResponse;
import com.wordle.Wordle.service.WordsService;
import com.wordle.Wordle.service.UserGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class WordleController {

    private UserGameService userGameService;
    private WordsService wordsService;

    @Autowired
    public WordleController(UserGameService userGameService, WordsService wordsService) {
        this.userGameService = userGameService;
        this.wordsService = wordsService;
    }

    @GetMapping("/startGame")
    public String startGame() {
        String word = wordsService.getRandomWords();
        System.out.println(word);
        return userGameService.addGameToDataStore(word);
    }

    @PostMapping("/submitGuess")
    public GuessResponse submitGuess(@RequestParam String guess, @RequestParam String userToken){
        return userGameService.submitGuess(guess, userToken);
    }
}
