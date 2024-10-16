package Paneles;

import Dao.DaoHabitacion;
import Dao.DaoReserva;
import Entidades.Habitacion;
import Entidades.tipoHabitacion;
import PanelesRegistros.RegistroHabitacion;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MostrarHabitaciones extends javax.swing.JInternalFrame {

    DaoHabitacion habitacionDao = new DaoHabitacion();
    DaoReserva reservaDao = new DaoReserva();
    DefaultTableModel modeloHabitacion = new DefaultTableModel();
    RegistroHabitacion registroHabitacion; // Declaración de la variable global

    public MostrarHabitaciones() {
        initComponents();
        listarHabitaciones(TablaHabitacion);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaHabitacion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cboEstado = new javax.swing.JComboBox<>();
        btnFiltrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Habitaciones");

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
        TablaHabitacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablaHabitacionMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TablaHabitacion);

        jLabel1.setText("Estado:");

        cboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Estado", "Disponible", "Reservado" }));

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
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
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFiltrar, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TablaHabitacionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaHabitacionMousePressed
        //Seleccionar la habitacion y asignarlo a sus campos respectivos
        if (evt.getClickCount() == 2) { //seleccionar dando doble click
            int fila = TablaHabitacion.getSelectedRow();
            String codigo;
            String numeroHabitacion;
            String pisoHabitacion;
            String precioHabitacion;
            String tipoHabitacion;

            codigo = TablaHabitacion.getValueAt(fila, 0).toString();
            numeroHabitacion = TablaHabitacion.getValueAt(fila, 1).toString();
            pisoHabitacion = TablaHabitacion.getValueAt(fila, 2).toString();
            tipoHabitacion = TablaHabitacion.getValueAt(fila, 3).toString();
            precioHabitacion = TablaHabitacion.getValueAt(fila, 4).toString();
            PanelReservas.txtIdHabitacion.setText(codigo);
            PanelReservas.txtNumeroHabitacion.setText(numeroHabitacion);
            PanelReservas.txtPisoHabitacion.setText(pisoHabitacion);
            PanelReservas.txtPrecioHabitacion.setText(precioHabitacion);
            PanelReservas.txtTipoHabitacion.setText(tipoHabitacion);
            this.dispose();
        }
    }//GEN-LAST:event_TablaHabitacionMousePressed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String estadoSeleccionado = cboEstado.getSelectedItem().toString();
        modeloHabitacion.setRowCount(0);
        filtrarEstadoHabitacion(estadoSeleccionado);
    }//GEN-LAST:event_btnFiltrarActionPerformed
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
    }
    
    private void filtrarEstadoHabitacion(String estadoSeleccionado) {
        modeloHabitacion = (DefaultTableModel) TablaHabitacion.getModel();
        List<Habitacion> listaHabitacion = habitacionDao.listarHabitaciones();
        Object[] object = new Object[6];

        for (int i = 0; i < listaHabitacion.size(); i++) {
            Habitacion hab = listaHabitacion.get(i);

            // Aquí comparas el estado de la habitación con el estado seleccionado en el JComboBox
            if (estadoSeleccionado.equals("Disponible") && hab.getEstado().equals("Disponible")) {
                object[0] = hab.getIdHabitacion();
                object[1] = hab.getNumeroHabitacion();
                object[2] = hab.getPisoHabitacion();
                int idtipohabitacion = hab.getIdHabitacion();
                String tipohabitacion = reservaDao.obtenerTipoHabitacion(idtipohabitacion);
                object[3] = tipohabitacion;
                object[4] = hab.getPrecioDiario();
                object[5] = hab.getEstado();
                
                modeloHabitacion.addRow(object);
            } else if (estadoSeleccionado.equals("Reservado") && hab.getEstado().equals("Reservado")) {
                object[0] = hab.getIdHabitacion();
                object[1] = hab.getNumeroHabitacion();
                object[2] = hab.getPisoHabitacion();
                int idtipohabitacion = hab.getIdHabitacion();
                String tipohabitacion = reservaDao.obtenerTipoHabitacion(idtipohabitacion);
                object[3] = tipohabitacion;
                object[4] = hab.getPrecioDiario();
                object[5] = hab.getEstado();

                modeloHabitacion.addRow(object);
            }
        }

        // Actualizar la tabla con los datos filtrados
        TablaHabitacion.setModel(modeloHabitacion);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaHabitacion;
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JComboBox<String> cboEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
