/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.modelo.dao;

import co.edu.intecap.clinicaveterinaria.modelo.conexion.Conexion;
import co.edu.intecap.clinicaveterinaria.modelo.vo.TipoMascotaVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author INTECAP
 */
public class TipoMascotaDao extends Conexion implements GenericoDao<TipoMascotaVo> {

    @Override
    public void insertar(TipoMascotaVo object) {
        PreparedStatement sentencia;
        try {
            conectar();
            String sql = "insert into id_mascota(nombre,estado) values(?,?)";
            sentencia = cnn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            
            sentencia.setString(1, object.getNombre());
            sentencia.setBoolean(2, object.isEstado());
            sentencia.executeUpdate(); 
            ResultSet rs = sentencia.getGeneratedKeys();
            if (rs.next()) {
                object.setIdTipoMascota(rs.getInt(1));
            }
            
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar ();
        }
    }

    @Override
    public void editar(TipoMascotaVo object) {
        PreparedStatement sentencia;
        try {
            conectar();
             String sql = "update tipomascota set id_mascota = ?, nombre = ?, estado = ?, telefono = ?, estado =  where id_cliente = ?";
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar();
        }
        
    }

    @Override
    public List<TipoMascotaVo> consultar() {
        return null;
    }

    @Override
    public TipoMascotaVo consultar(int id) {
        return null;
    }
    
}
