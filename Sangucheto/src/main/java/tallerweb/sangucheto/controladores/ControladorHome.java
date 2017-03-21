package tallerweb.sangucheto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Stock;

@Controller
public class ControladorHome {

	@RequestMapping(path="/")
	public ModelAndView irAHome(){
		return new ModelAndView("home");
	}
	
	@RequestMapping(path="/stock")
	public ModelAndView irAStock(){
		ModelMap mm = new ModelMap("stock", Stock.getInstance().obtenerStock());
		return new ModelAndView("stock", mm);
	}
}
