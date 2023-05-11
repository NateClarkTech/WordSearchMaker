package WordSearch;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Random;


public class WordSearchMaker {
    private ArrayList<String> words;
    private ArrayList<ArrayList<Character>> board;

    public WordSearchMaker(){
        this.words = new ArrayList<String>();
        this.board = new ArrayList<ArrayList<Character>>();
    }

    public WordSearchMaker(ArrayList<String> words){
        this.words = new ArrayList<String>();
        this.words.addAll(words);
        this.board = new ArrayList<ArrayList<Character>>();
    }

    public ArrayList<String> getWords(){
        return words;
    }

    public ArrayList<ArrayList<Character>> getBoard(){
        return this.board;
    }

    public void setWords(ArrayList<String> words){
        this.words = new ArrayList<String>(words);
    }

    private ArrayList<ArrayList<Character>> deepCopy(ArrayList<ArrayList<Character>> board) {
        ArrayList<ArrayList<Character>> copy = new ArrayList<ArrayList<Character>>();
        for (ArrayList<Character> list : board) {
            copy.add(new ArrayList<>(list));
        }
        //printBoard(copy);
        return copy;
    }

    private boolean insertWord(String word, ArrayList<ArrayList<Character>> board, int direction, int x, int y){
        System.out.println("X: " + x + " Y: " + y + " RANDINT: " + direction);
        switch (direction) {
            case 0 -> {
                for (int i = 0; i < word.length(); i++) {
                    if ((x < board.get(0).size()) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        board.get(y).set(x, word.charAt(i));
                        x++;
                    } else {

                        System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            case 1 -> {
                for (int i = 0; i < word.length(); i++) {
                    if (((x < board.get(0).size()) && y < board.size()) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        board.get(y).set(x, word.charAt(i));
                        x++;
                        y++;
                    } else {
                        System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            case 2 -> {
                for (int i = 0; i < word.length(); i++) {
                    if ((y < board.size()) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        board.get(y).set(x, word.charAt(i));
                        y++;
                    } else {
                        System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            case 3 -> {
                for (int i = 0; i < word.length(); i++) {
                    if ((x > -1 && y < board.size()) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        board.get(y).set(x, word.charAt(i));
                        x--;
                        y++;
                    } else {
                        System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            case 4 -> {
                for (int i = 0; i < word.length(); i++) {
                    if ((x > -1) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        board.get(y).set(x, word.charAt(i));
                        x--;
                    } else {
                        System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            case 5 -> {
                for (int i = 0; i < word.length(); i++) {
                    if ((x > -1 && y > -1) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        board.get(y).set(x, word.charAt(i));
                        x--;
                        y--;
                    } else {
                        System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            case 6 -> {
                for (int i = 0; i < word.length(); i++) {
                    if ((y > -1) && ((board.get(y).get(x) == '1') || board.get(y).get(x).equals(word.charAt(i)))) {
                        board.get(y).set(x, word.charAt(i));
                        y--;
                    } else {
                        System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            case 7 -> {
                for (int i = 0; i < word.length(); i++) {
                    if ((x < board.get(0).size() && y > -1) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        board.get(y).set(x, word.charAt(i));
                        x++;
                        y--;
                    } else {
                        System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    private void findPlaceForWord() {
        String currentWord;
        boolean wordInserted = false;
        Random rand = new Random(Clock.systemUTC().millis());
        int randInt;
        int randX;
        int randY;
        int counter;
        ArrayList<ArrayList<Character>> boardCopy = new ArrayList<ArrayList<Character>>();
        for (int i = 0; i < words.size(); i++) {
            randInt = rand.nextInt(0, 9);
            randX = rand.nextInt(0, this.board.get(0).size());
            randY = rand.nextInt(0, this.board.size());
            counter = 0;
            currentWord = words.get(i);
            while (!wordInserted) {
                boardCopy = deepCopy(this.board);
                wordInserted = insertWord(currentWord, boardCopy, randInt, randX, randY);
                counter += 1;
                randInt = (randInt + 1) % 8;
                if (counter == 8){
                    randX = rand.nextInt(0, this.board.get(0).size());
                    randY = rand.nextInt(0, this.board.size());
                    counter = 0;
                }
            }
            wordInserted = false;
            board = deepCopy(boardCopy);
        }
    }

    private void findPlaceForWord(ArrayList<String> words) {
        String currentWord;
        boolean wordInserted = false;
        Random rand = new Random(Clock.systemUTC().millis());
        int randInt;
        int randX;
        int randY;
        int counter;
        ArrayList<ArrayList<Character>> boardCopy = new ArrayList<ArrayList<Character>>();
        for (int i = 0; i < words.size(); i++) {
            currentWord = words.get(i);
            randInt = rand.nextInt(0, 9);
            randX = rand.nextInt(0, this.board.get(0).size());
            randY = rand.nextInt(0, this.board.size());
            counter = 0;
            while (!wordInserted) {
                boardCopy = deepCopy(this.board);
                wordInserted = insertWord(currentWord, boardCopy, randInt, randX, randY);
                counter += 1;
                randInt = (randInt + 1) % 8;
                if (counter == 8) {
                    randX = rand.nextInt(0, this.board.get(0).size());
                    randY = rand.nextInt(0, this.board.size());
                }
            }
            wordInserted = false;
            board = deepCopy(boardCopy);
        }
    }

    public void makeWordSearch() {
        wordSearchBoardSize();

        findPlaceForWord();

        insertRandomLetters();
    }
    public void makeWordSearch(ArrayList<String> words) {
        wordSearchBoardSize(words);

        findPlaceForWord(words);

        insertRandomLetters();
    }

    private char getRandomLetter(){
        Random rand = new Random();
        int randomNum = rand.nextInt(26);
        return (char) (randomNum + 65);
    }

    private void insertRandomLetters(){
        for (ArrayList<Character> characters : board) {
            for (int j = 0; j < characters.size(); j++) {
                if (characters.get(j) == '1')
                    characters.set(j, getRandomLetter());
            }
        }
    }

    public void printBoard() {
        for (ArrayList<Character> characters : board) {
            for (Character character : characters) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }

    public void printBoard(ArrayList<ArrayList<Character>> board) {
        for (ArrayList<Character> characters : board) {
            for (Character character : characters) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }

    private void wordSearchBoardSize(){
        int lenOfLargestWord = 0;
        this.board = new ArrayList<ArrayList<Character>>();

        for (String word : words) {
            if (lenOfLargestWord < word.length()) {
                lenOfLargestWord = word.length();
            }
        }

        for (int i = 0; i < lenOfLargestWord * 2; i++){
            this.board.add(new ArrayList<Character>());
            for (int j = 0; j < lenOfLargestWord * 2; j++){
                this.board.get(i).add('1');
            }
        }
    }
    private void wordSearchBoardSize(ArrayList<String> words){
        int lenOfLargestWord = 0;
        this.board = new ArrayList<ArrayList<Character>>();

        for (String word : words) {
            if (lenOfLargestWord < word.length()) {
                lenOfLargestWord = word.length();
            }
        }

        for (int i = 0; i < lenOfLargestWord * 2; i++){
            this.board.add(new ArrayList<Character>());
            for (int j = 0; j < lenOfLargestWord * 2; j++){
                this.board.get(i).add('1');
            }
        }
    }
}
