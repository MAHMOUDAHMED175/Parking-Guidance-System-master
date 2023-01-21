package ParkingGuidanceSystem.view.admin;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import ParkingGuidanceSystem.controller.*;

public class all_spots {
    public void as(){
        JFrame f=new JFrame("Parking Guidance System");
        
        AdminClass op = new AdminClass();
        List list = op.ViewSpots();    
        String[][] data= new String[list.size()][2] ;
        for(int i=0;i<list.size();i++){
            String str = (String) list.get(i);
            String[] splited = str.split("\\s+");
            data[i][0] = splited[0];
            if(splited[1].equals("true"))
                data[i][1] = "Empty";
            else
                data[i][1] = "Busy";
        }
        String column[]={"Code","Status"};         
        
        JTable jt=new JTable(data,column);    
    jt.setBounds(200,500,200,300);          
    JScrollPane sp=new JScrollPane(jt);  
            jt.setRowHeight(30);
            jt.setFont(new Font("Serif", Font.PLAIN, 25));
            Font font = new Font("Arial", Font.BOLD, 22);
      JTableHeader header = jt.getTableHeader();
      header.setFont(font);


    f.add(sp);          
    Color c=new Color(40, 51, 74);
                f.getContentPane().setBackground(c);
                
            f.setSize(500, 600); 
    f.setVisible(true);  
    
    }
}
