import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class BottomOverWorld extends JPanel{
  
  private MyJButton btnHealth = new MyJButton("Health");
  private MyJButton btnStats = new MyJButton("Stats");
  private MyJButton btnStop = new MyJButton("Stop");
  private GamePanel gp;
  private String playersname = GamePanel.playersname;
  private javax.swing.Timer timer;
  
  //Items
  private int numFuel;
  private int numFood;
  private int numFlashDrives;
  private int numMoney;
  private int numTires;
  private int numMufflers;
  
  public static int numNextLandMark = 200;
  
  
  
  //Health
  private int playerHealth = GamePanel.healthPlayer;
  private int mrSawyerHealth = GamePanel.healthMrSawyer;
  private int vikrantHealth = GamePanel.healthVikrant;
  private int varunHealth = GamePanel.healthVarun;
  private int brianHealth = GamePanel.healthBrian;
  
  
  private boolean seeHealth = true;
  private boolean seeStats = false;
  private boolean seeStop = false;
  private JLabel lblPlayerName = new JLabel(playersname);
  private JLabel lblMrSawyerName = new JLabel("Mr. Sawyer                   ");
  private JLabel lblVikrantName = new JLabel("Vikrant");
  private JLabel lblVarunName = new JLabel("Varun");
  private JLabel lblBrianName = new JLabel("Brian");
  private JLabel lblPlayerHealth = new JLabel("<html><font color='green'>"+playerHealth+"</font></html>");
  private JLabel lblMrSawyerHealth = new JLabel("<html><font color='green'>"+mrSawyerHealth+"</font></html>");
  private JLabel lblVikrantHealth = new JLabel("<html><font color='green'>"+vikrantHealth+"</font></html>");
  private JLabel lblVarunHealth = new JLabel("<html><font color='green'>"+varunHealth+"</font></html>");
  private JLabel lblBrianHealth = new JLabel("<html><font color='green'>"+brianHealth+"</font></html>");
  private ArrayList<JLabel> listHealthLabels = new ArrayList<JLabel>();
  private JLabel lblFuelName = new JLabel("Fuel: ");
  private JLabel lblFoodName = new JLabel("Food: ");
  private JLabel lblFlashDrivesName = new JLabel("Flash Drives: ");
  private JLabel lblMoneyName = new JLabel("Money: ");
  private JLabel lblTiresName = new JLabel("Tires: ");
  private JLabel lblMufflersName = new JLabel("Mufflers: ");
  private JLabel lblNextLandmarkName = new JLabel("Next Landmark:         ");
  private JLabel lblFuelNum = new JLabel();
  private JLabel lblFoodNum = new JLabel();
  private JLabel lblFlashDrivesNum = new JLabel();
  private JLabel lblMoneyNum = new JLabel();
  private JLabel lblTiresNum = new JLabel();
  private JLabel lblMufflersNum = new JLabel();
  private JLabel lblNextLandmarkNum = new JLabel();
  private ArrayList<JLabel> listStatsLabels = new ArrayList<JLabel>();
  
  private JPanel healthPanel = new JPanel();
  private JPanel statsPanel = new JPanel();
  
  public BottomOverWorld(OverWorld tempow, GamePanel tempgp){
    
    gp = tempgp;
    playersname = GamePanel.playersname;
    
    timer = new javax.swing.Timer(200, new TimerListener());
    timer.start();
    
    numFuel = GamePanel.numFuel;
    numFood = GamePanel.numFood;
    numFlashDrives = GamePanel.numFlashDrives;
    numMoney = GamePanel.numMoney;
    numTires = GamePanel.numTires;
    numMufflers = GamePanel.numMufflers;
    
    lblPlayerName.setText(GamePanel.playersname);
    lblFuelNum.setText(""+numFuel);
    lblFoodNum.setText(""+numFood);
    lblFlashDrivesNum.setText(""+numFlashDrives);
    lblMoneyNum.setText(""+numMoney);
    lblTiresNum.setText(""+numTires);
    lblMufflersNum.setText(""+numMufflers);
    lblNextLandmarkNum.setText(""+numNextLandMark);
    
    setLayout(new BorderLayout());
    
    setBackground(new Color(0xd2b48c));
    
    btnHealth.setPreferredSize(new Dimension(150,getHeight()/3));
    btnStats.setPreferredSize(new Dimension(150,getHeight()/3));
    btnStop.setPreferredSize(new Dimension(150,getHeight()/3));
    
    btnHealth.addActionListener(new HandleBtnHealth());
    btnStats.addActionListener(new HandleBtnStats());
    btnStop.addActionListener(new HandleBtnStop());
    
    JPanel btnPanel = new JPanel();
    btnPanel.setLayout(new GridLayout(3,1));
    btnPanel.add(btnHealth);
    btnPanel.add(btnStats);
    btnPanel.add(btnStop);
    
    add(btnPanel, BorderLayout.EAST);
    
    
    listHealthLabels.add(lblPlayerName);
    listHealthLabels.add(lblPlayerHealth);
    listHealthLabels.add(lblMrSawyerName);
    listHealthLabels.add(lblMrSawyerHealth);
    listHealthLabels.add(lblVikrantName);
    listHealthLabels.add(lblVikrantHealth);
    listHealthLabels.add(lblVarunName);
    listHealthLabels.add(lblVarunHealth);
    listHealthLabels.add(lblBrianName);
    listHealthLabels.add(lblBrianHealth);
    for (int i = 0; i<10; i++){
      listHealthLabels.get(i).setOpaque(true);
      listHealthLabels.get(i).setBackground(new Color(0xd2b48c));
    }
    
    listStatsLabels.add(lblFuelName);
    listStatsLabels.add(lblFuelNum);
    listStatsLabels.add(lblFoodName);
    listStatsLabels.add(lblFoodNum);
    listStatsLabels.add(lblFlashDrivesName);
    listStatsLabels.add(lblFlashDrivesNum);
    listStatsLabels.add(lblMoneyName);
    listStatsLabels.add(lblMoneyNum);
    listStatsLabels.add(lblTiresName);
    listStatsLabels.add(lblTiresNum);
    listStatsLabels.add(lblMufflersName);
    listStatsLabels.add(lblMufflersNum);
    listStatsLabels.add(lblNextLandmarkName);
    listStatsLabels.add(lblNextLandmarkNum);
    for (int i = 0; i<listStatsLabels.size(); i++){
      listStatsLabels.get(i).setOpaque(true);
      listStatsLabels.get(i).setBackground(new Color(0xd2b48c));
    }
    
    
    updateHud();
  }
  
  
  //Collects the distance.
  private class TimerListener implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if (GamePanel.isMoving){
        Background.canLoseFuel = true;
        GamePanel.miles++;
        numNextLandMark--;
        updateStats();
        updateHealth();
      }
      
      revalidate();
      repaint();
    }
  }
  
  public void updateStats(){
    lblFuelNum.setText(""+GamePanel.numFuel);
    lblFoodNum.setText(""+GamePanel.numFood);
    lblFlashDrivesNum.setText(""+GamePanel.numFlashDrives);
    lblMoneyNum.setText(""+GamePanel.numMoney);
    lblTiresNum.setText(""+GamePanel.numTires);
    lblMufflersNum.setText(""+GamePanel.numMufflers);
    lblNextLandmarkNum.setText(""+numNextLandMark); 
  }
  
  private class HandleBtnHealth implements ActionListener{
    public void actionPerformed(ActionEvent e){
      seeHealth = true;
      seeStats = false;
      seeStop = false;
      updateHud();
    }
  }
  
  private class HandleBtnStats implements ActionListener{
    public void actionPerformed(ActionEvent e){
      seeHealth = false;
      seeStats = true;
      seeStop = false;
      updateHud();
    }
  }
  
  private class HandleBtnStop implements ActionListener{
    public void actionPerformed(ActionEvent e){
      seeHealth = false;
      seeStats = false;
      seeStop = true;
      updateHud(); 
    }
  }
  
  public void updateHealth(){
    if (GamePanel.healthPlayer > 0)
      lblPlayerHealth.setText("<html><font color='green'>"+GamePanel.healthPlayer+"</font></html>");
    else
      lblPlayerHealth.setText("<html><font color='red'>"+GamePanel.healthPlayer+"</font></html>");
    if (GamePanel.healthMrSawyer > 0)
      lblMrSawyerHealth.setText("<html><font color='green'>"+GamePanel.healthMrSawyer+"</font></html>");
    else
      lblMrSawyerHealth.setText("<html><font color='red'>"+GamePanel.healthMrSawyer+"</font></html>");
    if (GamePanel.healthVikrant > 0)
      lblVikrantHealth.setText("<html><font color='green'>"+GamePanel.healthVikrant+"</font></html>");
    else
      lblVikrantHealth.setText("<html><font color='red'>"+GamePanel.healthVikrant+"</font></html>");
    if (GamePanel.healthVarun > 0)
      lblVarunHealth.setText("<html><font color='green'>"+GamePanel.healthVarun+"</font></html>");
    else
      lblVarunHealth.setText("<html><font color='red'>"+GamePanel.healthVarun+"</font></html>");
    if (GamePanel.healthBrian > 0)
      lblBrianHealth.setText("<html><font color='green'>"+GamePanel.healthBrian+"</font></html>");
    else
      lblBrianHealth.setText("<html><font color='red'>"+GamePanel.healthBrian+"</font></html>");
  }
  
  
  
  private void updateHud(){
    if (seeHealth){
      createHealthPanel();
    }else if (seeStats){
      createStatsPanel();
    }else if (seeStop){
      gotoStoppedPanel();
    }
    revalidate();
    repaint();
  }
  
  private void createHealthPanel(){
    
    remove(healthPanel);
    remove(statsPanel);
    
    lblPlayerHealth.setText("<html><font color='green'>"+GamePanel.healthPlayer+"</font></html>");
    lblMrSawyerHealth.setText("<html><font color='green'>"+GamePanel.healthMrSawyer+"</font></html>");
    lblVikrantHealth.setText("<html><font color='green'>"+GamePanel.healthVikrant+"</font></html>");
    lblVarunHealth.setText("<html><font color='green'>"+GamePanel.healthVarun+"</font></html>");
    lblBrianHealth.setText("<html><font color='green'>"+GamePanel.healthBrian+"</font></html>");
    
    healthPanel.setLayout(new GridLayout(5,2));
    healthPanel.setBackground(new Color(0xd2b48c));
    healthPanel.add(lblPlayerName);
    healthPanel.add(lblPlayerHealth);
    healthPanel.add(lblMrSawyerName);
    healthPanel.add(lblMrSawyerHealth);
    healthPanel.add(lblVikrantName);
    healthPanel.add(lblVikrantHealth);
    healthPanel.add(lblVarunName);
    healthPanel.add(lblVarunHealth);
    healthPanel.add(lblBrianName);
    healthPanel.add(lblBrianHealth);
    
    add(healthPanel, BorderLayout.WEST);
    
    
    revalidate();
    repaint();
    
  }
  
  private void createStatsPanel(){
    
    remove(healthPanel);
    remove(statsPanel);
    
    statsPanel.setLayout(new GridLayout(7,2));
    for (int i = 0; i<listStatsLabels.size(); i++){
      listStatsLabels.get(i).setBackground(new Color(0xd2b48c));
      statsPanel.add(listStatsLabels.get(i));
    }
    
    statsPanel.setBackground(new Color(0xd2b48c));
    
    add(statsPanel, BorderLayout.WEST);
    
    
    revalidate();
    repaint();
    
  }
  
  private void gotoStoppedPanel(){
    if (GamePanel.isMoving){
      GamePanel.isMoving = false;
      GamePanel.totalmiles += GamePanel.miles;
      GamePanel.overWorldVisible = false;
      GamePanel.stoppedVisible = true;
      
      Stopped st = new Stopped(gp);
      gp.add(st);
    }
    gp.revalidate();
    gp.repaint();
  }
  
  
}
