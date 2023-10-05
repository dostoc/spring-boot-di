package modulo2.springbootdi;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import modulo2.springbootdi.models.domain.ItemFactura;
import modulo2.springbootdi.models.domain.Producto;
import modulo2.springbootdi.models.service.IServicio;
import modulo2.springbootdi.models.service.MiServicio;
import modulo2.springbootdi.models.service.MiServicioComplejo;

@Configuration
public class AppConfig {
    
    @Bean("miServicioSimple")
    @Primary
    public IServicio registarMiServicio(){
        return new MiServicio();
    }

    @Bean("miServicioSecundario")
    public IServicio registarMiServicioComplejo(){
        return new MiServicioComplejo();
    }

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems(){
        Producto producto1 = new Producto("Camara Sony", 100f);
        Producto producto2 = new Producto("Bicicleta Bianchi", 200f);
        Producto producto3 = new Producto("Pelopincho", 1500f);

        ItemFactura linea1 = new ItemFactura(producto1, 1);
        ItemFactura linea2 = new ItemFactura(producto2, 2);
        ItemFactura linea3 = new ItemFactura(producto3, 3);

        return Arrays.asList(linea1, linea2, linea3);
    }
}