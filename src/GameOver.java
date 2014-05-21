import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOver extends JPanel{
  
  private GamePanel gp;
  
  public GameOver(GamePanel tempgp){
    setBackground(Color.BLACK);
    setLayout(new BorderLayout());
    
    JLabel lblGameOver = new JLabel("<html><font color='white'>Game Over</font></html>");
    //lblGameOver.setBounds(200,150,300,20);
    lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
    lblGameOver.setVerticalAlignment(SwingConstants.CENTER);
    add(lblGameOver);
    
    JButton btnRestart = new JButton("Play again?");
    btnRestart.addActionListener(new HandleBtnRestart());
    add(btnRestart,BorderLayout.SOUTH);
    
    gp = tempgp;
  }
  
  public void restartGame(){
    resetStats();
    
    gp.removeAll();
    
    MainMenu mm = new MainMenu(gp);
    
    gp.add(mm);
    
    revalidate();
    repaint();
    
    gp.revalidate();
    gp.repaint(); 
  }
  
  private void resetStats(){
    GamePanel.numFuel = 0;
    GamePanel.numFood = 0;
    GamePanel.numFlashDrives = 0;
    GamePanel.numMoney = 0;
    GamePanel.numTires = 0;
    GamePanel.numMufflers = 0;
    
    GamePanel.healthPlayer = 100;
    GamePanel.healthMrSawyer = 100;
    GamePanel.healthVikrant = 100;
    GamePanel.healthVarun = 100;
    GamePanel.healthBrian = 100;
    
    GamePanel.isParty = true;
    GamePanel.isSupplies = false;
    GamePanel.isStore = false;
    GamePanel.isWait = false;
    
    GamePanel.playersname = "Mr. Null";
    GamePanel.miles = 0;
    GamePanel.totalmiles = 0;
    GamePanel.isMoving = false;
    GamePanel.landMarksEncountered = 0;
    GamePanel.overWorldVisible = false;
    GamePanel.landMarkVisible = false;
    GamePanel.stoppedVisible = false;

  }
  
  private class HandleBtnRestart implements ActionListener{
    public void actionPerformed(ActionEvent e){
      restartGame();
    }
  }
}