/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.vista.paneles;

import co.edu.intecap.clinicaveterinaria.control.TipoMascotaDelegado;
import co.edu.intecap.clinicaveterinaria.modelo.vo.TipoMascotaVo;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author INTECAP
 */
public class TipoMascotaPanel extends javax.swing.JPanel {

    private DefaultTableModel modelo;
    private final TipoMascotaVo tipoMascotaVo;

    /**
     * Creates new form TipoMascotaPanel
     */
    public TipoMascotaPanel() {
        initComponents();
        configurarTabla();
        llenarTabla(new TipoMascotaDelegado(this).consultarTipoMascota(), modelo);
        this.tipoMascotaVo = new TipoMascotaVo();
    }

    /* 04 - 04 - 2016
     Método para obtener valores del GUI y registrar un
     nuevo tipo de mascota*/
    private void registrarTipoMascota() {
        // asignar nombre del tipo de mascota
        tipoMascotaVo.setNombre(txtNombre.getText());
        tipoMascotaVo.setEstado(cbxEstado.isSelected());
        
        // validar si el id de la constante es mayor a cero (0)
        if (tipoMascotaVo.getIdTipoMascota() < 1) {
            // se crea un nuevo registro de tipo_mascota
            new TipoMascotaDelegado(this).registrarTipoMascota(tipoMascotaVo);
        } else {
            new TipoMascotaDelegado(this).editarTipoMascota(tipoMascotaVo);
        }
        
        
        // mensaje de confirmación de registro
        JOptionPane.showMessageDialog(this, "Tipo de mascota Registrado",
                "Registro de datos", JOptionPane.INFORMATION_MESSAGE
        );
        refrescarTabla();
        limpiarCampos();
        limpiarConstante();

    }

    /* 
     Permite establecer los parametros iniciales de una tabla
     */
    private void configurarTabla() {
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Mascota");
        modelo.addColumn("Nombre");
        modelo.addColumn("estado");
        tblTipoMascota.setModel(modelo);
        tblTipoMascota.getSelectionModel().addListSelectionListener(tableListener);

//      Carga una lista de tipos de mascota desde la base de datos
//      a la tabla de la interfaz gráfica de usuari0       
//      @param listaTipoMascota lista de tipos de mascota de la base de datos
//      @param modelo Modelo de tabla con la estructura de los datos a cargar
    }

    private void llenarTabla(List<TipoMascotaVo> listaTipoMascota, DefaultTableModel modelo) {
        for (TipoMascotaVo tipoMascotaVo : listaTipoMascota) {
            Object[] fila = new Object[3];
            fila[0] = tipoMascotaVo.getIdTipoMascota();
            fila[1] = tipoMascotaVo.getNombre();
            fila[2] = tipoMascotaVo.isEstado();
            modelo.addRow(fila);
        }
        tblTipoMascota.updateUI();
    }

    /**
     * Actualiza la información de la tabla con cada vez que se realiza un
     * registro
     */
    private void refrescarTabla() {
        /**
         * Esto limpia los duplicados
         */
        modelo.setRowCount(0);
        List<TipoMascotaVo> listaMascotas = new TipoMascotaDelegado(this).consultarTipoMascota();
        llenarTabla(listaMascotas, modelo);
    }

    private void limpiarCampos() {
        txtNombre.setText(""); //con este comando se limpia
        cbxEstado.setSelected(false);
    }

    /**
     * reinicia los valores de la constante que se usa para inserta o actualizar
     * un registro de la tabla tipo_mascota
     */
    private void limpiarConstante() {
        // limpiar el id de tipo de mascota
        tipoMascotaVo.setIdTipoMascota(0);
        // limpiar el nombre del tipo de mascota
        tipoMascotaVo.setNombre("");
        // limpiar el estado del tipo de mascota
        tipoMascotaVo.setEstado(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JCheckBox();
        txtNombre = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTipoMascota = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        bntGuardar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();

        jLabel1.setText("Nombre:");

        jLabel2.setText("Estado:");

        cbxEstado.setText("Activo");

        tblTipoMascota.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblTipoMascota);

        bntGuardar.setText("Guardar");
        bntGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(cbxEstado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bntGuardar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 43, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(cbxEstado))
                    .addComponent(bntGuardar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bntGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntGuardarActionPerformed
        this.registrarTipoMascota();
// TODO add your handling code here:
    }//GEN-LAST:event_bntGuardarActionPerformed

    /**
     * Escuchador de eventos para la selección de filas en una tabla,
     * permite obtener el id de un registro de la table con datos de la base
     * de datos, con el fin de realizar el trabajo de edición de un registro
     * para ello se usa un objeto que represente un registro de la tabla
     * de la base de datos (vo) para luego enviar dichos datos como parte de los
     * parametros de la actualización
     */
    
    ListSelectionListener tableListener = new ListSelectionListener() {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            // validar si se ha seleccionado una fila de la tabla
            if (tblTipoMascota.getSelectedRow() > -1) {
                // se obtiene el ID de la fila seleccionada en la tabla
                // int id  -> variable que guarda el id_tipo_mascota de la fila seleccionada.
                
                // (int) -> casteo del objeto que se obtiene al seleccionar una fila de la tabla
                // de la interfaz gráfica de usuario "se castea a un dato de tipo int".
                
                // tblTipoMascota.getValueAt -> método que permite obtener el dato de una celda
                //de la tabla segun los parámetros "(fila, columna)" este método retorna un
                // objeto de la clase object.
                
                // tblTipoMascota.getSelectedRow -> método que retorna el número de la fila
                // sobre la cual se ha realizado una selección con el mouse.
                
                // 0 -> representa el indice de la columna seleccionada, siempre es 0 porque se toma
                // como referencia la primera columna de la tabla.
                
                int id = (int) tblTipoMascota.getValueAt(tblTipoMascota.getSelectedRow(), 0);
                // consultar en la base de datos por ese id seleccionado y guardar
                // el resultado de la consulta en un nuevo object de TipoMascotaVo
                TipoMascotaVo tMvo = new TipoMascotaDelegado(TipoMascotaPanel.this).consultarTipoMascota(id);
                // asignar los valores obtenidos de la consulta a la constante
                tipoMascotaVo.setIdTipoMascota(tMvo.getIdTipoMascota());
                tipoMascotaVo.setNombre(tMvo.getNombre());
                tipoMascotaVo.setEstado(tMvo.isEstado() );
                // llenar campos del formulario
                llenarCampos();
            }
        }
    }; // aquí se añadió el punto y coma (;) después de implementar el ListSelectionListener
    // cuando es un objeto

    private void llenarCampos() {
        txtNombre.setText(tipoMascotaVo.getNombre());
        cbxEstado.setSelected(tipoMascotaVo.isEstado());
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntGuardar;
    private javax.swing.JCheckBox cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable tblTipoMascota;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
