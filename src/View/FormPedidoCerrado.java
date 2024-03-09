/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controlador.PedidoController;
import Modelo.ItemsDTO;
import Modelo.PedidoDTO;
import Modelo.ProductoCompletoDTO;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author nahue
 */
public final class FormPedidoCerrado extends javax.swing.JFrame {

    private String nombreMesa;
    private int idPedido;
    PedidoController controladoraPedido;

    public FormPedidoCerrado(String nombreMesa, int idPedido) throws SQLException {
        initComponents();
        controladoraPedido = PedidoController.GetInstance();
        lblPedidoId.setText(String.valueOf(idPedido));
        lblNombreMesa.setText(nombreMesa);
        verTablaPedidoCerrado(idPedido);
    }

    private FormPedidoCerrado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblNombreMesa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblPedidoId = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidoCerrado = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblDescuento = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText(" Mesa:");

        lblNombreMesa.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblNombreMesa.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setText("Pedido: ");

        lblPedidoId.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        lblPedidoId.setText("ID");

        btnVolver.setText("VOLVER");

        tablaPedidoCerrado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Descripcion", "Cantidad", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaPedidoCerrado);
        if (tablaPedidoCerrado.getColumnModel().getColumnCount() > 0) {
            tablaPedidoCerrado.getColumnModel().getColumn(0).setResizable(false);
            tablaPedidoCerrado.getColumnModel().getColumn(0).setPreferredWidth(120);
            tablaPedidoCerrado.getColumnModel().getColumn(1).setResizable(false);
            tablaPedidoCerrado.getColumnModel().getColumn(1).setPreferredWidth(120);
            tablaPedidoCerrado.getColumnModel().getColumn(2).setResizable(false);
            tablaPedidoCerrado.getColumnModel().getColumn(2).setPreferredWidth(40);
            tablaPedidoCerrado.getColumnModel().getColumn(3).setResizable(false);
            tablaPedidoCerrado.getColumnModel().getColumn(3).setPreferredWidth(60);
        }

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("TOTAL:");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTotal.setText("$$$");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("DESCUENTO:");

        lblDescuento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblDescuento.setText("$$$");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnVolver)
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPedidoId, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombreMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDescuento)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblNombreMesa)
                    .addComponent(jLabel2)
                    .addComponent(lblPedidoId)
                    .addComponent(btnVolver))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lblTotal))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lblDescuento))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void verTablaPedidoCerrado(int idPedido) {
        
        PedidoDTO pedidoCerrado = controladoraPedido.obtenerUnPedidoCerrado(idPedido);
        DefaultTableModel modelo = new DefaultTableModel();
        // Agregar las columnas al modelo
        modelo.addColumn("Nombre");
        modelo.addColumn("Descripción");
        modelo.addColumn("Cantidad");
        modelo.addColumn("Precio");
        // Recorrer la lista de ítems y agregar cada uno al modelo de la tabla
        for (ItemsDTO item : pedidoCerrado.getItems()) {
            ProductoCompletoDTO producto = item.getProducto();
            modelo.addRow(new Object[]{
                producto.getNombre(),
                producto.getDescripcion(),
                item.getCantidad(),
                item.getCostoTotal()
            });
        }
        
        float total = pedidoCerrado.getCostoTotal();
        lblTotal.setText(String.valueOf(total));
        float descuento = pedidoCerrado.getDescuento();
        lblDescuento.setText(String.valueOf(descuento));
        
        tablaPedidoCerrado.setModel(modelo);
    }

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
            java.util.logging.Logger.getLogger(FormPedidoCerrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPedidoCerrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPedidoCerrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPedidoCerrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FormPedidoCerrado().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescuento;
    private javax.swing.JLabel lblNombreMesa;
    private javax.swing.JLabel lblPedidoId;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaPedidoCerrado;
    // End of variables declaration//GEN-END:variables
}
