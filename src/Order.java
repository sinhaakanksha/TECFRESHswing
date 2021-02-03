
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
   static int orderId;
    String date;
    String Address;
    //int total;
    ArrayList<Product> ODR;
    
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
    this.ODR=PD;
}
static int getOrderId(){
    return orderId++;
}
public String getAddress(){
    return Address;
}
public String getDate(){
    return date;
}
public ArrayList getOrder(){
    return ODR;
}
}

 