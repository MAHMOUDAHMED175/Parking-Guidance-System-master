
package ParkingGuidanceSystem.view.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.plaf.FontUIResource;
import ParkingGuidanceSystem.controller.*;

import java.awt.Dimension;
import javax.swing.plaf.ColorUIResource;

public class entry {
        
    public void t(){
    
        JFrame f=new JFrame("Parking Guidance System");
        
        JPanel p1=new JPanel();  
        p1.setBounds(0,0,350,100);
        p1.setBackground(new Color(251, 222, 68));
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel l1 = new JLabel("Enter Parking");
        l1.setBounds(30,0,100,150);
        l1.setFont(new Font("Serif", Font.BOLD, 52));
        l1.setForeground(new Color(40, 51, 74));
        
       
        JLabel l2=new JLabel("Enter Your Plate Number:");
        l2.setBounds(660, 100 , 900, 500);
        l2.setFont(new Font("", Font.PLAIN, 30));
        l2.setForeground(Color.white);
        
        JTextField t1 = new JTextField(); 
        t1.setBounds(660,380 ,600,65);
        t1.setFont(new Font("", Font.PLAIN, 35));
        t1.setBackground(new Color(108,122,137));
        t1.setForeground(Color.white);
        
        JButton b1 =new JButton();
        JButton b2 =new JButton();
        
        b1.setText("Print Ticket");
        b1.setBounds(460,550,350,80);
        b1.setFont(new Font("", Font.BOLD, 35));
        b1.setBackground(new Color(77, 136, 255));
        b1.setForeground(Color.white);
        
        b2.setText("Back");
        b2.setBounds(1100,550,350,80);
        b2.setFont(new Font("", Font.BOLD, 35));
        b2.setBackground(new Color(246,80,88));
        b2.setForeground(Color.white);
         
        Color c=new Color(40, 51, 74);
        f.getContentPane().setBackground(c);
        
        f.add(p1);
        p1.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(b1);
        f.add(b2);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
                
        b1.addActionListener((ActionEvent e) -> {
            
            
            UIManager.put("OptionPane.messageFont", new FontUIResource(
            new Font("Verdana", Font.PLAIN, 30) ) );
            UIManager.put("OptionPane.messageForeground", Color.white);
            UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.BOLD,30)));
            UIManager.put("Button.background", new Color(251, 222, 68));
            UIManager.put("OptionPane.minimumSize",new Dimension(550,200)); 
            UIManager.put("OptionPane.background",new ColorUIResource(45, 255, 0));
            UIManager.put("Panel.background",new ColorUIResource(245, 0, 0));
            
            String plateNum = t1.getText();
            if(plateNum.matches("[0-9a-zA-Z]+")){
                Customer op = new Customer(plateNum);
                String result = op.printTicket();
                JOptionPane.showMessageDialog(f,result); 
            }
            else JOptionPane.showMessageDialog(f,"Wrong plate number format.","Alert",JOptionPane.WARNING_MESSAGE);
        }); 
         
        b2.addActionListener((ActionEvent e) -> {
            home k=new home();
            k.user();
            f.setVisible(false); 
        });
        
    }
}
   