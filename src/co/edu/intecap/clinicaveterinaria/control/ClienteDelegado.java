
package co.edu.intecap.clinicaveterinaria.control;

import co.edu.intecap.clinicaveterinaria.modelo.dao.ClienteDao;
import co.edu.intecap.clinicaveterinaria.modelo.vo.ClienteVo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class ClienteDelegado {
    
    // atributos de clase que son constantes (Su valor como objeto
    // no puede cambiar)
    private final JFrame contenedor;
    private final ClienteDao clienteDao;

    public ClienteDelegado(JFrame contenedor) {
        // asignacion indical del valor de las constantes
        this.contenedor = contenedor;
        this.clienteDao = new ClienteDao();
    }
    public void insertarCliente(ClienteVo clienteVo) {
        try {
            this.clienteDao.insertar(clienteVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void editarCliente(ClienteVo clienteVo) {
        try {
            this.clienteDao.editar(clienteVo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
    }
    public List<ClienteVo> consultarClientes(){
        List <ClienteVo> listaClientes;
        try {
            listaClientes = this.clienteDao.consultar();
        } catch (Exception e) {
            listaClientes = new ArrayList<>();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
        return listaClientes;
    }
    public ClienteVo consultarCliente(int id){
        ClienteVo clienteVo;
        try {
            clienteVo = this.clienteDao.consultar(id);
        } catch (Exception e) {
            clienteVo = new ClienteVo();
            JOptionPane.showMessageDialog(contenedor, e.getMessage(), "Error en insersión", JOptionPane.ERROR_MESSAGE);
        }
        return clienteVo;
    }
}



