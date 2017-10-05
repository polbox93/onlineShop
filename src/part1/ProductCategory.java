package part1;

import java.util.ArrayList;

public class ProductCategory {

    private String name;
    private Integer ID;
    private static Integer counter = 1;
    private static ArrayList<ProductCategory> categories = new ArrayList<>();


    public ProductCategory(){

        this.ID = counter++;
    }

    public ProductCategory(String name) {
        this.name = name;
        this.ID = counter++;
        categories.add(this);
    }

    public String getName(){
        return name;
    }


    public String toString() {
        String result = this.ID.toString() + ". " + this.name;
        return result;
    }


    public static ArrayList<ProductCategory> getList(){

        return categories;
    }

    public static ProductCategory checkCategory(String category) throws NullPointerException{
        for(ProductCategory pc : categories){
            if(pc.getName().equals(category)){
                return pc;
            }
        }
        throw new NullPointerException("There is no such category. First create category.");
    }


    public static ProductCategory getProductCategory(String categoryName) throws NullPointerException{
        for(ProductCategory prodCat : categories){
            if(prodCat.getName().equals(categoryName)){
                return prodCat;
            }
        }
        throw new NullPointerException("No cuch category");
    }
}