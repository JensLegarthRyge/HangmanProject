import java.util.Scanner;

public class UserInput {

    public static char getUserInput() {
        //I have to make a method for this since scanners can't take only chars
        boolean verification = false;
        Scanner sc = new Scanner(System.in);
        char charToReturn='0';
        while (!verification){
            //I kept getting this annoying exception when hitting enter with no input
            //this looks bad, but it works I guess
            try {
                String stringGuessed = sc.nextLine();
                charToReturn = stringGuessed.charAt(0);
                verification=true;
            } catch (StringIndexOutOfBoundsException e){
                System.out.println("Invalid input, please try again:");
            }
        }
        return Character.toLowerCase(charToReturn);
    }
}
