package ParkingGuidanceSystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import ParkingGuidanceSystem.model.connection;

public class Customer { 
    
    private final String plateNumbre;
    public Ticket t;

    // setter
    public Customer(String plateNumbre){
        this.plateNumbre = plateNumbre;
    }
    
    private String getSpot(){
        connection conn = new connection();
        String code = conn.changebusy("true");
        return code;
    }
    
    public String printTicket(){
        if(!plateNumbre.isEmpty() && plateNumbre.length() < 12){
            String spotCode = this.getSpot();
            t = new Ticket(plateNumbre,spotCode);
            return t.toString();
        }
        return "Process failed";
    }
    
    public int pay (int ticketid) throws ParseException{
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String leavingDate = formatter.format(new Date());
        
        connection conn = new connection();
        
        int check_si = conn.getspot(ticketid, this.plateNumbre);
        
        if(check_si > 0){
            exitOperator op = new exitOperator();
            int cost = 5 * op.parkingHours(ticketid);
            
            conn.changeempty(check_si);
            conn.updateTicketTime(ticketid, this.plateNumbre, leavingDate);
            
            return cost;
        }
        return -1;
    }
    
}
