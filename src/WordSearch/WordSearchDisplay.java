package WordSearch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class WordSearchDisplay extends JFrame{
    private ArrayList<ArrayList<Character>> grid;
    private JPanel panel;
    private ArrayList<ArrayList<JButton>> buttons;
    private ArrayList<String> correctWords;
    private ArrayList<JButton> clickedButtons;

    public WordSearchDisplay(ArrayList<ArrayList<Character>> grid, ArrayList<String> correctWords) {
        super("Word Search Display");

        this.grid = grid;
        this.correctWords = correctWords;
        this.clickedButtons = new ArrayList<JButton>();
        this.buttons = new ArrayList<ArrayList<JButton>>();

        panel = new JPanel(new GridLayout(grid.size(), grid.get(0).size()));

        for (int i = 0; i < grid.size(); i++) {
            ArrayList<JButton> buttonRow = new ArrayList<JButton>();
            for (int j = 0; j < grid.get(i).size(); j++) {
                JButton button = new JButton(Character.toString(grid.get(i).get(j)));
                button.setPreferredSize(new Dimension(50,50));
                button.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                button.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JButton btn = (JButton) e.getSource();
                        if (btn.getBackground() == Color.YELLOW) {
                            btn.setBackground(new JButton().getBackground()); // default color
                            clickedButtons.remove(btn);
                        } else {
                            btn.setBackground(Color.YELLOW);
                            clickedButtons.add(btn);
                            checkWord();
                        }
                    }
                });
                buttonRow.add(button);
                panel.add(button);
            }
            buttons.add(buttonRow);
        }

        JScrollPane scrollPane = new JScrollPane((panel));
        add(scrollPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void checkWord() {
        StringBuilder sb = new StringBuilder();
        for (JButton button : clickedButtons) {
            sb.append(button.getText());
        }
        String word = sb.toString();
        if (correctWords.contains(word)) {
            for (JButton button : clickedButtons) {
                button.setBackground(Color.GREEN);
            }
            clickedButtons.clear();
        }
    }
}