package demo_datas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Closer {

    public void closeStatement(Statement st){
        try {
            st.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void closeConnection (Connection co){
        try{
            co.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void closeResultSet (ResultSet rs){
        try{
            rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }


}
