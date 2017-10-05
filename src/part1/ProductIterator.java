package part1;

import java.util.ArrayList;



public class ProductIterator implements Iterator {

    private ArrayList<Product> productList;
    private Integer index;


    public ProductIterator(ArrayList<Product> productList){
        this.productList = productList;
        this.index = 0;
    }


    public ArrayList<Product> getProductList() {
        return this.productList;
    }

    @Override
    public boolean hasNext() {
        if(this.index < this.productList.size()) {
            return true;
        }
        return false;
    }


    @Override
    public Product next() {
        return productList.get(index++);
    }
}
