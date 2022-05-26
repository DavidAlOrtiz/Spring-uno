package mx.edu.app.uno.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mx.edu.app.uno.web.models.Usuario;

@Controller
@RequestMapping("/app")
public class controladorUno {

	@GetMapping("/")
	public String inicio(Model model) {
		model.addAttribute("titulo", "Hola mundo desde un atributo");
		return "index";
	}

	@GetMapping("/home")
	public String contacto(ModelMap atributo) {
		atributo.addAttribute("atr", "Atributo desde un modelMap ");
		return "home";
	}

	@GetMapping("/contacto")
	public String contacto(Map<String, Object> map) {
		map.put("correo", "dva@gmail.com");
		return "contacto";
	}

	@GetMapping("/datos")
	public ModelAndView datos(ModelAndView mv) {
		mv.addObject("datoPersonal", "curso de esprin boot basico");
		mv.setViewName("datos");
		return mv;
	}

	@GetMapping("/perfil")
	public String perfil(Model model) {
		Usuario user = new Usuario();
		user.setNombre("Juan");
		user.setApellidoPaterno("Lopez");
		user.setApellidoMaterno("apellidoMaterno");
		user.setEmail("email@gmail.com");
		model.addAttribute("usuario", user);
		model.addAttribute("titulo",
				user.getNombre() + "" + user.getApellidoPaterno() + "" + user.getApellidoMaterno());
		return "perfil";
	}

	@GetMapping("/listar")
	public String listar(Model model) {

		Usuario user = new Usuario();
		user.setNombre("Juan");
		user.setApellidoPaterno("Lopez");
		user.setApellidoMaterno("apellidoMaterno");
		user.setEmail("email@gmail.com");
		model.addAttribute("usuario", user);
		model.addAttribute("titulo",
				user.getNombre() + "" + user.getApellidoPaterno() + "" + user.getApellidoMaterno());
		List<Usuario> usuarios = new ArrayList<Usuario>();
		usuarios.add(user);
		usuarios.add(new Usuario("Juan", "Lopez", "Perez", "Lian@gmaol.com"));

		usuarios.add(new Usuario("Juan2", "Lopez2", "Perez2", "Lian2@gmaol.com"));

		usuarios.add(new Usuario("Juan4", "Lopez3", "Perez3", "Lian3@gmaol.com"));
		usuarios.add(new Usuario("Juan5", "Lopez3", "Perez3", "Lian3@gmaol.com"));
		usuarios.add(new Usuario("Juan6", "Lopez3", "Perez3", "Lian3@gmaol.com"));

		model.addAttribute("usuarios", usuarios);
		return "listar";
	}

	@ModelAttribute("usuarios")
	public List<Usuario> agregarUsuarios() {
		List<Usuario> usuarios = Arrays.asList(new Usuario("Juan6", "Lopez3", "Perez3", "Lian3@gmaol.com"),
				new Usuario("Juan6", "Lopez3", "Perez3", "Lian3@gmaol.com"),
				new Usuario("Juan6", "Lopez3", "Perez3", "Lian3@gmaol.com"),
				new Usuario("Juan6", "Lopez3", "Perez3", "Lian3@gmaol.com"),
				new Usuario("Juan6", "Lopez3", "Perez3", "Lian3@gmaol.com"));
		return usuarios;

	}

	@GetMapping("/mostrar")
	public String mostrar(Model model) {

		return "mostrar";
	}

}
