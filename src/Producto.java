public class Producto {
    private String codigo;
    private String nombre;
    private double precio;
    private static int ultimoCodigo = 1; // Código único incremental

    // Constructor que asigna automáticamente el código
    public Producto(String nombre, double precio) {
        this.codigo = "P" + ultimoCodigo++;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return codigo + "\t" + nombre + "\t" + precio;
    }
}