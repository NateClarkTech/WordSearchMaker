import java.util.ArrayList;
import WordSearch.*;

/**********************************************
 * @author Nathaniel Clark, Jhonder, Megan
 * @version 1.0
 * @since May 2023
 * Main - uses the wordsearch maker package
 *        to make a wordsearch
 **********************************************/

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        //get words from the user
        words = GetWords.setWords();
        //make the word search board
        WordSearchMaker wordSearch = new WordSearchMaker(words);
        wordSearch.makeWordSearch();
        //print and display the board
        wordSearch.printBoard();
        //new WordSearchDisplay(wordSearch.getBoard());
        System.out.println();
        wordSearch.makeWordSearch(words);
        wordSearch.printBoard();

        new WordSearchDisplay(wordSearch.getBoard(), words);
    }
}