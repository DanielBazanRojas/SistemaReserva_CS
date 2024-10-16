package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ConexionMySQL.conexion;
import Entidades.trabajador;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class DaoTrabajador {
    conexion conectar = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarTrabajadores(){
        List<trabajador> datosTrabajador = new ArrayList<>();
        String sql = "Select * from trabajador";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                trabajador tra = new trabajador();
                tra.setIdTrabajador(rs.getInt("idTrabajador"));
                tra.setNombreTrabajador(rs.getString("nombreTrabajador"));
                tra.setApellidoTrabajador(rs.getString("apellidoTrabajador"));
                tra.setTipoDocumento(rs.getString("tipoDocumento"));
                tra.setNumDocumento(rs.getString("numDocumento"));
                tra.setIdUsuario(rs.getInt("idUsuario"));
                tra.setIdCargo(rs.getInt("idCargo"));
                datosTrabajador.add(tra);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Agrega esta línea para imprimir el error en la consola
            System.out.println("SQL Query: " + sql);
        }
        return datosTrabajador;
    }
    public String obtenerUsuarioTrabajadorPorId(int idUsuario) {
        String nombreusuario = null;
        String sql = "SELECT username FROM usuario WHERE idUsuario = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombreusuario = rs.getString("username");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return nombreusuario;
    }
    
    public boolean CreateTrabajador(trabajador trabajador) {
        String sql = "INSERT INTO trabajador(nombreTrabajador, apellidoTrabajador, tipoDocumento, numDocumento, idCargo, idCargo) "
                + "VALUES (?,?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, trabajador.getNombreTrabajador());
            ps.setString(2, trabajador.getApellidoTrabajador());
            ps.setString(3, trabajador.getTipoDocumento());
            ps.setString(4, trabajador.getNumDocumento());
            ps.setInt(5, trabajador.getIdCargo());
            ps.setInt(6, trabajador.getIdUsuario());
            int resultado = ps.executeUpdate();
            if (resultado != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("SQL Query: " + sql);
            }
        }
    }
    
    public trabajador leerTrabajador(int idTrabajdor) {
        trabajador tra = null;
        String sql = "SELECT nombreTrabajador, apellidoTrabajador, tipoDocumento, numDocumento, idCargo, idUsuario FROM trabajador "
                + "WHERE idTrabajador = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTrabajdor);
            rs = ps.executeQuery();
            if (rs.next()) {
                tra = new trabajador();
                tra.setIdTrabajador(idTrabajdor);
                tra.setNombreTrabajador(rs.getString("nombreTrabajador"));
                tra.setApellidoTrabajador(rs.getString("apellidoTrabajador"));
                tra.setTipoDocumento(rs.getString("tipoDocumento"));
                tra.setNumDocumento(rs.getString("numDocumento"));
                tra.setIdCargo(rs.getInt("idCargo"));
                tra.setIdUsuario(rs.getInt("idUsuario"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tra;
    }
    
    public String obtenerNombreCargoPorId(int idCargo) {
        String nombreCargo = null;
        String sql = "SELECT nombreCargo FROM cargo WHERE idCargo = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCargo);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombreCargo = rs.getString("nombreCargo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return nombreCargo;
    }
    
    public int obtenerIdCargoPorNombreCargo(String nombreCargo) {
        int idCargo = 0;
        String sql = "SELECT idCargo FROM cargo WHERE nombreCargo = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombreCargo);
            rs = ps.executeQuery();
            if (rs.next()) {
                idCargo = rs.getInt("idCargo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return idCargo;
    }
    
    public String obtenerNombreUsuarioPorId(int idUsuario) {
        String nombreUsuario = null;
        String sql = "SELECT nombreUsuario FROM usuario WHERE idUsuario = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idUsuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombreUsuario = rs.getString("nombreUsuario");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return nombreUsuario;
    }
}
