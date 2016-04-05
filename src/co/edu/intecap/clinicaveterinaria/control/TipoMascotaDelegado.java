
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.modelo.dao.TipoMascotaDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.TipoMascotaVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.JOptionPane;


public class TipoMascotaDelegado {
    
    // atributos de clase que son constantes (Su valor como objeto
    // no puede cambiar)
    private final JPanel contenedor;
    private final TipoMascotaDao tipoMascotaDao;

    public TipoMascotaDelegado(JPanel contenedor) {
        // asignacion indical del valor de las constantes
        this.contenedor = contenedor;
        this.tipoMascotaDao = new TipoMascotaDao();
    }
    public void registrarTipoMascota(TipoMascotaVo consultaVo) {
        try {
            this.tipoMascotaDao.insertar(consultaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarTipoMascota(TipoMascotaVo consultaVo) {
        try {
            this.tipoMascotaDao.editar(consultaVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
    }
    public List<TipoMascotaVo> consultarTipoMascota(){
        List <TipoMascotaVo> listaTipoMascota;
        try {
            listaTipoMascota = this.tipoMascotaDao.consultar();
        } catch (Exception e) {
            listaTipoMascota = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
        return listaTipoMascota;
    }
    public TipoMascotaVo consultarTipoMascota(int id){
        TipoMascotaVo consultaVo;
        try {
            consultaVo = this.tipoMascotaDao.consultar(id);
        } catch (Exception e) {
            consultaVo = new TipoMascotaVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
        return consultaVo;
    }
}