import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private ItemFactura[] items;
    private static final int MAX_ITEMS = 10;
    private static int ultimoFolio = 1;
    private int indiceItems = 0;

    // Constructor
    public Factura(String descripcion, Cliente cliente) {
        this.folio = ultimoFolio++;
        this.descripcion = descripcion;
        this.fecha = new Date(); // Fecha actual
        this.cliente = cliente;
        this.items = new ItemFactura[MAX_ITEMS];
    }

    // Métodos
    public void addItemFactura(ItemFactura item) {
        if (indiceItems < MAX_ITEMS) {
            this.items[indiceItems++] = item;
        } else {
            System.out.println("No se pueden agregar más ítems a la factura.");
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemFactura item : items) {
            if (item != null) {
                total += item.calcularImporte();
            }
        }
        return total;
    }

    public String generarDetalle() {
        StringBuilder sb = new StringBuilder("Factura Nº: ");
        sb.append(folio)
                .append("\nCliente: ")
                .append(cliente.getNombre())
                .append("\tNIF: ")
                .append(cliente.getNif())
                .append("\nDescripción: ")
                .append(descripcion)
                .append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd 'de' MMMM, yyyy");
        sb.append("Fecha Emisión: ")
                .append(df.format(fecha))
                .append("\n\n#\tNombre\tPrecio\tCant.\tTotal\n");

        for (int i = 0; i < indiceItems; i++) {
            sb.append(i + 1)
                    .append("\t")
                    .append(items[i])
                    .append("\n");
        }

        sb.append("\nGran Total: ").append(calcularTotal());
        return sb.toString();
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}