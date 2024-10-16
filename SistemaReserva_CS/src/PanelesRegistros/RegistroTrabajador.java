package PanelesRegistros;

import Dao.DaoCargo;
import Dao.DaoTrabajador;
import Entidades.cargo;
import Entidades.trabajador;
import Paneles.PanelReservas;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class RegistroTrabajador extends javax.swing.JInternalFrame {

    DaoCargo cargoDao = new DaoCargo();
    DaoTrabajador trabajadorDao = new DaoTrabajador();
    trabajador trabajador = new trabajador();
    DefaultTableModel modeloTrabajador = new DefaultTableModel();

    public RegistroTrabajador() {
        initComponents();
        listarTrabajador(TablaTrabajador);
        txtIdTrabajador.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaTrabajador = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreTrabajador = new javax.swing.JTextField();
        txtApellidoTrabajador = new javax.swing.JTextField();
        txtTipoDocumento = new javax.swing.JTextField();
        txtNumeroDocumento = new javax.swing.JTextField();
        btnNuevoRegistro = new javax.swing.JButton();
        btnGuardarDatos = new javax.swing.JButton();
        cboTrabajadorCargo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnUsuario = new javax.swing.JButton();
        txtIdTrabajador = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Trabajador");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado De Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 14))); // NOI18N

        TablaTrabajador.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        TablaTrabajador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombres", "Apellidos", "Tipo Doc.", "Número Doc.", "Cargo", "Usuario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaTrabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaTrabajadorMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaTrabajador);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Datos Del Trabajador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 2, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel1.setText("Nombres:");

        jLabel2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel2.setText("Apellidos:");

        jLabel3.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel3.setText("Tipo Documento:");

        jLabel4.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel4.setText("Número:");

        jLabel5.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel5.setText("Cargo:");

        btnNuevoRegistro.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnNuevoRegistro.setText("Nuevo Registro");

        btnGuardarDatos.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnGuardarDatos.setText("Guardar Datos");
        btnGuardarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDatosActionPerformed(evt);
            }
        });

        cboTrabajadorCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Cargo" }));

        jLabel7.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel7.setText("Usuario:");

        btnUsuario.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnUsuario.setText("Crear Usuario");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addComponent(txtTipoDocumento))
                            .addComponent(cboTrabajadorCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtApellidoTrabajador)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnUsuario)
                                .addGap(106, 106, 106))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIdTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(btnNuevoRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 126, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(txtNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtApellidoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(txtNumeroDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtTipoDocumento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboTrabajadorCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoRegistro)
                    .addComponent(btnGuardarDatos)
                    .addComponent(txtIdTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void CargarCargo() {
        List<cargo> listaUsuarios = cargoDao.listarCargo();
        for (cargo TrabajadorCargo : listaUsuarios) {
            cboTrabajadorCargo.addItem(TrabajadorCargo.getNombreCargo());
        }
    }

    public JComboBox getCboTrabajadorCargo() {
        return cboTrabajadorCargo;
    }

    public void crearTrabajador() {
        String nombreTrabajador = txtNombreTrabajador.getText();
        String apellidoTrabajador = txtApellidoTrabajador.getText();
        String tipoDocumento = txtTipoDocumento.getText();
        String numeroDocumento = txtNumeroDocumento.getText();
        Object nombreCargo = cboTrabajadorCargo.getSelectedItem();
        int idCargo = this.trabajadorDao.obtenerIdCargoPorNombreCargo(nombreCargo.toString());
        String usuario = txtUsuario.getText();

        trabajador tra = new trabajador();
        tra.setNombreTrabajador(nombreTrabajador);
        tra.setApellidoTrabajador(apellidoTrabajador);
        tra.setTipoDocumento(tipoDocumento);
        tra.setNumDocumento(numeroDocumento);
        tra.setIdCargo(idCargo);
        tra.setNombreUsuario(usuario);

        // Llamar al método CreateHabitacion para guardar en la base de datos
        boolean respuesta = trabajadorDao.CreateTrabajador(tra);

        // Mostrar mensaje de éxito o error
        if (respuesta) {
            JOptionPane.showMessageDialog(null, "trabajador registrado con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Error. El trabajador no fue registrado");
        }
    }

    public void listarTrabajador(JTable tabla) {
        modeloTrabajador = (DefaultTableModel) tabla.getModel();
        List<trabajador> listaTrabajadores = trabajadorDao.listarTrabajadores();
        Object[] object = new Object[7];

        for (int i = 0; i < listaTrabajadores.size(); i++) {
            object[0] = listaTrabajadores.get(i).getIdTrabajador();
            object[1] = listaTrabajadores.get(i).getNombreTrabajador();
            object[2] = listaTrabajadores.get(i).getApellidoTrabajador();
            object[3] = listaTrabajadores.get(i).getTipoDocumento();
            object[4] = listaTrabajadores.get(i).getNumDocumento();
            int idCargo = listaTrabajadores.get(i).getIdCargo();
            String nombreCargo = trabajadorDao.obtenerNombreCargoPorId(idCargo);
            object[5] = nombreCargo;
            int idTrabajador = listaTrabajadores.get(i).getIdTrabajador();
            String nombreUsuario = trabajadorDao.obtenerNombreUsuarioPorId(idTrabajador);
            object[6] = nombreUsuario;
            modeloTrabajador.addRow(object);
        }
        TablaTrabajador.setModel(modeloTrabajador);
    }


    private void TablaTrabajadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaTrabajadorMousePressed
        //Seleccionar la habitacion y asignarlo a sus campos respectivos
        if (evt.getClickCount() == 2) { //seleccionar dando doble click
            int fila = TablaTrabajador.getSelectedRow();
            String codigo;
            String nombreCliente;

            codigo = TablaTrabajador.getValueAt(fila, 0).toString();
            nombreCliente = TablaTrabajador.getValueAt(fila, 1).toString() + " " + TablaTrabajador.getValueAt(fila, 2).toString();

            PanelReservas.txtIdCliente.setText(codigo);
            PanelReservas.txtNombreCliente.setText(nombreCliente);
            this.dispose();
        }
    }//GEN-LAST:event_TablaTrabajadorMousePressed

    private void btnGuardarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDatosActionPerformed
        crearTrabajador();
    }//GEN-LAST:event_btnGuardarDatosActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        RegistroUsuario formularioUsuario = new RegistroUsuario();
        this.getParent().add(formularioUsuario);
        formularioUsuario.toFront();
        formularioUsuario.setVisible(true);
    }//GEN-LAST:event_btnUsuarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaTrabajador;
    private javax.swing.JButton btnGuardarDatos;
    private javax.swing.JButton btnNuevoRegistro;
    private javax.swing.JButton btnUsuario;
    private javax.swing.JComboBox<String> cboTrabajadorCargo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtApellidoTrabajador;
    private javax.swing.JTextField txtIdTrabajador;
    private javax.swing.JTextField txtNombreTrabajador;
    private javax.swing.JTextField txtNumeroDocumento;
    private javax.swing.JTextField txtTipoDocumento;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
