/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.modelo.dao;

import co.edu.intecap.clinicaveterinaria.modelo.conexion.Conexion;
import co.edu.intecap.clinicaveterinaria.modelo.vo.ClienteVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author INTECAP
 */
public class ClienteDao extends Conexion implements GenericoDao<ClienteVo> {

    @Override
    public void insertar(ClienteVo object) {
        PreparedStatement sentencia;
        try {
            conectar();
            String sql = "insert into mascota(nombre,correo,telefono,estado) values(?,?,?,?)";
            sentencia = cnn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            sentencia.setString(1, object.getNombre());
            sentencia.setString(2, object.getCorreo());
            sentencia.setString(3, object.getTelefono());
            sentencia.setBoolean(4, object.isEstado());
            sentencia.executeUpdate(); 
            ResultSet rs = sentencia.getGeneratedKeys(); // este metodo devuelve el id de la mascota
            if(rs.next()) {
                object.setIdCliente(rs.getInt(1));
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar();
        }
    }

    @Override
    public void editar(ClienteVo object) {
        PreparedStatement sentencia;
        try {
            conec
        } catch (Exception e) {
        } finally {
            desconectar;
        }
    }

    @Override
    public List<ClienteVo> consultar() {
        return null;
    }

    @Override
    public ClienteVo consultar(int id) {
        return null;
    }
    
    
}
