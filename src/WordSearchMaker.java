import java.util.ArrayList;
import java.util.Random;

public class WordSearchMaker {
    private ArrayList<String> words;
    private ArrayList<ArrayList<Character>> board;

    WordSearchMaker(){
        this.words = new ArrayList<String>();
        this.board = new ArrayList<ArrayList<Character>>();
    }

    WordSearchMaker(ArrayList<String> words){
        this.words = new ArrayList<String>();
        this.words.addAll(words);
        this.board = new ArrayList<ArrayList<Character>>();
    }

    ArrayList<String> getWords(){
        return words;
    }
    void setWords(ArrayList<String> words){
        this.words.addAll(words);
    }

    boolean insertWord(String word, ArrayList<ArrayList<Character>> board, int direction, int x, int y){
        switch (direction) {
            case 0:
                for (int i = 0; i < word.length(); i++)
                    if (x < board.get(0).size() && y < board.size() && board.get(y).get(x).charValue() == '1'){
                        board.get(y).set(x, Character.valueOf(word.charAt(i)));
                    }

            case 1:

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:

        }
        return true;
    }

    void findPlaceForWord() {
        String currentWord;
        boolean wordInserted = false;
        Random rand = new Random();
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
            while (wordInserted == false) {
                boardCopy.addAll(board);
                currentWord = words.get(i);
                wordInserted = insertWord(currentWord, boardCopy, randInt, randX, randY);
                counter += 1;
                randInt = (randInt + 1) % 8;
                if (counter == 8){
                    randX = rand.nextInt(0, this.board.get(0).size());
                    randY = rand.nextInt(0, this.board.size());
                }
            }
            board = new ArrayList<ArrayList<Character>>(boardCopy);
        }
    }

    void findPlaceForWord(ArrayList<String> words) {
        String currentWord;
        boolean wordInserted = false;
        Random rand = new Random();
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
            while (wordInserted == false) {
                boardCopy.addAll(board);
                wordInserted = insertWord(currentWord, boardCopy, randInt, randX, randY);
                counter += 1;
                randInt = (randInt + 1) % 8;
                if (counter == 8) {
                    randX = rand.nextInt(0, this.board.get(0).size());
                    randY = rand.nextInt(0, this.board.size());
                }
            }
            board = new ArrayList<ArrayList<Character>>(boardCopy);
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
        for (int i = 0; i < board.size(); i++){
            for (int j = 0; j < board.get(i).size(); j++){
                if (board.get(i).get(j).charValue() == '1')
                    board.get(i).set(j, getRandomLetter());
            }
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.size(); i++){
            for (int j = 0; j < board.get(i).size(); j++){
                System.out.print(board.get(i).get(j).charValue() + " ");
            }
            System.out.println();
        }
    }

    private void wordSearchBoardSize(){
        int lenOfLargestWord = 0;
        this.board = new ArrayList<ArrayList<Character>>();

        for (int i = 0; i < words.size(); i++){
            if (lenOfLargestWord < words.get(i).length()){
                lenOfLargestWord = words.get(i).length();
            }
        }

        for (int i = 0; i < lenOfLargestWord; i++){
            this.board.add(new ArrayList<Character>());
            for (int j = 0; j < lenOfLargestWord; j++){
                this.board.get(i).add(Character.valueOf('1'));
            }
        }
    }
    private void wordSearchBoardSize(ArrayList<String> words){
        int lenOfLargestWord = 0;
        this.board = new ArrayList<ArrayList<Character>>();

        for (int i = 0; i < words.size(); i++){
            if (lenOfLargestWord < words.get(i).length()){
                lenOfLargestWord = words.get(i).length();
            }
        }

        for (int i = 0; i < lenOfLargestWord; i++){
            this.board.add(new ArrayList<Character>());
            for (int j = 0; j < lenOfLargestWord; j++){
                this.board.get(i).add(Character.valueOf('1'));
            }
        }
    }
}
