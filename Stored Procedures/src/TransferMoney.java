import java.sql.*;

public class TransferMoney {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "password");

            CallableStatement cs =
                con.prepareCall("{call TransferFunds(?,?,?)}");

            cs.setInt(1, 101);     // From Account ID
            cs.setInt(2, 102);     // To Account ID
            cs.setDouble(3, 5000); // Amount

            cs.execute();

            System.out.println("Funds transferred successfully.");

            cs.close();
            con.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}