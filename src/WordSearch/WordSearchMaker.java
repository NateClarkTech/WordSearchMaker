package WordSearch;

import java.time.Clock;
import java.util.ArrayList;
import java.util.Random;

/**************************************************************
 * @author Nathaniel Clark, Jhonder, Megan                    *
 *  @version 1.0                                              *
 *  @since May 2023                                           *
 *  WordSearchMaker - a program that takes a list             *
 *                    of words then gives a wordsearch        *
 *                    board with the words randomly inserted  *
 **************************************************************/

public class WordSearchMaker {
    private ArrayList<String> words;
    private ArrayList<ArrayList<Character>> board;
    //Constructors
    public WordSearchMaker(){
        this.words = new ArrayList<String>();
        this.board = new ArrayList<ArrayList<Character>>();
    }

    public WordSearchMaker(ArrayList<String> words){
        this.words = new ArrayList<String>();
        this.words.addAll(words);
        this.board = new ArrayList<ArrayList<Character>>();
    }
    //getters and setters
    public ArrayList<String> getWords(){
        return words;
    }
    public ArrayList<ArrayList<Character>> getBoard(){
        return this.board;
    }
    public void setWords(ArrayList<String> words){
        this.words = new ArrayList<String>(words);
    }

    /**********************************************************
     * Makes a deep copy of an ArrayList<ArrayList<Character>>*
     * @param board 2D ArrayList of Characters to be copied   *
     * @return copy of input                                  *
     *********************************************************/
    private ArrayList<ArrayList<Character>> deepCopy(ArrayList<ArrayList<Character>> board) {
        ArrayList<ArrayList<Character>> copy = new ArrayList<ArrayList<Character>>();
        for (ArrayList<Character> list : board) {
            copy.add(new ArrayList<>(list));
        }
        //printBoard(copy);
        return copy;
    }

    /****************************************************************************
     * Inserts a word in an ArrayList<ArrayList<Character>>                     *
     * @param word word to be inserted in the board                             *
     * @param board the word search board                                       *
     * @param direction value that determines which way word will be inserted   *
     * @param x random x cord                                                   *
     * @param y random y cord                                                   *
     * @return true if word inserted, else false                                *
     ****************************************************************************/
    private boolean insertWord(String word, ArrayList<ArrayList<Character>> board, int direction, int x, int y){
        //System.out.println("X: " + x + " Y: " + y + " RANDINT: " + direction);
        switch (direction) {
            //left to right
            case 0 -> {
                //for each letter in the string
                for (int i = 0; i < word.length(); i++) {
                    //check to see if current cord can take the current letter
                    if ((x < board.get(0).size()) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        //insert word
                        board.get(y).set(x, word.charAt(i));
                        x++;
                    } else {
                        //cord is not valid, word failed to be inserted
                        //System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            //right to left down diagonal
            case 1 -> {
                //for each letter in the string
                for (int i = 0; i < word.length(); i++) {
                    //check to see if current cord can take the current letter
                    if (((x < board.get(0).size()) && y < board.size()) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        //insert word'
                        board.get(y).set(x, word.charAt(i));
                        x++;
                        y++;
                    } else {
                        //cord is not valid, word failed to be inserted
                        //System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            //up to down
            case 2 -> {
                //for each letter in the string
                for (int i = 0; i < word.length(); i++) {
                    //check to see if current cord can take the current letter
                    if ((y < board.size()) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        //insert word
                        board.get(y).set(x, word.charAt(i));
                        y++;
                    } else {
                        //cord is not valid, word failed to be inserted
                        //System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            //left to right down diagonal
            case 3 -> {
                //for each letter in the string
                for (int i = 0; i < word.length(); i++) {
                    //check to see if current cord can take the current letter
                    if ((x > -1 && y < board.size()) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        //insert word
                        board.get(y).set(x, word.charAt(i));
                        x--;
                        y++;
                    } else {
                        //cord is not valid, word failed to be inserted
                        //System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            //left to right
            case 4 -> {
                //for each letter in the string
                for (int i = 0; i < word.length(); i++) {
                    //check to see if current cord can take the current letter
                    if ((x > -1) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        //insert word
                        board.get(y).set(x, word.charAt(i));
                        x--;
                    } else {
                        //cord is not valid, word failed to be inserted
                        //System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            //left to right up diagonal
            case 5 -> {
                //for each letter in the string
                for (int i = 0; i < word.length(); i++) {
                    //check to see if current cord can take the current letter
                    if ((x > -1 && y > -1) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        //insert word
                        board.get(y).set(x, word.charAt(i));
                        x--;
                        y--;
                    } else {
                        //cord is not valid, word failed to be inserted
                        //System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            //down to up
            case 6 -> {
                //for each letter in the string
                for (int i = 0; i < word.length(); i++) {
                    //check to see if current cord can take the current letter
                    if ((y > -1) && ((board.get(y).get(x) == '1') || board.get(y).get(x).equals(word.charAt(i)))) {
                        //insert word
                        board.get(y).set(x, word.charAt(i));
                        y--;
                    } else {
                        //cord is not valid, word failed to be inserted
                        //System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
            //left to right up diagonal
            case 7 -> {
                //for each letter in the string
                for (int i = 0; i < word.length(); i++) {
                    //check to see if current cord can take the current letter
                    if ((x < board.get(0).size() && y > -1) && (board.get(y).get(x) == '1' || board.get(y).get(x).equals(word.charAt(i)))) {
                        //insert word
                        board.get(y).set(x, word.charAt(i));
                        x++;
                        y--;
                    } else {
                        //cord is not valid, word failed to be inserted
                        //System.out.println("FALSE");
                        return false;
                    }
                }
                return true;
            }
        }
        return true;
    }

    /**************************************************************
     * Randomly finds a place for the word, program will not halt *
     * until all words are inserted                               *
     **************************************************************/
    private void findPlaceForWord() {
        String currentWord;
        boolean wordInserted = false;
        //random number gen
        Random rand = new Random(Clock.systemUTC().millis());
        //values for randomly inserting word
        int randInt;
        int randX;
        int randY;
        int counter;
        //make a board to roll back too if word isn't properly inserted
        ArrayList<ArrayList<Character>> boardCopy = new ArrayList<ArrayList<Character>>();
        //for each word
        for (int i = 0; i < words.size(); i++) {
            //get random coordinates and direction to insert word
            randInt = rand.nextInt(0, 9);
            randX = rand.nextInt(0, this.board.get(0).size());
            randY = rand.nextInt(0, this.board.size());
            counter = 0;
            currentWord = words.get(i);
            //while the word isn't inserted
            while (!wordInserted) {
                //make a copy of board to roll back too.
                boardCopy = deepCopy(this.board);
                //try to insert word, if successful wordInserted is true
                wordInserted = insertWord(currentWord, boardCopy, randInt, randX, randY);
                //counter used to find new cord if no directions can take the word
                counter += 1;
                //change direction
                randInt = (randInt + 1) % 8;
                //if no direction could take the word, get new random cords.
                if (counter == 8){
                    randX = rand.nextInt(0, this.board.get(0).size());
                    randY = rand.nextInt(0, this.board.size());
                    counter = 0;
                }
            }
            wordInserted = false;
            //since word inserted to reflect the changes in the wordsearch board
            board = deepCopy(boardCopy);
        }
    }
    /**************************************************************
     * Randomly finds a place for the word, program will not halt *
     * until all words are inserted                               *
     * @param words List of words to add to board                 *
     **************************************************************/
    private void findPlaceForWord(ArrayList<String> words) {
        String currentWord;
        boolean wordInserted = false;
        //random number gen
        Random rand = new Random(Clock.systemUTC().millis());
        //values for randomly inserting word
        int randInt;
        int randX;
        int randY;
        int counter;
        //make a board to roll back too if word isn't properly inserted
        ArrayList<ArrayList<Character>> boardCopy = new ArrayList<ArrayList<Character>>();
        //for each word
        for (int i = 0; i < words.size(); i++) {
            //get current word
            currentWord = words.get(i);
            //get random coordinates and direction to insert word
            randInt = rand.nextInt(0, 9);
            randX = rand.nextInt(0, this.board.get(0).size());
            randY = rand.nextInt(0, this.board.size());
            counter = 0;
            //while the word isn't inserted
            while (!wordInserted) {
                //make a copy of board to roll back too.
                boardCopy = deepCopy(this.board);
                //try to insert word, if successful wordInserted is true
                wordInserted = insertWord(currentWord, boardCopy, randInt, randX, randY);
                //counter used to find new cord if no directions can take the word
                counter += 1;
                //change direction
                randInt = (randInt + 1) % 8;
                //if no direction could take the word, get new random cords.
                if (counter == 8) {
                    randX = rand.nextInt(0, this.board.get(0).size());
                    randY = rand.nextInt(0, this.board.size());
                }
            }
            wordInserted = false;
            //since word inserted to reflect the changes in the wordsearch board
            board = deepCopy(boardCopy);
        }
    }

    /*************************************************
     * makeWordSearch with the word list in the class*
     *************************************************/
    public void makeWordSearch() {
        //make the board
        wordSearchBoardSize();
        //find place for word
        findPlaceForWord();
        //randomly insert all remaining spaces with random letters
        insertRandomLetters();
    }

    /**********************************************
     * make word search with the param words list *
     * @param words list of words                 *
     **********************************************/
    public void makeWordSearch(ArrayList<String> words) {
        //make the board
        wordSearchBoardSize(words);
        //find place for word
        findPlaceForWord(words);
        //randomly insert all remaining spaces with random letters
        insertRandomLetters();
    }

    /******************************
     * Get a random char from A-Z *
     * @return random letter      *
     ******************************/
    private char getRandomLetter(){
        Random rand = new Random();
        int randomNum = rand.nextInt(26);
        return (char) (randomNum + 65);
    }

    /******************************************************
     * inserts random letters in empty spots in the board *
     * the char '1' means the spot is empty               *
     ******************************************************/
    private void insertRandomLetters(){
        for (ArrayList<Character> characters : board) {
            //check each spot of the board
            for (int j = 0; j < characters.size(); j++) {
                //'1' means spot is empty
                if (characters.get(j) == '1')
                    //fill with random char form A-Z
                    characters.set(j, getRandomLetter());
            }
        }
    }

    /**************************************
     * Prints the board into the terminal *
     **************************************/
    public void printBoard() {
        //for each spot, print it.
        for (ArrayList<Character> characters : board) {
            //for each row
            for (Character character : characters) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }
    /**************************************
     * Prints the board into the terminal *
     **************************************/
    public void printBoard(ArrayList<ArrayList<Character>> board) {
        //for each spot, print it.
        for (ArrayList<Character> characters : board) {
            //for each row
            for (Character character : characters) {
                System.out.print(character + " ");
            }
            System.out.println();
        }
    }

    /*********************************************
     * makes the word search board               *
     * grid size is x2 the size of largest word  *
     *********************************************/
    private void wordSearchBoardSize(){
        int lenOfLargestWord = 0;
        this.board = new ArrayList<ArrayList<Character>>();
        //find the longest word
        for (String word : words) {
            if (lenOfLargestWord < word.length()) {
                lenOfLargestWord = word.length();
            }
        }
        //make an empty grid that is twice the size of the largest word
        for (int i = 0; i < lenOfLargestWord * 2; i++){
            this.board.add(new ArrayList<Character>());
            for (int j = 0; j < lenOfLargestWord * 2; j++){
                this.board.get(i).add('1');
            }
        }
    }

    /*********************************************************
     * makes the word search board                           *
     * grid size is x2 the size of largest word in the list  *
     * @param words list of words                            *
     *********************************************************/
    private void wordSearchBoardSize(ArrayList<String> words){
        int lenOfLargestWord = 0;
        this.board = new ArrayList<ArrayList<Character>>();
        //find the longest word
        for (String word : words) {
            if (lenOfLargestWord < word.length()) {
                lenOfLargestWord = word.length();
            }
        }
        //make an empty grid that is twice the size of the largest word
        for (int i = 0; i < lenOfLargestWord * 2; i++){
            this.board.add(new ArrayList<Character>());
            for (int j = 0; j < lenOfLargestWord * 2; j++){
                this.board.get(i).add('1');
            }
        }
    }
}
