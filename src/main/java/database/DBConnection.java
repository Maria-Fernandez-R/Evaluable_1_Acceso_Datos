package database;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            createConnection();
        }
        return connection;
    }

    private static void createConnection(){
        try {
            String url = "jdbc:mysql://localhost:3306/almacen";
            String user = "root";
            String pass = "";
            connection = DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            System.out.println("ERROR: Ha ocurrido un error en la conexion");
            e.printStackTrace();
        }
    }
}
