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
	public ModelAndView irAStock(String mensaje, String tipoMensaje){
		ModelMap mm = new ModelMap();
		mm.put("stock", Stock.getInstance().obtenerStock());
		mm.put("mensaje", mensaje);
		mm.put("tipoMensaje", tipoMensaje);
		return new ModelAndView("stock", mm);
	}
	
	@RequestMapping(path="/stockModificado")
	public ModelAndView auxiliarModificacion(){
		return irAStock(null, null);
	}
	
	@RequestMapping(path="/ingredienteEliminado")
	public ModelAndView auxiliarEliminacion(){
		return irAStock(null, null);
	}
	
	@RequestMapping(path="/ingredienteAgregado")
	public ModelAndView auxiliarAgregacion(){
		return irAStock(null, null);
	}
	
	@RequestMapping(value="stockModificado", method=RequestMethod.POST)
	public ModelAndView modificarStock(@ModelAttribute("ingrediente")Ingrediente ingrediente, 
			@RequestParam(value="cantidadAIngresar") Integer cantidad ){
		// Se crea el mensaje
		String mensaje = "";
		String tipoMensaje = "success";
		// Se agrega o resta solo si la cantidad es distinta de 0
		if(cantidad != 0){
			Stock.getInstance().agregarStock(ingrediente, cantidad);
			mensaje = "<strong>Ingrediente Actualizado.</strong> El ingrediente se ha actualizado correctamente.";
		}else{
			mensaje = "<strong>Cantidad Inválida.</strong> La cantidad debe ser distinta de 0.";
			tipoMensaje = "warning";
		}
		return irAStock(mensaje, tipoMensaje);
	}
	
	@RequestMapping(value="ingredienteEliminado" , method=RequestMethod.POST)
	public ModelAndView eliminarIngrediente(@ModelAttribute("ingrediente")Ingrediente ingrediente ){
		// Elimino el ingrediente, en caso de ser un ingrediente del Sangucheto también lo elimino del mismo
		Stock.getInstance().eliminarIngrediente(ingrediente);
		Sanguchetto.getInstance().eliminarIngrediente(ingrediente);
		return irAStock("<strong>Ingrediente Eliminado.</strong> El ingrediente " + ingrediente.getNombre() + " se ha eliminado correctamente.", "success");
	}
	
	@RequestMapping(value="ingredienteAgregado", method=RequestMethod.POST)
	public ModelAndView agregarIngrediente(@ModelAttribute("ingrediente")Ingrediente ingrediente, 
			@RequestParam(value="precio", defaultValue="0")Double precio ){
		// Se crea el mensaje
		String mensaje = "";
		String tipoMensaje = "success";
		// Si el ingrediente no tiene nombre no se agrega
		if(ingrediente.getNombre().equals("")){
			mensaje = "<strong>Nombre Inválido.</strong> Debe ingresar un nombre para el ingrediente nuevo.";
			tipoMensaje = "danger";
			return irAStock(mensaje, tipoMensaje);
		}
		// Se le establece el precio
		ingrediente.setPrecio(precio);
		// Si se puede agregar indica un mensaje de exito, caso contrario que ya existia
		if(Stock.getInstance().agregarIngrediente(ingrediente)){
			mensaje = "<strong>Nuevo Ingrediente.</strong> Se ha añadido correctamente el ingrediente " + ingrediente.getNombre() + ".";
		}else{
			mensaje = "<strong>Nombre Inválido.</strong> El nombre especificado para el ingrediente ya existe, por favor elija otro.";
			tipoMensaje = "warning";
		}
		return irAStock(mensaje, tipoMensaje);
	}

}
