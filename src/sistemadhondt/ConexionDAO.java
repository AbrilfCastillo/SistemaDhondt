package sistemadhondt;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

public class ConexionDAO {

    public static void nuevoPartido(String txtA, int txtB){
        Connection conn = null;
        try {
            conn = Conexion.conectar();

            String sql = "INSERT INTO partidos(nombre,votos) VALUES (?,?);";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, txtA);
            ps.setInt(2, txtB);

            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,"Guardado");

        } catch (HeadlessException | NumberFormatException | SQLException ex) {

            System.out.println(ex);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        
    }
    
    public static List<Partido> mostrarPartidos(){
        Connection conn = null;
        List<Partido> lista = new ArrayList<>();

        try {
            conn = Conexion.conectar();

            String sql = "SELECT * FROM partidos;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int votos = rs.getInt("votos");

                lista.add(new Partido(id, nombre, votos));
            }

            return lista;

        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        return lista;
    }
    
    public static void actualizarPartido(int id, String nombre, int votos) {
    Connection conn = null;

    try {
        conn = Conexion.conectar();

        String sql = "UPDATE partidos SET nombre = ?, votos = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, nombre);
        ps.setInt(2, votos);
        ps.setInt(3, id);

        ps.executeUpdate();

        System.out.println("Actualizado correctamente");

    } catch (SQLException ex) {
        System.out.println(ex);
    } finally {
        try {
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
    
}