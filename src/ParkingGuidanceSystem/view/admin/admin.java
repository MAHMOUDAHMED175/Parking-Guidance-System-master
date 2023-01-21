package ParkingGuidanceSystem.view.admin;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

import ParkingGuidanceSystem.view.main.home;

public class admin {
    public void a(){
        JFrame f=new JFrame("Parking Guidance System");
        
        JPanel p1=new JPanel();  
        p1.setBounds(10,10,380,100);
        p1.setBackground(new Color(251, 222, 68));
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel l1 = new JLabel("Admin Profile");
        l1.setBounds(10,10,380,150);
        l1.setFont(new Font("Serif", Font.BOLD, 52));
        l1.setForeground(new Color(40, 51, 74));
        
        JButton b1 =new JButton();
        JButton b2 =new JButton();
        JButton b3 =new JButton();
        JButton b4 =new JButton();
        JButton b5 =new JButton();
        JButton b6 =new JButton();
        JButton b7 =new JButton();
        JButton b8 =new JButton();
             

        b1.setText("Add Spot");
        b1.setBounds(80,200,350,80);
        b1.setFont(new Font("", Font.BOLD, 30));
        b1.setBackground(new Color(77, 136, 255));
        b1.setForeground(Color.white);
        
        b2.setText("Add User");
        b2.setBounds(650,300,350,80);
        b2.setFont(new Font("", Font.BOLD, 30));
        b2.setBackground(new Color(77, 136, 255));
        b2.setForeground(Color.white);
                
        b3.setText("Update User");
        b3.setBounds(1150,200,350,80);
        b3.setFont(new Font("", Font.BOLD, 30));
        b3.setBackground(new Color(77, 136, 255));
        b3.setForeground(Color.white);
        
        b4.setText("Delete User");
        b4.setBounds(60,430,350,80);
        b4.setFont(new Font("", Font.BOLD, 30));
        b4.setBackground(new Color(77, 136, 255));
        b4.setForeground(Color.white);
        
        b5.setText("View Shift Report");
        b5.setBounds(650,530,350,80);
        b5.setFont(new Font("", Font.BOLD, 30));
        b5.setBackground(new Color(77, 136, 255));
        b5.setForeground(Color.white);
                
        b6.setText("View Parking Report");
        b6.setBounds(1150,430,350,80);
        b6.setFont(new Font("", Font.BOLD, 30));
        b6.setBackground(new Color(77, 136, 255));
        b6.setForeground(Color.white);
        
        b7.setText("Logout");
        b7.setBounds(1150,660,350,80);
        b7.setFont(new Font("", Font.BOLD, 30));
        b7.setBackground(new Color(246,80,88));
        b7.setForeground(Color.white);
            
        b8.setText("View Spots");
        b8.setBounds(60,660,350,80);
        b8.setFont(new Font("", Font.BOLD, 30));
        b8.setBackground(new Color(77, 136, 255));
        b8.setForeground(Color.white);
        
        f.add(p1);
        p1.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(b7);
        f.add(b8);
               
        Color c=new Color(40, 51, 74);
        f.getContentPane().setBackground(c);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true); 
    
        b1.addActionListener((ActionEvent e) -> {
            add_spot k=new add_spot();
            k.as();
            f.setVisible(false); 
        }); 
        
        b2.addActionListener((ActionEvent e) -> {
            add_user a=new add_user();
            a.au();
            f.setVisible(false); 
        }); 
         
        b3.addActionListener((ActionEvent e) -> {
            update_user m=new update_user();
            m.uu();
            f.setVisible(false); 
        }); 
        
        b4.addActionListener((ActionEvent e) -> {
            delete_user b=new delete_user();
            b.du();
            f.setVisible(false); 
        }); 
        
        b5.addActionListener((ActionEvent e) -> {
            shift_report nk=new shift_report();
            nk.shr();
            f.setVisible(false); 
        });
        
        b6.addActionListener((ActionEvent e) -> {
            parking_report nk=new parking_report();
            nk.pr();
            f.setVisible(false); 
        }); 
            
       
    
        b7.addActionListener((ActionEvent e) -> {
            home k=new home();
            k.user();
            f.setVisible(false); 
        }); 
    
        b8.addActionListener((ActionEvent e) -> {
            all_spots op = new all_spots();
            op.as(); 
        }); 
    
      
    
    }
}
