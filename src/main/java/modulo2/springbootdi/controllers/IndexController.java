package modulo2.springbootdi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import modulo2.springbootdi.models.service.IServicio;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("MiServicioComplejo") // define un componente a ejecutar por defecto - esta en uso primary
    private IServicio servicio;

    @GetMapping({"/","","/index"})
    public String index(Model model){
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }
}
