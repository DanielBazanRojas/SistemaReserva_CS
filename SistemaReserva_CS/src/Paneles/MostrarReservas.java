package Paneles;

import Dao.DaoReserva;
import Entidades.ReservaInfo;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MostrarReservas extends javax.swing.JInternalFrame {

    DaoReserva daoReserva = new DaoReserva();
    DefaultTableModel modeloReserva = new DefaultTableModel();

    public MostrarReservas() {
        initComponents();
        listarReservas(TablaConsulta);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnConsultarDNI = new javax.swing.JButton();
        txtDniCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaConsulta = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("Consulta Reservas");

        btnConsultarDNI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/consultarReserva.png"))); // NOI18N
        btnConsultarDNI.setText("Consultar");
        btnConsultarDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarDNIActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/DNI.png"))); // NOI18N
        jLabel1.setText("Consultar Reserva - DNI:");

        TablaConsulta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Reserva", "DNI - RUC - Cliente", "Nombre Cliente", "N° Habitación", "Tipo", "Total", "Trabajador", "Fecha Reserva", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TablaConsulta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnConsultarDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarDNI))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConsultarDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarDNIActionPerformed
        
    }//GEN-LAST:event_btnConsultarDNIActionPerformed

    public void listarReservas(JTable tabla) {
        modeloReserva = (DefaultTableModel) tabla.getModel();
        List<ReservaInfo> listaReservaInformacion = daoReserva.listarReservas();
        Object[] object = new Object[9];

        for (int i = 0; i < listaReservaInformacion.size(); i++) {
            object[0] = listaReservaInformacion.get(i).getIdReserva();

            int idCliente = listaReservaInformacion.get(i).getIdCliente();
            String dniCliente = daoReserva.obtenerDniClientePorId(idCliente);
            object[1] = dniCliente;
            String nombreCliente = daoReserva.obtenerNombreClientePorId(idCliente);
            object[2] = nombreCliente;

            int idHabitacion = listaReservaInformacion.get(i).getIdHabitacion();
            String numeroHabitacion = daoReserva.obtenerNumeroHabitacionPorId(idHabitacion);
            object[3] = numeroHabitacion;
            String tipoHabitacion = daoReserva.obtenerTipoHabitacion(idHabitacion);
            object[4] = tipoHabitacion;

            object[5] = listaReservaInformacion.get(i).getTotal();

            int idTrabajador = listaReservaInformacion.get(i).getIdTrabajador();
            String nombreTrabajador = daoReserva.obtenerNombreTrabajadorPorId(idTrabajador);
            object[6] = nombreTrabajador;

            object[7] = listaReservaInformacion.get(i).getFechaReserva();

            String estadoHabitacion = listaReservaInformacion.get(i).getEstadoHabitacion();
            object[8] = estadoHabitacion;

            modeloReserva.addRow(object);
        }
        TablaConsulta.setModel(modeloReserva);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaConsulta;
    private javax.swing.JButton btnConsultarDNI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDniCliente;
    // End of variables declaration//GEN-END:variables
}
