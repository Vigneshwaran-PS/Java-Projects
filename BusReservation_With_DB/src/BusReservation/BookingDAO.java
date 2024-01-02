package BusReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class BookingDAO {

    public int getBookedCount(int busNo , Date date)throws Exception{
        String query = "select count(bus_no) from booking where bus_no = ? and travel_date = ?";
        Connection con = DbConnectivity.getConnectivity();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,busNo);
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        ps.setDate(2,sqldate);
        ResultSet rs = ps.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addBooking(Booking booking)throws Exception{
        String query = "insert into booking values(?,?,?)";
        Connection con = DbConnectivity.getConnectivity();
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1,booking.busNo);
        ps.setString(2,booking.passengerName);
        java.sql.Date sqldate = new java.sql.Date(booking.date.getTime());
        ps.setDate(3,sqldate);
        ps.executeUpdate();
    }
}
