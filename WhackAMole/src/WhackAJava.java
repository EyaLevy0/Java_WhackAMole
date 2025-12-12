import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;





public class WhackAJava {
   int boardwidth = 600;
   int boardheight = 650; //50px for score

   JFrame frame = new JFrame("Java: Whack A Mole");
   JLabel textLabel = new JLabel();
   JPanel textPanel = new JPanel();
   JPanel boardPanel = new JPanel();

   JButton[] board = new JButton[9];
   ImageIcon javaIcon;
   ImageIcon pythonIcon;



   WhackAJava() {
    frame.setVisible(true);
    frame.setSize(boardwidth, boardheight);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    textLabel.setFont(new Font("Arial", Font.PLAIN, 50));
    textLabel.setHorizontalAlignment(JLabel.CENTER);
    textLabel.setText("Score: 0");
    textLabel.setOpaque(true);

    textPanel.setLayout(new BorderLayout());
    textPanel.add(textLabel);
    frame.add(textPanel, BorderLayout.NORTH);

   boardPanel.setLayout(new GridLayout(3, 3));
   //boardPanel.setBackground(Color.black);
   frame.add(boardPanel);

   for(int i=0; i<9; i++) {
       JButton tile = new JButton();
       board[i] = tile;
       boardPanel.add(tile);
   }

   }
}