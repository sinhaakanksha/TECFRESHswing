
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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
public class OrderManager {
     static int id=1123;
    private ArrayList<Product> OD;
    private ArrayList<Order> ORDER;
    public OrderManager(){
        init();
    }
    public void init( ){
        OD = new ArrayList<>();
         ORDER = new ArrayList<>();
         //id=1123;
    }

    public void Add(String name, int quantity, int price) {
        Product po = new Product();
        po.NameSetter(name);
        po.QuantitySetter(quantity);
        po.PriceSetter(price);
        po.TotalSetter(quantity * price);
        OD.add(po);
    }

    public void Delete(String name) {
        for (int i = 0; i < OD.size(); i++) {
            if (OD.get(i).NameGetter().equals(name)) {
                OD.remove(i);
            }
        }
    }

    public void Display() {
        for (int i = 0; i < OD.size(); i++) {
            System.out.println(OD.get(i).NameGetter() + " " + OD.get(i).QuantityGetter() + " " + OD.get(i).PriceGetter() + " " + OD.get(i).TotalGetter());
        }
    }
    public void Confirm() {
        int sum=0;
        Order or= new Order();
        or.setOrderId(id);
        id++;
        or.setAddress("dnaogjofpkdow");
        or.setDate("12.02.21");
        or.setOrder(OD);
        for(int i=0;i<OD.size();i++){
           sum=sum+OD.get(i).TotalGetter();
        }
        or.setTotal(sum);
        ORDER.add(or);
       
       
    }
    public void Disp(){
        for(int i=0;i<ORDER.size();i++){
            System.out.println(ORDER.get(i).getOrderId()+" "+ORDER.get(i).getAddress()+" ");
            for(int j=0;j<OD.size();j++){
                System.out.println(OD.get(j).NameGetter() + " " + OD.get(j).QuantityGetter() + " " + OD.get(j).PriceGetter() + " " + OD.get(j).TotalGetter());
            }
            System.out.println(ORDER.get(i).getTotal());
        }
    }
    

    public static void main(String[] args) throws IOException {
        OrderManager m = new OrderManager();
        OrderManager m1 = new OrderManager();
        m.Add("Potato", 2, 30);
        m.Add("Tomato", 2, 120);
        m1.Add("Milk", 2, 50);
        m1.Add("Sope", 3, 150);
        m1.Add("Parle G", 1, 20);
        //m.Display();
        //m.Delete("Sope");
       // m.Display();
       m.Confirm();
       m.Disp(); 
       m1.Confirm();
       m1.Disp();
       //m.init("Tomato");

    }

}
