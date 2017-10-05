package part2;

public class Main {

    public static void main(String[] args){

        Order order1 = new Order();
        System.out.println(order1.getStatus());

        order1.checkout();
        System.out.println(order1.getStatus());

        order1.pay();
        System.out.println(order1.getStatus());


        Order order2 = new Order();
        CheckoutProcess check = new CheckoutProcess();
        PaymentProcess pay = new PaymentProcess();

        System.out.println(order2.getStatus());

        check.process(order2);
        System.out.println(order2.getStatus());

        pay.process(order2);
        System.out.println(order2.getStatus());

    }
}
