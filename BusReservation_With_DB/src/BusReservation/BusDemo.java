package BusReservation;

import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args)throws Exception{
        Scanner s = new Scanner(System.in);
        System.out.println("\n------------------------Welcome To Bus Ticket Booking----------------------------");

        BusDAO busDAO = new BusDAO();
        busDAO.displayBusInfo();

        int userInput = 1;
        while(userInput == 1 || userInput == 2){
            System.out.println("\nPress 1 to Book or Press 2 to cancel Booking or Press 3 to Exit");
            userInput = s.nextInt();
            if(userInput == 1){
                Booking booking = new Booking();
                if(booking.isAvailable()){
                    BookingDAO bookingDAO = new BookingDAO();
                    bookingDAO.addBooking(booking);
                }else{
                    System.err.println("Sorry...Bus is Full . Try another date");
                }
            }

            if(userInput == 2){
                Cancellation cancel = new Cancellation();
                if(cancel.checkCancellation()){
                    CancellationDAO cancellationDAO = new CancellationDAO();
                    cancellationDAO.bookingCancel(cancel);
                    System.out.println("\n Cancellation Success.............");
                }else{
                    System.err.println("\nNo Such Details Found...Enter Valid cancellation detail...... ");
                }
            }

            if(userInput == 3){
                break;
            }
        }
    }
}
