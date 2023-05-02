import java.util.ArrayList;

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

    public void makeWordSearch(ArrayList<String> words) {
        wordSearchBoardSize();
    }

    public void makeWordSearch() {
        wordSearchBoardSize();




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
}
