import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Creación de cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = s.nextLine();
        System.out.print("Ingrese el NIF del cliente: ");
        String nifCliente = s.nextLine();
        Cliente cliente = new Cliente(nombreCliente, nifCliente);

        // Creación de factura
        System.out.print("Ingrese una descripción de la factura: ");
        String descFactura = s.nextLine();
        Factura factura = new Factura(descFactura, cliente);

        // Agregar productos a la factura
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrese nombre del producto: ");
            String nombreProducto = s.nextLine();
            System.out.print("Ingrese el precio del producto: ");
            double precioProducto = s.nextDouble();
            System.out.print("Ingrese la cantidad del producto: ");
            int cantidadProducto = s.nextInt();
            s.nextLine();  // Consumir nueva línea

            Producto producto = new Producto(nombreProducto, precioProducto);
            ItemFactura item = new ItemFactura(producto, cantidadProducto);
            factura.addItemFactura(item);
        }

        // Mostrar la factura completa
        System.out.println(factura);
    }
}
