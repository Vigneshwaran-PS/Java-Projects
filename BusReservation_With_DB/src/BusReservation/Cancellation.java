package BusReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Cancellation {

    int busNo;
    String passengerName;
    Date date;
    Cancellation(){
        System.out.println("\n---------------Cancellation------------------");
        Scanner s = new Scanner(System.in);

        System.out.println("Enter Bus No : ");
        busNo = s.nextInt();
        System.out.println("Enter Passenger Name : ");
        passengerName = s.next();
        System.out.println("Enter Date in dd-mm-yyyy");
        String userDate = s.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date = dateFormat.parse(userDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkCancellation()throws Exception{
        CancellationDAO cancelling = new CancellationDAO();
        return cancelling.checkForCancellation(busNo,passengerName,date);
    }
}
