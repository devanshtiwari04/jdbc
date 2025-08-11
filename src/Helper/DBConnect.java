package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

    //Singleton class
    public static Connection db_instance;

    private DBConnect(){

    }

    public static Connection getDBConnection(){
        if(DBConnect.db_instance==null){

            try {
                Class.forName(DBconfig.getDbDriver());
                System.out.println("Driver loaded Successfully");
            } catch (ClassNotFoundException e) {
                System.out.println("Driver Connection  Error "+e.getMessage());
            }

            try {
                DBConnect.db_instance= DriverManager.getConnection(DBconfig.getDbUrl(),DBconfig.getDbUser(),DBconfig.getDbPassword());
                System.out.println("Db connected Successfully");
            } catch (SQLException e) {
                System.out.println("Cannot connect to Database"+e.getMessage());
            }








        }
        return  DBConnect.db_instance;
    }
}
