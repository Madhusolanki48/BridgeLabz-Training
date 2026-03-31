package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // database URL
    private static final String URL =
        "jdbc:mysql://127.0.0.1:3306/health_clinic_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static final String USER = "root";
    private static final String PASSWORD = "04MySQL08@"; 

    //method to get connection
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    //to check whether database connected or not
//    public static void main(String[] args) {
//        try {
//            Connection conn = getConnection();
//            System.out.println("Connected Successfully!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
