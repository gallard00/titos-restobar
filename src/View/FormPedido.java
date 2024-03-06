package View;

import Controlador.ItemController;
import Controlador.PedidoController;
import Controlador.ProductoController;
import Modelo.ItemsDTO;
import Modelo.ProductoCompletoDTO;
import Modelo.ProductoDTO;
import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class FormPedido extends javax.swing.JFrame {

    PedidoController controladoraPedido;
    ProductoController controladoraProducto;
    ItemController controladoraItems;
    Object productoSeleccionado;
    private String nombreMesa;
    private int idMesa;

    /**
     * Creates new form FormPedido
     *
     * @throws java.sql.SQLException
     */
    public FormPedido() throws SQLException {
        controladoraPedido = PedidoController.GetInstance();
        controladoraProducto = ProductoController.GetInstance();
        controladoraItems = ItemController.GetInstance();
        initComponents();
    }

    public FormPedido(String nombreMesa, int idMesa) throws SQLException {
        this.nombreMesa = nombreMesa;
        this.idMesa = idMesa;
        controladoraPedido = PedidoController.GetInstance();
        controladoraProducto = ProductoController.GetInstance();
        controladoraItems = ItemController.GetInstance();
        initComponents();
        PoblarComboBoxProductos();
        verificarListaItems();
    }

    public void verificarListaItems() //Verifica si la lista de productos tiene algo
    {
        if (!controladoraItems.PedirListaItems().isEmpty()) {
            actualizarTablaPedido();
        }
    }

    public void PoblarComboBoxProductos() {
        List<ProductoCompletoDTO> listaProductos = controladoraProducto.pedirListaProductoCompleto();
        List<String> nombresYDescripciones = new ArrayList<>();

        for (ProductoCompletoDTO producto : listaProductos) {
            // Concatenamos el nombre y la descripción para mostrar en el ComboBox
            String nombreYDescripcion = producto.getNombre() + " - " + producto.getDescripcion();
            nombresYDescripciones.add(nombreYDescripcion);
        }

        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(nombresYDescripciones.toArray(new String[0]));
        jComboBoxProductos.setModel(comboBoxModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAsignarItemAPedido = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxProductos = new javax.swing.JComboBox();
        jSpinnerCantidad = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        datosTablaPedido = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAsignarItemAPedido.setText("AGREGAR");
        btnAsignarItemAPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarItemAPedidoActionPerformed(evt);
            }
        });

        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("PEDIDO ");

        jComboBoxProductos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxProductosItemStateChanged(evt);
            }
        });

        jLabel2.setText("Producto :");

        jLabel3.setText("Cantidad :");

        datosTablaPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Precio", "Cantidad", "Costo Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(datosTablaPedido);
        if (datosTablaPedido.getColumnModel().getColumnCount() > 0) {
            datosTablaPedido.getColumnModel().getColumn(0).setResizable(false);
            datosTablaPedido.getColumnModel().getColumn(0).setPreferredWidth(110);
            datosTablaPedido.getColumnModel().getColumn(1).setResizable(false);
            datosTablaPedido.getColumnModel().getColumn(1).setPreferredWidth(110);
            datosTablaPedido.getColumnModel().getColumn(2).setPreferredWidth(60);
            datosTablaPedido.getColumnModel().getColumn(3).setResizable(false);
            datosTablaPedido.getColumnModel().getColumn(3).setPreferredWidth(40);
            datosTablaPedido.getColumnModel().getColumn(4).setPreferredWidth(60);
        }

        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("TOTAL:");

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("$$$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVolver)
                                .addGap(179, 179, 179)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(13, 13, 13)
                                .addComponent(jSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnAsignarItemAPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 9, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(btnVolver)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAsignarItemAPedido)
                            .addComponent(btnBorrar))
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsignarItemAPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarItemAPedidoActionPerformed
        try {

            String nombreDescripcion = (String) jComboBoxProductos.getSelectedItem();
            String[] partes = nombreDescripcion.split(" - ");
            String nombreProducto = partes[0]; // El primer elemento es el nombre del producto
            String descripcionProducto = partes[1];
            int idPedidoActivo = controladoraPedido.obtenerIdPedidoActivo(idMesa);
            // Obtener el producto completo correspondiente al nombre seleccionado
            ProductoCompletoDTO productoBuscado = controladoraProducto.buscarProductoPorNombre(nombreProducto, descripcionProducto);
            int idProducto = productoBuscado.getIdProducto();
            // Obtener la cantidad del spinner
            int cantidad = (int) jSpinnerCantidad.getValue();
            float valor = (float) productoBuscado.getPrecio();
            // Calcular el costo total multiplicando la cantidad por el precio del producto
            float costoTotal = valor * cantidad;

            // Crear el nuevo ítem con la cantidad y el costo total
            if (controladoraItems.CrearItems(cantidad, costoTotal, idProducto, idPedidoActivo)) {
                JOptionPane.showMessageDialog(null, "Producto Agregado");
            }

            // Actualizar la tabla del pedido
            actualizarTablaPedido();
        } catch (HeadlessException e) {

        }
        this.actualizarTablaPedido();
    }//GEN-LAST:event_btnAsignarItemAPedidoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        int filaSeleccionada = seleccionarFila();
        if (filaSeleccionada != -1) { // Verificar si se seleccionó alguna fila
            // Obtener el modelo de la tabla
            DefaultTableModel modelo = (DefaultTableModel) datosTablaPedido.getModel();
            // Obtener el ID del ítem de la fila seleccionada
            int idItems = (int) modelo.getValueAt(filaSeleccionada, 0);
            // Eliminar el ítem de la base de datos
            controladoraItems.BorrarItems(idItems);
            // Eliminar la fila de la tabla
            modelo.removeRow(filaSeleccionada);
            // Mostrar un mensaje de éxito
            JOptionPane.showMessageDialog(null, "Ítem borrado exitosamente.");
            actualizarTablaPedido();

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para borrar.");
        }

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void jComboBoxProductosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxProductosItemStateChanged
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            // Obtener el índice seleccionado
            int indiceSeleccionado = jComboBoxProductos.getSelectedIndex();
            List<ProductoCompletoDTO> listaProductos = controladoraProducto.pedirListaProductoCompleto();
            // Obtener el ProductoDTO correspondiente a partir del índice
            ProductoCompletoDTO productoSeleccionado = listaProductos.get(indiceSeleccionado);

            // Aquí puedes mostrar los detalles del producto en otros componentes de la interfaz de usuario
            // Por ejemplo:
            // jTextFieldNombre.setText(productoSeleccionado.getNombre());
            // jTextFieldDescripcion.setText(productoSeleccionado.getDescripcion());
        }
    }//GEN-LAST:event_jComboBoxProductosItemStateChanged

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        this.setVisible(false);
        FormSelectedMesa formSelectedMesa = null;
        try {
            formSelectedMesa = new FormSelectedMesa(nombreMesa, idMesa);
        } catch (SQLException ex) {
            Logger.getLogger(FormPedido.class.getName()).log(Level.SEVERE, null, ex);
        }
        formSelectedMesa.setVisible(true);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void actualizarTablaPedido() {

        int pedidoActivo = controladoraPedido.obtenerIdPedidoActivo(idMesa);
        
        List<ItemsDTO> listaItems = controladoraItems.obtenerItemsPedidoActivo(pedidoActivo);

        // Crear un modelo de tabla
        DefaultTableModel modelo = new DefaultTableModel();

        // Agregar las columnas al modelo
        modelo.addColumn("ID Item");
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Precio");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Costo Total");

        // Recorrer la lista de ítems y agregar cada uno al modelo de la tabla
        for (ItemsDTO item : listaItems) {

            ProductoCompletoDTO producto = item.getProducto();

            modelo.addRow(new Object[]{
                item.getId(),
                producto.getNombre(),
                producto.getDescripcion(),
                producto.getPrecio(),
                item.getCantidad(),
                item.getCostoTotal()
            });
            
        }

        // Establecer el modelo en la tabla
        datosTablaPedido.setModel(modelo);

        TableColumn columnaIdItem = datosTablaPedido.getColumnModel().getColumn(0);
        columnaIdItem.setMinWidth(0);
        columnaIdItem.setMaxWidth(0);
        columnaIdItem.setPreferredWidth(0);
        calcularTotalCostos();
    }

    private void calcularTotalCostos() {
        DefaultTableModel modelo = (DefaultTableModel) datosTablaPedido.getModel();
        float total = 0.0f;
        for (int fila = 0; fila < modelo.getRowCount(); fila++) {
            float costoTotalItem = (float) modelo.getValueAt(fila, 5); // Suponiendo que la columna 5 contiene el costo total
            total += costoTotalItem;
        }
        String txtTotal = String.valueOf(total);
        jLabel5.setText(txtTotal);
        
    }

    private int seleccionarFila() {
        int i = datosTablaPedido.getSelectedRow();

        if (i > -1) {
            return i;
        }
        return -1;
    }

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FormPedido().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FormPedido.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarItemAPedido;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JTable datosTablaPedido;
    private javax.swing.JComboBox jComboBoxProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerCantidad;
    // End of variables declaration//GEN-END:variables
}
