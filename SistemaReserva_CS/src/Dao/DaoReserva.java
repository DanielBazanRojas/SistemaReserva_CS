package Dao;

import ConexionMySQL.conexion;
import Entidades.Reserva;
import Entidades.ReservaInfo;
import Entidades.detalleReserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DaoReserva {

    conexion conectar = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement stmt;

    public int obtenerCorrelativo() throws Exception {
        int correlativo = 0;
        String sql = "SELECT R.correlativoReserva FROM reserva R ORDER BY "
                + "R.idReserva DESC LIMIT 1";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next() == true) {
                correlativo = rs.getInt("correlativoReserva");
            }
        } catch (Exception e) {
            throw e;
        }
        return correlativo;
    }

    public List listarReservas() {
        List<ReservaInfo> informacionReserva = new ArrayList<>();
        String sql = "SELECT R.idReserva, R.serieReserva, R.correlativoReserva, R.fechaReserva, R.idPago, R.idCliente, R.idTrabajador, R.montoTotal, H.estado, H.idHabitacion "
                + "FROM reserva R "
                + "INNER JOIN detallereserva DR ON R.idReserva = DR.idReserva "
                + "INNER JOIN habitacion H ON DR.idHabitacion = H.idHabitacion";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReservaInfo infoReserva = new ReservaInfo();
                infoReserva.setIdReserva(rs.getInt("idReserva"));
                infoReserva.setSerieReserva(rs.getString("serieReserva"));
                infoReserva.setCorrelativoReserva(rs.getString("correlativoReserva"));
                infoReserva.setFechaReserva(rs.getDate("fechaReserva"));
                infoReserva.setIdPago(rs.getInt("idPago"));
                infoReserva.setIdCliente(rs.getInt("idCliente"));
                infoReserva.setIdTrabajador(rs.getInt("idTrabajador"));
                infoReserva.setTotal(rs.getDouble("montoTotal"));
                infoReserva.setEstadoHabitacion(rs.getString("estado"));
                infoReserva.setIdHabitacion(rs.getInt("idHabitacion"));
                informacionReserva.add(infoReserva);
            }
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getLocalizedMessage());
        }
        return informacionReserva;
    }

    public String obtenerEstadoHabitacionPorId(int idHabitacion) {
        String estadoHabitacion = null;
        String sql = "SELECT estado FROM habitacion WHERE idHabitacion = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHabitacion);
            rs = ps.executeQuery();
            if (rs.next()) {
                estadoHabitacion = rs.getString("estado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estadoHabitacion;
    }

    public String obtenerTipoHabitacion(int idHabitacion) {
        /*Declaramos la variable prod de tipo Producto, esta variable 
          será utlizada para almacenar el objeto Producto obtenido en la BD*/
        String tipoH = null;
        String sql = "SELECT th.tipoHabitacion FROM tipoHabitacion th inner join habitacion h WHERE h.idHabitacion = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHabitacion);
            rs = ps.executeQuery();
            if (rs.next()) {
                tipoH = rs.getString("tipoHabitacion");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return tipoH;
    }

    public String obtenerNumeroHabitacionPorId(int idHabitacion) {
        String NumeroHabitacion = null;
        String sql = "SELECT numeroHabitacion FROM habitacion WHERE idHabitacion = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHabitacion);
            rs = ps.executeQuery();
            if (rs.next()) {
                NumeroHabitacion = rs.getString("numeroHabitacion");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NumeroHabitacion;
    }

    public String obtenerDniClientePorId(int idCliente) {
        String DniCliente = null;
        String sql = "SELECT numDocumento FROM cliente WHERE idCliente = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                DniCliente = rs.getString("numDocumento");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DniCliente;
    }

    public String obtenerNombreTrabajadorPorId(int idTrabajador) {
        String nombreTrabajador = null;
        String sql = "SELECT nombreTrabajador FROM trabajador WHERE idTrabajador = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idTrabajador);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombreTrabajador = rs.getString("nombreTrabajador");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreTrabajador;
    }

    public String obtenerNombreClientePorId(int idCliente) {
        String nombreCliente = null;
        String sql = "SELECT nombreCliente FROM cliente WHERE idCliente = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idCliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombreCliente = rs.getString("nombreCliente");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombreCliente;
    }

    public String obtenerNombrePagoPorId(int idPago) {
        String nombrePago = null;
        String sql = "SELECT formaPago FROM pago WHERE idPago = ?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idPago);
            rs = ps.executeQuery();
            if (rs.next()) {
                nombrePago = rs.getString("formaPago");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nombrePago;
    }

    public void registrar(Reserva reserva) throws SQLException, Exception {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaFormateada = formato.format(reserva.getFechaReserva());
        int codigoReserva;
        String sql = "insert into reserva(serieReserva, correlativoReserva, fechaReserva, idPago, idCliente, idTrabajador, montoTotal, estado) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);

            ps.setString(1, reserva.getSerieReserva());
            ps.setString(2, reserva.getCorrelativoReserva());
            ps.setString(3, formato.format(reserva.getFechaReserva()));
            ps.setInt(4, reserva.getIdPago());
            ps.setInt(5, reserva.getIdCliente());
            ps.setInt(6, reserva.getIdTrabajador());
            ps.setDouble(7, reserva.getTotal());
            ps.setInt(8, reserva.isEstado() ? 1 : 0);
            ps.executeUpdate();

            // Obtener el ID de la reserva generada
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT @@IDENTITY AS Codigo");
            if (rs.next()) {
                codigoReserva = rs.getInt("Codigo");

                for (detalleReserva infoReserva : reserva.getDetalleReserva()) {
                    sql = "insert into detalleReserva (idReserva, idHabitacion, cantidadDias, montoTotal) "
                            + "values (?, ?, ?, ?)";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, codigoReserva);
                    ps.setInt(2, infoReserva.getIdHabitacion());
                    ps.setInt(3, infoReserva.getCantidadDias());
                    ps.setDouble(4, infoReserva.getMontoTotal());
                    ps.executeUpdate();

                    sql = "UPDATE habitacion SET estado = 'Reservado' WHERE idHabitacion = ?";
                    ps = con.prepareStatement(sql);
                    ps.setInt(1, infoReserva.getIdHabitacion());
                    ps.executeUpdate();
                }
            } else {
                throw new SQLException("No se pudo obtener el ID de la reserva generada.");
            }
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        } finally {
            // Cerrar recursos (ResultSet, PreparedStatement, Statement, Connection) en el bloque finally
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    // Manejar error al cerrar ResultSet
                }
            }
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    // Manejar error al cerrar PreparedStatement
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    // Manejar error al cerrar Statement
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    // Manejar error al cerrar Connection
                }
            }
        }
    }
}
