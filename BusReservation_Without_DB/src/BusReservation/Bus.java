package BusReservation;

public class Bus {

    private int busNo;
    private boolean ac;
    private int capacity;

    Bus(int busNo , boolean ac , int capacity){
        this.capacity = capacity;
        this.busNo = busNo;
        this.ac = ac;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getBusNo() {
        return busNo;
    }

    public boolean isAc() {
        return ac;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public void setAc(boolean ac) {
        this.ac = ac;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void displayBusInf0(){
        System.out.println("\t Bus No : " + getBusNo() + "\t Ac : " + isAc() + "\t Capacity : " + getCapacity());
    }
}
