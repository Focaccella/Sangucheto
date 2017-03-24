package tallerweb.sangucheto.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.Stock;

@Controller
public class ControladorStock {
	
	 @ModelAttribute("ingrediente")
	 public Ingrediente getIngredienteObject() {
		 return new Ingrediente();
	 }
	
	@RequestMapping(path="/stock")
	public ModelAndView irAStock(){
		ModelMap mm = new ModelMap("stock", Stock.getInstance().obtenerStock());		
		return new ModelAndView("stock", mm);
	}
	
	@RequestMapping(path="/stockModificado")
	public ModelAndView auxiliarModificacion(){
		return irAStock();
	}
	
	@RequestMapping(path="/IngredienteEliminado")
	public ModelAndView auxiliarEliminacion(){
		return irAStock();
	}
	
	@RequestMapping(path="/IngredienteAgregado")
	public ModelAndView auxiliarAgregacion(){
		return irAStock();
	}
	
	@RequestMapping(value="stockModificado", method=RequestMethod.POST)
	public ModelAndView modificarStock(@ModelAttribute("ingrediente")Ingrediente ingrediente, @RequestParam(value="cantidadAIngresar") Integer cantidad ){
		if(cantidad != 0)
			Stock.getInstance().agregarStock(ingrediente, cantidad);
		return irAStock();
	}
	
	@RequestMapping(value="IngredienteEliminado" , method=RequestMethod.POST)
	public ModelAndView eliminarIngrediente(@ModelAttribute("ingrediente")Ingrediente ingrediente ){
		// Elimino el ingrediente, en caso de ser un ingrediente del Sangucheto tambi�n lo elimino del mismo
		Stock.getInstance().eliminarIngrediente(ingrediente);
		Sanguchetto.getInstance().eliminarIngrediente(ingrediente);
		return irAStock();
	}
	
	@RequestMapping(value="IngredienteAgregado", method=RequestMethod.POST)
	public ModelAndView agregarIngrediente(@ModelAttribute("ingrediente")Ingrediente ingrediente, @RequestParam(value="precio", defaultValue="0")Integer precio ){
		if(ingrediente.getNombre().equals(""))
			ingrediente.setNombre("Unnamed");
		ModelMap model = new ModelMap();
		ingrediente.setPrecio(precio.doubleValue());
		Stock.getInstance().agregarIngrediente(ingrediente);
		return irAStock();
	}

}
