package Paneles;

import Dao.DaoHabitacion;
import PanelesRegistros.RegistroHabitacion;
import Entidades.tipoHabitacion;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PanelHabitacion extends javax.swing.JInternalFrame {

    DaoHabitacion habitacionDao = new DaoHabitacion();
    DefaultTableModel modeloHabitacion = new DefaultTableModel();
    RegistroHabitacion registroHabitacion; // Declaración de la variable global

    public PanelHabitacion() {
        initComponents();
        listarHabitaciones(TablaHabitacion);
        RegistroHabitacion registroHabitacion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNuevaHabitacion = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaHabitacion = new javax.swing.JTable();
        lblTotalRegistros = new javax.swing.JLabel();
        btnActualizarHabitacion = new javax.swing.JButton();
        btnEliminarHabitacion = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setIconifiable(true);
        setTitle("HABITACIONES DISPONIBLES");

        btnNuevaHabitacion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnNuevaHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/agregar.png"))); // NOI18N
        btnNuevaHabitacion.setText("Nueva Habitación");
        btnNuevaHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaHabitacionActionPerformed(evt);
            }
        });

        TablaHabitacion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        TablaHabitacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "N° Habitación", "Piso Habitación", "Tipo", "Precio x Día", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaHabitacion);

        lblTotalRegistros.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        lblTotalRegistros.setText("Total Registros:");

        btnActualizarHabitacion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnActualizarHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/actualizar.png"))); // NOI18N
        btnActualizarHabitacion.setText("Actualizar Habitación");
        btnActualizarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarHabitacionActionPerformed(evt);
            }
        });

        btnEliminarHabitacion.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnEliminarHabitacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/eliminar.png"))); // NOI18N
        btnEliminarHabitacion.setText("Eliminar Habitación");
        btnEliminarHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarHabitacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevaHabitacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnActualizarHabitacion)
                        .addGap(128, 128, 128)
                        .addComponent(btnEliminarHabitacion))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTotalRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevaHabitacion)
                    .addComponent(btnActualizarHabitacion)
                    .addComponent(btnEliminarHabitacion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTotalRegistros)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaHabitacionActionPerformed
        RegistroHabitacion registroHabitacion = new RegistroHabitacion();
        this.getParent().add(registroHabitacion);
        registroHabitacion.toFront();
        registroHabitacion.setVisible(true);
        registroHabitacion.btnActualizarRegistro.setEnabled(false);
    }//GEN-LAST:event_btnNuevaHabitacionActionPerformed

    private void btnActualizarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarHabitacionActionPerformed
        int filaSeleccionada = TablaHabitacion.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
            Object valorCelda = TablaHabitacion.getValueAt(filaSeleccionada, 0);
            if (valorCelda instanceof Integer) {
                int idHabitacion = (int) valorCelda;
                tipoHabitacion th = habitacionDao.leerHabitacion(idHabitacion);
                RegistroHabitacion registroHabitacion = new RegistroHabitacion();
                this.getParent().add(registroHabitacion);
                registroHabitacion.mostrarDatosHabitacion(th); // Llama al método para mostrar los datos
                registroHabitacion.txtNumeroHabitacion.setEnabled(false);
                registroHabitacion.cboPisoHabitacion.setEnabled(false);
                registroHabitacion.txtEstadoHabitacion.setEnabled(false);
                registroHabitacion.txtTipoHabitacion.setEnabled(false);
                registroHabitacion.btnGuardarRegistro.setEnabled(false);
                registroHabitacion.setVisible(true);
            }
        }
    }//GEN-LAST:event_btnActualizarHabitacionActionPerformed

    private void btnEliminarHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarHabitacionActionPerformed
        int filaHabitacion = TablaHabitacion.getSelectedRow();
        if (filaHabitacion == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila");
        } else {
            tipoHabitacion th = new tipoHabitacion();
            int id = Integer.parseInt(TablaHabitacion.getValueAt(filaHabitacion, 0).toString());
            th.setIdHabitacion(id);
            boolean transaccionExitosa = habitacionDao.DeleteHabitacion(th);

            if (transaccionExitosa) {
                JOptionPane.showMessageDialog(null, "Habitación Eliminada con Éxito");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar la habitación");
            }
        }
    }//GEN-LAST:event_btnEliminarHabitacionActionPerformed
    public void listarHabitaciones(JTable tabla) {
        modeloHabitacion = (DefaultTableModel) tabla.getModel();
        List<tipoHabitacion> listaTipoHabitacion = habitacionDao.listarHabitaciones();

        for (int i = 0; i < listaTipoHabitacion.size(); i++) {
            tipoHabitacion tipoHab = listaTipoHabitacion.get(i);
            Object[] object = new Object[6];
            object[0] = tipoHab.getIdHabitacion();
            object[1] = tipoHab.getNumeroHabitacion();
            object[2] = tipoHab.getPisoHabitacion();
            object[3] = tipoHab.getTipoHabitacion();
            object[4] = tipoHab.getPrecioDiario();
            object[5] = tipoHab.getEstado();

            modeloHabitacion.addRow(object);
        }
        TablaHabitacion.setModel(modeloHabitacion);
        TotalRegistros();
    }

    public void TotalRegistros() {
        int totalRegistros = TablaHabitacion.getRowCount();
        lblTotalRegistros.setText("Total de Registros: " + totalRegistros);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaHabitacion;
    private javax.swing.JButton btnActualizarHabitacion;
    private javax.swing.JButton btnEliminarHabitacion;
    private javax.swing.JButton btnNuevaHabitacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTotalRegistros;
    // End of variables declaration//GEN-END:variables

}
