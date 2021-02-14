
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;

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
     /*static*/ int id=1123;
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
        int s=0;
        System.out.println("Product  Quantity Price Total");
        for (int i = 0; i < OD.size(); i++) {
            System.out.println(OD.get(i).NameGetter() + "   " + OD.get(i).QuantityGetter() + "        " 
                    + OD.get(i).PriceGetter() + "     " + OD.get(i).TotalGetter());
            s=s+OD.get(i).TotalGetter();
                    
        }
        System.out.println(s);
        
        
    }
    public ArrayList Viewcart(){
        /*Add("Potato", 2, 30);
        Add("abs", 2, 60);
        Add("xyz", 5, 300);*/
         return OD;
    }
    public ArrayList view(){
        return OD;
    }
    public ArrayList ViewOrder(){
         Add("Potato", 2, 30);
        Add("abs", 2, 60);
        Add("xyz", 5, 300);
        Confirm();
        Add("Potato", 2, 30);
        Add("abs", 2, 60);
        Add("xyz", 6, 300);
       Confirm();
      /* Add("Potato", 2, 30);
        Add("abs", 4, 60);
        Add("xyz", 5, 300);
       Confirm();*/
       
        return ORDER;
    }
    public void Confirm() {
        int sum=0;
        Order or= new Order();
        or.setOrderId(id);
        id++;
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy ");
        or.setAddress("dnaogjofpkdow");
        or.setDate(formatter.format(date));
        or.setStatus("pending");
        or.setOrder(OD);
        for(int i=0;i<OD.size();i++){
           sum=sum+OD.get(i).TotalGetter();
        }
        or.setTotal(sum);
        ORDER.add(or);
        OD= new ArrayList<>();
        
       
       
    }
    public void Disp(){
        for(int i=0;i<ORDER.size();i++){
           // if(ORDER.get(i).getID()==(oid)){
            System.out.println(ORDER.get(i).getOrderId()+" "+ORDER.get(i).getAddress()+" "+ ORDER.get(i).getDate());
            for(int j=0;j<OD.size();j++){
                System.out.println(OD.get(j).NameGetter() + " " + OD.get(j).QuantityGetter() + " " + OD.get(j).PriceGetter() + " " + OD.get(j).TotalGetter());
            }
            System.out.println(ORDER.get(i).getTotal());
        //}
        }
    }
    

    public static void main(String[] args) throws IOException {
        OrderManager m = new OrderManager();
        OrderManager m1 = new OrderManager();
        
        m.Add("Potato", 2, 30);
        m.Add("Tomato", 2, 120);
        m1.Add("Milk", 2, 50);
        m.Add("Sope", 3, 150);
        m.Add("Parle G", 1, 20);
        JFrame MainUI= new MainUI(m);
        MainUI.setVisible(true);
       /* m.Display();
        m.Delete("Sope");
        m.Display();
       m.Confirm();
       m.Disp(); 
       m1.Confirm();
       m1.Disp();
       m.init("Tomato");
     //assert(mgr.getAllPatients().length()==12)
//assert(mgr.getPatient("123").name().equals("Arif"))*/

    }

}
