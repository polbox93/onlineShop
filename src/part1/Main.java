package part1;

import java.util.Date;

public class Main{

    public static void main(String[] args) {
        FeaturedProductCategory fpc = new FeaturedProductCategory("clothes", new Date(05,02,2017));
        Product tshirt = new Product("tshirt", 2.3f, fpc);
        System.out.println(tshirt);


        Product dress = new Product("dress", 2.9f, fpc);
        System.out.println(dress);


        Product eggs = new Product("eggs", 2.3f, new FeaturedProductCategory("Food", new Date(02,10,2017)));
        System.out.println(eggs);


        Product bread = new Product("bread", 1.0f, new FeaturedProductCategory("Food", new Date(05,12,2017)));
        System.out.println(bread);


        System.out.println(Product.getAllProducts());


        Basket basket = new Basket();
        basket.addProduct(tshirt);
        basket.addProduct(dress);
        basket.addProduct(eggs);
        basket.addProduct(bread);

        System.out.println(basket.getBasket());



        ProductIterator iter = basket.getIterator();

        System.out.println(iter.getProductList());


//        System.out.println(iter.productList);

        while (iter.hasNext()){
            System.out.println(iter.next());
        }

    }

}
