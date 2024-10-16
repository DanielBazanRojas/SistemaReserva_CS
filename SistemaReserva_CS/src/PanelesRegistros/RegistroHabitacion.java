package PanelesRegistros;

import Dao.DaoHabitacion;
import Entidades.tipoHabitacion;
import javax.swing.JOptionPane;

public class RegistroHabitacion extends javax.swing.JInternalFrame {

    DaoHabitacion daoHabitacion = new DaoHabitacion();
    tipoHabitacion th = new tipoHabitacion();

    public RegistroHabitacion() {
        initComponents();
        txtIdHabitacion.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtCaracteristicasHabitacion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNumeroHabitacion = new javax.swing.JTextField();
        cboPisoHabitacion = new javax.swing.JComboBox<>();
        txtPrecioHabitacion = new javax.swing.JTextField();
        txtEstadoHabitacion = new javax.swing.JTextField();
        txtTipoHabitacion = new javax.swing.JTextField();
        btnGuardarRegistro = new javax.swing.JButton();
        btnActualizarRegistro = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtIdHabitacion = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Registro Habitaciones");

        txtCaracteristicasHabitacion.setColumns(20);
        txtCaracteristicasHabitacion.setRows(5);
        jScrollPane1.setViewportView(txtCaracteristicasHabitacion);

        jLabel1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel1.setText("Número Habitación:");

        jLabel2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel2.setText("Piso Habitación:");

        jLabel3.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel3.setText("Precio x Día:");

        jLabel4.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel4.setText("Estado:");

        jLabel5.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel5.setText("Tipo Habitación:");

        txtNumeroHabitacion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N

        cboPisoHabitacion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cboPisoHabitacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Piso", "Piso 02", "Piso 03", "Piso 04", "Piso 05", "Piso 06", "Psio 07" }));

        txtPrecioHabitacion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N

        txtEstadoHabitacion.setEditable(false);
        txtEstadoHabitacion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        txtEstadoHabitacion.setText("Disponible");

        txtTipoHabitacion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N

        btnGuardarRegistro.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnGuardarRegistro.setText("Guardar Registro");
        btnGuardarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarRegistroActionPerformed(evt);
            }
        });

        btnActualizarRegistro.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnActualizarRegistro.setText("Actualizar Registro");
        btnActualizarRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarRegistroActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel6.setText("Características:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumeroHabitacion)
                            .addComponent(cboPisoHabitacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPrecioHabitacion)
                            .addComponent(txtEstadoHabitacion)
                            .addComponent(txtTipoHabitacion)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnActualizarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumeroHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboPisoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrecioHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEstadoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTipoHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnActualizarRegistro)
                    .addComponent(btnGuardarRegistro)
                    .addComponent(txtIdHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarRegistroActionPerformed
        if (validarDatos() == false) {
            JOptionPane.showMessageDialog(null, "Faltan ingresar datos");
            return;
        } else {
            crearHabitacion();
            dispose();
        }
    }//GEN-LAST:event_btnGuardarRegistroActionPerformed

    private void btnActualizarRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarRegistroActionPerformed
       actualizarHabitacion();
       dispose();
    }//GEN-LAST:event_btnActualizarRegistroActionPerformed

    private boolean validarDatos() {
        if (txtNumeroHabitacion.getText().isEmpty()) {
            return false;
        }
        if (cboPisoHabitacion.getSelectedIndex() == 0) {
            return false;
        }
        if (txtPrecioHabitacion.getText().isEmpty()) {
            return false;
        }
        if (txtCaracteristicasHabitacion.getText().isEmpty()) {
            return false;
        }
        return true;
    }

    public void crearHabitacion() {
        // Obtener los valores de los campos
        String numeroHabitacion = txtNumeroHabitacion.getText();
        Object pisoHabitacion = cboPisoHabitacion.getSelectedItem();
        String precioDiario = txtPrecioHabitacion.getText();
        String estadoHabitacion = txtEstadoHabitacion.getText();
        String tipoHabitacion = txtTipoHabitacion.getText();
        String caracteristicas = txtCaracteristicasHabitacion.getText();

        // Validar si el pisoHabitacionObj es una opción válida
        if (pisoHabitacion == null) {
            JOptionPane.showMessageDialog(null, "Por favor, seleccione un piso válido.");
            return;
        }
        // Crear una instancia de tipoHabitacion con los datos
        tipoHabitacion th = new tipoHabitacion();
        th.setNumeroHabitacion(numeroHabitacion);
        int seleccionado = cboPisoHabitacion.getSelectedIndex();
        th.setPisoHabitacion((String) cboPisoHabitacion.getItemAt(seleccionado));
        th.setPrecioDiario(Double.parseDouble(precioDiario));
        th.setEstado(estadoHabitacion);
        th.setTipoHabitacion(txtTipoHabitacion.getText());
        th.setCaracteristicas(caracteristicas);

        // Llamar al método CreateHabitacion para guardar en la base de datos
        boolean respuesta = daoHabitacion.CreateHabitacion(th);

        // Mostrar mensaje de éxito o error
        if (respuesta) {
            JOptionPane.showMessageDialog(null, "Habitación registrada con éxito");
        } else {
            JOptionPane.showMessageDialog(null, "Error. La habitación no fue registrada");
        }
    }

    public void actualizarHabitacion() {
        String numeroHabitacion = txtNumeroHabitacion.getText();
        String pisoHabitacion = cboPisoHabitacion.getSelectedItem().toString();
        String precioHabitacion = txtPrecioHabitacion.getText();
        String estadoHabitacion = txtEstadoHabitacion.getText();
        String tipoHabitacion = txtTipoHabitacion.getText();
        String caracteristicas = txtCaracteristicasHabitacion.getText();

        tipoHabitacion th = new tipoHabitacion();
        th.setNumeroHabitacion(numeroHabitacion);
        th.setPisoHabitacion(pisoHabitacion);
        th.setPrecioDiario(Double.parseDouble(precioHabitacion));
        th.setEstado(estadoHabitacion);
        th.setTipoHabitacion(tipoHabitacion);
        th.setCaracteristicas(caracteristicas);
        th.setIdHabitacion(Integer.valueOf(this.txtIdHabitacion.getText()));

        // Llama al método en tu DAO para actualizar la habitación
        boolean transaccionExitosa = daoHabitacion.UpdateHabitacion(th);

        if (transaccionExitosa) {
            JOptionPane.showMessageDialog(null, "Habitación actualizada con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar la habitación.");
        }
    }

    public void mostrarDatosHabitacion(tipoHabitacion th) {
        txtNumeroHabitacion.setText(th.getNumeroHabitacion());
        cboPisoHabitacion.setSelectedItem(th.getPisoHabitacion());
        txtPrecioHabitacion.setText(Double.toString(th.getPrecioDiario()));
        txtEstadoHabitacion.setText(th.getEstado());
        txtTipoHabitacion.setText(th.getTipoHabitacion());
        txtCaracteristicasHabitacion.setText(th.getCaracteristicas());
        txtIdHabitacion.setText(Integer.toString(th.getIdHabitacion()));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnActualizarRegistro;
    public javax.swing.JButton btnGuardarRegistro;
    public javax.swing.JComboBox<String> cboPisoHabitacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtCaracteristicasHabitacion;
    public javax.swing.JTextField txtEstadoHabitacion;
    public javax.swing.JTextField txtIdHabitacion;
    public javax.swing.JTextField txtNumeroHabitacion;
    private javax.swing.JTextField txtPrecioHabitacion;
    public javax.swing.JTextField txtTipoHabitacion;
    // End of variables declaration//GEN-END:variables
}
