import java.util.ArrayList;
import java.util.Scanner;

public class GetWords {

    public static boolean integerCheck(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return Integer.parseInt(s) > 0;
    }

    public static ArrayList<String> setWords(){
        ArrayList<String> wordList = new ArrayList<>();
        int n;
        boolean intCheck = false;
        //create a new scanner
        Scanner scr = new Scanner(System.in);

        String p1 = "";
        //User sets the number of words. Exits when user inputs a number from 0-20.
        while(!intCheck) {
            System.out.print("How many words would you like in the word search? (maximum of 20): ");
            p1 = scr.nextLine();
            if (integerCheck(p1) && Integer.parseInt(p1) <= 20) {
                intCheck = true;
            } else {
                System.out.println("Invalid input, please type a number from 1-20.");
            }
        }
        n = Integer.parseInt(p1);

        //Takes in n words from the user
        System.out.println("Please enter " + n + " words.");
        int numWordsInputed = 0;
        boolean validWord;
        while (numWordsInputed != n){
            System.out.print("Please enter a word: ");
            p1 = scr.nextLine();
            validWord = true;
            if (p1.length() < 3){
                validWord = false;
                System.out.println("Invalid input, words have to be at least 3 letters and words can only have letters from A-Z.");
            }
            for (int j = 0; j < p1.length(); j++) {
                if (!Character.isLetter(p1.charAt(j))){
                    validWord = false;
                    System.out.println("Invalid input, words have to be at least 3 letters and words can only have letters from A-Z.");
                    break;
                }
            }
            if (validWord == true) {
                wordList.add(p1.toUpperCase());
                numWordsInputed++;
            }
        }


        scr.close();

        return wordList;
    }

}
