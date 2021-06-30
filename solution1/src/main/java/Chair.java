public class Chair {

    public boolean occupied;

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chair{");
        sb.append("occupied=").append(occupied);
        sb.append('}');
        return sb.toString();
    }
}
