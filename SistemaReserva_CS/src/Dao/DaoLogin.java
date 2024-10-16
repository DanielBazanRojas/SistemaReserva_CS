package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ConexionMySQL.conexion;
import Entidades.usuario;

public class DaoLogin {

    conexion conectar = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public usuario login(String userName, String passName) {
        usuario usu = null;
        String sql = "SELECT u.nombreUsuario, u.claveUsuario, c.nombreCargo, t.nombreTrabajador, t.apellidoTrabajador FROM usuario U "
                + "INNER JOIN trabajador t ON U.idUsuario = T.idUsuario "
                + "JOIN cargo c ON C.idCargo = T.idCargo "
                + "WHERE U.nombreUsuario = ? AND U.claveUsuario = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, passName);
            rs = ps.executeQuery();
            if (rs.next()) {
                usu = new usuario();
                usu.setNombreUsuario(rs.getString("nombreUsuario"));
                usu.setClaveUsuario(rs.getString("claveUsuario"));

                // Verificar si "nombreCargo" es nulo antes de acceder a él
                String nombreCargo = rs.getString("nombreCargo");
                if (nombreCargo != null) {
                    usu.setNombreCargo(nombreCargo);
                } else {
                    // Puedes establecer un valor predeterminado o manejarlo de la manera que desees
                    usu.setNombreCargo("Cargo no especificado");
                }
                usu.setNombreTrabajador(rs.getString("nombreTrabajador")+ " "+ rs.getString("apellidoTrabajador"));
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getLocalizedMessage());
        }
        return usu;
    }
}
