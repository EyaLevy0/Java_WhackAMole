import.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;





public class WhackAMole {
   int boardwidth = 600;
   int boardheight = 650; //50px for score

   Frame frame = new JFrame("Java: Whack A Mole");

   WhackAMole() {
    frame.set.visible(true);
    frame.setSize(boardwidth, boardheight);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());
   }
}