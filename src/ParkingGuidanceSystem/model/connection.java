package ParkingGuidanceSystem.model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class connection {
    
    public static Connection conn;
    public String data = "0";
    public connection (){
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/parking_db?serverTimezone=UTC",
                    "Mahmoud",
                    "Qw12er34m0+?"
            );
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int checkLogin(String username, String password){
        String sql = "select role_id from users where BINARY username = '"+username+"' and BINARY password = '"+password+"'";
        int role = 0;
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            role = rs.getInt(1);
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return role;
    }
    
    public String getTicket(int ticketid){
        String sql = "select entry_date from tickets where id = "+ticketid+" and leaving_date IS NULL";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                return rs.getTimestamp("entry_date").toString();
            }
                
            
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return this.data;
    }
    
    public int addTicket(String plateNum, String date, String spotCode){
        String sql2 = "select id from spots where BINARY name = '"+spotCode+"'";
        
        try{
            Statement sstmt = conn.createStatement();
            ResultSet rs2 = sstmt.executeQuery(sql2);
            rs2.next();
            
            String sql = "insert into tickets(plate_number, entry_date, spot_id) values('"+plateNum+"','"+date+"',"+rs2.getInt(1)+")";
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public boolean updateTicketTime(int ticketId,String plateNum,String leavingTime){
        String sql = "update tickets set leaving_date = '"+leavingTime+"' where id = "+ticketId+" and BINARY plate_number = '"+plateNum+"' and leaving_date IS NULL";
        
        try{
            Statement stmt = conn.createStatement();
            return stmt.execute(sql);
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public List viewSpots(){
        String sql = "select name, status from spots";
        List list = new ArrayList();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                list.add(rs.getString(1)+" "+rs.getString(2));
            }
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    //overloading
    public List viewSpots(String status){
        String sql = "select name from spots where status = '"+status+"'";
        List list = new ArrayList();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                list.add(rs.getString(1));
            }
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }
    
    public int addSpot(String spotName){
        String sql = "insert into spots(status,name) values('true','"+spotName+"')";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            int valid = stmt.executeUpdate();
            return valid;
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public int addUser(String username, String password, int roleid, int shiftid){
        String sql = "insert into users(username,password,role_id,shift_id) values('"+username+"','"+password+"',"+roleid+","+shiftid+")";
        
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            int valid = stmt.executeUpdate();
            return valid;
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
            
    public int updateRole(String username, int roleid){
        String sql = "update users set role_id = "+roleid+" where BINARY username = '"+username+"'";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            int valid = stmt.executeUpdate();
            return valid;
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public int deleteUser(String username){
        String sql = "delete from users where BINARY username = '"+username+"'";
        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            int valid = stmt.executeUpdate();
            return valid;
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public String changebusy(String status){
        String sql = "select name from spots where status = '"+status+"' LIMIT 1";
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                String Code = rs.getString(1);
                String sql2 = "update spots set status = 'false' where BINARY name = '"+Code+"'";
                stmt.execute(sql2);
                return Code;
            }
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return "false";
    }
    
    public int getspot(int ticketID, String plateNum){
        String sql = "select spot_id from tickets where id = "+ticketID+" and BINARY plate_number = '"+plateNum+"' and leaving_date IS NULL";
        
        try{
            Statement stmt = conn.createStatement();
            ResultSet id = stmt.executeQuery(sql);
            id.next();
            return id.getInt(1);
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
    
    public boolean changeempty(int spotId){
        String sql = "update spots set status = 'true' where id= "+spotId+"";
        try{
            Statement stmt = conn.createStatement();
            return stmt.execute(sql);
            
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
    return false;
    }
    
    public List viewshiftreport(String date, int shiftid){
       
        String sql="select start, end from shifts where id = "+shiftid+"";
            List list = new ArrayList();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                sql ="select * from tickets where entry_date between '"+date+" "+rs.getTime(1)+"' AND '"+date+" "+rs.getTime(2)+"' or leaving_date between '"+date+" "+rs.getTime(1)+"' AND '"+date+" "+rs.getTime(2)+"' ";
                rs = stmt.executeQuery(sql);
                while(rs.next()){
                    list.add(rs.getString(1)+","+rs.getString(2)+","+rs.getTimestamp(3)+","+rs.getTimestamp(4));
                }
            }
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
   
   }
   
   
   public List viewcarreport(String date){
        String sql="select * from tickets where entry_date between '"+date+"' AND curdate()+1";
            
            List list = new ArrayList();
        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                list.add(rs.getString(1)+","+rs.getString(2)+","+rs.getTimestamp(3)+","+rs.getTimestamp(4));
            }
	}catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
   
   }
}





