package tallerweb.sangucheto.controladores;

import org.springframework.stereotype.Controller;
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
public class ControladorSangucheto {
	
	 @ModelAttribute("ingrediente")
	 public Ingrediente getIngredienteObject() {
		 return new Ingrediente();
	 }

	@RequestMapping(path="/sangucheto")
	public ModelAndView irASangucheto(String mensaje, String tipoMensaje){
		// Envia el stock, el sangucheto y un mensaje pasado por parametro a la vista
		ModelMap mm = new ModelMap();
		mm.put("stock", Stock.getInstance().obtenerStock());
		mm.put("sangucheto", Sanguchetto.getInstance());
		mm.put("mensaje", mensaje);
		mm.put("tipoMensaje", tipoMensaje);
		return new ModelAndView("sangucheto", mm);
	}
	
	@RequestMapping(path="/eliminarIngrediente")
	public ModelAndView auxiliarModificacion(){
		return irASangucheto(null, null);
	}
	
	@RequestMapping(path="/agregarIngrediente")
	public ModelAndView auxiliarEliminacion(){
		return irASangucheto(null, null);
	}
	
	@RequestMapping(value="eliminarIngrediente", method=RequestMethod.POST)
	public ModelAndView elminarIngrediente(@ModelAttribute("ingrediente") Ingrediente ingrediente){
		// Obtengo la cantidad del ingrediente que hay en el sangucheto
		Integer cantidad =  Sanguchetto.getInstance().obtenerCantidadDeIngrediente(ingrediente);
		// Restauro el stock de ese ingrediente
		Stock.getInstance().agregarStock(ingrediente, cantidad);
		// Elimino el ingrediente del sangucheto
		Sanguchetto.getInstance().eliminarIngrediente(ingrediente);
		// Muestro un mensaje
		String mensaje = "<strong>Ingrediente Eliminado.</strong> Se ha eliminado el ingrediente " + ingrediente.getNombre();
		mensaje += ". Se ha restaurado el stock en " + cantidad + " unidades";
		return irASangucheto(mensaje, "success");
	}
	
	@RequestMapping(value="agregarIngrediente", method=RequestMethod.POST)
	public ModelAndView agregarIngrediente(@RequestParam("ingredienteAgregado") String nombreIngrediente,
										@RequestParam("cantidad") Integer cantidad){
		// Si la cantidad se envia vacía o es menor a 1 se pone por defecto en 1 
		if(cantidad == null || cantidad < 1)
			cantidad = 1;
		// Se crea el mensaje y se obtiene el ingrediente del stock
		String mensaje = "";
		String tipoMensaje = "success";
		Ingrediente ing = Stock.getInstance().obtenerIngrediente(nombreIngrediente);
		// Se comprueba que haya stock suficiente, en caso afirmativo se resta del stock, caso contrario se muestra mensaje de error
		if(Stock.getInstance().obtenerStockDisponible(ing) >= cantidad){
			Sanguchetto.getInstance().agregarIngrediente(ing, cantidad);
			Stock.getInstance().comprarIngrediente(ing, cantidad);
			mensaje = "<strong>Ingrediente Añadido.</strong> Se agrego una cantidad de " + cantidad + " del ingrediente " + nombreIngrediente;
			
		}else{
			mensaje = "<strong>Stock Insuficiente.</strong> No hay suficiente stock del ingrediente " + nombreIngrediente;
			tipoMensaje = "danger";
		}
		return irASangucheto(mensaje, tipoMensaje);
	}
	
	@RequestMapping(value="comprar")
	public ModelAndView comprar(){
		String mensaje = "";
		String tipoMensaje="success";
		// Si el sangucheto tiene ingredientes (no solo condimentos), se realiza la compra
		if(Sanguchetto.getInstance().verIngredientes().size() > 0)
			return confirmar();
		mensaje="<strong>El Sangucheto no posee ingredientes.</strong> Debe agregar al menos un ingrediente para realizar la compra.";
		tipoMensaje="danger";
		return irASangucheto(mensaje, tipoMensaje);
	}
	
	@RequestMapping(path="/confirmacion")
	public ModelAndView confirmar(){
		ModelMap mm = new ModelMap();
		mm.put("sangucheto", Sanguchetto.getInstance().getIngredientes().clone());
		mm.put("preciofinal", Sanguchetto.getInstance().getPrecioConDescuento());
		Sanguchetto.getInstance().vaciar();
		return new ModelAndView("confirmacion", mm);
	}

}

