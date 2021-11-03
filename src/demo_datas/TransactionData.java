package demo_datas;

import java.sql.*;

public class TransactionData {

    public static void main(String[] args) {

        Connection co = null;
        Statement st = null;

        try{
            co = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc", "root", "");

            co.setAutoCommit(false);  //Only run if everything is true

            st = co.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            int x=1;
            if (x<2){
                throw new SQLException("Fake error");
            }

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            co.commit();

            System.out.println("rows1 " + rows1);
            System.out.println("rows2 " + rows2);

        } catch (SQLException e){
            try {
                co.rollback();
                throw new SQLException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException ex) {
                System.out.println("Error trying to rollback! Caused by: " + ex.getMessage());
            }

        } finally{
            DB_Closer db = new DB_Closer();
            db.closeConnection(co);
            db.closeStatement(st);
        }
    }

}
