package part3;

import part1.*;
import part2.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class ApplicationController {

    private ApplicationView appView;
    private static final String CREATE_NEW_PRODUCT = "1";
    private static final String CREATE_NEW_CATEGORY = "2";
    private static final String ADD_PRODUCT_TO_BASKET = "3";
    private static final String SEE_ALL_PRODUCT_IN_BASKET = "4";
    private static final String REMOVE_PRODUCT_FROM_BASKET = "5";
    private static final String LIST_ALL_AVAILABLE_PRODUCT = "6";
    private static final String PRODUCT_OF_SPECIFIC_CATEGORY = "7";
    private static final String CHECK_AVAILABILITY_OF_PRODUCT = "8";
    private static final String PAY_FOR_ORDER = "9";
    private static final String EXIT = "0";


    public ApplicationController(){

        this.appView = new ApplicationView();
    }


    public void startController(String option, Basket basket){

        switch(option){
            case CREATE_NEW_PRODUCT:
                createNewProduct();
                break;
            case CREATE_NEW_CATEGORY:
                createNewCategory();
                break;
            case ADD_PRODUCT_TO_BASKET:
                addProductToBasket(basket);
                break;
            case SEE_ALL_PRODUCT_IN_BASKET:
                seeAllProductInBasket(basket);
                break;
            case REMOVE_PRODUCT_FROM_BASKET:
                removeProductFromBasket(basket);
                break;
            case LIST_ALL_AVAILABLE_PRODUCT:
                seeAvailableProduct();
                break;
            case PRODUCT_OF_SPECIFIC_CATEGORY:
                checkProductFromCategory();
                break;
            case CHECK_AVAILABILITY_OF_PRODUCT:
                checkAvailabilitySpecificProduct();
                break;
            case PAY_FOR_ORDER:
                payForOrder(basket);
                break;
            case EXIT:
                break;

            default:
                appView.printMsg("No such option. Choose number from 0 to 9.");
        }
    }

    public void createNewProduct(){
        String name;
        String categoryName;
        Float price;

        if(!(ProductCategory.getList().size() == 0 )) {
            try {
                appView.printMsg("Enter product name: ");
                name = appView.getUserInput();

                appView.printMsg("Available categories: ");
                appView.printTable(ProductCategory.getList());
                appView.printMsg("Enter category name: ");
                categoryName = appView.getUserInput();

                appView.printMsg("Enter decimal part of price: ");
                String decimal = appView.getUserInput();
                appView.printMsg("Enter fractional part of price: ");
                String fractional = appView.getUserInput();

                price = Float.parseFloat(decimal + "." + fractional);


                ProductCategory prodCat = ProductCategory.getProductCategory(categoryName);
                Product product = new Product(name, price, prodCat);

                appView.printMsg("Product added successfuly");

            } catch (NumberFormatException e) {
                appView.printMsg("ACHTUNG!!! Wrong number format.");

            } catch (NullPointerException e) {
                appView.printMsg(e.getMessage());
            }
        } else {
            appView.printMsg("There is no categories. Add category first.");
        }
    }


    public void createNewCategory(){
        appView.printMsg("Choose category type that you want to create: \n   1)Product category \n" +
                                                                        "   2)Featured product category \n" +
                                                                        "   0)Go back \n" +
                                                                        "Enter option:");
        String userChoice = appView.getUserInput();

        while(!userChoice.equals("0")){
            if(userChoice.equals("1")){
                appView.printMsg("Enter category name: ");
                String name = appView.getUserInput();
                ProductCategory prodCat = new ProductCategory(name);
                break;
            } else if(userChoice.equals("2")) {
                createFeaturedProductCategory();
                break;
            } else {
                appView.printMsg("No such option");
                break;
            }
        }

    }


    public void createFeaturedProductCategory(){
        appView.printMsg("Enter category name: ");
        String name = appView.getUserInput();

        appView.printMsg("Enter date in format dd/MM/yyyy: ");
        String newDate = appView.getUserInput();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try{
            Date date = sdf.parse(newDate);
            FeaturedProductCategory featProdCat = new FeaturedProductCategory(name, date);
        } catch (ParseException e){
            appView.printMsg(e.getMessage());
        }
    }


    public void addProductToBasket(Basket basket){
        appView.printMsg("Available product:");
        appView.printTable(Product.getAllProducts());

        appView.printMsg("Enter product name:");
        String productName = appView.getUserInput();

        try{
            Product product = Product.getProductByName(productName);
            basket.addProduct(product);
        } catch (NullPointerException e){
            appView.printMsg(e.getMessage());
        }
    }


    public void seeAllProductInBasket(Basket basket){
        Integer counter = 1;

        for(Iterator iter = basket.getIterator(); iter.hasNext();){
            Product product = (Product) iter.next();
            appView.printMsg(counter.toString() + ". " + product);
            counter++;
        }
    }


    public void removeProductFromBasket(Basket basket){
        appView.printMsg("Enter product name to remove:");
        String productName = appView.getUserInput();

        try{
            Product product = Product.getProductByName(productName);
            basket.removeProduct(product);
        } catch (NullPointerException e){
            appView.printMsg(e.getMessage());
        }
    }


    public void seeAvailableProduct(){
        Integer counter = 1;

        for(Product product : Product.getAllProducts()){
            appView.printMsg(counter.toString() + ". " + product);
            counter++;
        }
    }


    public void checkProductFromCategory(){
        appView.printMsg("Enter category name:");
        String categoryName = appView.getUserInput();
        ProductCategory prodCat = new ProductCategory(categoryName);

        try{
            ArrayList<Product> productList = Product.getAllProductsBy(prodCat);
        } catch (NullPointerException e){
            appView.printMsg(e.getMessage());
        }
    }


    public void checkAvailabilitySpecificProduct(){
        appView.printMsg("Enter product name:");
        String productName = appView.getUserInput();

        try{
            Product product = Product.getProductByName(productName);
            appView.printMsg("This product is available");

        } catch (NullPointerException e){
            appView.printMsg("This product is unavailable");
        }
    }

    public void payForOrder(Basket basket){
        appView.printMsg("Do you want to pay for all products in basket? y/n");
        String userInput = appView.getUserInput();

        if(userInput.equals("y")){
            Order order = new Order();
            CheckoutProcess checkout = new CheckoutProcess();
            PaymentProcess payment = new PaymentProcess();

            checkout.process(order);
            payment.process(order);

            basket.clearBasket();
        } else if(userInput.equals("n")){
            appView.printMsg("Not payed yet");
        } else{
            appView.printMsg("Chose y/n");
        }
    }
}
