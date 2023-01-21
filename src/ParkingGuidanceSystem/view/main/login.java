package ParkingGuidanceSystem.view.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;
import ParkingGuidanceSystem.view.admin.*;
import ParkingGuidanceSystem.view.entry.*;
import ParkingGuidanceSystem.view.exit.*;
import ParkingGuidanceSystem.controller.*;
import java.awt.Dimension;
import javax.swing.plaf.ColorUIResource;

public class login {
   
    public void log(){
        JFrame f=new JFrame("Parking Guidance System");
        
        JPanel p1=new JPanel();  
        p1.setBounds(0,0,300,100);
        p1.setBackground(new Color(251, 222, 68));
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel l1 = new JLabel("Login Page");
        l1.setBounds(30,0,100,150);
        l1.setFont(new Font("Serif", Font.BOLD, 52));
        l1.setForeground(new Color(40, 51, 74));
        
        JLabel l2=new JLabel("Username:");
        l2.setBounds(660,50, 900,500);
        l2.setFont(new Font("",  Font.PLAIN, 30));
        l2.setForeground(Color.white);

        JLabel l3=new JLabel("Password:");
        l3.setBounds(660,200, 900,500);
        l3.setFont(new Font("",  Font.PLAIN, 30));
        l3.setForeground(Color.white);
        
        JTextField t2 = new JTextField(); 
        t2.setBounds(660,330, 600,65);
        t2.setFont(new Font("",  Font.PLAIN, 35));
        t2.setBackground(new Color(108,122,137));
        t2.setForeground(Color.white);
        
        JPasswordField t3 = new JPasswordField(); 
        t3.setBounds(660,480, 600,65);
        t3.setFont(new Font("",  Font.PLAIN, 35));
        t3.setBackground(new Color(108,122,137));
        t3.setForeground(Color.white);
        
        JButton b1 =new JButton();
        JButton b2 =new JButton();

        b1.setText("Login");
        b1.setBounds(460,650,350,80);
        b1.setFont(new Font("", Font.BOLD, 35));
        b1.setBackground(new Color(77, 136, 255));
        b1.setForeground(Color.white);
        
        b2.setText("Back");
        b2.setBounds(1100,650,350,80);
        b2.setFont(new Font("", Font.BOLD, 35));
        b2.setBackground(new Color(246,80,88));
        b2.setForeground(Color.white);
        
        f.add(p1);
        p1.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(l2);
        f.add(l3);
        f.add(t2);
        f.add(t3);
        
        Color c=new Color(241, 101, 13);
        f.getContentPane().setBackground(c);
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
            UIManager.put("OptionPane.background",new ColorUIResource(40, 51, 74));
            UIManager.put("Panel.background",new ColorUIResource(225, 87, 12));
            
            String username = t2.getText();
            String password = t3.getText();
            
            if(username.matches("[0-9a-zA-Z]+")&&password.matches("[0-9a-zA-Z]+")){
                UserLogin op = new UserLogin();
                int role = op.Login(username,password);
            
                switch(role){
                    case 1:
                        admin n = new admin();
                        n.a();
                        f.setVisible(false);
                        break;
                    case 3:
                        exit_opretor ex = new exit_opretor();
                        ex.exo();
                        f.setVisible(false);
                        break;
                    case 2:
                        entry_opretor en = new entry_opretor();
                        en.eno();
                        f.setVisible(false);
                        break;
                    default :
                        JOptionPane.showMessageDialog(f,"Wrong username or password.","Alert",JOptionPane.WARNING_MESSAGE);
              }
            }
            else JOptionPane.showMessageDialog(f,"Wrong username or password.","Alert",JOptionPane.WARNING_MESSAGE);
            
        });         
       
    
        b2.addActionListener((ActionEvent e) -> {
            home k=new home();
            k.user();
            f.setVisible(false); 
        });
        
    }
}
