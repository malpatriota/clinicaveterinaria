
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.modelo.dao.HistoriaDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.HistoriaVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


public class HistoriaDelegado {
    
    // atributos de clase que son constantes (Su valor como objeto
    // no puede cambiar)
    private final JPanel contenedor;
    private final HistoriaDao historiaDao;

    public HistoriaDelegado(JPanel contenedor) {
        // asignacion indical del valor de las constantes
        this.contenedor = contenedor;
        this.historiaDao = new HistoriaDao();
    }
    public void insertarHistoria(HistoriaVo consultaVo) {
        try {
            this.historiaDao.insertar(consultaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarHistoria(HistoriaVo consultaVo) {
        try {
            this.historiaDao.editar(consultaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
    }
    public List<HistoriaVo> consultarHistoria(){
        List <HistoriaVo> listaHistoria;
        try {
            listaHistoria = this.historiaDao.consultar();
        } catch (Exception e) {
            listaHistoria = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
        return listaHistoria;
    }
    public HistoriaVo consultarHistoria(int id){
        HistoriaVo consultaVo;
        try {
            consultaVo = this.historiaDao.consultar(id);
        } catch (Exception e) {
            consultaVo = new HistoriaVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
        return consultaVo;
    }
}