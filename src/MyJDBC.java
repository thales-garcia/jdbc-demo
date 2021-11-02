import java.sql.*;

public class MyJDBC {

    public static void main(String[] args) {

        try {

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursejdbc", "root", "");

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("select * from department");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("Id") + ", " + resultSet.getString("Name"));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
