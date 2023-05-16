package WordSearch;

import java.util.ArrayList;
import java.util.Scanner;

/**********************************************
 * @author Nathaniel Clark, Jhonder, Megan    *
 * @version 1.0                               *
 * @since May 2023                            *
 * GetWords - gets user input for words       *
 **********************************************/

public class GetWords {
    /**************************************************
     * @param s A user inputed string                 *
     * @return true if string is a number, else false *
     *************************************************/
    private static boolean integerCheck(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return Integer.parseInt(s) > 0;
    }

    /******************************************************
     * Gets user input for words they want in word search *
     * @return ArrayList of words                         *
     ******************************************************/
    public static ArrayList<String> setWords(){
        //ArrayList to store words
        ArrayList<String> wordList = new ArrayList<>();
        //number of words that will be in list
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
        //while n words not entered
        while (numWordsInputed != n){
            System.out.print("Please enter a word: ");
            p1 = scr.nextLine(); //get a string
            validWord = true;
            //check if word is valid
            for (String word : wordList){
                if (p1.equalsIgnoreCase(word)){
                    validWord = false;
                    System.out.println("Invalid input, there can't be duplicate words.");
                }
            }
            //prevents words with only 1 and 2 letters
            if (p1.length() < 3){
                validWord = false;
                System.out.println("Invalid input, words have to be at least 3 letters long.");
            }
            //make sure word is not already in the word search
            for (int j = 0; j < p1.length(); j++) {
                if (!Character.isLetter(p1.charAt(j))){
                    validWord = false;
                    System.out.println("Invalid input, words have to be at least 3 letters and words can only have letters from A-Z.");
                    break;
                }
            }
            //if word passed all the logic check then it is valid and add it to the list
            if (validWord == true) {
                wordList.add(p1.toUpperCase());
                numWordsInputed++;
            }
        }
        scr.close();
        return wordList;
    }

}
