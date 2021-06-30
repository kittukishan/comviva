import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WaitingRoom {

    // default chairs in waiting room is 5.
    public List<Chair> chairs = new ArrayList<Chair>(5);

    public List<Customer> customers = new ArrayList<Customer>();

    public List<Chair> getChairs() {
        return chairs;
    }

    public void setChairs(List<Chair> chairs) {
        this.chairs = chairs;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public int addchairs (Chair chair){
        chairs.add(chair);
        return chairs.size();
    }

    public List<Chair> getOccupiedChairs(){
        List<Chair> availableChairs = new ArrayList<Chair>(BarberConstants.DEFAULT_CHAIRS);
        return getChairs().stream().filter(chair->chair.isOccupied()).collect(Collectors.<Chair>toList());
    }

    public List<Chair> getVacantChairs(){
       return  chairs.stream().filter(chair->!chair.isOccupied()).collect(Collectors.toList());

    }
    public void addCustomer(Customer customer){
        if(chairs.size() >= BarberConstants.DEFAULT_CHAIRS)
            this.customers.add(customer);
    }

    public void removeCustomer(Customer customer){
        this.customers.remove(customer);
    }
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WaitingRoom{");
        sb.append("chairs=").append(chairs);
        sb.append('}');
        return sb.toString();
    }
}
