import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.LinkedHashMap;
import java.util.Map;


public class Wordle {
    private static String randomSelector() {
        String filename = "./fiveLetterWords.txt";
        String word = null;

        Random random = new Random();
        int randomLineNumber = random.nextInt(5757);
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            for (int i = 0; i <= randomLineNumber; i++) {
                word = br.readLine();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return word;
    }

    public String wordChecker(String guess, String word) {
        
        if (guess.length() != 5) {
            return "Invalid input. Please enter a five letter word.";
        }
        if (guess.equals(word)) {
            return "You guessed the word!";
        }
        String[] guessArr = new String[5];
        String[] wordArr = new String[5];
        boolean[] matched = new boolean[5];


        for (int i = 0; i < 5; i++) {
            guessArr[i] = String.valueOf(guess.charAt(i));
            wordArr[i] = String.valueOf(word.charAt(i));
        }
    
        String[] result = new String[5];
        for (int i = 0; i < 5; i++) {
            result[i] = "_";
            matched[i] = false;
        }

        for (int i = 0; i < 5; i++) {
            if (guessArr[i] != null && guessArr[i].equals(wordArr[i])) {
                result[i] = guessArr[i];
                wordArr[i] = null;
                guessArr[i] = null;
                matched[i] = true;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (guessArr[i] != null) { 
                for (int j = 0; j < 5; j++) {
                    if (wordArr[j] != null && !matched[j] && guessArr[i].equals(wordArr[j])) { // Check if wordArr[j] is not null
                        result[i] = "(" + guessArr[i] + ")";
                        matched[j] = true;
                        break; 
                    }
                }
            }
        }

        return String.join("", result);
    }


    public static void main(String[] args) {
        String randomWord = randomSelector();
        System.out.println("the word is: " + randomWord);
        Scanner scanner = new Scanner(System.in);
        String guess = "";
        Wordle wordle = new Wordle();
    
        while (!guess.equals(randomWord)) {
            System.out.println("Enter a five letter word:");
            guess = scanner.nextLine();
            String result = wordle.wordChecker(guess, randomWord);
            System.out.println(result);
            if (guess.equals(randomWord)) {
                System.out.println("Congratulations! You've guessed the word correctly.");
                break;
            }
        }
    }
}