package View;

import Paneles.MostrarReservas;
import Paneles.PanelHabitacion;
import Paneles.PanelReservas;
import PanelesRegistros.RegistroTrabajador;

public class DashboardSistema extends javax.swing.JFrame {

    private String nombreTrabajador = null;
    private String cargoTrabajador = null;
    
    public DashboardSistema() {
        initComponents();
        this.setExtendedState(DashboardSistema.MAXIMIZED_BOTH);
        this.setTitle("Sistema De Reserva - Joneya Hotel 3 Estrellas");
    }
    
    public void getNombreusuario(String cargoTrabajador, String nombreTrabajador) {
        this.cargoTrabajador = cargoTrabajador;
        this.nombreTrabajador = nombreTrabajador;
        /*Seteamos el nombre del trabajador*/
        lblnombreTrabajador.setText(nombreTrabajador);
        lblCargoTrabajador.setText(cargoTrabajador);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Escritorio = new javax.swing.JDesktopPane();
        lblnombreTrabajador = new javax.swing.JLabel();
        lblCargoTrabajador = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        menuInformacion = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        menuConsultas = new javax.swing.JMenu();
        contentMenuItem = new javax.swing.JMenuItem();
        menuReservas = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuAdministrador = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menuSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Escritorio.setToolTipText("");
        Escritorio.add(lblnombreTrabajador);
        lblnombreTrabajador.setBounds(10, 20, 200, 0);
        Escritorio.add(lblCargoTrabajador);
        lblCargoTrabajador.setBounds(10, 50, 230, 0);

        fileMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/inicio.png"))); // NOI18N
        fileMenu.setMnemonic('f');
        fileMenu.setText("InicioJoneya");
        menuBar.add(fileMenu);

        menuInformacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/informacion.png"))); // NOI18N
        menuInformacion.setMnemonic('e');
        menuInformacion.setText("Información");

        cutMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cutMenuItem.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        cutMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/habitacion.png"))); // NOI18N
        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Registrar Habitacion");
        cutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutMenuItemActionPerformed(evt);
            }
        });
        menuInformacion.add(cutMenuItem);

        menuBar.add(menuInformacion);

        menuConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/consulta.png"))); // NOI18N
        menuConsultas.setMnemonic('h');
        menuConsultas.setText("Consultas");

        contentMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        contentMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/consultar reserva.png"))); // NOI18N
        contentMenuItem.setMnemonic('c');
        contentMenuItem.setText("Consultar Reservas");
        contentMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contentMenuItemActionPerformed(evt);
            }
        });
        menuConsultas.add(contentMenuItem);

        menuBar.add(menuConsultas);

        menuReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/recepcion.png"))); // NOI18N
        menuReservas.setText("Realizar Reservas");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/reserva.png"))); // NOI18N
        jMenuItem3.setText("Reservar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuReservas.add(jMenuItem3);

        menuBar.add(menuReservas);

        menuAdministrador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/administrador.png"))); // NOI18N
        menuAdministrador.setText("Administrador");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/Registrar Trabajador.png"))); // NOI18N
        jMenuItem1.setText("Registro Trabajadores y Usuarios");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuAdministrador.add(jMenuItem1);

        menuBar.add(menuAdministrador);

        menuSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImageMenu/Salir.png"))); // NOI18N
        menuSalir.setText("Salir");
        menuBar.add(menuSalir);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutMenuItemActionPerformed
        PanelHabitacion registroHabitacion = new PanelHabitacion();
        Escritorio.add(registroHabitacion);
        registroHabitacion.setVisible(true);
        registroHabitacion.toFront();
    }//GEN-LAST:event_cutMenuItemActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        PanelReservas reservaPanel = new PanelReservas();
        Escritorio.add(reservaPanel);
        reservaPanel.setVisible(true);
        reservaPanel.toFront();
        PanelReservas.txtNombreTrabajador.setText(lblnombreTrabajador.getText());
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void contentMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contentMenuItemActionPerformed
        MostrarReservas ConsultaPanel= new MostrarReservas();
        Escritorio.add(ConsultaPanel);
        ConsultaPanel.setVisible(true);
        ConsultaPanel.toFront();
    }//GEN-LAST:event_contentMenuItemActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        RegistroTrabajador trabajadorPamel= new RegistroTrabajador();
        Escritorio.add(trabajadorPamel);
        trabajadorPamel.setVisible(true);
        trabajadorPamel.toFront();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DashboardSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardSistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardSistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JMenuItem contentMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JLabel lblCargoTrabajador;
    private javax.swing.JLabel lblnombreTrabajador;
    public javax.swing.JMenu menuAdministrador;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuConsultas;
    public javax.swing.JMenu menuInformacion;
    public javax.swing.JMenu menuReservas;
    private javax.swing.JMenu menuSalir;
    // End of variables declaration//GEN-END:variables

}
