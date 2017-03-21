package tallerweb.sangucheto.modelo;

public class Ingrediente {

    private String nombre;
    private Double precio;
    private TipoIngrediente tipo;
    
    public Ingrediente(String nombre, Double precio, TipoIngrediente tipo){
    	this.nombre = nombre;
    	this.precio = precio;
    	this.tipo = tipo;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    public TipoIngrediente getTipo() {
        return tipo;
    }
    public void setTipo(TipoIngrediente tipo) {
        this.tipo = tipo;
    }
}
