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

/**
 * FormSelectedMesa es una interfaz gráfica que maneja los pedidos de una mesa
 * seleccionada. Permite agregar productos, cerrar pedidos, ver pedidos activos
 * y cerrados, y borrar pedidos cerrados.
 */
public final class FormSelectedMesa extends javax.swing.JFrame {

    // Variables de instancia
    private JFrame ventanaActual;
    private String nombreMesa;
    private int idMesa;

    PedidoController pedidoControladora;
    ItemController controladoraItems;

    /**
     * Constructor de la clase FormSelectedMesa.
     *
     * @param nombreMesa El nombre de la mesa seleccionada.
     * @param idMesa El identificador único de la mesa seleccionada.
     * @throws SQLException Si ocurre un error al interactuar con la base de
     * datos.
     */
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

    /**
     * Constructor privado vacío de la clase FormSelectedMesa.
     *
     * @throws SQLException Si ocurre un error al interactuar con la base de
     * datos.
     */
    private FormSelectedMesa() throws SQLException {
        controladoraItems = ItemController.GetInstance();
        pedidoControladora = PedidoController.GetInstance();
        initComponents();
    }

    /**
     * Verifica si hay pedidos activos y cerrados para la mesa seleccionada y
     * actualiza la interfaz en consecuencia.
     */
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
/**
     * Método invocado cuando se presiona el botón "AGREGAR" para añadir un
     * producto al pedido activo de la mesa. Si ya existe un pedido activo para
     * la mesa, muestra un mensaje de advertencia y abre el formulario de
     * pedido. De lo contrario, crea un nuevo pedido activo y luego abre el
     * formulario de pedido.
     *
     * @param evt El evento de acción que desencadena la invocación del método.
     */
    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed

        if (pedidoControladora.existePedidoActivo(idMesa)) {
            JOptionPane.showMessageDialog(this, "¡Ya hay un pedido activo para esta mesa!");
            ingresarFormPedido();
        } else {
            // Obtener la fecha actual
            Date fechaApertura = new Date();
            // Aún no hay fecha de cierre, descuento o costo total definidos para el nuevo pedido
            Date fechaCierre = null;
            float descuento = 0;
            float costoTotal = 0;
            // Estado inicial del nuevo pedido es ACTIVO
            EstadoPedido estadoPedido = EstadoPedido.ACTIVO;
            // Crear un nuevo pedido activo para la mesa seleccionada
            pedidoControladora.crearPedido(fechaApertura, fechaCierre, descuento, costoTotal, estadoPedido, idMesa);
            // Abrir el formulario de pedido para agregar productos
            ingresarFormPedido();
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

    }//GEN-LAST:event_btnBorrarActionPerformed
    /**
     * Este método se activa cuando se hace clic en el botón "VOLVER". Oculta la
     * ventana actual y muestra la ventana FormMesa. Si se produce una excepción
     * SQLException, registra un mensaje de error detallado.
     *
     * @param evt El evento del botón "VOLVER"
     */
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        try {
            // Oculta la ventana actual
            this.setVisible(false);
            // Crea una nueva instancia de FormMesa
            FormMesa formMesa = new FormMesa();
            // Muestra la nueva instancia de FormMesa
            formMesa.setVisible(true);
        } catch (SQLException ex) {
            // Maneja cualquier excepción SQLException registrando un mensaje de error detallado
            Logger.getLogger(FormSelectedMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVolverActionPerformed
    /**
     * Este método se activa cuando se hace clic en el botón "CERRAR". Calcula
     * el descuento total aplicado al pedido activo, muestra un mensaje de
     * confirmación y, si se confirma, cierra el pedido activo y actualiza la
     * vista del pedido activo.
     *
     * @param evt El evento del botón "CERRAR"
     */
    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
// Calcula el descuento total restando el descuento del total del pedido activo
        float totalDescuento = totalPedidoActivo() - calcularDescuento();
        // Muestra un cuadro de diálogo de confirmación para cerrar el pedido
        int option = JOptionPane.showConfirmDialog(this, "¿Estás seguro de cerrar el pedido?", "Confirmar cierre de pedido", JOptionPane.YES_NO_OPTION);
        // Si se confirma el cierre del pedido
        if (option == JOptionPane.YES_OPTION) {
// Cierra el pedido activo con el descuento total calculado
            cerrarPedido(totalDescuento);
            // Actualiza la vista del pedido activo
            verPedidoActivo();
        }
    }//GEN-LAST:event_btnCerrarActionPerformed
    /**
     * Este método se activa cuando se hace clic en el botón "VER" de un pedido
     * cerrado en la tabla de pedidos cerrados. Obtiene la fila seleccionada en
     * la tabla y verifica si se ha seleccionado un pedido cerrado. Si se ha
     * seleccionado un pedido cerrado, abre el formulario correspondiente para
     * ver el detalle del pedido cerrado. Si no se ha seleccionado ningún pedido
     * cerrado, muestra un mensaje de advertencia.
     *
     * @param evt El evento del botón "VER"
     */
    private void btnVerPedidoCerradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerPedidoCerradoActionPerformed
        // Obtiene la fila seleccionada en la tabla de pedidos cerrados
        int filaSeleccionada = tablaPedidosCerrados.getSelectedRow();
        // Verifica si se ha seleccionado una fila
        if (filaSeleccionada != -1) {
            // Si se ha seleccionado un pedido cerrado, abre el formulario correspondiente para ver el detalle del pedido cerrado
            ingresarFormPedidoCerrado();
        } else {
            // Si no se ha seleccionado ningún pedido cerrado, muestra un mensaje de advertencia
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un pedido cerrado para ver.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnVerPedidoCerradoActionPerformed
    /**
     * Este método se activa cuando se hace clic en el botón "BORRAR" de un
     * pedido cerrado en la tabla de pedidos cerrados. Obtiene la fila
     * seleccionada en la tabla y verifica si se ha seleccionado un pedido
     * cerrado. Si se ha seleccionado un pedido cerrado, obtiene el ID del
     * pedido y lo borra de la base de datos. Actualiza la tabla de pedidos
     * cerrados para reflejar los cambios. Si no se ha seleccionado ningún
     * pedido cerrado, muestra un mensaje de advertencia.
     *
     * @param evt El evento del botón "BORRAR"
     */
    private void btnBorrarPedidoCerradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarPedidoCerradoActionPerformed
        // Obtiene la fila seleccionada en la tabla de pedidos cerrados
        int filaSeleccionada = tablaPedidosCerrados.getSelectedRow();
        // Verifica si se ha seleccionado una fila
        if (filaSeleccionada != -1) {
            // Si se ha seleccionado un pedido cerrado, obtiene el ID del pedido y lo borra de la base de datos
            int idPedido = (int) tablaPedidosCerrados.getValueAt(filaSeleccionada, 0);
            // Actualiza la tabla de pedidos cerrados para reflejar los cambios
            pedidoControladora.borrarPedido(idPedido);
            verPedidosCerrados();
        } else {
            // Si no se ha seleccionado ningún pedido cerrado, muestra un mensaje de advertencia
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un pedido cerrado para borrar.", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarPedidoCerradoActionPerformed
    /**
     * Cierra el pedido activo para la mesa seleccionada. Obtiene el ID del
     * pedido activo, calcula el descuento aplicado al pedido, obtiene la fecha
     * de cierre actual, actualiza el estado del pedido a "CERRADO" en la base
     * de datos, actualiza la tabla de pedidos cerrados para reflejar los
     * cambios y muestra un mensaje de confirmación de que el pedido se ha
     * cerrado exitosamente.
     */
    private void cerrarPedido(float totalDescuento) {
        // Obtiene el ID del pedido activo para la mesa seleccionada

        int idPedido = pedidoControladora.obtenerIdPedidoActivo(idMesa);
        // Calcula el descuento aplicado al pedido

        float descuento = calcularDescuento();
        // Obtiene la fecha de cierre actual

        Date fechaCierre = new Date();
        // Actualiza el estado del pedido a "CERRADO" en la base de datos

        pedidoControladora.actualizarPedido(idPedido, fechaCierre, descuento, totalDescuento, EstadoPedido.CERRADO);
        // Actualiza la tabla de pedidos cerrados para reflejar los cambios

        verPedidosCerrados();
        // Muestra un mensaje de confirmación de que el pedido se ha cerrado exitosamente

        JOptionPane.showMessageDialog(this, "Pedido cerrado exitosamente.");
        // Actualiza la visualización del pedido activo

        verPedidoActivo();
    }

    /**
     * Calcula el costo total del pedido activo para la mesa seleccionada.
     * Obtiene el ID del pedido activo, luego utiliza este ID para calcular el
     * costo total del pedido activo consultando la base de datos a través del
     * controlador de ítems.
     *
     * @return El costo total del pedido activo.
     */
    private float totalPedidoActivo() {
        // Obtiene el ID del pedido activo para la mesa seleccionada

        int idPedido = pedidoControladora.obtenerIdPedidoActivo(idMesa);
        // Calcula el costo total del pedido activo utilizando el controlador de ítems

        float total = controladoraItems.calcularTotalPedidoActivo(idPedido);
        return total;
    }

    /**
     * Calcula el descuento aplicado al pedido activo basado en el valor
     * ingresado en el spinner de descuento. El descuento se calcula como un
     * porcentaje del costo total del pedido activo. Si el valor ingresado es un
     * entero o un float, se calcula el descuento y se devuelve. Si el valor no
     * es ni entero ni float, se devuelve cero.
     *
     * @return El descuento aplicado al pedido activo.
     */
    private float calcularDescuento() {
        // Obtiene el costo total del pedido activo

        float total = totalPedidoActivo();
        // Obtiene el valor ingresado en el spinner de descuento

        Object value = spnDescuento.getValue();
        // Verifica si el valor ingresado es un entero

        if (value instanceof Integer) {
            // Convierte el valor a float

            float descuentoPorcentaje = ((Integer) value).floatValue();
            // Calcula el descuento como un porcentaje del costo total del pedido activo

            float descuento = total * (descuentoPorcentaje / 100);
            return descuento;
        } // Verifica si el valor ingresado es un float
        else if (value instanceof Float) {
            // Obtiene el valor de descuento como float

            float descuentoPorcentaje = (Float) value;
            // Calcula el descuento como un porcentaje del costo total del pedido activo

            float descuento = total * (descuentoPorcentaje / 100);
            return descuento;
        } // Si el valor ingresado no es ni entero ni float, devuelve cero
        else {

            return 0.0f;
        }

    }

    /**
     * Muestra los detalles del pedido activo en la tabla de la interfaz
     * gráfica. Obtiene los detalles del pedido activo del controlador de
     * pedidos y del controlador de ítems. Si existe un pedido activo para la
     * mesa actual, se muestra en la tabla con los siguientes campos: - Nombre
     * del producto. - Descripción del producto. - Cantidad solicitada.
     */
    private void verPedidoActivo() {
        // Verifica si existe un pedido activo para la mesa actual

        if (pedidoControladora.existePedidoActivo(idMesa)) {
            // Obtiene el ID del pedido activo para la mesa actual

            int idPedido = pedidoControladora.obtenerIdPedidoActivo(idMesa);
            // Crea un nuevo modelo de tabla para mostrar los detalles del pedido activo

            DefaultTableModel modeloPedidoActivo = new DefaultTableModel();
            // Obtiene la lista de ítems del pedido activo

            List<ItemsDTO> listaItems = controladoraItems.obtenerItemsPedidoActivo(idPedido);
            // Agrega las columnas al modelo de tabla

            modeloPedidoActivo.addColumn("Nombre");
            modeloPedidoActivo.addColumn("Descripcion");
            modeloPedidoActivo.addColumn("Cantidad");
            // Itera sobre la lista de ítems del pedido activo

            for (ItemsDTO item : listaItems) {
                // Obtiene el producto asociado al ítem

                ProductoCompletoDTO producto = item.getProducto();
                // Agrega una fila al modelo de tabla con el nombre, la descripción y la cantidad del producto

                modeloPedidoActivo.addRow(new Object[]{
                    producto.getNombre(),
                    producto.getDescripcion(),
                    item.getCantidad()
                });

            }
            // Establece el modelo de tabla actualizado en la tabla de la interfaz gráfica

            tablaPedidoActivo.setModel(modeloPedidoActivo);
        }
    }

    /**
     * Muestra los pedidos cerrados en la tabla de la interfaz gráfica. Obtiene
     * los pedidos cerrados del controlador de pedidos. Los detalles de los
     * pedidos cerrados se muestran en una tabla con los siguientes campos: - ID
     * del pedido. - Fecha de apertura del pedido. - Fecha de cierre del pedido.
     * - Costo total del pedido.
     */
    private void verPedidosCerrados() {
        // Crea un nuevo modelo de tabla para mostrar los pedidos cerrados

        DefaultTableModel modeloPedidosCerrados = new DefaultTableModel();
        // Obtiene la lista de pedidos cerrados para la mesa actual

        List<PedidoDTO> listaPedidos = pedidoControladora.obtenerPedidosCerrados(idMesa);
        // Agrega las columnas al modelo de tabla

        modeloPedidosCerrados.addColumn("ID");
        modeloPedidosCerrados.addColumn("Fecha Apertura");
        modeloPedidosCerrados.addColumn("Fecha Cierre");
        modeloPedidosCerrados.addColumn("Costo Total");
        // Itera sobre la lista de pedidos cerrados

        for (PedidoDTO pedido : listaPedidos) {
            // Crea una fila con los detalles del pedido y la agrega al modelo de tabla

            Object[] fila = {
                pedido.getId(),
                pedido.getFechaApertura(),
                pedido.getFechaCierre(),
                pedido.getCostoTotal()
            };
            modeloPedidosCerrados.addRow(fila);
        }
        // Establece el modelo de tabla actualizado en la tabla de pedidos cerrados de la interfaz gráfica

        tablaPedidosCerrados.setModel(modeloPedidosCerrados);

    }

    /**
     * Abre el formulario para agregar un nuevo pedido. Cierra la ventana actual
     * si existe, luego crea una nueva instancia del formulario de pedido, le
     * asigna un observador para manejar el evento de cierre del formulario hijo
     * y lo hace visible. La ventana actual se establece invisible mientras se
     * muestra el formulario de pedido.
     *
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    private void ingresarFormPedido() {

        try {
            // Si hay una ventana actual abierta, la cierra

            if (ventanaActual != null) {
                ventanaActual.dispose();
            }
            // Crea una nueva instancia del formulario de pedido con el nombre de la mesa y su ID

            FormPedido formPedido = new FormPedido(nombreMesa, idMesa);
            // Agrega un observador para manejar el evento de cierre del formulario hijo

            formPedido.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    // Hace visible la ventana actual cuando se cierra el formulario hijo

                    setVisible(true);
                }
            });
            // Muestra el formulario de pedido

            formPedido.setVisible(true);
            // Establece la nueva ventana actual como el formulario de pedido

            ventanaActual = formPedido;
            // Hace invisible la ventana actual

            this.setVisible(false);
        } catch (SQLException ex) {
            // Registra cualquier excepción de SQL que ocurra
            Logger.getLogger(FormSelectedMesa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Abre el formulario para ver un pedido cerrado seleccionado. Obtiene la
     * fila seleccionada en la tabla de pedidos cerrados y recupera el ID del
     * pedido. Si hay una ventana actual abierta, la cierra. Luego, crea una
     * nueva instancia del formulario de pedido cerrado con el nombre de la
     * mesa, su ID y el ID del pedido. Agrega un observador para manejar el
     * evento de cierre del formulario hijo. Muestra el formulario de pedido
     * cerrado y establece la nueva ventana actual como el formulario de pedido
     * cerrado. Hace invisible la ventana actual mientras se muestra el
     * formulario de pedido cerrado.
     *
     * @throws SQLException Si ocurre un error al acceder a la base de datos.
     */
    private void ingresarFormPedidoCerrado() {
        // Obtiene la fila seleccionada en la tabla de pedidos cerrados

        int filaSeleccionada = tablaPedidosCerrados.getSelectedRow();
        // Obtiene el ID del pedido seleccionado

        int idPedido = (int) tablaPedidosCerrados.getValueAt(filaSeleccionada, 0);
        try {
            // Si hay una ventana actual abierta, la cierra

            if (ventanaActual != null) {
                ventanaActual.dispose();
            }
            // Crea una nueva instancia del formulario de pedido cerrado con el nombre de la mesa, su ID y el ID del pedido
            FormPedidoCerrado formPedidoCerrado = new FormPedidoCerrado(nombreMesa, idMesa, idPedido);
            // Agrega un observador para manejar el evento de cierre del formulario hijo
            formPedidoCerrado.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    // Hace visible la ventana actual cuando se cierra el formulario hijo
                    setVisible(true);
                }
            });
            // Muestra el formulario de pedido cerrado
            formPedidoCerrado.setVisible(true);
            // Establece la nueva ventana actual como el formulario de pedido cerrado
            ventanaActual = formPedidoCerrado;
            // Hace invisible la ventana actual
            this.setVisible(false);
        } catch (SQLException ex) {
            // Registra cualquier excepción de SQL que ocurra
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
