package Paneles;

import Dao.DaoReserva;
import Entidades.Reserva;
import Entidades.detalleReserva;
import PanelesRegistros.RegistroCliente;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import ConexionMySQL.conexion;

public class PanelReservas extends javax.swing.JInternalFrame {

    DaoReserva reservaDao = new DaoReserva();
    private int itemContador = 0;

    public PanelReservas() {
        initComponents();
        DateIngreso.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    calcularDias();
                }
            }
        });

        DateSalida.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent e) {
                if ("date".equals(e.getPropertyName())) {
                    calcularDias();
                }
            }
        });
        cargarCorrelativoSerie();

    }

    private void cargarCorrelativoSerie() {
        this.txtSerieReserva.setText("R0001");
        int correlativo = 0;
        try {
            correlativo = this.reservaDao.obtenerCorrelativo();
            this.txtCorrelativoReserva.setText("0000" + (++correlativo));
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaResumen = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreCliente = new javax.swing.JTextField();
        btnRegistrarDatosClientes = new javax.swing.JButton();
        txtNumeroHabitacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPisoHabitacion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTipoHabitacion = new javax.swing.JTextField();
        btnMostrarHabitaciones = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        DateReserva = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        DateIngreso = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        DateSalida = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtTotalDias = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cboMetodoPago = new javax.swing.JComboBox<>();
        btnAgregarDetalle = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txtPrecioHabitacion = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtIdHabitacion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombreTrabajador = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtSerieReserva = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtCorrelativoReserva = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtMontoTotal = new javax.swing.JTextField();
        btnReservarHabitacion = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Reservas");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resumen Reserva", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        TablaResumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "C° Hab", "N° Hab", "Tipo", "Días", "Precio x Día", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaResumen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 12))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cliente:");

        txtNombreCliente.setEditable(false);

        btnRegistrarDatosClientes.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnRegistrarDatosClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/registrarCliente.png"))); // NOI18N
        btnRegistrarDatosClientes.setText("Registrar Datos");
        btnRegistrarDatosClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarDatosClientesActionPerformed(evt);
            }
        });

        txtNumeroHabitacion.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("N° Habitación:");

        jLabel4.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Piso Habitación:");

        txtPisoHabitacion.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo:");

        txtTipoHabitacion.setEditable(false);

        btnMostrarHabitaciones.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnMostrarHabitaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/mostrarHabitacion.png"))); // NOI18N
        btnMostrarHabitaciones.setText("Mostrar Habitaciones");
        btnMostrarHabitaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarHabitacionesActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Fecha Reserva:");

        jLabel7.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Fecha Ingreso:");

        jLabel8.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha Salida:");

        jLabel9.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Total Días:");

        txtTotalDias.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Método Pago:");

        cboMetodoPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Pago", "1. Efectivo", "2. Yape", "3. Plim" }));

        btnAgregarDetalle.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnAgregarDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/agregarDetalle.png"))); // NOI18N
        btnAgregarDetalle.setText("Agregar Detalle");
        btnAgregarDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDetalleActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Precio x Día:");

        txtPrecioHabitacion.setEditable(false);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Codigo:");

        txtIdHabitacion.setEditable(false);

        jLabel16.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Codigo:");

        txtIdCliente.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtIdHabitacion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addComponent(txtPisoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtPrecioHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMostrarHabitaciones))
                            .addComponent(jLabel14))
                        .addGap(85, 85, 85))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboMetodoPago, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(DateReserva, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgregarDetalle)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DateIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DateSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTotalDias, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel9)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegistrarDatosClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRegistrarDatosClientes)
                            .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPisoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMostrarHabitaciones)
                                    .addComponent(txtPrecioHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtTotalDias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(DateSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMetodoPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarDetalle))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/Trabajador.png"))); // NOI18N
        jLabel1.setText("Trabajador:");

        txtNombreTrabajador.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/Serie.png"))); // NOI18N
        jLabel11.setText("Serie:");

        txtSerieReserva.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/correlativo.png"))); // NOI18N
        jLabel12.setText("Correlativo:");

        txtCorrelativoReserva.setEditable(false);

        jLabel13.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel13.setText("Total:");

        btnReservarHabitacion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnReservarHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/reservado.png"))); // NOI18N
        btnReservarHabitacion.setText("Reservar Habitación");
        btnReservarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservarHabitacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSerieReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCorrelativoReserva))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnReservarHabitacion, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtSerieReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtCorrelativoReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 173, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMontoTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReservarHabitacion)
                        .addGap(12, 12, 12))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarDatosClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarDatosClientesActionPerformed
        RegistroCliente formularioRegistro = new RegistroCliente();
        this.getParent().add(formularioRegistro);
        formularioRegistro.toFront();
        formularioRegistro.setVisible(true);    
    }//GEN-LAST:event_btnRegistrarDatosClientesActionPerformed

    private void btnMostrarHabitacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarHabitacionesActionPerformed
        MostrarHabitaciones formularioHabitaciones = new MostrarHabitaciones();
        this.getParent().add(formularioHabitaciones);
        formularioHabitaciones.toFront();
        formularioHabitaciones.setVisible(true);
    }//GEN-LAST:event_btnMostrarHabitacionesActionPerformed

    private void btnAgregarDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDetalleActionPerformed
        int idHabitacion = Integer.parseInt(txtIdHabitacion.getText());
        String numeroHabitacion = txtNumeroHabitacion.getText();
        String tipoHabitacion = txtTipoHabitacion.getText();
        int cantidadDias = Integer.parseInt(txtTotalDias.getText());
        double precioHabitacion = Double.parseDouble(txtPrecioHabitacion.getText());
        double montoTotal = Math.round(cantidadDias * precioHabitacion * 100.0) / 100.0;
        // Verificar el estado de la habitación
        String estadoHabitacion = obtenerEstadoHabitacion(idHabitacion);
        if ("Reservado".equals(estadoHabitacion)) {
            JOptionPane.showMessageDialog(null, "Esta habitación está reservada. Elija otra habitación.", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            DefaultTableModel modeloResumenReserva = (DefaultTableModel) TablaResumen.getModel();
        int numeroFilas = modeloResumenReserva.getRowCount();
        actualizarContador();

        Object[] DatosDeFila = {itemContador, idHabitacion, numeroHabitacion, tipoHabitacion, cantidadDias, precioHabitacion, montoTotal};
        modeloResumenReserva.addRow(DatosDeFila);
        calcularTotalAPagar();
        limpiarCampos();
        }
    }//GEN-LAST:event_btnAgregarDetalleActionPerformed

    conexion conectar = new conexion();

    private String obtenerEstadoHabitacion(int idHabitacion) {
        String estado = ""; // Inicializa el estado como una cadena vacía
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = conectar.getConnection();
            String sql = "SELECT estado FROM habitacion WHERE idHabitacion = ?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idHabitacion);
            rs = ps.executeQuery();

            if (rs.next()) {
                estado = rs.getString("estado");
            }
        } catch (SQLException e) {
            // Manejar errores de consulta a la base de datos
            e.printStackTrace();
        } finally {
            // Cerrar recursos en el bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // Manejar errores al cerrar recursos
                e.printStackTrace();
            }
        }

        return estado;
    }

    public void limpiarCampos() {
        txtIdHabitacion.setText("");
        txtNumeroHabitacion.setText("");
        txtPisoHabitacion.setText("");
        txtPrecioHabitacion.setText("");
        txtTipoHabitacion.setText("");
    }

    private void calcularTotalAPagar() {
        DefaultTableModel modeloResumenReserva = (DefaultTableModel) TablaResumen.getModel();
        int rowCount = modeloResumenReserva.getRowCount();
        double totalAPagar = 0.0;

        for (int i = 0; i < rowCount; i++) {
            double totalFila = (double) modeloResumenReserva.getValueAt(i, 6);
            totalAPagar += totalFila;
        }
        // Actualizar el valor total a pagar en el componente correspondiente
        txtMontoTotal.setText(String.valueOf(totalAPagar));
    }

    private void actualizarContador() {
        DefaultTableModel modeloResumenReserva = (DefaultTableModel) TablaResumen.getModel();
        int rowCount = modeloResumenReserva.getRowCount();

        for (int i = 0; i < rowCount; i++) {
            modeloResumenReserva.setValueAt(i + 1, i, 0);
        }
        itemContador = rowCount > 0 ? rowCount + 1 : 1;
    }

    private void calcularDias() {
        java.sql.Date fechaInicio = null;
        java.sql.Date fechaSalida = null;

        if (DateIngreso.getDate() != null) {
            fechaInicio = new java.sql.Date(DateIngreso.getDate().getTime());
        }

        if (DateSalida.getDate() != null) {
            fechaSalida = new java.sql.Date(DateSalida.getDate().getTime());
        }

        if (fechaInicio != null && fechaSalida != null) {
            long dias = ChronoUnit.DAYS.between(fechaInicio.toLocalDate(), fechaSalida.toLocalDate());
            txtTotalDias.setText(String.valueOf(dias));
        } else {
            txtTotalDias.setText("");
        }
    }

    private void btnReservarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservarHabitacionActionPerformed
        if (TablaResumen.getRowCount() > 0) {
            // Continuar con el proceso de reserva
            Reserva reserva = GuardarReserva();
            // Guardar información de la reserva
            ArrayList<detalleReserva> infoReservas = obtenerDetalleReserva();
            reserva.setDetalleReserva(infoReservas);
            try {
                reservaDao.registrar(reserva);
                JOptionPane.showMessageDialog(null, "Habitación reservada con éxito");
                reiniciarCamposYTabla();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al reservar habitación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnReservarHabitacionActionPerformed

    public Reserva GuardarReserva() {
        Reserva reserva = new Reserva();
        reserva.setIdTrabajador(1);
        if (DateReserva.getDate() != null) {
            Date fechaReserva = DateReserva.getDate();
            reserva.setFechaReserva(fechaReserva);
        }

        reserva.setSerieReserva(txtSerieReserva.getText());
        reserva.setCorrelativoReserva(txtCorrelativoReserva.getText());

        reserva.setIdCliente(Integer.parseInt(txtIdCliente.getText()));
        Object valorPago = cboMetodoPago.getSelectedItem();
        String idPago = primerCaracter(String.valueOf(valorPago), 1);
        reserva.setIdPago(Integer.parseInt(idPago));
        reserva.setEstado(true);
        reserva.setTotal(Double.parseDouble(txtMontoTotal.getText()));
        return reserva;
    }

    public void reiniciarCamposYTabla() {
        // Actualizar el contador
        itemContador = 0;

        // Actualizar el correlativo
        cargarCorrelativoSerie();

        // Limpiar los campos de texto
        txtIdCliente.setText("");
        txtNombreCliente.setText("");
        txtIdHabitacion.setText("");
        txtNumeroHabitacion.setText("");
        txtPisoHabitacion.setText("");
        txtTipoHabitacion.setText("");
        txtPrecioHabitacion.setText("");
        DateReserva.setDate(null);
        DateIngreso.setDate(null);
        DateSalida.setDate(null);
        txtTotalDias.setText("");
        txtMontoTotal.setText("");

        //Restablecer el ComboBox
        cboMetodoPago.setSelectedIndex(0);

        // Limpiar la tabla
        DefaultTableModel model = (DefaultTableModel) TablaResumen.getModel();
        model.setRowCount(0);
    }

    public ArrayList<detalleReserva> obtenerDetalleReserva() {
        JTable table = TablaResumen;
        ArrayList<detalleReserva> informacionReserva = new ArrayList<>();

        for (int i = 0; i < table.getRowCount(); i++) {
            detalleReserva infoReserva = new detalleReserva();

            for (int j = 0; j < table.getColumnCount(); j++) {
                Object value = table.getValueAt(i, j);

                switch (j) {
                    case 0: // Columna item°
                        break;
                    case 1: // Columna C° Habitacion
                        infoReserva.setIdHabitacion((int) value);
                        break;
                    case 2: // Columna N° Habitacion
                        break;
                    case 3: // Columna N° Tipo
                        break;
                    case 4: // Columna TotalDias
                        infoReserva.setCantidadDias((int) value);
                        break;
                    case 5: // Columna precio x Día                     
                        break;
                    case 6:  // Columna MontoTotal
                        infoReserva.setMontoTotal((double) value);
                        break;
                }
            }

            informacionReserva.add(infoReserva);
        }

        return informacionReserva;
    }

    public String primerCaracter(String str, int n) {
        /*Si en caso la cadena es nula, evitamos el nullPointerException*/
        if (str == null) {
            return null;
        }
        return str.length() < n ? str : str.substring(0, n);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateIngreso;
    private com.toedter.calendar.JDateChooser DateReserva;
    private com.toedter.calendar.JDateChooser DateSalida;
    private javax.swing.JTable TablaResumen;
    private javax.swing.JButton btnAgregarDetalle;
    private javax.swing.JButton btnMostrarHabitaciones;
    private javax.swing.JButton btnRegistrarDatosClientes;
    private javax.swing.JButton btnReservarHabitacion;
    private javax.swing.JComboBox<String> cboMetodoPago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCorrelativoReserva;
    public static javax.swing.JTextField txtIdCliente;
    public static javax.swing.JTextField txtIdHabitacion;
    public javax.swing.JTextField txtMontoTotal;
    public static javax.swing.JTextField txtNombreCliente;
    public static javax.swing.JTextField txtNombreTrabajador;
    public static javax.swing.JTextField txtNumeroHabitacion;
    public static javax.swing.JTextField txtPisoHabitacion;
    public static javax.swing.JTextField txtPrecioHabitacion;
    private javax.swing.JTextField txtSerieReserva;
    public static javax.swing.JTextField txtTipoHabitacion;
    private javax.swing.JTextField txtTotalDias;
    // End of variables declaration//GEN-END:variables
}
