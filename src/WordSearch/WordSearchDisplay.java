package WordSearch;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WordSearchDisplay extends JFrame{
    private ArrayList<ArrayList<Character>> grid;
    private JPanel panel;

    public WordSearchDisplay(ArrayList<ArrayList<Character>> grid) {
        super("Word Search Display");

        this.grid = grid;
        panel = new JPanel(new GridLayout(grid.size(), grid.get(0).size()));

        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                JLabel label = new JLabel(Character.toString(grid.get(i).get(j)), SwingConstants.CENTER);
                label.setPreferredSize(new Dimension(50,50));
                label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panel.add(label);
            }
        }

        JScrollPane scrollPane = new JScrollPane((panel));
        add(scrollPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
