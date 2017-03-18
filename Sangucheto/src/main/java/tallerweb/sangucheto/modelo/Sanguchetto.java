package tallerweb.sangucheto.modelo;

import java.util.LinkedList;
import java.util.List;

public class Sanguchetto {

	private static Sanguchetto instance = new Sanguchetto();
	private List<Ingrediente> ingredientes = new LinkedList<>();
	
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
	public void agregarIngrediente(Ingrediente ingrediente){
		// Implementar
		ingredientes.add(ingrediente);
	}
	
	/**
	 * Lista todos los ingredientes que forman parte del sanguchetto.<br>
	 * @return
	 */
	public List<Ingrediente> verIngredientes(){
		// Implementar
		List<Ingrediente> soloIngredientes = new LinkedList<>();
		for(Ingrediente ingrediente : ingredientes){
			if(ingrediente.getTipo().equals(TipoIngrediente.INGREDIENTE)){
				soloIngredientes.add(ingrediente);
			}
		}
		return soloIngredientes;
	}
	
	/**
     * Lista todos los condimentos que forman parte del sanguchetto.<br>
     * @return
     */
    public List<Ingrediente> verCondimentos(){
        // Implementar
		List<Ingrediente> soloCondimentos = new LinkedList<>();
		for(Ingrediente ingrediente : ingredientes){
			if(ingrediente.getTipo().equals(TipoIngrediente.CONDIMENTO)){
				soloCondimentos.add(ingrediente);
			}
		}
		return soloCondimentos;
    }
	
	/**
	 * Devuelve el precio total del sanguchetto.<br>
	 * @return
	 */
	public Double getPrecio(){
		// Implementar
		Double precio = 0.0;
		for(Ingrediente ingrediente : ingredientes){
			precio += ingrediente.getPrecio();
		}
		return precio;
	}
}
