package View;

import Controlador.PrecioController;
import Controlador.ProductoController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class FormProducto extends javax.swing.JFrame {

    ProductoController ProductoControladora;
    PrecioController PrecioControladora;

    public FormProducto() throws SQLException {
        ProductoControladora = ProductoController.GetInstance();
        PrecioControladora = PrecioController.GetInstance();
        initComponents();
        verificarListaProductos();
    }

    public void verificarListaProductos() //Verifica si la lista de mesas tiene algo
    {
        if (!ProductoControladora.PedirListaProducto().isEmpty()) {
            reiniciarTablaProducto();
        }
    }

    private boolean validarDatos() {
        {
            try {
                if (txtNombreProducto.getText().equals("") || txtDescripcion.getText().equals("") || txtCosto.getText().equals("") || txtPorcentajeAumento.getText().equals("")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nombre, descripción, costo y aumento no pueden estar vacios. Reingrese:");
                return false;
            }
            try {
                if (!chkBox.isSelected()) {
                    int spnValor = (int) spnCantidadProducto.getValue();
                    if (spnValor < 1) {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "El valor de la cantidad debe ser igual o mayor 1:");
                return false;
            }
        }
        return true;
    }

    public void reiniciarTablaProducto() {
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

        for (int i = 0; i < ListaProducto.size(); i++) {
            modelo.addRow(ProductoControladora.RequestTableRow(i));
        }
        datosTablaProducto.setModel(modelo);
        datosTablaProducto.setCellSelectionEnabled(false);
        datosTablaProducto.setRowSelectionAllowed(true);
    } //Datos de la Tabla, valores iniciales.

    private int seleccionarFila() {
        int i = datosTablaProducto.getSelectedRow();

        if (i > -1) {
            return i;
        }
        return -1;
    }

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
        btnVolver = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPorcentajeAumento = new javax.swing.JTextPane();

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

        jLabel2.setText("ELABORADO");

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
        datosTablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosTablaProductoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(datosTablaProducto);

        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel6.setText("AUMENTO:");

        jScrollPane1.setViewportView(txtPorcentajeAumento);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnGuardar)
                                    .addGap(89, 89, 89)
                                    .addComponent(btnBorrar))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(spnCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(chkBox))
                                            .addGap(74, 74, 74))
                                        .addComponent(jScrollPane1))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 76, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnVolver))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkBox)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spnCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnBorrar))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (evt.getSource() == btnGuardar) {
            if (validarDatos() == false) {
            } else {
                int filaSeleccionada = seleccionarFila();
                String nombre = txtNombreProducto.getText();
                String descripcion = txtDescripcion.getText();
                float costo = Float.parseFloat(txtCosto.getText());
                float porcentajeAumento = Float.parseFloat(txtPorcentajeAumento.getText());

                if (filaSeleccionada >= 0) {
                    int idProducto = (int) datosTablaProducto.getModel().getValueAt(filaSeleccionada, 0);
                    if (!ProductoControladora.SiProductoExiste(nombre, descripcion, costo)) {
                        if (ProductoControladora.ActualizarProducto(idProducto, nombre, descripcion, costo)) {
                            JOptionPane.showMessageDialog(null, "Producto Modificado");
                            crearActualizarPrecio(idProducto, costo, porcentajeAumento);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya existe un producto con el mismo nombre y descripción");
                    }
                } else {
                    if (!ProductoControladora.SiProductoExiste(nombre, descripcion, costo)) {
                        if (ProductoControladora.SiProductoExiste(nombre, descripcion, costo)) {
                            JOptionPane.showMessageDialog(null, "Producto Guardado");
                            // Crea un nuevo precio al guardar un nuevo producto
                            int idProductoNuevo = ProductoControladora.obtenerUltimoIDProducto();
                            crearActualizarPrecio(idProductoNuevo, costo, porcentajeAumento);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya existe un producto con el mismo nombre y descripción");
                    }
                }
                this.reiniciarTablaProducto();
    }//GEN-LAST:event_btnGuardarActionPerformed
        }
    }

    private void crearActualizarPrecio(int idProducto, float costo, float porcentajeAumento) {
        // Llama al método correspondiente en tu PrecioController para crear o actualizar el precio
        int idPrecio = PrecioControladora.obtenerIdPrecioPorProducto(idProducto);
        if (idPrecio != -1) {
            // Si existe un precio, actualiza los datos
            PrecioControladora.ActualizarPrecio(idPrecio, idProducto, calcularPrecio(costo, porcentajeAumento));
        } else {
            // Si no existe un precio, crea uno nuevo
            PrecioControladora.CrearPrecio(idProducto, calcularPrecio(costo, porcentajeAumento));
        }

    }

    private float calcularPrecio(float costo, float porcentajeAumento) {
        // Implementa tu lógica para calcular el precio
        // Puedes hacer algo como esto (ajústalo según tus necesidades):
        return costo + (costo * (porcentajeAumento / 100));
    }
    
    private void chkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxActionPerformed
        if (!evt.equals(chkBox.isSelected())) {
            spnCantidadProducto.setEnabled(true);
        } else {
            spnCantidadProducto.setEnabled(false);
        }
    }//GEN-LAST:event_chkBoxActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (evt.getSource() == btnBorrar) {
            int filaSeleccionada = seleccionarFila();
            if (filaSeleccionada >= 0) {
                int id = (int) datosTablaProducto.getModel().getValueAt(filaSeleccionada, 0);
                ProductoControladora.BorrarProducto(id);
                reiniciarTablaProducto();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar el producto");
            }
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void datosTablaProductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datosTablaProductoMouseClicked
        int i = datosTablaProducto.getSelectedRow();
        String nombre = (String) datosTablaProducto.getModel().getValueAt(i, 1);
        String descripcion = (String) datosTablaProducto.getModel().getValueAt(i, 2);
        Float costo = (Float) datosTablaProducto.getModel().getValueAt(i, 3);
        String costoStr = String.valueOf(costo);

        txtNombreProducto.setText(nombre);
        txtDescripcion.setText(descripcion);
        txtCosto.setText(String.valueOf(costoStr));
    }//GEN-LAST:event_datosTablaProductoMouseClicked

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
        FormIndex formIndex = new FormIndex();
        formIndex.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

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
    private javax.swing.JButton btnVolver;
    private javax.swing.JCheckBox chkBox;
    private javax.swing.JTable datosTablaProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner spnCantidadProducto;
    private javax.swing.JTextPane txtCosto;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextPane txtNombreProducto;
    private javax.swing.JTextPane txtPorcentajeAumento;
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
