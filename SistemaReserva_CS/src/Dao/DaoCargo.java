package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ConexionMySQL.conexion;
import Entidades.cargo;

public class DaoCargo {

    conexion conectar = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarCargo() {
        List<cargo> datosCargo = new ArrayList<>();
        String sql = "select * from cargo";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cargo c = new cargo();
                c.setIdCargo(rs.getInt(1));
                c.setNombreCargo(rs.getString(2));
                c.setEstado(rs.getBoolean(3));
                datosCargo.add(c);
            }
        } catch (Exception e) {
        }
        return datosCargo;
    }
    
    public cargo leerCargo(int idCargo) {
        cargo car = null;
        String sql = "select idCargo,nombreCargo, estado from cargo where idCargo = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCargo);
            rs = ps.executeQuery();
            if (rs.next()) {
                /* Paso 9: Instanciamos el objeto cargo */
                car = new cargo();
                car.setIdCargo(idCargo);
                car.setIdCargo(rs.getInt("idCargo"));
                car.setNombreCargo(rs.getString("nombreCargo"));
                car.setEstado(rs.getBoolean("estado"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return car;
    }
}
