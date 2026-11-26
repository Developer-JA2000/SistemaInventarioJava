/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventario;

/**
 *
 * @author ASUS
 */
public class Inventario {
    
    private Producto[] productos;
    private int cantidad;

    // Constructor
    public Inventario() {
        productos = new Producto[50];
        cantidad = 0;
    }
    
    
    
    public void registrarProducto(Producto producto) {

        if (cantidad < productos.length) {

            productos[cantidad] = producto;

            cantidad++;

            System.out.println("Producto registrado correctamente.");

        } else {

            System.out.println("El inventario esta lleno.");

        }
    }
    
  
    public void listarProductos() {

        if (cantidad == 0) {

            System.out.println("No hay productos registrados.");

        } else {

            System.out.println("===== LISTA DE PRODUCTOS =====");

            for (int i = 0; i < cantidad; i++) {

                System.out.println("Codigo: " + productos[i].getCodigo());
                System.out.println("Nombre: " + productos[i].getNombre());
                System.out.println("Precio: " + productos[i].getPrecio());
                System.out.println("Stock: " + productos[i].getStock());

                System.out.println("-------------------------");
            }
        }
    }

    public Producto buscarProducto(int codigo) {

    for (int i = 0; i < cantidad; i++) {

        if (productos[i].getCodigo() == codigo) {

            return productos[i];

        }
    }

    return null;
}
    
    
    // Modificar producto
    public void modificarProducto(int codigo, double nuevoPrecio, int nuevoStock) {

        Producto producto = buscarProducto(codigo);

        if (producto != null) {

            producto.setPrecio(nuevoPrecio);
            producto.setStock(nuevoStock);

            System.out.println("Producto modificado correctamente.");

        } else {

            System.out.println("Producto no encontrado.");

        }
    }

    
    // Eliminar producto
    public void eliminarProducto(int codigo) {

        int posicion = -1;

        // Buscar la posicion del producto
        for (int i = 0; i < cantidad; i++) {

            if (productos[i].getCodigo() == codigo) {

                posicion = i;
                break;
            }
        }

        // Comprobar si existe
        if (posicion != -1) {

            // Desplazar los productos
            for (int i = posicion; i < cantidad - 1; i++) {

                productos[i] = productos[i + 1];
            }

            // Liberar la ultima posicion
            productos[cantidad - 1] = null;

            cantidad--;

            System.out.println("Producto eliminado correctamente.");

        } else {

            System.out.println("Producto no encontrado.");

        }
    }


    
}
