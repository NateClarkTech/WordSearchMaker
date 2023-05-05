import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<String>();
        words.add("HELLO");
        words.add("GAMERS");
        WordSearchMaker wordSearch = new WordSearchMaker(words);
        wordSearch.makeWordSearch();
        wordSearch.printBoard();
        System.out.println();
        wordSearch.makeWordSearch(words);
        wordSearch.printBoard();
    }
}