package part3;

import part1.*;
import part2.*;

public class Application {

    private static final String EXIT = "0";
    private Basket basket;
    private String ption;
    private static ApplicationView appView = new ApplicationView();
    private static ApplicationController appController = new ApplicationController();




    public void application(){
        String option = "";
        Basket basket = new Basket();

        do{
            appView.printMenu();
            appView.printMsg("Choose option: ");
            option = appView.getUserInput();
            appController.startController(option, basket);
        } while (!option.equals("0"));
    }
}
