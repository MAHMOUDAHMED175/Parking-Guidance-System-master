package ParkingGuidanceSystem.controller;

import ParkingGuidanceSystem.model.connection;
public class UserLogin {

    private int Id = 0;
    
    public int Login(String UserName , String password ){
        if(!UserName.isEmpty()&&!password.isEmpty()&&UserName.length()<100&&password.length()<100){
            connection conn = new connection();
            this.Id = conn.checkLogin(UserName, password);
        }
         
        return this.Id;   
    }

}
