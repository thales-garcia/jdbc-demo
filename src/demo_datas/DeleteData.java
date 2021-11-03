package demo_datas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteData {

    public static void main(String[] args) {

        Connection co = null;
        PreparedStatement st = null;

        try{
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc", "root", "");

            st = co.prepareStatement("DELETE FROM department WHERE Id = ?");

            st.setInt(1, 2);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows Affected " + rowsAffected);

        } catch (SQLException e){
            e.printStackTrace();
        } finally{
            DB_Closer db = new DB_Closer();
            db.closeConnection(co);
            db.closeStatement(st);
        }
    }

}
