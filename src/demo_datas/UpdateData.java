package demo_datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData {

    public static void main(String[] args) {

        //Updating Data

        Connection co = null;
        PreparedStatement st = null;

        try {

            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc", "root", "");

            st = co.prepareStatement(
                    "UPDATE seller "
                            + "SET BaseSalary = BaseSalary + ? "
                            + "WHERE "
                            + "(DepartmentId = ?)");

            st.setDouble(1, 200.0);
            st.setInt(2, 2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows Affected: " + rowsAffected);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DB_Closer db = new DB_Closer();
            db.closeConnection(co);
            db.closeStatement(st);

        }

    }

}
