import java.util.Random;

public class Customer {

    /***
     * status can be waiting, occupied, leaveshop
     */
    public int id;

    public String status;

    public Customer() {
        this.id = new Random(9).nextInt();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Customer{");
        sb.append("status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
