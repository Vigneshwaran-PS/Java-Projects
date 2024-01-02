package BusReservation;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {

    int busNo;
    String passengerName;
    Date date;

    Booking(){
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


    public boolean isAvailable()throws Exception{
        int capacity = 0;
        BusDAO busDAO = new BusDAO();
        capacity = busDAO.getCapacity(busNo);

        int booked = 0;
        BookingDAO bookingDAO = new BookingDAO();
        booked = bookingDAO.getBookedCount(busNo,date);

        return booked<capacity;
    }
}
