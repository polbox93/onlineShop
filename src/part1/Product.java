package part1;

import java.util.ArrayList;


public class Product {

    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;
    private static Integer counter = 1;
    private static ArrayList<Product> productList = new ArrayList<>();


    public Product(){
        this.ID = counter++;
        productList.add(this);
    }

    public Product(String name, Float defaultPrice, ProductCategory productCategory){
        this.ID = counter++;
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;

        productList.add(this);

    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString() {
        String result = "";

        if (this.productCategory instanceof FeaturedProductCategory) {
            result = String.format("FeaturedProductCategory: ID: %d, name: %s, default price: %f", this.ID,
                                            this.name, this.defaultPrice);
        } else {
            result = String.format("ID: %d, name: %s, default price: %f", this.ID,
                    this.name, this.defaultPrice);
        }
        return result;
    }

    public static ArrayList<Product> getAllProducts(){

        return productList;
    }

    public static ArrayList<Product> getAllProductsBy(ProductCategory productCategory) throws NullPointerException{
        ArrayList<Product> resultList = new ArrayList<>();

        for (Product prod : productList){
            if (prod.productCategory.equals(productCategory)){
                resultList.add(prod);
            } else {
                throw new NullPointerException("Sorry, no category with this name");
            }
        }
        return resultList;
    }

    public static Product getProductByName(String name) throws NullPointerException {
        for(Product prod : productList){
            if(prod.getName().equals(name)){
                return prod;
            }
        }
        throw new NullPointerException("Sorry, no product with this name");
    }
}
