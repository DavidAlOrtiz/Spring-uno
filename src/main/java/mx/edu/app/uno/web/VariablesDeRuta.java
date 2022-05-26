package mx.edu.app.uno.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VariablesDeRuta {

    @GetMapping("/")
    public String index() {
        return "variables/index";
    }

    //
    @GetMapping("/string/{texto}")
    public String variables(@PathVariable String texto, Model model) {
        model.addAttribute("titulo", "recibe los objetos de un path");
        model.addAttribute("resultado", "El valor enviado es " + texto);
        return "variables/mostrar";
    }

    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto, @PathVariable int numero, Model model) {
        model.addAttribute("titulo", "enviar datos los objetos de un path");
        model.addAttribute("resultado", "El valor enviado es " + texto + "" + "Tu numero" + numero);
        return "variables/mostrar";
    }
}
