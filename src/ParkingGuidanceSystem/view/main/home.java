package ParkingGuidanceSystem.view.main;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class home {
    public void user(){
        JFrame f = new JFrame("Parking Guidance System");
        
        JPanel p1=new JPanel();
        p1.setBounds(0,0,600,100);
        p1.setBackground(new Color(197, 154, 15));
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel l1 = new JLabel("Parking Guidance System");
        l1.setBounds(30,0,90,150);
        l1.setFont(new Font("Serif", Font.BOLD, 52));
        l1.setForeground(new Color(0, 0, 0));
        
        JButton b1 =new JButton();
        JButton b2 =new JButton();
        JButton b3 =new JButton();

        b1.setText("Enter Parking");
        b1.setBounds(485,350,550,90);
        b1.setFont(new Font("", Font.BOLD, 35));
        b1.setBackground(new Color(77, 136, 255));
        b1.setForeground(Color.white);
        
        b2.setText("Exit Parking");
        b2.setBounds(485,550,550,90);
        b2.setFont(new Font("", Font.BOLD, 35));
        b2.setBackground(new Color(246,80,88));
        b2.setForeground(Color.white);
                
        b3.setText("Login");
        b3.setBounds(1300,700,200,70);
        b3.setFont(new Font("", Font.BOLD, 30));
        b3.setBackground(new Color(77, 255, 77));
        b3.setForeground(Color.black);
        // الخلفيه الكبيره
        Color c=new Color(199, 62, 62);
        f.getContentPane().setBackground(c);
        
        f.add(p1);
        p1.add(l1);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);

               
        b1.addActionListener((ActionEvent e) -> {
            entry n = new entry();
            n.t();
            
            f.setLayout(null);
            f.setVisible(false);
        });
                  
        b2.addActionListener((ActionEvent e) -> {
            exit n=new exit();
            n.ex();
            
            f.setLayout(null);
            f.setVisible(false);
        });
        
        b3.addActionListener((ActionEvent e) -> {
            login n=new login();
            n.log();
            
            f.setLayout(null);
            f.setVisible(false);
        });
    
    }
    
}
