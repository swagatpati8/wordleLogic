package com.wordle.Wordle.model;

public class Game {
    private String word;
    private int currentTries;
    private int currentTime;

    public Game(String word, int currentTries) {
        this.word = word;
        this.currentTries = currentTries;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public int getCurrentTries() {
        return currentTries;
    }

    public void setCurrentTries(int currentTries) {
        this.currentTries = currentTries;
    }

}
