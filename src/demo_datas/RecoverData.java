package demo_datas;

import java.sql.*;

public class RecoverData {

    public static void main(String[] args) {

        //Recovering Data

        Connection co = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc", "root", "");

            st = co.createStatement();

            rs = st.executeQuery("select * from department");

            while (rs.next()) {
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DB_Closer db = new DB_Closer();
            db.closeConnection(co);
            db.closeStatement(st);
            db.closeResultSet(rs);
        }
    }
}
