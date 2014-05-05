import javax.swing.*;
import java.awt.*;

public class Runner{
  
  public static void main(String[] args){
    
    JFrame f = new JFrame();
    f.setTitle("The Sawyer Trail");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setSize(500,500);
    Container pane = f.getContentPane();
    f.setLayout(new BorderLayout());
    
    GamePanel gp = new GamePanel();
    /*
     MainMenu mm = new MainMenu(gp);
     
     gp.add(mm);
     pane.add(gp, BorderLayout.CENTER);
     */
    
    
    /*
     //******Below is for testing purposes.
     SupplySelection ss = new SupplySelection(gp,"carrot");
     
     gp.add(ss);
     pane.add(gp, BorderLayout.CENTER);
     //******Testing purposes end here.
     */
    
    OverWorld ow = new OverWorld(gp, "cat-man", 54, 32, 10, 98, 76, 65);
    gp.add(ow);
    pane.add(gp, BorderLayout.CENTER);
    
    
    f.setVisible(true);
    
  }
}