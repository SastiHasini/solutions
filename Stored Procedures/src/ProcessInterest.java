import java.sql.*;

public class ProcessInterest {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "password");

            CallableStatement cs =
                con.prepareCall("{call ProcessMonthlyInterest}");

            cs.execute();

            System.out.println("Monthly interest processed successfully.");

            cs.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}