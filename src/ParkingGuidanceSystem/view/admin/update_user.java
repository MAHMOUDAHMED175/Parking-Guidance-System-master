package ParkingGuidanceSystem.view.admin;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import ParkingGuidanceSystem.controller.*;
import java.awt.Dimension;
import javax.swing.plaf.ColorUIResource;

public class update_user {
    public void uu(){
    
        JFrame f=new JFrame("Parking Guidance System");
        
        JPanel p1=new JPanel();  
        p1.setBounds(0,0,650,100);
        p1.setBackground(new Color(251, 222, 68));
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel l1 = new JLabel("Admin Profile [Update User]");
        l1.setBounds(30,0,100,150);
        l1.setFont(new Font("Serif", Font.BOLD, 52));
        l1.setForeground(new Color(40, 51, 74));
        
        JLabel l2=new JLabel("Username:");
        l2.setBounds(660,25, 900,500);
        l2.setFont(new Font("", Font.PLAIN, 30));
        l2.setForeground(Color.white);
        
        JLabel l3=new JLabel("New Role:");
        l3.setBounds(660,150, 900,500);
        l3.setFont(new Font("", Font.PLAIN, 30));
        l3.setForeground(Color.white);
            
        JTextField t1 = new JTextField(); 
        t1.setBounds(660,300, 550,65);
        t1.setFont(new Font("", Font.PLAIN, 35));
        t1.setBackground(new Color(108,122,137));
        t1.setForeground(Color.white);
        
        String[] petStrings = {"Admin", "Entry Operator", "Exit Operator"};
        JComboBox petList = new JComboBox(petStrings);
        petList.setBounds(660,425, 550,65);
        petList.setFont(new Font("", Font.PLAIN, 35));
        petList.setSelectedIndex(1);
        
        JButton b1 =new JButton();
        JButton b2 =new JButton();
        
        b1.setText("Update");
        b1.setBounds(460,575,350,80);
        b1.setFont(new Font("", Font.BOLD, 30));
        b1.setBackground(new Color(77, 136, 255));
        b1.setForeground(Color.white);
        
        b2.setText("Back");
        b2.setBounds(1100,575,350,80);
        b2.setFont(new Font("", Font.BOLD, 30));
        b2.setBackground(new Color(246,80,88));
        b2.setForeground(Color.white);  
           
        f.add(p1);
        p1.add(l1);
        f.add(l2);
        f.add(l3);
        f.add(t1);
        f.add(petList);
        f.add(b1);
        f.add(b2);
        
        b1.addActionListener((ActionEvent e) -> {
            UIManager.put("OptionPane.messageFont", new FontUIResource(
            new Font("Verdana", Font.PLAIN, 30) ) );
            UIManager.put("OptionPane.messageForeground", Color.white);
            UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.BOLD,30)));
            UIManager.put("Button.background", new Color(251, 222, 68));
            UIManager.put("OptionPane.minimumSize",new Dimension(550,200)); 
            UIManager.put("OptionPane.background",new ColorUIResource(40, 51, 74));
            UIManager.put("Panel.background",new ColorUIResource(40, 51, 74));
            
            String username = t1.getText();
            int roleId = petList.getSelectedIndex()+1;
            
            if(username.matches("[0-9a-zA-Z]+")){
                AdminClass op = new AdminClass();
                if(op.UpdateUser(username, roleId))
                    JOptionPane.showMessageDialog(f,"User updated successfuly.");
                else
                    JOptionPane.showMessageDialog(f,"Operation faild.","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else JOptionPane.showMessageDialog(f,"Only numbers and characters are allowed.","Alert",JOptionPane.WARNING_MESSAGE);
        }); 
            
        b2.addActionListener((ActionEvent e) -> {
            admin h=new admin();
            h.a();
            f.setVisible(false);
        }); 
                        
        Color c=new Color(40, 51, 74);
        f.getContentPane().setBackground(c);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
    }
}
