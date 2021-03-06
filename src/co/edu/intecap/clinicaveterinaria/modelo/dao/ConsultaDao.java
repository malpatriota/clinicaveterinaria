/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.modelo.dao;

import co.edu.intecap.clinicaveterinaria.modelo.conexion.Conexion;
import co.edu.intecap.clinicaveterinaria.modelo.vo.ConsultaVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INTECAP
 */
public class ConsultaDao extends Conexion implements GenericoDao<ConsultaVo> {

    @Override
    public void insertar(ConsultaVo object) {
        PreparedStatement sentencia = null;
        try {
            conectar();
            String sql = "insert into consulta(fecha,motivo,descripcion,estado,id_medico,id_historia) values(?,?,?,?,?,?)";
            sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            sentencia.setDate(1, object.getFecha());
            sentencia.setString(2,object.getMotivo());
            sentencia.setString(3, object.getDescripcion());
            sentencia.setBoolean(4, object.isEstado());
            sentencia.setInt(5, object.getIdMedico());
            sentencia.setInt(6, object.getIdHistoria());
            sentencia.executeUpdate();
            ResultSet rs = sentencia.getGeneratedKeys();
            if (rs.next()) {
                object.setIdConsulta(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar();
        }        
    }

    @Override
    public void editar(ConsultaVo object) {
        PreparedStatement sentencia;
        
        try {
            conectar();
            String sql = "update consulta set id_consulta, fecha, motivo, descripcion, estado, id_medico, id_historia, where id_consulta = ? ";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setDate(1, object.getFecha());
            sentencia.setString(2, object.getDescripción());
            sentencia.setBoolean(3, object.isEstado());
            sentencia.setInt(4, object.getIdMedico());
            sentencia.setInt(5, object.getIdHistoria());
            sentencia.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar();
        }
        
    }

    @Override
    public List<ConsultaVo> consultar() {
            PreparedStatement sentencia;
            List<ConsultaVo> lista = new ArrayList<>();
        try {
            conectar();
            String sql = "select * from consulta";
            sentencia = cnn.prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
            ConsultaVo consulta = new ConsultaVo();
            consulta.setIdConsulta(rs.getInt("id_consulta"));
            consulta.setFecha(rs.getDate("fecha"));
            consulta.setMotivo(rs.getString("motivo"));
            consulta.setDescripción(rs.getString("descripcion"));
            consulta.isEstado(rs.getBoolean("estado"));
            consulta.setIdMedico(rs.getInt("id_medico"));
            consulta.setIdHistoria(rs.getInt("id_historia"));
            lista.add(consulta);
                       }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar();
        }
        return lista;
    }

    @Override
    public ConsultaVo consultar(int id) {
        PreparedStatement sentencia;
        ConsultaVo obj = new ConsultaVo();
        try {
            conectar();
            String sql = "select * from consulta where = id_consulta = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                obj.setIdConsulta(rs.getInt("id_consulta"));
                obj.setFecha(rs.getDate("fecha"));
                obj.setMotivo(rs.getString("motivo"));
                obj.setDescripcion(rs.getString("descripcion"));
                obj.setEstado(rs.getBoolean("estado"));
                obj.setIdCliente(rs.getInt("id_cliente"));
                obj.setIdHistoria(rs.getInt("id_historia"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar();
        }
        return obj;
    }
    
    
    
}
