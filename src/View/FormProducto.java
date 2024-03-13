package View;

import Controlador.PrecioController;
import Controlador.ProductoController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Formulario para mostrar la lista de productos disponibles y gestionar su
 * información. Se encarga de mostrar la lista de productos en una tabla y
 * proporciona opciones para interactuar con ellos. También permite agregar
 * nuevos productos, editar los existentes y eliminarlos. Además, muestra los
 * precios asociados a los productos.
 *
 * @throws SQLException Si ocurre un error al acceder a la base de datos.
 */
public class FormProducto extends javax.swing.JFrame {

    // Lista para almacenar los IDs de los productos
    private List<Integer> listaIdProducto = new ArrayList<>();
    // Controlador para gestionar la información de los productos
    ProductoController ProductoControladora;
    // Controlador para gestionar los precios de los productos
    PrecioController PrecioControladora;

    /**
     * Constructor de la clase. Inicializa los controladores de productos y
     * precios. Inicializa los componentes visuales del formulario. Verifica si
     * hay productos disponibles para mostrar en la tabla.
     *
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    public FormProducto() throws SQLException {
        ProductoControladora = ProductoController.GetInstance();
        PrecioControladora = PrecioController.GetInstance();
        initComponents();
        verificarListaProductos();
    }

    /**
     * Verifica si hay productos disponibles para mostrar en la tabla. Si hay
     * productos, se reinicia la tabla para mostrar la lista actualizada.
     */
    public void verificarListaProductos() {
        if (!ProductoControladora.PedirListaProducto().isEmpty()) {
            reiniciarTablaProducto();
        }
    }

    /**
     * Valida los datos ingresados en los campos del formulario. Verifica que
     * los campos de nombre, descripción, costo y aumento no estén vacíos.
     * También verifica que el valor de la cantidad sea igual o mayor a 1 si el
     * checkbox no está seleccionado.
     *
     * @return true si los datos son válidos, false si hay algún error en la
     * validación.
     */
    private boolean validarDatos() {
        {
            try {
                // Verifica que los campos obligatorios no estén vacíos
                if (txtNombreProducto.getText().equals("") || txtDescripcion.getText().equals("") || txtCosto.getText().equals("") || txtPorcentajeAumento.getText().equals("")) {
                    throw new Exception();
                }
            } catch (Exception e) {
                // Muestra un mensaje de error si algún campo obligatorio está vacío
                JOptionPane.showMessageDialog(null, "Nombre, descripción, costo y aumento no pueden estar vacios. Reingrese:");
                return false;
            }
            try {
                // Verifica que el valor de la cantidad sea igual o mayor a 1 si el checkbox no está seleccionado
                if (!chkBox.isSelected()) {
                    int spnValor = (int) spnCantidadProducto.getValue();
                    if (spnValor < 1) {
                        throw new Exception();
                    }
                }
            } catch (Exception e) {
                // Muestra un mensaje de error si el valor de la cantidad es menor a 1
                JOptionPane.showMessageDialog(null, "El valor de la cantidad debe ser igual o mayor 1:");
                return false;
            }
        }
        return true;
    }

    /**
     * Reinicia la tabla de productos con los datos actualizados de la lista de
     * productos. Obtiene la lista completa de productos y actualiza la tabla
     * con los datos correspondientes.
     */
    public void reiniciarTablaProducto() {
        // Crea un nuevo modelo de tabla
        DefaultTableModel modeloProducto = new DefaultTableModel();
        // Obtiene la lista completa de productos
        List<? extends Object> ListaProducto = ProductoControladora.pedirListaProductoCompleto();
        // Agrega las columnas al modelo de la tabla
        modeloProducto.addColumn("Id");
        modeloProducto.addColumn("Nombre");
        modeloProducto.addColumn("Descripcion");
        modeloProducto.addColumn("Costo");
        modeloProducto.addColumn("Precio");
        modeloProducto.addColumn("Cantidad");
        // Itera sobre la lista de productos para agregar cada fila a la tabla
        for (int i = 0; i < ListaProducto.size(); i++) {
            Object[] rowData = ProductoControladora.RequestTableRow(i);
            modeloProducto.addRow(rowData);
        }
        // Establece el modelo de tabla actualizado en la tabla de productos
        datosTablaProducto.setModel(modeloProducto);
        datosTablaProducto.setCellSelectionEnabled(false);
        datosTablaProducto.setRowSelectionAllowed(true);
    }

    /**
     * Obtiene el índice de la fila seleccionada en la tabla de productos.
     *
     * @return El índice de la fila seleccionada. Devuelve -1 si no hay ninguna
     * fila seleccionada.
     */
    private int seleccionarFila() {
        // Obtiene el índice de la fila seleccionada
        int i = datosTablaProducto.getSelectedRow();
        // Verifica si se ha seleccionado una fila válida
        if (i > -1) {
            return i;
        }
        // Devuelve -1 si no hay ninguna fila seleccionada
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
                "Nombre", "Descripcion", "Costo", "Precio", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        datosTablaProducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datosTablaProductoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(datosTablaProducto);
        if (datosTablaProducto.getColumnModel().getColumnCount() > 0) {
            datosTablaProducto.getColumnModel().getColumn(2).setMinWidth(80);
            datosTablaProducto.getColumnModel().getColumn(2).setPreferredWidth(80);
            datosTablaProducto.getColumnModel().getColumn(2).setMaxWidth(80);
        }

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
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spnCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(chkBox)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar)
                                .addGap(89, 89, 89)
                                .addComponent(btnBorrar))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(btnVolver)))
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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chkBox)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnCantidadProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar)
                            .addComponent(btnBorrar))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Maneja el evento de clic en el botón "Guardar". Valida los datos
     * ingresados y guarda el producto en la base de datos si son válidos.
     *
     * @param evt El evento que desencadena esta acción.
     */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (evt.getSource() == btnGuardar) {
            // Verifica si los datos ingresados son válidos
            if (validarDatos() == false) {
                // No hace nada si los datos no son válidos
            } else {
                // Obtiene la fila seleccionada en la tabla de productos
                int filaSeleccionada = seleccionarFila();
                String nombre = txtNombreProducto.getText();
                String descripcion = txtDescripcion.getText();
                float costo = Float.parseFloat(txtCosto.getText());
                float porcentajeAumento = Float.parseFloat(txtPorcentajeAumento.getText());
                int stock = (int) spnCantidadProducto.getValue();
                // Verifica si se ha seleccionado una fila en la tabla
                if (filaSeleccionada >= 0) {
                    // Obtiene el ID del producto seleccionado y su cantidad actual en stock
                    int idProducto = (int) datosTablaProducto.getModel().getValueAt(filaSeleccionada, 0);
                    int cantidadActual = (int) datosTablaProducto.getModel().getValueAt(filaSeleccionada, 5);
                    int nuevaCantidad = cantidadActual + stock;
                    // Actualiza la cantidad de productos no elaborados en stock
                    ProductoControladora.actualizarProductoNoElaborado(idProducto, nuevaCantidad);
                    // Verifica si el producto ya existe en la base de datos y lo actualiza
                    if (!ProductoControladora.SiProductoExiste(nombre, descripcion, costo)) {
                        if (ProductoControladora.ActualizarProducto(idProducto, nombre, descripcion, costo)) {
                            JOptionPane.showMessageDialog(null, "Producto Modificado");
                            // Crea o actualiza el precio del producto
                            PrecioControladora.crearActualizarPrecio(idProducto, costo, porcentajeAumento);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya existe un producto con el mismo nombre y descripción. Solo se sumo la nueva cantidad. ");
                    }
                } else {
                    // Verifica si el producto ya existe en la base de datos y lo crea
                    if (!ProductoControladora.SiProductoExiste(nombre, descripcion, costo)) {
                        if (ProductoControladora.CrearProducto(nombre, descripcion, costo)) {
                            // Obtiene el ID del nuevo producto
                            int idProductoNuevo = ProductoControladora.obtenerUltimoIDProducto();
                            // Crea o actualiza el precio del producto
                            PrecioControladora.crearActualizarPrecio(idProductoNuevo, costo, porcentajeAumento);
                            // Verifica si el producto es elaborado o no y lo guarda en la base de datos
                            if (!chkBox.isSelected()) {
                                ProductoControladora.crearProductoNoElaborado(idProductoNuevo, stock);
                                JOptionPane.showMessageDialog(null, "Producto no Elaborado Guardado");
                            } else {
                                JOptionPane.showMessageDialog(null, "Producto Guardado");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Ya existe un producto con el mismo nombre y descripción");
                    }
                }
                // Actualiza la tabla de productos
                this.reiniciarTablaProducto();
    }//GEN-LAST:event_btnGuardarActionPerformed
        }
    }

    /**
     * Maneja el evento de clic en el CheckBox "chkBox". Habilita o deshabilita
     * el spinner de cantidad dependiendo del estado del CheckBox.
     *
     * @param evt El evento que desencadena esta acción.
     */
    private void chkBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkBoxActionPerformed
        if (!evt.equals(chkBox.isSelected())) {
            // Habilita el spinner de cantidad si el CheckBox está seleccionado
            spnCantidadProducto.setEnabled(true);
        } else {
            // Deshabilita el spinner de cantidad si el CheckBox no está seleccionado
            spnCantidadProducto.setEnabled(false);
        }
    }//GEN-LAST:event_chkBoxActionPerformed
    /**
     * Maneja el evento de clic en el botón "btnBorrar". Borra un producto
     * seleccionado de la tabla de productos.
     *
     * @param evt El evento que desencadena esta acción.
     */
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (evt.getSource() == btnBorrar) {
            int filaSeleccionada = seleccionarFila();
            if (filaSeleccionada >= 0) {
                int idProducto = (int) datosTablaProducto.getModel().getValueAt(filaSeleccionada, 0);
                try {
                    int stock = (int) datosTablaProducto.getModel().getValueAt(filaSeleccionada, 5);
                    if (stock > 0) {
                        // Borra el producto no elaborado si tiene stock
                        ProductoControladora.borrarProductoNoElaborado(idProducto);
                    } else {
                        // Borra el producto
                        ProductoControladora.BorrarProducto(idProducto);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FormProducto.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        txtNombreProducto.setText(nombre);
        txtDescripcion.setText(descripcion);
        txtCosto.setText(String.valueOf(costo));

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

    public void agregarFila(int id) {
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) datosTablaProducto.getModel();
        modelo.addRow(ProductoControladora.RequestObjectIndex(id));
        datosTablaProducto.setModel(modelo);
    }

    public void eliminarFila(int id) {
        int columna = 0;
        String IDString = String.valueOf(id);
        javax.swing.table.DefaultTableModel modelo = (javax.swing.table.DefaultTableModel) datosTablaProducto.getModel();
        for (int i = 0; i < modelo.getRowCount(); i++) {
            if (modelo.getValueAt(i, columna).toString().equals(IDString)) {
                modelo.removeRow(i);
                break;
            }
        }
        datosTablaProducto.setModel(modelo);
    }

}
