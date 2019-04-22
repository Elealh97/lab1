package gt.edu.umg.ingenieria.sistemas.laboratorio1.service;
import java.util.List;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.dao.ClientRepository;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Josué Barillas (jbarillas)
 */
@Service
public class ReportService {
    @Autowired
    private ClientRepository clienterepo;

    public List<Client> buscarTodos(){
        List<Client> lista = (List<Client>) this.clienterepo.findAll();
        return lista;
    }
    
    public Client buscarPorNit(String nit){
        Client e1 = this.clienterepo.findClientByNit(nit);
        return e1;
    }
    
    public Client buscarPorNombre(String firstName){
        Client e1 = (Client) this.clienterepo.findByName(firstName);
        return e1;
    }
    
      public Client buscarPorApellido(String lastName){
        Client e1 = (Client) this.clienterepo.findByName(lastName);
        return e1;
    }
    
    public Client crearCliente(Client e1){
        return this.clienterepo.save(e1);
    }  
    
    public Client editarCliente(Long id, String nit){
        Client e1 = this.clienterepo.findById(id).get();
        e1.setNit(nit);
        return this.clienterepo.save(e1);
    }
     
    
    public String reporteCliente(){

        List<Client> lista = (List<Client>) this.clienterepo.findAll();
        StringBuilder s1= new StringBuilder();
        s1.append("firstName \t LastName \t phone \t address");
        for (Client e1 : lista){
            s1.append(e1.getFirstName());
            s1.append("\t");
            s1.append(e1.getLastName());
            s1.append("\t");
            s1.append(e1.getPhone());
            s1.append("\t");
            s1.append(e1.getAddress());
            s1.append("\n");
        }
    return "Se creo el reporte";
    }    

}

