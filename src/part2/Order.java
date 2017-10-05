package part2;

public class Order implements Orderable {

    private int id = 1;
    private String status;


    public Order() {
        this.id = id++;
        this.status = "new";
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public boolean checkout() {
        if(this.status.equals("new")){
            this.status = "checked";
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean pay() {
        if(this.status.equals("checked")){
            this.status = "payed";
            return true;
        }
        return false;
    }
}
