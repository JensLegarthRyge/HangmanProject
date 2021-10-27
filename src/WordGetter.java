import java.io.*;
import java.util.*;

public class WordGetter {

    public static String getRandomWordWithDifficultySetting(){
        char userChoice = UserInput.getUserInput();
        String randomWord = getRandomWord();

        if (userChoice=='e'){
            while(randomWord.length()>5){
                randomWord=getRandomWord();
            }
        } else if (userChoice=='h'){
            while (randomWord.length()<=5){
                randomWord=getRandomWord();
            }
        }
        return randomWord;
    }

    public static char[] getWordBoard(String wordToGuess){
        //Creates new char array which by default is loaded with underscores
        char[] wordProgress = new char[wordToGuess.length()];
        Arrays.fill(wordProgress, '_');
        return wordProgress;
    }

    private static String getRandomWord(){
        Random random = new Random();
        File wordListRaw = new File("src/hangman-words.rtf");
        ArrayList<String> wordList = new ArrayList<>();
        try {
            Scanner sc = new Scanner(wordListRaw);
            while (sc.hasNextLine()){
                wordList.add(sc.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int randomIndexFromWordList = random.nextInt(wordList.size()-1);
        String randomWordFromList = wordList.get(randomIndexFromWordList);
        return stringNeat(randomWordFromList);
    }

    private static String stringNeat(String wordToNeatify) {
        return wordToNeatify.replace("\\", "");
    }
}
