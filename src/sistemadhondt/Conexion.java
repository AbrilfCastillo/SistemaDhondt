package sistemadhondt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public static Connection conectar() {
          try {

              String url = "jdbc:ucanaccess://C:/Users/sheyla/Desktop/votacion.accdb";
              Connection conn = DriverManager.getConnection(url);

              return conn;

          } catch (SQLException e) {

              System.out.println("Error de conexión " + e);
              return null;

          }
      }

}