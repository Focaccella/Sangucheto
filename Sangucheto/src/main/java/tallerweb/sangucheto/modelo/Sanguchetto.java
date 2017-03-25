package tallerweb.sangucheto.modelo;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Sanguchetto {

	private static Sanguchetto instance = new Sanguchetto();
	private Map<Ingrediente, Integer> ingredientes = new HashMap<>();
	
	private Sanguchetto(){}
	
	public static Sanguchetto getInstance(){
		return instance;
	}
	
	/**
	 * Elimina todos los ingredientes del sanguchetto.<br>
	 */
	public void vaciar(){
		// Implementar
		ingredientes.clear();
	}
	
	/**
	 * Agrega un ingrediente al carrito.<br>
	 * @param ingrediente
	 */
	public void agregarIngrediente(Ingrediente ingrediente, Integer cantidad){
		if(contieneIngrediente(ingrediente))
			ingredientes.put(ingrediente, ingredientes.get(ingrediente) + cantidad);
		else
			ingredientes.put(ingrediente, cantidad);
	}
	
	/**
	 * Obtener los ingredientes
	 */
	public Map<Ingrediente, Integer> getIngredientes(){
		return ingredientes;
	}
	
	
	/**
	 * Lista todos los ingredientes que forman parte del sanguchetto.<br>
	 * @return
	 */
	public Map<Ingrediente, Integer> verIngredientes(){
		// Implementar
		Map<Ingrediente, Integer> soloIngredientes = new HashMap<>();
		for(Ingrediente ingrediente : ingredientes.keySet()){
			if(ingrediente.getTipo().equals(TipoIngrediente.INGREDIENTE)){
				soloIngredientes.put(ingrediente, ingredientes.get(ingrediente));
			}
		}
		return soloIngredientes;
	}
	
	/**
     * Lista todos los condimentos que forman parte del sanguchetto.<br>
     * @return
     */
	public Map<Ingrediente, Integer> verCondimentos(){
		// Implementar
		Map<Ingrediente, Integer> soloCondimentos = new HashMap<>();
		for(Ingrediente ingrediente : ingredientes.keySet()){
			if(ingrediente.getTipo().equals(TipoIngrediente.CONDIMENTO)){
				soloCondimentos.put(ingrediente, ingredientes.get(ingrediente));
			}
		}
		return soloCondimentos;
	}	
	
	/**
	 * Devuelve el precio sin descuento del sanguchetto.<br>
	 * @return
	 */
	public Double getPrecio(){
		// Implementar
		Double precio = 0.0;
		for(Ingrediente ingrediente : ingredientes.keySet()){
			precio += ingrediente.getPrecio() * ingredientes.get(ingrediente);
		}
		return precio;
	}
	
	/**
	 * Devuelve el precio total con descuento del sanguchetto.<br>
	 * @return
	 */
	public Double getPrecioConDescuento(){
		return getPrecio() - getDescuento();
	}
	
	/**
	 * Devuelve el descuento.<br>
	 * @return
	 */
	public Double getDescuento(){
		if(getPrecio() >= 100)
			return getPrecio() * porcentajeDescuento();
		return 0.0;
	}
	
	/**
	 * Devuelve el porcentaje de descuento.<br>
	 * @return
	 */
	private Double porcentajeDescuento(){
		return 0.1; // 10% de descuento
	}
	
	/**
	 * Elimina el ingrediente indicado del Sanguchetto, no importa cual sea la cantidad disponible del mismo.<br>
	 * @param ingrediente
	 * @return true en caso de exito, false si el ingrediente no existe en el Sanguchetto.<br>
	 */
	public Boolean eliminarIngrediente(Ingrediente ingrediente){
		if(!this.ingredientes.containsKey(ingrediente)){
			return false;
		}
		this.ingredientes.remove(ingrediente);
		return true;
	}
	
	/**
	 * Indica si el ingrediente indicado fue incluido en el Sangucheto.<br>
	 * @param ingrediente
	 * @return
	 */
	public Boolean contieneIngrediente(Ingrediente ingrediente){
		return ingredientes.containsKey(ingrediente);
	}
	
	/**
	 * Obtiene la cantidad de un ingrediente en el Sangucheto<br>
	 * @param ingrediente
	 * @return
	 */
	public Integer obtenerCantidadDeIngrediente(Ingrediente ingrediente){
		return ingredientes.get(ingrediente);
	}
	
	
}
