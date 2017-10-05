package part1;

import java.util.ArrayList;

public class Basket {
    private ProductIterator iterator;
    private ArrayList<Product> productList;

    public Basket(){
        this.iterator = iterator;
        this.productList = new ArrayList<>();
    }


    public ProductIterator getIterator(){
        this.iterator = new ProductIterator(this.productList);
        return this.iterator;
    }


    public ArrayList<Product> getBasket(){
        return this.productList;
    }


    public void addProduct(Product product){
        this.productList.add(product);
    }


    public Boolean removeProduct(Product product){
        if (this.productList.contains(product)){
            productList.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public void clearBasket(){
        this.productList.clear();
    }
}
