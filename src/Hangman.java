import java.util.ArrayList;

public class Hangman {
    public static void main(String[] args) {
        HangmanMechanics.printIntroduction();

        //Get a random word and put it in to a Char Array
        String wordToGuess = WordGetter.getRandomWordWithDifficultySetting();
        char[] wordToGuessInArray = wordToGuess.toCharArray();

        //Create the empty board according to length of word
        char[] wordBoard = WordGetter.getWordBoard(wordToGuess);
        ArrayList<Character> charsGuessed = new ArrayList<>();

        gameEngine(wordToGuessInArray,wordBoard,charsGuessed);
    }


    static void gameEngine(char[] wordToGuessInCharArray, char[] wordBoard,ArrayList<Character> charsGuessed){
        int wrongGuessCounter =0;

        System.out.println(wordBoard);

        while (wrongGuessCounter<6 && !HangmanMechanics.hasWon(wordBoard)){
            System.out.println("\nTake a guess: ");
            char charGuessed = UserInput.getUserInput();
            if (!charsGuessed.contains(charGuessed)){
                charsGuessed.add(charGuessed);
            }
            if (HangmanMechanics.doesWordContainGuess(wordToGuessInCharArray,charGuessed,wordBoard)){
                HangmanMechanics.fillCorrectGuess(wordToGuessInCharArray,charGuessed,wordBoard);
            } else
                wrongGuessCounter++;

            System.out.println("\n"+ HangmanMechanics.getGallowsProgress(wrongGuessCounter)+"\n");
            System.out.print("Progress: ");
            System.out.print(wordBoard);
            System.out.print("\nCharacters used: ");
            System.out.print(charsGuessed);
        }
        if (wrongGuessCounter==6){
            System.out.println("\nUnfortunately, you die💀");
        } else {
            System.out.println("\nCongratulations, you live🎉");
        }
    }









}
