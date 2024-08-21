package com.wordle.Wordle.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class WordsService {

    private List<String> words;

    @PostConstruct
    private void loadWords() throws IOException {
        words = FileUtils.readLines(new File("src/main/resources/words.txt"), "utf-8");
    }

    public String getRandomWords() {
        Random random = new Random();
        return words.get(random.nextInt(words.size()));
    }
}
