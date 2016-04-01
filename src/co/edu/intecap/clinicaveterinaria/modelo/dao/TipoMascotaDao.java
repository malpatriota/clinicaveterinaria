/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.modelo.dao;

import co.edu.intecap.clinicaveterinaria.modelo.conexion.Conexion;
import co.edu.intecap.clinicaveterinaria.modelo.vo.TipoMascotaVo;
import java.util.List;

/**
 *
 * @author INTECAP
 */
public class TipoMascotaDao extends Conexion implements GenericoDao<TipoMascotaVo> {

    @Override
    public void insertar(TipoMascotaVo object) {
        
    }

    @Override
    public void editar(TipoMascotaVo object) {
        
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
