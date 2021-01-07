package Service;

import Model.Product;
import storge.ReadAndWrite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManager {
    private List<Product> list = new ArrayList<>();
    public static final String FILE_NAME = "product.dat";

    public void addProduct(Product p) {
        list.add(p);
        ReadAndWrite.writeFile(list,FILE_NAME);
    }

    public void displayProduct() {
        for (Product p : list) {
            System.out.println(p);
        }
    }

    public void  findProductById(int id){
        for (Product p: list) {
            if (p.getId() == id){
                System.out.println(p);
                return;
            }
        }
        System.out.println("Not found !!!");
    }

    public void deleteProductByName (String name){
        for (Product p: list) {
            if (name.equalsIgnoreCase(p.getName())){
                list.remove(p);
            }
        }
    }

    public void edit(int index, Product product){
        for (int i = 0; i < list.size(); i++) {
            if(index==i){
                list.set(i,product);
                return;
            }
        }
        displayProduct();
    }
    public void sortByPrice(){
        Collections.sort(list,((o1, o2) -> {
            if(o1.getPrice()>o2.getPrice()) return 1;
            if(o1.getPrice()<o2.getPrice()) return -1;
            else return 0;
        }));
    }
    public void sortById(){
        Collections.sort(list,((o1, o2) -> {
            if(o1.getId()>o2.getId()) return 1;
            if(o1.getId()<o2.getId()) return -1000;
            else return 0;
        }));
    }
    public void sortByName(){
        Collections.sort(list);
    }


}
