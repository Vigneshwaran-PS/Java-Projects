package BusReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Cancellation {

    int busNo;
    String passengerName;
    Date date;

    Cancellation(){
        Scanner s = new Scanner(System.in);

        System.out.println("Enter Bus No : ");
        busNo = s.nextInt();
        System.out.println("Enter the Passenger Name : ");
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

    public boolean checkingCancellationDetails(ArrayList<Booking> bookings){
        for (Booking b : bookings){
            if(b.busNo == busNo && b.passengerName.equals(passengerName) && b.date.equals(date)){
                return true;
            }
        }
        return false;
    }
}

