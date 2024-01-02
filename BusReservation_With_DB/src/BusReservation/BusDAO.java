package BusReservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class BusDAO {

    public void displayBusInfo()throws Exception{
        System.out.println("\n\n\t\t ---------Bus Details---------");
        String query = "select * from bus;";
        Connection con = DbConnectivity.getConnectivity();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            System.out.print("\t\tBus No : " + rs.getInt(1));
            if(rs.getInt(2) == 0){
                System.out.print("\t\tAc : Yes");
            }else {
                System.out.print("\t\tAc : No");
            }
            System.out.print("\t\tCapacity : " + rs.getInt(3));
            System.out.println();
        }
    }

    public int getCapacity(int busNo)throws Exception{
        String query = "select capacity from bus where bus_no = "+busNo;
        Connection con = DbConnectivity.getConnectivity();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
}
