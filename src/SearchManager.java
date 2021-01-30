import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
        
public class SearchManager {
    static List<Catalog> list= new ArrayList<>();
    static List<Catalog> filterlist = new ArrayList<>();
    
    public void search(String query,List<Catalog> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().toLowerCase().contains(query.toLowerCase())){
                Catalog pd = new Catalog();
                pd.setName(list.get(i).getName());
                pd.setPrice(list.get(i).getPrice());
                pd.setCategory(list.get(i).getCategory());
                pd.setDiscount(list.get(i).getDiscount());
                filterlist.add(pd);
            }
        }
    }
    
    public void display(List<Catalog> arr){
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i).getName()+","+arr.get(i).getPrice()+","
                    +arr.get(i).getCategory()+","+arr.get(i).getDiscount());
        }
    }
    
    public static void main(String[] args){
        SearchManager sm = new SearchManager();
        String line = "";  
        String splitBy = ",";  
        String path = "src/products.csv";
        try{  
            BufferedReader br = new BufferedReader(new FileReader(path));  
            br.readLine();
            while((line = br.readLine()) != null)   //returns a Boolean value 
            {  
                String[] product = line.split(splitBy);    // use comma as separator
                /**System.out.println("Product Name: "+product[0]+",Product Price: "
                        +product[1]+",Category: "+product[2]+",Discount: "+product[3]);*/  
                Catalog p = new Catalog();
                p.setName(product[0]);
                p.setPrice(Integer.parseInt(product[1]));
                p.setCategory(product[2]);
                p.setDiscount(Integer.parseInt(product[3]));
                list.add(p);
            }  
        }   
        catch (IOException e){  
            e.printStackTrace();  
        }
        
        sm.display(list);
        sm.search("to",list);
        sm.display(filterlist);
    }
}