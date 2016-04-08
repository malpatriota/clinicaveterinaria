/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.vista.paneles;

import co.edu.intecap.clinicaveterinaria.control.ClienteDelegado;
import co.edu.intecap.clinicaveterinaria.control.MascotaDelegado;
import co.edu.intecap.clinicaveterinaria.control.TipoMascotaDelegado;
import co.edu.intecap.clinicaveterinaria.modelo.vo.ClienteVo;
import co.edu.intecap.clinicaveterinaria.modelo.vo.MascotaVo;
import co.edu.intecap.clinicaveterinaria.modelo.vo.TipoMascotaVo;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author INTECAP
 */
public class MascotaPanel extends javax.swing.JPanel {

    /**
     * Lista que contiene los tipos de mascotas existentes en la base de datos
     */
    private List<TipoMascotaVo> listaTipoMascota;

    /**
     * Lista que contiene los clientes existentes en la base de datos
     */
    private List<ClienteVo> listaClientes;

    /**
     * Creates new form MascotaPanel
     */
    public MascotaPanel() {
        initComponents();
        // cargar con datos la lista de tipo de mascota
        this.listaTipoMascota = new TipoMascotaDelegado(this).consultarTipoMascota();
        // cargar con datos la lista de clientes
        this.listaClientes = new ClienteDelegado(this).consultarClientes();
        configurarCombos();
    }

    private void configurarCombos() {
        cboTipoMascota.addItem("Seleccione un tipo de mascota");
        cboCliente.addItem("Seleccione un cliente");
        // se carga el comboBox con la información de la lista consutlada en la
        // base de datos de tipos de mascota
        for (TipoMascotaVo tipoMascotaVo : listaTipoMascota) {
            cboTipoMascota.addItem(tipoMascotaVo.getNombre());
        }
        for (ClienteVo clienteVo : listaClientes) {
            cboCliente.addItem(clienteVo.getNombre());
        }
    }
    /**
     * Obttener del List de tipos de mascota el id del tipo de mascota
     * seleccionado en el combo box
     * @return int del tipo de mascota seleccionado en el combo box
     */
    private int obtenerIdTipoMascotaCombo(){
        int idSeleccionado = cboTipoMascota.getSelectedIndex();
        int idTipoMascota = listaTipoMascota.get(idSeleccionado -1).getIdTipoMascota();
        return idTipoMascota;
    }
    /**
     * Obtener del List de clientes el id de cliente seleccionado en el
     * combobox
     * @return int id del cliente seleccionado en el combobox
     */
    private int obtenerIdClienteCombo(){
        int idSeleccionado = cboCliente.getSelectedIndex();
        int idCliente = listaClientes.get(idSeleccionado-1).getIdCliente();
        return idCliente;      
    }
    private void registrarMascota() {
        MascotaVo mascotaVo = new MascotaVo();
        // obtener el valor del txtNombre
        mascotaVo.setNombre(txtNombre.getText());
        // obtener el valor del txtEdad
        mascotaVo.setEdad((int)txtEdad.getModel().getValue());
        // obtener el valor del cbxEstado
        mascotaVo.setEstado(cbxEstado.isSelected());
        // obtener el id tipo mascota del cbo cboTipoMascota
        mascotaVo.setIdTipoMascota(this.obtenerIdTipoMascotaCombo());
        // obtener el id del cliente del cboCliente
        mascotaVo.setIdCliente(this.obtenerIdClienteCombo());
        new MascotaDelegado(this).insertarMascota(mascotaVo);
        JOptionPane.showMessageDialog(this, 
                "Mascota registrada correctamente",
                "Registro de mascota",
                JOptionPane.INFORMATION_MESSAGE
        );
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
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEdad = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        cboTipoMascota = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        cboCliente = new javax.swing.JComboBox();
        JScrollPane1 = new javax.swing.JScrollPane();
        tblMascota = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnGuardar = new javax.swing.JButton();

        jLabel1.setText("Nombre:");

        jLabel2.setText("Edad:");

        jLabel3.setText("Estado:");

        cbxEstado.setText("Activo");

        jLabel4.setText("Tipo de mascota:");

        jLabel5.setText("Cliente:");

        tblMascota.setModel(new javax.swing.table.DefaultTableModel(
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
        JScrollPane1.setViewportView(tblMascota);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre)
                                    .addComponent(txtEdad)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbxEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(58, 58, 58))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(26, 26, 26)
                                .addComponent(cboTipoMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addComponent(jSeparator1))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboTipoMascota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        registrarMascota();
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane1;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox cboCliente;
    private javax.swing.JComboBox cboTipoMascota;
    private javax.swing.JCheckBox cbxEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblMascota;
    private javax.swing.JSpinner txtEdad;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
