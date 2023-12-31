package modulo2.springbootdi.models.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@SessionScope
public class Factura {

    
    @Autowired
    private Cliente cliente;
    
    @Value("${factura.descripcion}")
    private String descripcion;

    @Autowired
    @Qualifier("itemsFacturaOficina") // tambien se puede usar deafault y marcar default en factura o primary
    private List<ItemFactura> items;
    
    @PostConstruct
    public void inicializar(){
        cliente.setNombre(cliente.getNombre().concat(" ").concat("José"));
        descripcion = descripcion.concat(" del cliente ").concat(cliente.getNombre());
    }

    @PreDestroy
    public void destruir(){
        System.out.println("Factura destruida: ".concat(descripcion));
    }

    

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }
    
    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }


}
