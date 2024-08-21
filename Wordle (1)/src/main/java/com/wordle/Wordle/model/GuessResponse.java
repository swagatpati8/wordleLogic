package com.wordle.Wordle.model;

import lombok.Getter;

import java.util.Map;

public class GuessResponse {

    @Getter
    private int currentTry;
    private String word;
    private GameStatus status;
    private Map<Character, CharacterValue> characterValueMap;

    public int getCurrentTry() {
        return currentTry;
    }

    public void setCurrentTry(int currentTry) {
        this.currentTry = currentTry;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public Map<Character, CharacterValue> getCharacterValueMap() {
        return characterValueMap;
    }

    public void setCharacterValueMap(Map<Character, CharacterValue> characterValueMap) {
        this.characterValueMap = characterValueMap;
    }

    public GuessResponse(int currentTry, String word, GameStatus status, Map<Character, CharacterValue> characterValueMap) {
        this.currentTry = currentTry;
        this.word = word;
        this.characterValueMap = characterValueMap;
    }
}