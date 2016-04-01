/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.intecap.clinicaveterinaria.modelo.dao;

import co.edu.intecap.clinicaveterinaria.modelo.conexion.Conexion;
import co.edu.intecap.clinicaveterinaria.modelo.vo.MedicoVo;
import java.util.List;

/**
 *
 * @author INTECAP
 */
public class MedicoDao extends Conexion implements GenericoDao<MedicoVo> {

    @Override
    public void insertar(MedicoVo object) {
        
    }

    @Override
    public void editar(MedicoVo object) {
        
    }

    @Override
    public List<MedicoVo> consultar() {
        return null;
    }

    @Override
    public MedicoVo consultar(int id) {
        return null;
    }
    
}
