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
    /*
    SELECT p.nombre, p.Votos, r.NroOrden, r.CantVotos, r.Indice, r.Porcentaje, r.TotalVotos
FROM Partido p INNER JOIN ResultadoVotos r ON p.Id = r.IdPartido
ORDER BY r.NroOrden
    
    */
}