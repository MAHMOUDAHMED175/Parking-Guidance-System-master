package ParkingGuidanceSystem.view.entry;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

import ParkingGuidanceSystem.view.main.home;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class entry_opretor {
    public void eno(){
        JFrame f=new JFrame("Parking Guidance System");
        
        JPanel p1=new JPanel();  
        p1.setBounds(0,0,650,100);
        p1.setBackground(new Color(251, 222, 68));
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel l1 = new JLabel("Entry Operator Profile");
        l1.setBounds(30,0,650,150);
        l1.setFont(new Font("Serif", Font.BOLD, 52));
        l1.setForeground(new Color(40, 51, 74));
        
        JButton b1 =new JButton();
        JButton b3 =new JButton();

        b1.setText("Free Spots");
        b1.setBounds(460,350,350,80);
        b1.setFont(new Font("", Font.BOLD, 30));
        b1.setBackground(new Color(77, 136, 255));
        b1.setForeground(Color.white);
        
        b3.setText("Logout");
        b3.setBounds(1100,350,350,80);
        b3.setFont(new Font("", Font.BOLD, 30));
        b3.setBackground(new Color(246,80,88));
        b3.setForeground(Color.white);
        
        Color c=new Color(40, 51, 74);
        f.getContentPane().setBackground(c);
                
        f.add(p1);
        p1.add(l1);
        f.add(b1);
        f.add(b3);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
                
        b1.addActionListener((ActionEvent e) -> {
            free_spots op = new free_spots();
            op.as(); 
        });
        
        b3.addActionListener((ActionEvent e) -> {
            home k=new home();
            k.user();
            f.setVisible(false); 
        });    
    }
    
}
