import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class OverWorld extends JPanel{
  private GamePanel gp;
  private OverWorld ow;
  /*
   //Supplies
   int numFuel;
   int numFood;
   int numFlashDrives;
   int numMoney;
   int numTires;
   int numMufflers;
   */
  
  //Health
  private int healthMrSawyer = 100;
  private int healthVikrant = 100;
  private int healthBrian = 100;
  private int healthVarun = 100;
  private int healthPlayer = 100;
  
  private String playersname;
  
  
  public OverWorld(GamePanel tempgp/*, String tempplayersname, int tempnumFuel, int tempnumFood, int tempnumFlashDrives, int tempnumMoney, int tempnumTires, int tempnumMufflers*/){
    
    gp = tempgp;
    /*
     playersname = tempplayersname;
     numFuel = tempnumFuel;
     numFood = tempnumFood;
     numFlashDrives = tempnumFlashDrives;
     numMoney = tempnumMoney;
     numTires = tempnumTires;
     numMufflers = tempnumMufflers;
     
     
     healthMrSawyer = 100;
     healthVikrant = 100;
     healthBrian = 100;
     healthVarun = 100;
     healthPlayer = 100;
     */
    
    BottomOverWorld bow = new BottomOverWorld(ow,gp/*, playersname, numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers, healthMrSawyer, healthVikrant, healthBrian, healthVarun, healthPlayer*/);
    TopOverWorld tow = new TopOverWorld(ow,gp,bow/*, playersname, numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers, healthMrSawyer, healthVikrant, healthBrian, healthVarun, healthPlayer*/);
    
    setLayout(new GridLayout(2,1));
    add(tow);
    add(bow);
    ow = this;
  }
  

  
}