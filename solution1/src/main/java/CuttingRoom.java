public class CuttingRoom {

    public Chair cuttingChair;

    public Customer customer;

    public Chair getCuttingChair() {
        return cuttingChair;
    }

    public void setCuttingChair(Chair cuttingChair) {
        this.cuttingChair = cuttingChair;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CuttingChair{");
        sb.append("cuttingChair=").append(cuttingChair);
        sb.append('}');
        return sb.toString();
    }
}
