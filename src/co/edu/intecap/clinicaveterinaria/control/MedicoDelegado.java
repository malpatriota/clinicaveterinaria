
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.modelo.dao.MedicoDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.MedicoVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class MedicoDelegado {
    
    // atributos de clase que son constantes (Su valor como objeto
    // no puede cambiar)
    private final JFrame contenedor;
    private final MedicoDao medicoDao;

    public MedicoDelegado(JFrame contenedor) {
        // asignacion indical del valor de las constantes
        this.contenedor = contenedor;
        this.medicoDao = new MedicoDao();
    }
    public void insertarMedico(MedicoVo consultaVo) {
        try {
            this.medicoDao.insertar(consultaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarMedico(MedicoVo consultaVo) {
        try {
            this.medicoDao.editar(consultaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
    }
    public List<MedicoVo> consultarMedico(){
        List <MedicoVo> listaMedico;
        try {
            listaMedico = this.medicoDao.consultar();
        } catch (Exception e) {
            listaMedico = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
        return listaMedico;
    }
    public MedicoVo consultarMedico(int id){
        MedicoVo consultaVo;
        try {
            consultaVo = this.medicoDao.consultar(id);
        } catch (Exception e) {
            consultaVo = new MedicoVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
        return consultaVo;
    }
}