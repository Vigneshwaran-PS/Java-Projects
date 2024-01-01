package BusReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {

    String passengerName;
    int busNo;
    Date date;

    Booking(){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter Bus No : ");
        busNo = s.nextInt();
        System.out.println("Enter Passenger Name : ");
        passengerName = s.next();
        System.out.println("Enter date in dd-mm-yyyy");
        String userDate = s.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(userDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean isAvailable(ArrayList<Bus> buses , ArrayList<Booking> bookings){
        int capacity = 0;
        for(Bus b : buses){
            if(b.getBusNo() == busNo){
                capacity = b.getCapacity();
            }
        }

        int booked = 0;
        for(Booking b : bookings){
            if(b.busNo == busNo && b.date.equals(date)){
                booked++;
            }
        }
        return booked<capacity;
    }


}
