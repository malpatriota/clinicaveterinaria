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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author INTECAP
 */
public class TipoMascotaDao extends Conexion implements GenericoDao<TipoMascotaVo> {

    @Override
    public void insertar(TipoMascotaVo object) {
        PreparedStatement sentencia = null;
        try {
            conectar();
            String sql = "insert into tipo_mascota (nombre,estado) values(?,?)";
            sentencia = cnn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

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
            desconectar();
        }
    }

    @Override
    public void editar(TipoMascotaVo object) {
        PreparedStatement sentencia;
        try {
            conectar();
            String sql = "update tipo_mascota set id_tipo_mascota = ?, nombre = ?, estado =  where id_tipo_mascota = ?";
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar();
        }

    }

    @Override
    public List<TipoMascotaVo> consultar() {
        PreparedStatement sentencia;
        List<TipoMascotaVo> listaTipoMascota = new ArrayList<>();
        try {
            conectar();
            String sql = "select * from tipo_mascota";
            sentencia = cnn.prepareStatement(sql);
            ResultSet rs = sentencia.executeQuery();
            while (rs.next()) {
                TipoMascotaVo tipoMascotaVo = new TipoMascotaVo();
                tipoMascotaVo.setIdTipoMascota(rs.getInt("id_tipo_mascota"));
                tipoMascotaVo.setNombre(rs.getString("nombre"));
                tipoMascotaVo.setEstado(rs.getBoolean("estado"));
                listaTipoMascota.add(tipoMascotaVo);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar();
        }
        return listaTipoMascota;
    }

    @Override
    public TipoMascotaVo consultar(int id) {
        PreparedStatement sentencia;
        TipoMascotaVo obj = new TipoMascotaVo();
        try {
            conectar();
            String sql = "select * from tipo_mascota where = id_tipo_mascota = ?";
            sentencia = cnn.prepareStatement(sql);
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                obj.setIdTipoMascota(rs.getInt("id_tipo_mascota"));
                obj.setNombre(rs.getString("nombre"));
                obj.setEstado(rs.getBoolean("estado"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            desconectar();
        }
        return obj;
    }
}
