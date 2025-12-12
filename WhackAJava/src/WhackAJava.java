import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

//Game class
public class WhackAJava {
   int boardwidth = 600;
   int boardheight = 650; //50px for score
   
   //create frame and panels
   JFrame frame = new JFrame("Java: Whack A Java");
   JLabel textLabel = new JLabel();
   JPanel textPanel = new JPanel();
   JPanel boardPanel = new JPanel();
   
   //create board
   JButton[] board = new JButton[9];
   ImageIcon javaIcon;
   ImageIcon pythonIcon;

   JButton currJavaTile;
   JButton currPythonTile;

   Random random = new Random();
   Timer setJavaTimer;
   Timer setPythonTimer;


   //constructor of the game
   WhackAJava() {
    //frame.setVisible(true);
    frame.setSize(boardwidth, boardheight);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    //text label to present score
    textLabel.setFont(new Font("Arial", Font.PLAIN, 50));
    textLabel.setHorizontalAlignment(JLabel.CENTER);
    textLabel.setText("Score: 0");
    textLabel.setOpaque(true);

    //text panel to hold the text label, positioning at the north of the frame
    textPanel.setLayout(new BorderLayout());
    textPanel.add(textLabel);
    frame.add(textPanel, BorderLayout.NORTH);

    //gridlock layout for the board panel
   boardPanel.setLayout(new GridLayout(3, 3));
   //boardPanel.setBackground(Color.black);
   frame.add(boardPanel);

   //load and scale images
   Image pythonImg = new ImageIcon(getClass().getResource("./python.png")).getImage();
   pythonIcon = new ImageIcon(pythonImg.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH) );

   Image javaImg = new ImageIcon(getClass().getResource("./Duke.png")).getImage();
   javaIcon = new ImageIcon(javaImg.getScaledInstance(100, 150, java.awt.Image.SCALE_SMOOTH) );

   //create buttons for the board and add to the board panel
   for(int i=0; i<9; i++) {
       JButton tile = new JButton();
       board[i] = tile;
       boardPanel.add(tile);
       tile.setFocusable(false);
       tile.setIcon(null);
   }

   setJavaTimer = new Timer(800, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
         //remove java from current tile
         if(currJavaTile != null) {
              currJavaTile.setIcon(null);
              currJavaTile = null;
         }
    
         //select random button to show java
         int num = random.nextInt(9);
         JButton tile = board[num];

         //if tile is occupied by python, skip tile for this turn 
         if(currPythonTile == tile) return;

         //set tile to java
         currJavaTile = tile;
         currJavaTile.setIcon(javaIcon);

   }
   
   });


   setPythonTimer = new Timer(1500, new ActionListener() {
    public void actionPerformed(ActionEvent e) {
         //remove python from current tile
         if(currPythonTile != null) {
              currPythonTile.setIcon(null);
              currPythonTile = null;
         }
    
         //select random button to show python
         int num = random.nextInt(9);
         JButton tile = board[num];

         //if tile is occupied by java, skip tile for this turn 
         if(currJavaTile == tile) return;

         //set tile to python
         currPythonTile = tile;
         currPythonTile.setIcon(pythonIcon);

   }
   
   });

   //start the timers for thr random appearance of java and python
    setJavaTimer.start();
    setPythonTimer.start();
   //make frame visible at the end to insure proper loading
   frame.setVisible(true);
   }
}