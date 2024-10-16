package Dao;

import ConexionMySQL.conexion;
import Entidades.tipoHabitacion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

public class DaoHabitacion {

    conexion conectar = new conexion();
    Connection con;
    PreparedStatement ps;
    PreparedStatement ps2;
    ResultSet rs;
    //ResultSet rs2;

    /*Traer los datos registrados*/
    public List listarHabitaciones() {
        List<tipoHabitacion> datosHabitaciones = new ArrayList<>();
        String sql = "SELECT h.idHabitacion, h.numeroHabitacion, h.pisoHabitacion, h.precioDiario, "
                + "h.estado, th.tipoHabitacion, th.caracteristicas FROM habitacion h INNER JOIN "
                + "tipoHabitacion th ON th.idHabitacion = h.idHabitacion ";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                tipoHabitacion hab = new tipoHabitacion();
                hab.setIdHabitacion(rs.getInt("idHabitacion"));
                hab.setNumeroHabitacion(rs.getString("numeroHabitacion"));
                hab.setPisoHabitacion(rs.getString("pisoHabitacion"));
                hab.setTipoHabitacion(rs.getString("tipoHabitacion"));
                hab.setPrecioDiario(rs.getDouble("precioDiario"));
                hab.setEstado(rs.getString("estado"));
                hab.setCaracteristicas(rs.getString("caracteristicas"));
                datosHabitaciones.add(hab);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SQL Query: " + sql);
        }
        return datosHabitaciones;
    }

    /*CREAR NUEVA HABITACION*/
    public boolean CreateHabitacion(tipoHabitacion th) {
        String consulta1 = "INSERT INTO habitacion(numeroHabitacion,pisoHabitacion,precioDiario,estado)"
                + "VALUES (?,?,?,?)";
        String consulta2 = "INSERT INTO tipohabitacion(idHabitacion,tipoHabitacion,caracteristicas)"
                + "VALUES ((SELECT idHabitacion from habitacion ORDER BY idHabitacion desc limit 1),?,?)";
        try {
            con = conectar.getConnection();
            con.setAutoCommit(false); //iniciamos la transacción de los datos
            ps = con.prepareStatement(consulta1, Statement.RETURN_GENERATED_KEYS); //obtener la clave primaria
            ps.setString(1, th.getNumeroHabitacion());
            ps.setString(2, th.getPisoHabitacion());
            ps.setDouble(3, th.getPrecioDiario());
            ps.setString(4, th.getEstado());
            //ejecutamos la primera consulta
            int resultado1 = ps.executeUpdate();
            // Obtenemos el idHabitación recién insertada
            int idHabitacion = -1; //-1, si ocurre algún error o no se obtiene un valor válido en nuestra BD, se pueda detectar facil.
            ResultSet generatedKeys = ps.getGeneratedKeys(); //obtenemos las claves generadas automaticamente
            if (generatedKeys.next()) { //si contiene al menos una fila
                idHabitacion = generatedKeys.getInt(1); //1, para obtener el valor de la primera columna
            }
            // Verificar el resultado de la primera consulta y el ID obtenido
            if (resultado1 != 0 && idHabitacion != -1) {
                // Preparar la segunda consulta
                ps2 = con.prepareStatement(consulta2);
                ps2.setString(1, th.getTipoHabitacion());
                ps2.setString(2, th.getCaracteristicas());
                // Ejecutamos la segunda consulta
                int resultado2 = ps2.executeUpdate();
                /*Completamos toda la transaccion realizada por ambas consultas*/
                if (resultado2 != 0) {
                    con.commit();
                    return true;
                } else {
                    con.rollback(); // Deshacemos la transacción si la segunda consulta falla
                    return false;
                }
            } else {
                con.rollback(); // Deshacer la transacción si la primera consulta falla o no se obtiene el ID
                return false;
            }
        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback(); // Deshacer la transacción en caso de excepción
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (con != null) {
                    con.setAutoCommit(true); // Restauramos el modo de autocommit
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public tipoHabitacion leerHabitacion(int idHabitacion) {
        tipoHabitacion tipoh = null;
        String sql = "SELECT h.numeroHabitacion, h.pisoHabitacion, h.precioDiario, h.estado, th.tipoHabitacion,"
                + "th.caracteristicas FROM tipoHabitacion th "
                + "INNER JOIN habitacion h on th.idHabitacion = h.idHabitacion "
                + "WHERE th.idHabitacion = ?";

        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHabitacion);
            rs = ps.executeQuery();
            if (rs.next()) {
                tipoh = new tipoHabitacion();
                tipoh.setIdHabitacion(idHabitacion);
                tipoh.setNumeroHabitacion(rs.getString("numeroHabitacion"));
                tipoh.setPisoHabitacion(rs.getString("pisoHabitacion"));
                tipoh.setPrecioDiario(rs.getDouble("precioDiario"));
                tipoh.setEstado(rs.getString("estado"));
                tipoh.setTipoHabitacion(rs.getString("tipoHabitacion"));
                tipoh.setCaracteristicas(rs.getString("caracteristicas"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoh;
    }

    public boolean UpdateHabitacion(tipoHabitacion th) {
        String consulta1 = "UPDATE habitacion SET numeroHabitacion=?, pisoHabitacion=?, precioDiario=?, estado=? WHERE idHabitacion=?";
        String consulta2 = "UPDATE tipohabitacion SET tipoHabitacion=?, caracteristicas=? WHERE idHabitacion=?";

        boolean transaccionExitosa = false; // Variable para rastrear el estado de la transacción

        try {
            con = conectar.getConnection();
            con.setAutoCommit(false); // Iniciamos la transacción de los datos
            ps = con.prepareStatement(consulta1);
            ps2 = con.prepareStatement(consulta2);

            ps.setString(1, th.getNumeroHabitacion());
            ps.setString(2, th.getPisoHabitacion());
            ps.setDouble(3, th.getPrecioDiario());
            ps.setString(4, th.getEstado());
            ps.setInt(5, th.getIdHabitacion());

            // Ejecutamos la primera consulta
            int resultado1 = ps.executeUpdate();

            // Verificar el resultado de la primera consulta
            if (resultado1 != 0) {
                // Preparar la segunda consulta
                ps2.setString(1, th.getTipoHabitacion());
                ps2.setString(2, th.getCaracteristicas());
                ps2.setInt(3, th.getIdHabitacion());

                // Ejecutamos la segunda consulta
                int resultado2 = ps2.executeUpdate();

                // Verificamos si ambas consultas fueron exitosas
                if (resultado2 != 0) {
                    con.commit(); // Commit si ambas consultas son exitosas
                    transaccionExitosa = true;
                } else {
                    con.rollback(); // Deshacemos la transacción si la segunda consulta falla
                }
            } else {
                con.rollback(); // Deshacer la transacción si la primera consulta falla
            }
        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback(); // Deshacemos la transacción en caso de excepción
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (con != null) {
                    con.setAutoCommit(true); // Restauramos el modo de autocommit
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return transaccionExitosa;
    }

    public boolean DeleteHabitacion(tipoHabitacion th) {
        String consulta1 = "DELETE FROM tipohabitacion WHERE idHabitacion=?";
        String consulta2 = "DELETE FROM habitacion WHERE idHabitacion=?";

        boolean transaccionExitosa = false; // Variable para rastrear el estado de la transacción

        try {
            con = conectar.getConnection();
            con.setAutoCommit(false); // Iniciamos la transacción de los datos
            ps = con.prepareStatement(consulta1);
            ps2 = con.prepareStatement(consulta2);

            ps.setInt(1, th.getIdHabitacion());
            ps2.setInt(1, th.getIdHabitacion());

            // Ejecutamos ambas consultas
            int resultado1 = ps.executeUpdate();
            int resultado2 = ps2.executeUpdate();

            // Verificamos si ambas consultas fueron exitosas
            if (resultado1 != 0 && resultado2 != 0) {
                con.commit(); // Commit si ambas consultas son exitosas
                transaccionExitosa = true;
            } else {
                con.rollback(); // Deshacemos la transacción si alguna consulta falla
            }
        } catch (Exception e) {
            try {
                if (con != null) {
                    con.rollback(); // Deshacemos la transacción en caso de excepción
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (ps2 != null) {
                    ps2.close();
                }
                if (con != null) {
                    con.setAutoCommit(true); // Restauramos el modo de autocommit
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return transaccionExitosa;
    }
}
