package tallerweb.sangucheto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.Stock;

@Controller
public class ControladorSangucheto {
	
	 @ModelAttribute("ingrediente")
	 public Ingrediente getIngredienteObject() {
		 return new Ingrediente();
	 }

	@RequestMapping(path="/sangucheto")
	public ModelAndView irASangucheto(){
		ModelMap mm = new ModelMap();
		mm.put("stock", Stock.getInstance().obtenerStock());
		mm.put("sangucheto", Sanguchetto.getInstance());
		return new ModelAndView("sangucheto", mm);
	}
	
	@RequestMapping(value="eliminarIngrediente", method=RequestMethod.POST)
	public ModelAndView elminarIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente){
		Sanguchetto.getInstance().eliminarIngrediente(ingrediente);
		ModelMap mm = new ModelMap();
		mm.put("stock", Stock.getInstance().obtenerStock());
		mm.put("sangucheto", Sanguchetto.getInstance());
		return new ModelAndView("sangucheto", mm);
	}
}

