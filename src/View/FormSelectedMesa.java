package View;

import Controlador.ItemController;
import Controlador.PedidoController;
import Modelo.ItemsDTO;
import Modelo.PedidoDTO;
import Modelo.PedidoDTO.EstadoPedido;
import Modelo.ProductoCompletoDTO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public final class FormSelectedMesa extends javax.swing.JFrame {

    private JFrame ventanaActual;
    private String nombreMesa;
    private int idMesa;

    PedidoController pedidoControladora;
    ItemController controladoraItems;

    public FormSelectedMesa(String nombreMesa, int idMesa) throws SQLException {
        controladoraItems = ItemController.GetInstance();
        pedidoControladora = PedidoController.GetInstance();
        this.nombreMesa = nombreMesa;
        this.idMesa = idMesa;
        initComponents();
        jLabel3.setText(nombreMesa);
        txtPrecioFinal.setText(String.valueOf(totalPedidoActivo()));
        verificarListaPedidosActivosYCerrados();
    }

    private FormSelectedMesa() throws SQLException {
        controladoraItems = ItemController.GetInstance();
        pedidoControladora = PedidoController.GetInstance();
        initComponents();
    }

    public void verificarListaPedidosActivosYCerrados() {
        if (pedidoControladora.existePedidoActivo(idMesa)) {
            verPedidoActivo();
        }

        if (!pedidoControladora.obtenerPedidosCerrados(idMesa).isEmpty()) {
            verPedidosCerrados();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAgregarProducto = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioFinal = new javax.swing.JLabel();
        spnDescuento = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPedidosCerrados = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaPedidoActivo = new javax.swing.JTable();
        btnVerPedidoCerrado = new javax.swing.JButton();
        btnBorrarPedidoCerrado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAgregarProducto.setText("AGREGAR");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnCerrar.setText("CERRAR");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Contenido del Pedido Activo");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Pedido de");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel3.setText("Mesa");

        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel4.setText("DESCUENTO:");

        jLabel5.setText("TOTAL:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtPrecioFinal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPrecioFinal.setText("$$$");

        spnDescuento.setMinimumSize(new java.awt.Dimension(70, 26));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Pedidos Cerrados");

        tablaPedidosCerrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Fecha Apertura", "Fecha Cierre", "Costo Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaPedidosCerrados);
        if (tablaPedidosCerrados.getColumnModel().getColumnCount() > 0) {
            tablaPedidosCerrados.getColumnModel().getColumn(0).setResizable(false);
            tablaPedidosCerrados.getColumnModel().getColumn(0).setPreferredWidth(25);
            tablaPedidosCerrados.getColumnModel().getColumn(1).setResizable(false);
            tablaPedidosCerrados.getColumnModel().getColumn(1).setPreferredWidth(100);
            tablaPedidosCerrados.getColumnModel().getColumn(2).setResizable(false);
            tablaPedidosCerrados.getColumnModel().getColumn(2).setPreferredWidth(100);
            tablaPedidosCerrados.getColumnModel().getColumn(3).setResizable(false);
        }

        tablaPedidoActivo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Cantidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaPedidoActivo);
        if (tablaPedidoActivo.getColumnModel().getColumnCount() > 0) {
            tablaPedidoActivo.getColumnModel().getColumn(0).setResizable(false);
            tablaPedidoActivo.getColumnModel().getColumn(0).setPreferredWidth(100);
            tablaPedidoActivo.getColumnModel().getColumn(1).setResizable(false);
            tablaPedidoActivo.getColumnModel().getColumn(1).setPreferredWidth(100);
            tablaPedidoActivo.getColumnModel().getColumn(2).setResizable(false);
            tablaPedidoActivo.getColumnModel().getColumn(2).setPreferredWidth(60);
        }

        btnVerPedidoCerrado.setText("VER");
        btnVerPedidoCerrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerPedidoCerradoActionPerformed(evt);
            }
        });

        btnBorrarPedidoCerrado.setText("BORRAR");
        btnBorrarPedidoCerrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarPedidoCerradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(310, 310, 310)
                .addComponent(jLabel2)
                .addGap(19, 19, 19)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(260, 260, 260)
                .addComponent(jLabel1)
                .addGap(192, 192, 192)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarProducto)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBorrarPedidoCerrado)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVerPedidoCerrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(3, 3, 3)))
                        .addGap(26, 26, 26))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnVolver))
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVerPedidoCerrado)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrarPedidoCerrado))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(177, 177, 177)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btnAgregarProducto)
                                .addGap(13, 13, 13)
                                .addComponent(btnCerrar)
                                .addGap(13, 13, 13)
                                .addComponent(btnBorrar)
                                .addGap(23, 23, 23)
                                .addComponent(spnDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioFinal))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        if (pedidoControladora.existePedidoActivo(idMesa)) {
            JOptionPane.showMessageDialog(this, "¡Ya hay un pedido activo para esta mesa!");
            ingresarFormPedido();
        } else {
            Date fechaApertura = new Date();
            Date fechaCierre = null;
            float descuento = 0;
            float costoTotal = 0;
            EstadoPedido estadoPedido = EstadoPedido.ACTIVO;

           
            pedidoControladora.crearPedido(fechaApertura, fechaCierre, descuento, costoTotal, estadoPedido, idMesa);
            ingresarFormPedido();
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
       
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        try {
            this.setVisible(false);
            FormMesa formMesa = new FormMesa();
            formMesa.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FormSelectedMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed

        float totalDescuento = totalPedidoActivo() - calcularDescuento();
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro de cerrar el pedido?", "Confirmar cierre de pedido", JOptionPane.YES_NO_OPTION);
        if (option == JOptionPane.YES_OPTION) {

            cerrarPedido(totalDescuento);
            verPedidoActivo();
        }
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnVerPedidoCerradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidoCerradoActionPerformed

        int filaSeleccionada = tablaPedidosCerrados.getSelectedRow();
        
        if (filaSeleccionada != -1) {
            ingresarFormPedidoCerrado();
        } else {

            JOptionPane.showMessageDialog(this, "Por favor, seleccione un pedido cerrado para ver.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVerPedidoCerradoActionPerformed

    private void btnBorrarPedidoCerradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPedidoCerradoActionPerformed

        int filaSeleccionada = tablaPedidosCerrados.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idPedido = (int) tablaPedidosCerrados.getValueAt(filaSeleccionada, 0);
            pedidoControladora.borrarPedido(idPedido);
            verPedidosCerrados();
        } else {

            JOptionPane.showMessageDialog(this, "Por favor, seleccione un pedido cerrado para borrar.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarPedidoCerradoActionPerformed

    private void cerrarPedido(float totalDescuento) {

        int idPedido = pedidoControladora.obtenerIdPedidoActivo(idMesa);
        float descuento = calcularDescuento();

        Date fechaCierre = new Date();

        pedidoControladora.actualizarPedido(idPedido, fechaCierre, descuento, totalDescuento, EstadoPedido.CERRADO);

        verPedidosCerrados();

        JOptionPane.showMessageDialog(this, "Pedido cerrado exitosamente.");
        verPedidoActivo();
    }

    private float totalPedidoActivo() {
        int idPedido = pedidoControladora.obtenerIdPedidoActivo(idMesa);
        float total = controladoraItems.calcularTotalPedidoActivo(idPedido);
        return total;
    }

    private float calcularDescuento() {
        float total = totalPedidoActivo();

        Object value = spnDescuento.getValue();

        if (value instanceof Integer) {

            float descuentoPorcentaje = ((Integer) value).floatValue();

            float descuento = total * (descuentoPorcentaje / 100);
            return descuento;
        } else if (value instanceof Float) {

            float descuentoPorcentaje = (Float) value;

            float descuento = total * (descuentoPorcentaje / 100);
            return descuento;
        } else {

            return 0.0f;
        }

    }

    private void verPedidoActivo() {
        if (pedidoControladora.existePedidoActivo(idMesa)) {
            int idPedido = pedidoControladora.obtenerIdPedidoActivo(idMesa);
            DefaultTableModel modeloPedidoActivo = new DefaultTableModel();

            List<ItemsDTO> listaItems = controladoraItems.obtenerItemsPedidoActivo(idPedido);
            modeloPedidoActivo.addColumn("Nombre");
            modeloPedidoActivo.addColumn("Descripcion");
            modeloPedidoActivo.addColumn("Cantidad");
            for (ItemsDTO item : listaItems) {

                ProductoCompletoDTO producto = item.getProducto();

                modeloPedidoActivo.addRow(new Object[]{
                    producto.getNombre(),
                    producto.getDescripcion(),
                    item.getCantidad()
                });

            }

            tablaPedidoActivo.setModel(modeloPedidoActivo);
        }
    }

    private void verPedidosCerrados() {
        DefaultTableModel modeloPedidosCerrados = new DefaultTableModel();

        List<PedidoDTO> listaPedidos = pedidoControladora.obtenerPedidosCerrados(idMesa);
        modeloPedidosCerrados.addColumn("ID");
        modeloPedidosCerrados.addColumn("Fecha Apertura");
        modeloPedidosCerrados.addColumn("Fecha Cierre");
        modeloPedidosCerrados.addColumn("Costo Total");

        for (PedidoDTO pedido : listaPedidos) {
            Object[] fila = {
                pedido.getId(),
                pedido.getFechaApertura(),
                pedido.getFechaCierre(),
                pedido.getCostoTotal()
            };
            modeloPedidosCerrados.addRow(fila);
        }

        tablaPedidosCerrados.setModel(modeloPedidosCerrados);

    }

    private void ingresarFormPedido() {

        try {
            if (ventanaActual != null) {
                ventanaActual.dispose();
            }
            FormPedido formPedido = new FormPedido(nombreMesa, idMesa);
            formPedido.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    setVisible(true);
                }
            });
            formPedido.setVisible(true);
            ventanaActual = formPedido;
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(FormSelectedMesa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ingresarFormPedidoCerrado(){
        
        int filaSeleccionada = tablaPedidosCerrados.getSelectedRow();
        int idPedido = (int) tablaPedidosCerrados.getValueAt(filaSeleccionada, 0);
        try {
            if (ventanaActual != null) {
                ventanaActual.dispose();
            }
            FormPedidoCerrado formPedidoCerrado = new FormPedidoCerrado(nombreMesa, idMesa, idPedido);
            formPedidoCerrado.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    setVisible(true);
                }
            });
            formPedidoCerrado.setVisible(true);
            ventanaActual = formPedidoCerrado;
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(FormSelectedMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            java.util.logging.Logger.getLogger(FormSelectedMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new FormSelectedMesa().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(FormSelectedMesa.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnBorrarPedidoCerrado;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnVerPedidoCerrado;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner spnDescuento;
    private javax.swing.JTable tablaPedidoActivo;
    private javax.swing.JTable tablaPedidosCerrados;
    private javax.swing.JLabel txtPrecioFinal;
    // End of variables declaration//GEN-END:variables
}
