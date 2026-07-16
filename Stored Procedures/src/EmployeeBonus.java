import java.sql.*;

public class EmployeeBonus {

    public static void main(String[] args) {

        try {

            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:XE",
                "system",
                "password");

            CallableStatement cs =
                con.prepareCall("{call UpdateEmployeeBonus(?,?)}");

            cs.setString(1, "IT");
            cs.setDouble(2, 10);

            cs.execute();

            System.out.println("Employee bonus updated successfully.");

            cs.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}