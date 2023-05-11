import java.util.ArrayList;
import WordSearch.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words = GetWords.setWords();
        WordSearchMaker wordSearch = new WordSearchMaker(words);
        wordSearch.makeWordSearch();
        wordSearch.printBoard();
        new WordSearchDisplay(wordSearch.getBoard());
    }
}