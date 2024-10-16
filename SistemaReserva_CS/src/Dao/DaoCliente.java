package Dao;

import ConexionMySQL.conexion;
import Entidades.cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCliente {
    
    conexion conectar = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public List listarClientes() {
        List<cliente> datosClientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cliente clientes = new cliente();
                clientes.setIdCliente(rs.getInt("idCliente"));
                clientes.setNombreCliente(rs.getString("nombreCliente"));
                clientes.setApellidoCliente(rs.getString("apellidoCliente"));
                clientes.setTipoDocumento(rs.getString("tipoDocumento"));
                clientes.setNumDocumento(rs.getString("numDocumento"));
                clientes.setContacto(rs.getString("contacto"));
                datosClientes.add(clientes);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SQL Query: " + sql);
        }
        return datosClientes;
    }
    
    public boolean CreateCliente(cliente cliente) {
        String sql = "INSERT INTO cliente(nombreCliente, apellidoCliente, tipoDocumento, numDocumento, contacto) "
                + "VALUES (?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombreCliente());
            ps.setString(2, cliente.getApellidoCliente());
            ps.setString(3, cliente.getTipoDocumento());
            ps.setString(4, cliente.getNumDocumento());
            ps.setString(5, cliente.getContacto());
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
    public cliente leerCliente(int idCliente) {
        cliente cli = null;
        String sql = "SELECT nombreCliente, apellidoCliente, tipoDocumento, numDocumento, contacto FROM cliente "
                + "WHERE idCliente = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                cli = new cliente();
                cli.setIdCliente(idCliente);
                cli.setNombreCliente(rs.getString("nombreCliente"));
                cli.setApellidoCliente(rs.getString("apellidoCliente"));
                cli.setTipoDocumento(rs.getString("tipoDocumento"));
                cli.setNumDocumento(rs.getString("numDocumento"));
                cli.setContacto(rs.getString("contacto"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cli;
    }
}
