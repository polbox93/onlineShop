package part2;

public class PaymentProcess extends AbstractProcess {

    @Override
    void action(Orderable item) {
        item.pay();
    }
}
