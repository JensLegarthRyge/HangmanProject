public class HangmanMechanics {

    public static void printIntroduction(){
        System.out.println("#####################################################");
        System.out.println("################ WELCOME TO HANGMAN #################");
        System.out.println("##### A children's game that is hauntingly dark #####");
        System.out.println("#####################################################");
        System.out.println();
        System.out.println("################ Select Difficulty ##################");
        System.out.println("Press 'H' for hard mode💀 \tPress 'E' for easy mode😌");
    }

    public static String getGallowsProgress(int wrongGuessCounter){
        String zeroLivesUsed = "  +---+\n  |   | \n      |\n      |\n      |\n      |\n=========";
        String oneLifeUsed = "  +---+\n  |   | \n  O   |\n      |\n      |\n      |\n=========";
        String twoLivesUsed = "  +---+\n  |   | \n  O   |\n  |   |\n      |\n      |\n=========";
        String threeLivesUsed = "  +---+\n  |   | \n  O   |\n /|   |\n      |\n      |\n=========";
        String fourLivesUsed = "  +---+\n  |   | \n  O   |\n /|\\  |\n      |\n      |\n=========";
        String fiveLivesUsed = "  +---+\n  |   | \n  O   |\n /|\\  |\n /    |\n      |\n=========";
        String sixLivesUsed = "  +---+\n  |   | \n  O   |\n /|\\  |\n / \\  |\n      |\n=========";
        if (wrongGuessCounter==0){
            return zeroLivesUsed;
        } else if (wrongGuessCounter==1){
            return oneLifeUsed;
        }  else if (wrongGuessCounter==2){
            return twoLivesUsed;
        } else if (wrongGuessCounter==3){
            return threeLivesUsed;
        } else if (wrongGuessCounter==4){
            return fourLivesUsed;
        } else if (wrongGuessCounter==5){
            return fiveLivesUsed;
        } else
            return sixLivesUsed;
    }

    public static boolean doesWordContainGuess(char[] wordToGuessInCharArray, char charGuessed, char[] wordBoard){
        for (int i = 0; i < wordToGuessInCharArray.length; i++) {
            if (wordToGuessInCharArray[i] == charGuessed) {
                wordBoard[i] = charGuessed;
                return true;
            }
        }
        return false;
    }

    public static boolean hasWon(char[] wordBoard){
        for (char c : wordBoard) {
            if (c == '_') {
                return false;
            }
        }
        return true;
    }

    public static void fillCorrectGuess(char[] wordToGuessInCharArray, char charGuessed, char[] wordBoard){
        for (int i = 0; i < wordToGuessInCharArray.length; i++) {
            if (wordToGuessInCharArray[i]==charGuessed){
                wordBoard[i]=charGuessed;
            }
        }
    }
}
