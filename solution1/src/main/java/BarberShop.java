import java.util.List;
import java.util.Scanner;

public class BarberShop {


    static WaitingRoom waitingRoom;
    static CuttingRoom cuttingRoom;
//    static List<Customer> totalCusotmer;
    static Barber barber;
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        InitializeBarberShop();
        System.out.println("*** BARBER SHOP IS OPEN  ***");
        while(true){
            int noOfCustomers = scanner.nextInt();
            sendCustomers(noOfCustomers);
        }

    }

    private static void sendCustomers(int noOfCustomers) {
        if(noOfCustomers==0){
            barber.setActive(false);
            return;
        }
        for(int i=0;i<noOfCustomers;i++){
            Customer customer = new Customer();
            String response = null;
            int responsefromShop = validateCuttingRoom(customer);
            if(responsefromShop==1){
                response = "customer is added cutting room";
                responseToCustomer(response);
            }else if(responsefromShop==2){
                response = "customer is added waiting room";
                responseToCustomer(response);
            }else{
                response = "customer left the shop";
                responseToCustomer(response);
            }


        }

    }

    private static void responseToCustomer(String response) {
        System.out.println("**** "+response+" ***** ");
    }

    private static int validateWatingRoom(Customer customer) {
        List<Chair> chairs = waitingRoom.getVacantChairs();
        if(chairs.size() <= BarberConstants.DEFAULT_CHAIRS && chairs.size()>1){
            waitingRoom.addCustomer(customer);
            chairs.get(0).setOccupied(true);
            return 2;
        }else{
            return 0;
        }
    }

    private static int validateCuttingRoom(Customer customer) {
        if(!barber.isActive() && cuttingRoom.getCustomer()==null){
            System.out.print("Barber is asleep and customer awakes him. ");
            barber.setActive(true);
            cuttingRoom.cuttingChair.setOccupied(true);
            customer.setStatus(BarberConstants.OCCUPIED);
            cuttingRoom.setCustomer(customer);
            return 1;
        }else if(barber.isActive() && cuttingRoom.getCustomer()==null){
            System.out.println("Barber is Active and customer is seated in cutting chair. ");
            barber.setActive(true);
            cuttingRoom.cuttingChair.setOccupied(true);
            customer.setStatus(BarberConstants.OCCUPIED);
            cuttingRoom.setCustomer(customer);
            return 1;
        }else{
            //barber.isActive() && cuttingRoom.getCustomer()!=null
            return validateWatingRoom(customer);
        }

    }

    private static void updateCustomerStatus(String occupied) {

    }

    private static void InitializeBarberShop() {

        barber = Barber.getInstance();
        System.out.println("***  Barber is active ***");
        waitingRoom = new WaitingRoom();
        for(int i=0;i<BarberConstants.DEFAULT_CHAIRS;i++){
            waitingRoom.addchairs(new Chair());
        }

        System.out.println("*** Waiting room initialized with default chairs ***");
        cuttingRoom = new CuttingRoom();
        cuttingRoom.setCuttingChair(new Chair());
        System.out.println("*** Cutting chair initialized ***");

    }

}
