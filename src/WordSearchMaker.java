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

    boolean insertWord(String word, int direction){
        switch (direction) {
            case 0:

            case 1:

            case 2:

            case 3:

            case 4:

            case 5:

            case 6:

            case 7:

        }
        return false;
    }

    void findPlaceForWord() {
        String currentWord;
        boolean wordInserted = false;
        Random rand = new Random();
        int randInt;
        int counter;
        for (int i = 0; i < words.size(); i++) {
            randInt = rand.nextInt(0, 9);
            counter = 0;
            while (wordInserted == false) {
                currentWord = words.get(i);
                wordInserted = insertWord(currentWord, randInt);
                counter += 1;
                randInt = (randInt + 1) % 8;
                if (counter == 8){

                }
            }
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
        for (int i = 0; i < words.size(); i++) {
            currentWord = words.get(i);
            randInt = rand.nextInt(0, 9);
            randX = rand.nextInt(0, this.board.get(0).size());
            randY = rand.nextInt(0, this.board.size());
            counter = 0;
            while (wordInserted == false) {
                currentWord = words.get(i);
                wordInserted = insertWord(currentWord, randInt);
                counter += 1;
                randInt = (randInt + 1) % 8;
                if (counter == 8) {
                    randX = rand.nextInt(0, this.board.get(0).size());
                    randY = rand.nextInt(0, this.board.size());
                }

            }
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
                this.board.get(i).add(new Character('1'));
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
                this.board.get(i).add(new Character('1'));
            }
        }
    }
}
