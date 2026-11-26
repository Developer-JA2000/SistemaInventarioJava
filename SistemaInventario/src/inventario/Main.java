
package inventario;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Inventario inventario = new Inventario();

        int opcion;

        do {

            System.out.println("\n===== SISTEMA DE INVENTARIO =====");
            System.out.println("1. Registrar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto");
            System.out.println("4. Modificar producto");
            System.out.println("5. Eliminar producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = entrada.nextInt();
            entrada.nextLine();

            switch (opcion) {

                
                case 1:

                System.out.println("===== REGISTRAR PRODUCTO =====");

                System.out.print("Ingrese codigo: ");
                int codigo = entrada.nextInt();
                entrada.nextLine();

                System.out.print("Ingrese nombre: ");
                String nombre = entrada.nextLine();

                System.out.print("Ingrese precio: ");
                double precio = entrada.nextDouble();

                System.out.print("Ingrese stock: ");
                int stock = entrada.nextInt();

                Producto nuevoProducto = new Producto(
                codigo, nombre, precio, stock
                                );

                inventario.registrarProducto(nuevoProducto);
                        break;

                case 2:
                    inventario.listarProductos();
                        break;
                    
                    
                case 3:

                System.out.println("===== BUSCAR PRODUCTO =====");

                System.out.print("Ingrese codigo del producto: ");
                int codigoBuscar = entrada.nextInt();

                Producto encontrado = inventario.buscarProducto(codigoBuscar);

                if (encontrado != null) {

                System.out.println("PRODUCTO ENCONTRADO");
                System.out.println("Codigo: " + encontrado.getCodigo());
                System.out.println("Nombre: " + encontrado.getNombre());
                System.out.println("Precio: " + encontrado.getPrecio());
                System.out.println("Stock: " + encontrado.getStock());

                } else {

                System.out.println("No se encontro el producto.");

                }

                    break;
                
                        
                case 4:

                System.out.println("===== MODIFICAR PRODUCTO =====");

                System.out.print("Ingrese codigo: ");
                int codigoModificar = entrada.nextInt();

                System.out.print("Nuevo precio: ");
                double nuevoPrecio = entrada.nextDouble();

                System.out.print("Nuevo stock: ");
                int nuevoStock = entrada.nextInt();

                inventario.modificarProducto(
                codigoModificar, nuevoPrecio, nuevoStock
                );

                    break;
                    
                    
                case 5:

                        System.out.println("===== ELIMINAR PRODUCTO =====");

                        System.out.print("Ingrese codigo del producto: ");
                        int codigoEliminar = entrada.nextInt();

                        inventario.eliminarProducto(codigoEliminar);

                    break;




                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida.");
            }

        } while (opcion != 0);
        entrada.close();
       
    }
}
