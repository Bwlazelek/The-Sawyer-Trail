import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{
  
  //Global Variables
  
  //Supplies
  public static int numFuel;
  public static int numFood;
  public static int numFlashDrives;
  public static int numMoney;
  public static int numTires;
  public static int numMufflers;
    
  //Health
  public static int healthPlayer = 100;
  public static int healthMrSawyer = 100;
  public static int healthVikrant = 100;
  public static int healthVarun = 100;
  public static int healthBrian = 100;
  
  //LandMark
  public static boolean isParty = true;
  public static boolean isSupplies = false;
  public static boolean isStore = false;
  
  //Misc
  public static String playersname = "Mr. Null";
  public static int miles;
  public static int totalmiles;
  public static boolean isMoving = false;
  public static GamePanel gp;
  public static int landMarksEncountered;
  
  
  public GamePanel(){
    
    gp = this;
    
    setLayout(new BorderLayout());
    
    
  }
}
