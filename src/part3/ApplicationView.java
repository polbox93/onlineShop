package part3;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class ApplicationView {

    Scanner scan = new Scanner(System.in);

    public void printMsg(String message){
        System.out.println(message);
    }

    public String getUserInput(){
        String userInput = scan.nextLine();
        return userInput;
    }

    public void printTable (ArrayList list){
        for(Object elem : list){
            System.out.println(elem);
        }
    }


    public void printMenu(){
        String menuOption = String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s\n"
                , "\nMenu"
                , "1) Create new product"
                , "2) Create new product category or new featured product category"
                , "3) Add product to the basket"
                , "4) See all products from basket"
                , "5) Remove product from basket"
                , "6) Get list of available products"
                , "7) Get list of product from specific product category"
                , "8) Check availability of specific product"
                , "9) Pay for order"
                , "0) EXIT");

        System.out.println(menuOption);
    }
}
