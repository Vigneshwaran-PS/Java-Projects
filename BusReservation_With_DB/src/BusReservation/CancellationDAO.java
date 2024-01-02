package BusReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class CancellationDAO {

    public boolean checkForCancellation(int busNo , String passenger , Date date)throws Exception{
        String query = "select * from booking";
        Connection con = DbConnectivity.getConnectivity();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()){
            if(rs.getInt(1) == busNo && rs.getString(2).equals(passenger) && rs.getDate(3).equals(new java.sql.Date(date.getTime()))){
                return true;
            }
        }
        return false;
    }

    public void bookingCancel(Cancellation cancel)throws Exception{
        String query = "delete from booking where bus_no = ? and passengerName = ? and travel_date = ?";
        Connection con = DbConnectivity.getConnectivity();
        PreparedStatement pt = con.prepareStatement(query);
        pt.setInt(1,cancel.busNo);
        pt.setString(2,cancel.passengerName);
        java.sql.Date sqldate = new java.sql.Date(cancel.date.getTime());
        pt.setDate(3,sqldate);
        pt.executeUpdate();
    }
}
