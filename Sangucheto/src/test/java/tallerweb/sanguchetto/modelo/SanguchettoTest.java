package tallerweb.sanguchetto.modelo;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;

import tallerweb.sangucheto.modelo.Ingrediente;
import tallerweb.sangucheto.modelo.Sanguchetto;
import tallerweb.sangucheto.modelo.Stock;
import tallerweb.sangucheto.modelo.TipoIngrediente;

public class SanguchettoTest {

    @Test
    public void testVaciar() {
    	// Vacio el Sanguchetto
    	Sanguchetto.getInstance().vaciar();
    	// Se agregan ingredientes al Sanguchetto
        Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("Mayonesa", 2.0, TipoIngrediente.CONDIMENTO), 2);
        Sanguchetto.getInstance().agregarIngrediente(new Ingrediente("Jamón", 20.0, TipoIngrediente.INGREDIENTE), 2);
        // Se comprueba que posea ingredientes
        assertTrue(Sanguchetto.getInstance().getIngredientes().size() > 0);
        // Se vacia
        Sanguchetto.getInstance().vaciar();
        // Se comprueba que esté vacio
        assertTrue(Sanguchetto.getInstance().getIngredientes().size() == 0);
    }

    @Test
    public void testAgregarIngrediente() {
    	// Vacio el Sanguchetto
    	Sanguchetto.getInstance().vaciar();
        // Se agrega un ingrediente al Sanguchetto
    	Ingrediente ingrediente = new Ingrediente("Jamón", 20.0, TipoIngrediente.INGREDIENTE);
    	Sanguchetto.getInstance().agregarIngrediente(ingrediente, 2);
    	// Se comprueba que lo contenga
    	assertTrue(Sanguchetto.getInstance().contieneIngrediente(ingrediente));
    }

    @Test
    public void testVerIngredientes() {
    	// Vacio el Sanguchetto
    	Sanguchetto.getInstance().vaciar();
        // Agrego ingredientes y condimentos al Sanguchetto
    	Ingrediente ingrediente1 = new Ingrediente("Jamón", 20.0, TipoIngrediente.INGREDIENTE);
    	Ingrediente ingrediente2 = new Ingrediente("Pollo", 20.0, TipoIngrediente.INGREDIENTE);
    	Ingrediente condimento1 = new Ingrediente("Mayonesa", 2.0, TipoIngrediente.CONDIMENTO);
    	Ingrediente condimento2 = new Ingrediente("Mostaza", 2.0, TipoIngrediente.CONDIMENTO);
    	Ingrediente condimento3 = new Ingrediente("Ketchup", 2.0, TipoIngrediente.CONDIMENTO);
    	Sanguchetto.getInstance().agregarIngrediente(ingrediente1, 5);
    	Sanguchetto.getInstance().agregarIngrediente(ingrediente2, 2);
    	Sanguchetto.getInstance().agregarIngrediente(condimento1, 3);
    	Sanguchetto.getInstance().agregarIngrediente(condimento2, 7);
    	Sanguchetto.getInstance().agregarIngrediente(condimento3, 1);
    	// Obtengo solo los ingredientes
    	Map<Ingrediente, Integer> soloIngredientes = Sanguchetto.getInstance().verIngredientes();
    	// Compruebo que sean 2 y que sean el ingrediente1 e ingrediente2
    	assertTrue(soloIngredientes.size() == 2);
    	assertTrue(soloIngredientes.containsKey(ingrediente1));
    	assertTrue(soloIngredientes.containsKey(ingrediente2));
    }

    @Test
    public void testVerCondimentos() {
    	// Vacio el Sanguchetto
    	Sanguchetto.getInstance().vaciar();
        // Agrego ingredientes y condimentos al Sanguchetto
    	Ingrediente ingrediente1 = new Ingrediente("Jamón", 20.0, TipoIngrediente.INGREDIENTE);
    	Ingrediente ingrediente2 = new Ingrediente("Pollo", 20.0, TipoIngrediente.INGREDIENTE);
    	Ingrediente condimento1 = new Ingrediente("Mayonesa", 2.0, TipoIngrediente.CONDIMENTO);
    	Ingrediente condimento2 = new Ingrediente("Mostaza", 2.0, TipoIngrediente.CONDIMENTO);
    	Ingrediente condimento3 = new Ingrediente("Ketchup", 2.0, TipoIngrediente.CONDIMENTO);
    	Sanguchetto.getInstance().agregarIngrediente(ingrediente1, 5);
    	Sanguchetto.getInstance().agregarIngrediente(ingrediente2, 2);
    	Sanguchetto.getInstance().agregarIngrediente(condimento1, 3);
    	Sanguchetto.getInstance().agregarIngrediente(condimento2, 7);
    	Sanguchetto.getInstance().agregarIngrediente(condimento3, 1);
    	// Obtengo solo los condimentos
    	Map<Ingrediente, Integer> soloCondimentos = Sanguchetto.getInstance().verCondimentos();
    	// Compruebo que sean 3 y que sean el condimento1, condimento2 y condimento3
    	assertTrue(soloCondimentos.size() == 3);
    	assertTrue(soloCondimentos.containsKey(condimento1));
    	assertTrue(soloCondimentos.containsKey(condimento2));
    	assertTrue(soloCondimentos.containsKey(condimento3));
    }

    @Test
    public void testGetPrecio() {
    	// Vacio el Sanguchetto
    	Sanguchetto.getInstance().vaciar();
        // Agrego ingredientes y condimentos al Sanguchetto
    	Ingrediente ingrediente1 = new Ingrediente("Jamón", 20.0, TipoIngrediente.INGREDIENTE);
    	Ingrediente ingrediente2 = new Ingrediente("Pollo", 20.0, TipoIngrediente.INGREDIENTE);
    	Ingrediente condimento1 = new Ingrediente("Mayonesa", 2.0, TipoIngrediente.CONDIMENTO);
    	Ingrediente condimento2 = new Ingrediente("Mostaza", 2.0, TipoIngrediente.CONDIMENTO);
    	Ingrediente condimento3 = new Ingrediente("Ketchup", 2.0, TipoIngrediente.CONDIMENTO);
    	Sanguchetto.getInstance().agregarIngrediente(ingrediente1, 5);
    	Sanguchetto.getInstance().agregarIngrediente(ingrediente2, 2);
    	Sanguchetto.getInstance().agregarIngrediente(condimento1, 3);
    	Sanguchetto.getInstance().agregarIngrediente(condimento2, 7);
    	Sanguchetto.getInstance().agregarIngrediente(condimento3, 1);
    	// Obtengo el precio, debe ser $162
    	assertTrue(Sanguchetto.getInstance().getPrecio() == 162.0);
    }

}
