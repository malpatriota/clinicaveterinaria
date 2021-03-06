/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.modelo.dao;

import co.edu.intecap.clinicaveterinaria.modelo.conexion.Conexion;
import co.edu.intecap.clinicaveterinaria.modelo.vo.HistoriaVo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INTECAP
 */
public class HistoriaDao extends Conexion implements GenericoDao<HistoriaVo> {

    @Override
    public void insertar(HistoriaVo object) {
        PreparedStatement sentencia = null;
        try {
        conectar();
        String sql = "insert into historia(fecha_apertura,fecha_cierre,estado,id_mascota) values(?,?,?,?,?)";
        sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        sentencia.setDate(1, object.getFechaApertura());
        sentencia.setDate(2, object.getFechaCierre());
        sentencia.setBoolean(3, object.isEstado());
        sentencia.setInt(4, object.getIdHistoria());
        sentencia.executeUpdate();
        ResultSet rs = sentencia.getGeneratedKeys();
            if (rs.next()) {
                object.getIdHistoria(rs.getInt(1));
            }
        } catch (Exception e) {
        e.printStackTrace(System.err);
        } finally {
        desconectar();
        }
    }

    @Override
    public void editar(HistoriaVo object) {
        PreparedStatement sentencia;
        List<HistoriaVo> lista = new ArrayList<>();
        try {
            conectar();
            String sql = "update historia set id_historia = ?, id_historia = ?, fecha_apertura = ?, fecha_cierre = ?, estado = ?, where id_historia = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setDate(1, object.getFechaApertura());
            sentencia.setDate(2, object.getFechaCierre());
            sentencia.setBoolean(3, object.isEstado());
            sentencia.setInt(4, object.getIdMascota());
            sentencia.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar();
        }
    }

    @Override
    public List<HistoriaVo> consultar() {
        PreparedStatement sentencia;
        List <HistoriaVo> lista = new ArrayList<>();
        try {
          conectar();
          String sql = "select * from historia";
          sentencia = cnn.prepareStatement(sql);
          ResultSet rs = sentencia.executeQuery(); 
          while (rs.next()) {                
          HistoriaVo historia = new HistoriaVo();
                    
          historia.setFechaApertura(rs.getDate("fecha_apertura"));
          historia.setFechaCierre(rs.getDate("fecha_cierre"));
          historia.setEstado(rs.getBoolean("estado"));
          historia.setIdMascota(rs.getInt("mascota"));
          lista.add(historia);
            }
          
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar();
        }
        return lista;
    }

    @Override
    public HistoriaVo consultar(int id) {
        PreparedStatement sentencia;
        HistoriaVo obj = new HistoriaVo();
        try {
        conectar();    
        String sql = "select * from mascota where = id_historia = ?";
        sentencia = cnn.prepareStatement(sql);
        sentencia.setInt(1, id);
        ResultSet rs = sentencia.executeQuery(); 
            if (rs.next()) {
                obj.setIdHistoria(rs.getInt("historia"));
                obj.setFechaApertura(rs.getDate("fecha_apertura"));
                obj.setFechaCierre(rs.getDate("fecha_cierre"));
                obj.setEstado(rs.getBoolean("estado"));
                obj.setIdMascota(rs.getInt("id_mascota"));
            }
        } catch (Exception e) {
        e.printStackTrace(System.err);
        } finally {
        desconectar();    
        }
    return obj;
    }   
}
