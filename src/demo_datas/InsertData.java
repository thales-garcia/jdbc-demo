package demo_datas;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class InsertData {

    public static void main(String[] args) {

        //Entering Data

        Connection co = null;
        PreparedStatement st = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc", "root", "");

            st = co.prepareStatement(
                    "INSERT INTO seller "
                            + "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
                            + "VALUES "
                            + "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Thales");
            st.setString(2, "thales@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/04/1985").getTime()));
            st.setDouble(4, 3000.0);
            st.setInt(5, 4);

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);       //Auxiliary table with a column containing the id's
                    System.out.println("Done! Id = " + id);
                }
            } else {
                System.out.println("No rows affected!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        finally{
            DB_Closer db = new DB_Closer();
            db.closeConnection(co);
            db.closeStatement(st);
        }
    }
}
