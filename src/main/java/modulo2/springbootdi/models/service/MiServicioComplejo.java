package modulo2.springbootdi.models.service;

import org.springframework.stereotype.Component;

@Component("MiServicioComplejo")
public class MiServicioComplejo implements IServicio{

    @Override
    public String operacion(){
        return "ejecutando algun proceso importante complicado ...";
    }
}
