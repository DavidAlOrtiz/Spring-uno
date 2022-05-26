package mx.edu.app.uno.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/parametros")
public class ParametrosControle {

    @GetMapping("/string")
    public String param(@RequestParam(name = "texto", required = false, defaultValue = "Valor default") String texto,
            Model model) {
        model.addAttribute("resultado", "La cadena que se envio fue :" + texto);
        model.addAttribute("titulo", "Utilizando un requestParam");
        return "parametro/ver";

    }

    @GetMapping("/")
    public String index() {
        return "parametro/index";
    }

    @GetMapping("/mixto")
    public String para(@RequestParam String saludo, @RequestParam Integer numero, Model model) {
        model.addAttribute("titulo", "Utilizando un requestParam");
        model.addAttribute("resultado", "La cadena que se envio fue :" + saludo + " " + numero);
        return "parametro/ver";
    }

    @GetMapping("/request")
    public String param(HttpServletRequest request, Model model) {
        String saludo = request.getParameter("saludo");
        Integer numero;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            // TODO: handle exception
            numero = 0;
        }
        model.addAttribute("titulo", "Utilizando un requestParam");
        model.addAttribute("resultado", "La cadena que se envio fue :" + saludo + " " + numero);
        return "parametro/ver";
    }

}
