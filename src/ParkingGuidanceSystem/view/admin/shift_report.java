package ParkingGuidanceSystem.view.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;

public class shift_report {
    public void shr(){
        JFrame f=new JFrame("Parking Guidance System");
        
        JPanel p1=new JPanel();  
        p1.setBounds(0,0,750,100);
        p1.setBackground(new Color(251, 222, 68));
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel l1 = new JLabel("Admin Profile [Shift Report]");
        l1.setBounds(30,0,100,150);
        l1.setFont(new Font("Serif", Font.BOLD, 52));
        l1.setForeground(new Color(40, 51, 74));
        
        JLabel l2=new JLabel("Date (yyyy-mm-dd):");
        l2.setBounds(660,25, 900,500);
        l2.setFont(new Font("", Font.PLAIN, 30));
        l2.setForeground(Color.white);
        
        JLabel l3=new JLabel("Shift:");
        l3.setBounds(660,150, 900,500);
        l3.setFont(new Font("", Font.PLAIN, 30));
        l3.setForeground(Color.white);
            
        JTextField t1 = new JTextField(); 
        t1.setBounds(660,300, 550,65);
        t1.setFont(new Font("", Font.PLAIN, 35));
        t1.setBackground(new Color(108,122,137));
        t1.setForeground(Color.white);
        
        String[] shiftStrings = {"Morning", "Mid-Day", "Evening", "Overnight"};
        JComboBox shiftList = new JComboBox(shiftStrings);
        shiftList.setBounds(660,425, 550,65);
        shiftList.setFont(new Font("", Font.PLAIN, 35));
        shiftList.setSelectedIndex(1);
        
        JButton b1 =new JButton();
        JButton b2 =new JButton();
        
        b1.setText("view");
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
        f.add(shiftList);
        f.add(b1);
        f.add(b2);
        
        b1.addActionListener((ActionEvent e) -> {
            String date1 = t1.getText();
            int shiftId = shiftList.getSelectedIndex()+1;
            
            UIManager.put("OptionPane.messageFont", new FontUIResource(
            new Font("Verdana", Font.PLAIN, 30) ) );
            UIManager.put("OptionPane.messageForeground", Color.white);
            UIManager.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.BOLD,30)));
            UIManager.put("Button.background", new Color(251, 222, 68));
            UIManager.put("OptionPane.minimumSize",new Dimension(550,200)); 
            UIManager.put("OptionPane.background",new ColorUIResource(40, 51, 74));
            UIManager.put("Panel.background",new ColorUIResource(40, 51, 74));
            
            if(!date1.isEmpty() && date1.matches("[0-9-]+")){
                table_shift_report nk=new table_shift_report();
                nk.vsr(date1,shiftId);
            }
            else JOptionPane.showMessageDialog(f,"Date must be in format yyyy-mm-dd.","Alert",JOptionPane.WARNING_MESSAGE); ;
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
