package part2;

public abstract class AbstractProcess {

    public void process(Orderable item){
        stepBefore();
        action(item);
        stepAfter();
    }


    private void stepBefore() {
        System.out.println("Checking status...");
    }

    private void stepAfter() {
        System.out.println("Process completed.");
    }

    abstract void action(Orderable item);
}
