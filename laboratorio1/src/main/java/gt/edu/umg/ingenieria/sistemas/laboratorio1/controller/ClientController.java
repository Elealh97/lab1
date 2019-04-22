package gt.edu.umg.ingenieria.sistemas.laboratorio1.controller;

import gt.edu.umg.ingenieria.sistemas.laboratorio1.model.Client;
import gt.edu.umg.ingenieria.sistemas.laboratorio1.service.ReportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 *
 * @author Josué Barillas (jbarillas)
 */
@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ReportService reportService;
    
    @GetMapping("/buscarTodos")
    public List<Client> seleccionartodo(){
        return this.reportService.buscarTodos();
    }
    
    @GetMapping("/buscarPorNit")
    public Client buscarPorNit(String nit){
        return this.reportService.buscarPorNit(nit);
    }
    
    @GetMapping("/buscarPorNombre")
    public Client buscarPorNombre(String firstName){       
        return this.reportService.buscarPorNombre(firstName);
    }
    
        
    @GetMapping("/buscarPorApellido")
    public Client buscarPorApellido(String firstName){       
        return this.reportService.buscarPorApellido(firstName);
    }
    
    @PostMapping("/crearCliente")
    public Client crear(@RequestBody(required = true) Client e1){
        return this.reportService.crearCliente(e1);
    }
    
    @PutMapping("/editarCliente/{id}/{nit}")
    public Client editarCliente(@PathVariable(required = true) long id, @PathVariable(required = true) String nit) throws Exception{
        return this.reportService.editarCliente(id, nit);
    }

    
    @GetMapping("/generarReporteClientes")
    public String reporte(){
        return this.reportService.reporteCliente();
    }
    
    
    
}
