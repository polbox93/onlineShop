package part2;

public class CheckoutProcess extends AbstractProcess {


    @Override
    void action(Orderable item) {
        item.checkout();
    }
}
