/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Catalog {
    String productName = null;
    String productCatg = null;
    int discount = 0;
    int Price = 0;
    int totalPrice=0;
    int Quantity=0;
    
    public void setName(String name){
        this.productName=name;
    }
        
    public void setCategory(String category){
        this.productCatg = category;
    }
    
    
    public void setDiscount(int d){
        this.discount=d;
    }
    
    public void setPrice(int pr){
        this.Price=pr;
    }
    
    public String getName(){
        return productName;
    }
        
    public String getCategory(){
        return productCatg;
    }
    
    public int getDiscount(){
        return discount;
    }
    
    
    public int getPrice(){
        return Price;
    }
    
    
}
