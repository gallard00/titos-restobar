
package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class FormIndex extends javax.swing.JFrame {
    
    private JFrame ventanaActual;
    public FormIndex() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnMesas = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("TITO´S RESTOBAR");

        btnMesas.setText("MESAS");
        btnMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMesasActionPerformed(evt);
            }
        });

        btnProductos.setText("PRODUCTOS");
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnProductos))
                    .addComponent(jLabel1))
                .addContainerGap(196, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(95, 95, 95)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                    .addComponent(btnMesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMesasActionPerformed
        try {
            // Comprueba si hay una ventana previa abierta y la cierra si es el caso
            if (ventanaActual != null) {
                ventanaActual.dispose();// Cierra el formulario actual si existe uno abierto
            }
            // Crea una nueva instancia de FormMesa
            FormMesa formMesa = new FormMesa();
            // Añade un WindowListener para la ventana formMesa
            formMesa.addWindowListener(new WindowAdapter() {
                @Override
                // Define un método (cerrarVentana) que se espera que maneje el cierre de la ventana
                public void windowClosed(WindowEvent e) {
                    // Acciones a realizar cuando se cierra FormMesa
                    setVisible(true); // Vuelve a mostrar el FormIndex al cerrar FormMesa
                }
            });
            // Muestra la ventana formMesa
            formMesa.setVisible(true);
            // Actualiza la referencia de ventana actual (ventanaActualProd) a formMesa
            ventanaActual = formMesa;
            // Oculta el FormIndex al abrir FormMesa
            this.setVisible(false);
        } catch (SQLException ex) {
            // Captura cualquier excepción SQLException que ocurra durante este proceso
            Logger.getLogger(FormIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMesasActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        try {
            // Comprueba si hay una ventana previa abierta y la cierra si es el caso
            if (ventanaActual != null) {
                ventanaActual.dispose();// Cierra el formulario actual si existe uno abierto
            }
            // Crea una nueva instancia de FormProducto
            FormProducto formProducto = new FormProducto();
            // Añade un WindowListener para la ventana formProducto
            formProducto.addWindowListener(new WindowAdapter(){
            @Override
            // Define un método (cerrarVentana) que se espera que maneje el cierre de la ventana
               public void windowClosed(WindowEvent e) {
                   // Acciones a realizar cuando se cierra FormProducto
                   setVisible(true);// Vuelve a mostrar el FormIndex al cerrar FormProducto
               }
            });
            // Muestra la ventana formProducto
            formProducto.setVisible(true);
            // Actualiza la referencia de ventana actual (ventanaActual) a formProducto
            ventanaActual = formProducto;
            // Oculta el FormIndex al abrir FormProducto
            this.setVisible(false);
            ventanaActual.toFront();
            ventanaActual.requestFocus();
        } catch (SQLException ex) {
            // Captura cualquier excepción SQLException que ocurra durante este proceso
            Logger.getLogger(FormIndex.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnProductosActionPerformed

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
            java.util.logging.Logger.getLogger(FormIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormIndex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormIndex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMesas;
    private javax.swing.JButton btnProductos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
