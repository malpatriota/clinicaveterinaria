
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.modelo.dao.ConsultaDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.ConsultaVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ConsultaDelegado {
    
    // atributos de clase que son constantes (Su valor como objeto
    // no puede cambiar)
    private final JFrame contenedor;
    private final ConsultaDao consultaDao;

    public ConsultaDelegado(JFrame contenedor) {
        // asignacion indical del valor de las constantes
        this.contenedor = contenedor;
        this.consultaDao = new ConsultaDao();
    }
    public void insertarConsulta(ConsultaVo consultaVo) {
        try {
            this.consultaDao.insertar(consultaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarConsulta(ConsultaVo consultaVo) {
        try {
            this.consultaDao.editar(consultaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
    }
    public List<ConsultaVo> consultarConsulta(){
        List <ConsultaVo> listaConsulta;
        try {
            listaConsulta = this.consultaDao.consultar();
        } catch (Exception e) {
            listaConsulta = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
        return listaConsulta;
    }
    public ConsultaVo consultarConsulta(int id){
        ConsultaVo consultaVo;
        try {
            consultaVo = this.consultaDao.consultar(id);
        } catch (Exception e) {
            consultaVo = new ConsultaVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
        return consultaVo;
    }
}
