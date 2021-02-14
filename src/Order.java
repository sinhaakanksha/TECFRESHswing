
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Order {
  /* static*/ int orderId;
   String Status;
    String date;
    String Address;
    int total;
    ArrayList<Product> OD;
    
public void setOrderId(int id){
    this.orderId=id;
}
public void setAddress(String add){
    this.Address=add;
}
public void setDate(String dt){
    this.date=dt;
}
public void setOrder(ArrayList<Product> PD){
    this.OD=PD;
}
public void setTotal( int t){
    this.total=t;
}
public int getOrderId(){
    
    return orderId++;
}
public void setStatus(String s){
    this.Status=s;
}
public String getAddress(){
    return Address;
}
public String getDate(){
    return date;
}
public ArrayList getOrder(){
    return OD;
}
public int getTotal(){
    return total;
}
public String getID(){
    return String.valueOf(orderId);
}
public String getStatus(){
    return Status;
}
}

 