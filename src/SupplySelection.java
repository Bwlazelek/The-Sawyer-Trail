import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SupplySelection extends JPanel{
  
  private GamePanel gp;
  private SupplySelection ss;
  private String playersName;
  private int numSupplies = 15;
  private int numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers;
  private JLabel lblText = new JLabel("Pick the supplies you want to gather. Items remaining: " + numSupplies);
  private JLabel lblError = new JLabel("");
  private MyJButton btnDone = new MyJButton("Done");
  private ArrayList<JButton> listSupplyButtons = new ArrayList<JButton>();
  private ArrayList<JLabel> listSupplyLabelsNames = new ArrayList<JLabel>();
  private ArrayList<JLabel> listSupplyLabelsAmounts = new ArrayList<JLabel>();
  
  private ImageIcon btnPlus = new ImageIcon("btnPlus.png"); 
  private ImageIcon btnMinus = new ImageIcon("btnMinus.png");
  
  public SupplySelection(GamePanel tempgp, String tempplayersName){
    
    setLayout(null);
    setBackground(new Color(242,249,44));
    
    gp = tempgp; //Reference to GamePanel.
    playersName = GamePanel.playersname;
    
    lblText.setBounds(15,60,500,20);
    lblText.setFont(GamePanel.fontType14);
    add(lblText);
    
    lblError.setBounds(145,400,500,20);
    lblError.setFont(GamePanel.fontType14);
    add(lblError);
    
    btnDone.setBounds(390,400,80,30);
    btnDone.addActionListener(new SupplyDone());
    add(btnDone);
    
    
    //Add 12 buttons to ArrayList
    for (int i = 0; i<6; i++){
      listSupplyButtons.add(new JButton(btnPlus));
      listSupplyButtons.add(new JButton(btnMinus));
    }
    
    //Add 6 labels to ArrayList
    for (int i = 0; i<6; i++){
      listSupplyLabelsNames.add(new JLabel(""));
    }
    
    //Add 6 labels to ArrayList
    for (int i = 0; i<6; i++){
      listSupplyLabelsAmounts.add(new JLabel("0"));
    }
    
    
    //Fuel
    listSupplyButtons.get(0).setBounds(120,150,32,32);
    listSupplyButtons.get(1).setBounds(30,150,32,32);
    listSupplyLabelsNames.get(0).setText("Fuel");
    listSupplyLabelsNames.get(0).setBounds(35,120,500,20);
    listSupplyLabelsAmounts.get(0).setBounds(85,150,500,20);
    add(listSupplyButtons.get(0));
    add(listSupplyButtons.get(1));
    add(listSupplyLabelsNames.get(0));
    add(listSupplyLabelsAmounts.get(0));
    
    //Food
    listSupplyButtons.get(2).setBounds(360,150,32,32);
    listSupplyButtons.get(3).setBounds(270,150,32,32);
    listSupplyLabelsNames.get(1).setText("Food");
    listSupplyLabelsNames.get(1).setBounds(275,120,500,20);
    listSupplyLabelsAmounts.get(1).setBounds(325,150,500,20);
    add(listSupplyButtons.get(2));
    add(listSupplyButtons.get(3));
    add(listSupplyLabelsNames.get(1));
    add(listSupplyLabelsAmounts.get(1));
    
    //Flash Drives
    listSupplyButtons.get(4).setBounds(120,250,32,32);
    listSupplyButtons.get(5).setBounds(30,250,32,32);
    listSupplyLabelsNames.get(2).setText("Flash Drives");
    listSupplyLabelsNames.get(2).setBounds(35,220,500,20);
    listSupplyLabelsAmounts.get(2).setBounds(85,250,500,20);
    add(listSupplyButtons.get(4));
    add(listSupplyButtons.get(5));
    add(listSupplyLabelsNames.get(2));
    add(listSupplyLabelsAmounts.get(2));
    
    //Money
    listSupplyButtons.get(6).setBounds(360,250,32,32);
    listSupplyButtons.get(7).setBounds(270,250,32,32);
    listSupplyLabelsNames.get(3).setText("Money");
    listSupplyLabelsNames.get(3).setBounds(275,220,500,20);
    listSupplyLabelsAmounts.get(3).setBounds(325,250,500,20);
    add(listSupplyButtons.get(6));
    add(listSupplyButtons.get(7));
    add(listSupplyLabelsNames.get(3));
    add(listSupplyLabelsAmounts.get(3));
    
    //Tires
    listSupplyButtons.get(8).setBounds(120,350,32,32);
    listSupplyButtons.get(9).setBounds(30,350,32,32);
    listSupplyLabelsNames.get(4).setText("Tires");
    listSupplyLabelsNames.get(4).setBounds(35,320,500,20);
    listSupplyLabelsAmounts.get(4).setBounds(85,350,500,20);
    add(listSupplyButtons.get(8));
    add(listSupplyButtons.get(9));
    add(listSupplyLabelsNames.get(4));
    add(listSupplyLabelsAmounts.get(4));
    
    //Mufflers
    listSupplyButtons.get(10).setBounds(360,350,32,32);
    listSupplyButtons.get(11).setBounds(270,350,32,32);
    listSupplyLabelsNames.get(5).setText("Mufflers");
    listSupplyLabelsNames.get(5).setBounds(275,320,500,20);
    listSupplyLabelsAmounts.get(5).setBounds(325,350,500,20);
    add(listSupplyButtons.get(10));
    add(listSupplyButtons.get(11));
    add(listSupplyLabelsNames.get(5));
    add(listSupplyLabelsAmounts.get(5));
    
    
    //Set button actions
    for (int i = 0; i<12; i++){
      if (i%2 == 0){
        listSupplyButtons.get(i).addActionListener(new PlusButton(i));
      }else{
        listSupplyButtons.get(i).addActionListener(new MinusButton(i));
      }
    }
    
    ss = this;
    
  }
  
  private class SupplyDone implements ActionListener{
    //Goes to next frame
    public void actionPerformed(ActionEvent e){
      if (numSupplies == 0){
        gp.remove(ss);
        PostSupplySelectionScene psss = new PostSupplySelectionScene(gp, numFuel, numFood, numFlashDrives, numMoney, numTires, numMufflers, playersName);
        gp.add(psss);
        gp.revalidate();
        gp.repaint();
      }
      else{
        lblError.setText("<html><font color = 'red'>Get the rest of your supplies!</font></html>");
      }
    }
  }
  
  private class PlusButton implements ActionListener{
    
    private int btnNum;
    
    public PlusButton(int tempBtnNum){
      btnNum = tempBtnNum;
    }
    
    public void actionPerformed(ActionEvent e){
      if (numSupplies > 0){
        if (btnNum == 0){
          numFuel += 4;
          numSupplies--;
        }else if (btnNum == 2){
          numFood += 50;
          numSupplies--;
        }else if (btnNum == 4){
          numFlashDrives += 2;
          numSupplies--;
        }else if (btnNum == 6){
          numMoney += 50;
          numSupplies--;
        }else if (btnNum == 8){
          numTires++;
          numSupplies--;
        }else if (btnNum == 10){
          numMufflers++;
          numSupplies--;
        }
        updateDisplay();
      }else{
        
        lblText.setText("<html>Pick the supplies you want to gather. Items remaining:<font color = 'red'> " + numSupplies + "</font></html>");
        
      }
    }
  }
  
  private class MinusButton implements ActionListener{
    
    private int btnNum;
    
    public MinusButton(int tempBtnNum){
      btnNum = tempBtnNum;
    }
    
    public void actionPerformed(ActionEvent e){
      if (numSupplies < 15){
        if (btnNum == 1 && numFuel > 0){
          numFuel -= 4;
          numSupplies++;
        }else if (btnNum == 3 && numFood > 0){
          numFood -= 50;
          numSupplies++;
        }else if (btnNum == 5 && numFlashDrives > 0){
          numFlashDrives -= 2;
          numSupplies++;
        }else if (btnNum == 7 && numMoney > 0){
          numMoney -= 50;
          numSupplies++;
        }else if (btnNum == 9 && numTires > 0){
          numTires--;
          numSupplies++;
        }else if (btnNum == 11 && numMufflers > 0){
          numMufflers--;
          numSupplies++;
        }
        updateDisplay();
      }else{
        
        lblText.setText("<html>Pick the supplies you want to gather. Items remaining:<font color = 'red'> " + numSupplies + "</font></html>");
        
      }
    }
  }
  
  public void updateDisplay(){
    listSupplyLabelsAmounts.get(0).setText(""+numFuel);
    listSupplyLabelsAmounts.get(1).setText(""+numFood);
    listSupplyLabelsAmounts.get(2).setText(""+numFlashDrives);
    listSupplyLabelsAmounts.get(3).setText(""+numMoney);
    listSupplyLabelsAmounts.get(4).setText(""+numTires);
    listSupplyLabelsAmounts.get(5).setText(""+numMufflers);
    lblText.setText("Pick the supplies you want to gather. Items remaining: " + numSupplies);
    lblError.setText("");
  } 
}