public class Barber {

    public boolean sleep;

    public static boolean active;

    public static Barber barber=null;
    private Barber(){

    }

    public static Barber getInstance(){
        if(barber==null){
            System.out.println("New Barber Initialized. ");
            barber = new Barber();
            barber.setActive(true);
        }
            //System.out.println("EXISTING Barber USED. ");
            return barber;

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Barber{");
        sb.append("active=").append(active);
        sb.append('}');
        return sb.toString();
    }
}
