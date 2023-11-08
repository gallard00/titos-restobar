package View;

import Controlador.ProductoController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class FormProducto extends javax.swing.JFrame {
    
    ProductoController ProductoControladora;
    
    public FormProducto() throws SQLException {
        ProductoControladora = ProductoController.GetInstance();
        initComponents();
    }

    private boolean validarDatos() {
        {
            try {
                if (txtNombreProducto.getText().equals("") || txtDescripcion.getText().equals("") || txtCosto.getText().equals("")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                 JOptionPane.showMessageDialog(null, "Nombre, Descripción y Costo no pueden estar vacios, Reingrese:");
                return false;
            }
            try{
                if(!chkBox.isSelected()){
                    int spnValue = (int) spnCantidadProducto.getValue();
                    if(spnValue < 1){
                        throw new Exception();
                    }
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "El valor de la cantidad debe ser igual o mayor 1:" );
                return false;
            }
        }
        return true;
    }
    public void ResetTablaProducto() {
        DefaultTableModel modelo = new DefaultTableModel();
  
        List<? extends Object> ListaProducto = ProductoControladora.PedirListaProducto();
        ArrayList<Object> nombrecolumna = new ArrayList<>();
        nombrecolumna.add("ID");
        nombrecolumna.add("Nombre");
        nombrecolumna.add("Descripcion");
        nombrecolumna.add("Costo");
        nombrecolumna.add("Cantidad");
        nombrecolumna.forEach(columna -> {
            modelo.addColumn(columna);
        });
        
        for(int i = 0; i<ListaProducto.size();i++)
        {
             modelo.addRow(ProductoControladora.RequestTableRow(i));
        }
        datosTablaProducto.setModel(modelo);
        datosTablaProducto.setCellSelectionEnabled(false);
        datosTablaProducto.setRowSelectionAllowed(true);
    } //Datos de la Tabla, valores iniciales.
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSpinner1 = new javax.swing.JSpinner();
        btnGuardar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNombreProducto = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCosto = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        chkBox = new javax.swing.JCheckBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        datosTablaProducto = new javax.swing.JTable();
        spnCantidadProducto = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);

        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("PRODUCTOS");

        jLabel2.setText("ELABORADO / NO ELABORADO");

        jLabel3.setText("NOMBRE: ");

        jLabel4.setText("DESCRIPCIÓN: ");

        jScrollPane2.setViewportView(txtNombreProducto);

        jScrollPane3.setViewportView(txtDescripcion);

        jScrollPane4.setViewportView(txtCosto);

        jLabel5.setText("COSTO:");

        jLabel7.setText("CANTIDAD:");

        chkBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkBoxActionPerformed(evt);
            }
        });

        datosTablaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Costo", "Cantidad"
            }
        ));
        jScrollPane6.setViewportView(datosTablaProducto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnGuardar)
                            .addGap(89, 89, 89)
                            .addComponent(btnBorrar)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(spnCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(chkBox))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(chkBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnBorrar))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 76, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if(evt.getSource() == btnGuardar){
            if (validarDatos()== false) {
            }else{
                int filaSeleccionada = seleccionarFila();
                String nombre = txtNombreProducto.getText();
                String descripcion = txtDescripcion.getText();
                float costo = Float.parseFloat(txtCosto.getText());
                
                
                
                if (filaSeleccionada >=0) {
                    int id = (int) datosTablaProducto.getModel().getValueAt(filaSeleccionada, 0);
                    if (!ProductoControladora.SiProductoExiste(nombre, descripcion)) {
                        if (ProductoControladora.ActualizarProducto(id, nombre, descripcion, costo)) {
                           JOptionPane.showMessageDialog(null, "Producto Modificado");
                       } 
                   }else{
                        JOptionPane.showMessageDialog(null, "Ya existe un producto con el mismo nombre y descripción");
                    }
                }else{
                    if (!ProductoControladora.SiProductoExiste(nombre, descripcion)) {
                        if(ProductoControladora.CrearProducto(nombre, descripcion, costo)){
                        JOptionPane.showMessageDialog(null, "Producto Guardado");
                        }
                    }else{
                       JOptionPane.showMessageDialog(null, "Ya existe un producto con el mismo nombre y descripción");
                    }
            }
            this.ResetTablaProducto();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    }
    
    private int seleccionarFila(){
        int i = datosTablaProducto.getSelectedRow();
        
        if(i > -1)
        {
            return i;
        }
        return -1;
    }
     
     
    private void chkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxActionPerformed
        if(!evt.equals(chkBox.isSelected())){
            spnCantidadProducto.setEnabled(true);
        }else{
            spnCantidadProducto.setEnabled(false);
        }
    }//GEN-LAST:event_chkBoxActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (evt.getSource() == btnBorrar) {
        int filaSeleccionada = seleccionarFila();
        if (filaSeleccionada >= 0) {
            int id = (int) datosTablaProducto.getModel().getValueAt(filaSeleccionada, 0);
            ProductoControladora.BorrarProducto(id);
            ResetTablaProducto(); // Actualizar la tabla después de eliminar
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
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
            java.util.logging.Logger.getLogger(FormProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormProducto().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JCheckBox chkBox;
    private javax.swing.JTable datosTablaProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner spnCantidadProducto;
    private javax.swing.JTextPane txtCosto;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextPane txtNombreProducto;
    // End of variables declaration//GEN-END:variables

    
    public void AgregarFila(int id) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) datosTablaProducto.getModel();
        modelo.addRow(ProductoControladora.RequestObjectIndex(id));
        datosTablaProducto.setModel(modelo);
    }

    
    public void EliminarFila(int id) {
        int columna = 0;
        String IDString = String.valueOf(id);
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) datosTablaProducto.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            
            if (modelo.getValueAt(i, columna).toString().equals(IDString)) {
                modelo.removeRow(i);
            }
        }
        datosTablaProducto.setModel(modelo);
    }

    public void ModificarFila(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }



}
