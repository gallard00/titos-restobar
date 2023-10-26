
package View;

import Controlador.MesaController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormMesa extends javax.swing.JFrame implements ITableFilas {

    MesaController MesaControladora;
    
    public FormMesa() throws SQLException {
        MesaControladora = MesaController.GetInstance();
        initComponents();
        
    }
    
    private boolean validarDatos() {
        {
            try {
                if (txtNombreMesa.getText().equals("")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Ningun campo puede estar vacio, Reingrese:");
                return false;
            }
            
            try {
                if(Integer.parseInt(txtNombreMesa.getText())<0)
                {
                    throw new Exception();
                }
            } catch(Exception e) {
                 JOptionPane.showMessageDialog(null, "Campo [Nombre] no puede contener numeros negativos");
                return false;
            }

        }
        return true;
    }
    
    @Override
    public String toString() {
        return "NombreMesa{" + ", NombreMesa=" + txtNombreMesa.getText()+ '}';
    }
    
    public void ResetTableMesa() {
        List<? extends Object> ListaMesa = MesaControladora.PedirListaMesas();

        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<Object> columnas = new ArrayList<>();
        columnas.add("ID");
        columnas.add("Nombre");
        columnas.forEach(columna -> {
            modelo.addColumn(columna);
        });

        for(int i = 0; i<ListaMesa.size();i++)
        {
            modelo.addRow(MesaControladora.RequestTableRow(i));
        }

        DataTableMesa.setModel(modelo);
        DataTableMesa.setCellSelectionEnabled(false);
        DataTableMesa.setRowSelectionAllowed(true);
    } //DataTable valores iniciales

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBorrar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNombreMesa = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DataTableMesa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre de la mesa:");

        jScrollPane2.setViewportView(txtNombreMesa);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("MESAS");

        jLabel3.setText("Lista de mesas");

        DataTableMesa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        DataTableMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DataTableMesaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(DataTableMesa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(2, 2, 2)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnGuardar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnBorrar)))
                            .addGap(216, 216, 216))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(468, 468, 468)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnBorrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (evt.getSource() == btnGuardar) {
            System.out.print("Guardado");
            if (validarDatos() == false) {
                System.out.print("\n" + "Error");
            } else {
                JOptionPane.showMessageDialog(null, "NombreMesa Guardado");
                int id = MesaControladora.CrearMesa(txtNombreMesa.getText());
                AgregarFila(id);
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void DataTableMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DataTableMesaMouseClicked
       int i = DataTableMesa.getSelectedRow();
        String nombre = (String) DataTableMesa.getModel().getValueAt(i, 1);
        txtNombreMesa.setText(nombre); //nombre
    }//GEN-LAST:event_DataTableMesaMouseClicked

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
         if (evt.getSource() == btnBorrar) {
            System.out.print("Eliminado");
            if (validarDatos() == false) {
                System.out.print("\n" + "Error");
            } else {
                JOptionPane.showMessageDialog(null, "NombreMesa Eliminado");
                int idMesa = Integer.parseInt(DataTableMesa.getValueAt(DataTableMesa.getSelectedRow(), 0).toString()); //ID de Vehiculo a Borrar
                MesaControladora.DeleteMesa(idMesa);
                EliminarFila(idMesa);
            }
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(FormMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormMesa().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormMesa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DataTableMesa;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextPane txtNombreMesa;
    // End of variables declaration//GEN-END:variables

    @Override
    public void AgregarFila(int id) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) DataTableMesa.getModel();
       //int ultimafila = (int) DataTableTipoVehiculo.getModel().getRowCount() - 1; //Seleccionar ultima fila del datatable ID
        //int idsuma = (int) DataTableTipoVehiculo.getModel().getValueAt(ultimafila, 0);
        modelo.addRow(MesaControladora.RequestObjectIndex(id));
        DataTableMesa.setModel(modelo);
    }

    @Override
    public void ModificarFila(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void EliminarFila(int id) {
        int columna = 0;
        String IDString = String.valueOf(id);
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) DataTableMesa.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            
            if (modelo.getValueAt(i, columna).toString().equals(IDString)) {
                modelo.removeRow(i);
            }
        }
        DataTableMesa.setModel(modelo);
    }
}
