package ParkingGuidanceSystem.view.admin;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import ParkingGuidanceSystem.controller.AdminClass;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class table_parking_report {
    
    public void vpr(String date){
         
        JFrame f=new JFrame("Parking Guidance System");
        
        AdminClass op = new AdminClass();
        List list = op.ViewParkingReport(date);
            
        String[][] data= new String[list.size()][4] ;
        for(int i=0;i<list.size();i++){
            String str = (String) list.get(i);
            String[] splited = str.split(",");
            data[i][0] = splited[0];
            data[i][1] = splited[1];
            data[i][2] = splited[2];
            data[i][3] = splited[3];}
            
        String[] column ={"Ticket ID","Plate Number","Entry Date","Leaving Date"};
        JTable jt=new JTable(data,column);    
        jt.setBounds(200,500,200,300);          
    
        JScrollPane sp=new JScrollPane(jt);  
        jt.setRowHeight(30);
        jt.setFont(new Font("Serif", Font.PLAIN, 25));
        Font font = new Font("Arial", Font.BOLD, 22);
      
        JTableHeader header = jt.getTableHeader();
        header.setFont(font);


        f.add(sp);          
        Color c=new Color(66, 133, 244);
        f.getContentPane().setBackground(c);
                
        f.setSize(1000, 600); 
        f.setVisible(true);
}
}
