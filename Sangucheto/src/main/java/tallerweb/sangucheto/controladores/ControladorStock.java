package tallerweb.sangucheto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Stock;

@Controller
public class ControladorStock {
	
	@RequestMapping(path="/stock")
	public ModelAndView irAStock(){
		ModelMap mm = new ModelMap("stock", Stock.getInstance().obtenerStock());
		return new ModelAndView("stock", mm);
	}
	
	@RequestMapping(path="/stockAgregado", method=RequestMethod.POST)
	public ModelAndView agregarStock(@ModelAttribute("ingrediente")Ingrediente ingrediente){
		
		return null;
	}
}
