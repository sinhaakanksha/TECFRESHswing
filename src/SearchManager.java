import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
        
public class SearchManager {
    private List<Catalog> list;
    private List<Catalog> filterlist;

    public SearchManager(){
        this.list = new ArrayList<Catalog>();
        this.filterlist = new ArrayList<Catalog>();
        //this.init("");
    }
    
    public boolean init(String filename){
        /**list= new ArrayList<>();
        filterlist = new ArrayList<>();*/
        
        boolean result = false;
        String line = "";  
        String splitBy = ","; 
        try{  
            BufferedReader br = new BufferedReader(new FileReader(filename));  
            br.readLine();
            while((line = br.readLine()) != null)   //returns a Boolean value 
            {  
                String[] product = line.split(splitBy);    // use comma as separator
                
                /**System.out.println("Product Name: "+product[0]+",Product Price: "
                        +product[1]+",Category: "+product[2]+",Discount: "+product[3]);*/ 
                
                Catalog c = new Catalog();
                c.setName(product[0]);
                c.setPrice(Integer.parseInt(product[1]));
                c.setCategory(product[2]);
                c.setDiscount(Integer.parseInt(product[3]));
                list.add(c);
            }
            result = true;
        }   
        catch (IOException e){  
            e.printStackTrace();  
        }
        return result;
    }
    
    public List<Catalog> search(String query,List<Catalog> list){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().toLowerCase().contains(query.toLowerCase())){
                Catalog cg = new Catalog();
                cg.setName(list.get(i).getName());
                cg.setPrice(list.get(i).getPrice());
                cg.setCategory(list.get(i).getCategory());
                cg.setDiscount(list.get(i).getDiscount());
                filterlist.add(cg);
            }
        }
        return filterlist;
    }
    
    public void display(List<Catalog> arr){
        this.list = arr;
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i).getName()+","+arr.get(i).getPrice()+","
                    +arr.get(i).getCategory()+","+arr.get(i).getDiscount());
        }
    }
    
    public List<Catalog> getProducts(){
        List<Catalog> products = null;
        
        products = Collections.unmodifiableList(this.list);
        return products;
    }
    
    public static void main(String[] args){
        //instantiate manager
        SearchManager sm = new SearchManager();
        List<Catalog> lt = sm.getProducts();
        
        //initialise
        sm.init("src/products.csv");
        
        /*unit tests
        List<Catalog> temp = sm.getProducts();
        assert(sm.getProducts().size()==9);
        assert(sm.getProducts().get(2).getName().contains("Apple"));*/
        
        
        sm.display(lt);
        System.out.println();
        System.out.println("Search Query = to");
        List<Catalog> filterlist = sm.search("to",lt);
        sm.display(filterlist);
    }
}