package BusReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n------------------Welcome to Bus Reservation--------------------\n");
        System.out.println("\t -------------Available Bus Details---------------");


        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();
        buses.add(new Bus(1,true,2));  // For testing
        buses.add(new Bus(2,false,10));
        buses.add(new Bus(3,true,15));
        buses.add(new Bus(4,false,5));

        for (Bus b : buses){
            b.displayBusInf0();
        }


        int userInput = 1;
        while(userInput == 1 || userInput == 2 ){
            System.out.println("\nPress 1 to Book or Press 2 to Cancel Book or Press 3 to Exit");
            userInput = s.nextInt();
            if(userInput == 1){
                Booking booking = new Booking();
                if(booking.isAvailable(buses,bookings)){
                    bookings.add(booking);
                }else{
                    System.err.println("Sorry..Bus is Full...Try another Bus or Date.......");
                }
            }

            //Cancellation part
            if(userInput == 2){
                Cancellation cancel = new Cancellation();
                if(cancel.checkingCancellationDetails(bookings)){
                    bookings.remove(cancel);
                    System.out.println("\n ---------Booking Cancelled----------");
                }else{
                    System.err.println("\n---------No Such Booking Found Or Enter Correct Details---------");
                }
            }

            if(userInput == 3){
                System.out.println("-------Thanks for Visiting Us-------");
                break;
            }
        }
    }
}
