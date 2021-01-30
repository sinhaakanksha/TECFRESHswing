
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

    private ArrayList<Product> OD = new ArrayList<>();
    private ArrayList<Product> FO = new ArrayList<>();

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
    public void Confirm() throws IOException{
        /*int sum=0;
        BufferedWriter bw= new BufferedWriter(new FileWriter("src/order.csv"));
         bw.write("Product"+","+"Quantity"+","+"Price"+","+"TotalPrice");
         bw.newLine();
        for( int i=0;i<OD.size();i++){
            bw.write(OD.get(i).NameGetter()+","+OD.get(i).QuantityGetter()+","+OD.get(i).PriceGetter()+","+OD.get(i).TotalGetter());
            sum= sum +Integer.valueOf(OD.get(i).TotalGetter());
            bw.newLine();
        }
        bw.write(",,,"+sum);
        bw.flush();*/
        for (int i = 0; i < OD.size(); i++){
        Product p = new Product();
        p.NameSetter(OD.get(i).NameGetter());
        p.QuantitySetter(OD.get(i).QuantityGetter());
        p.PriceSetter(OD.get(i).PriceGetter());
        p.TotalSetter(OD.get(i).TotalGetter());
        FO.add(p);
        }
    }
    public void init( String name){
        int temp=0;
        for(int i=0;i<FO.size();i++){
            if(FO.get(i).NameGetter().equals(name))
            {
                System.out.println("Element found in your order");
                temp=1;
                
            }
            
        }
        if(temp==0){
         System.out.println("Element NOT present in your order");
        }
    }

    public static void main(String[] args) throws IOException {
        OrderManager m = new OrderManager();
        m.Add("Potato", 2, 30);
        m.Add("Tomato", 2, 120);
        m.Add("Milk", 2, 50);
        m.Add("Sope", 3, 150);
        m.Add("Parle G", 1, 20);
        m.Display();
        //m.Delete("Sope");
       // m.Display();
       m.Confirm();
       m.init("Tomato");

    }

}
