import java.util.InputMismatchException;
import java.util.Scanner;

public class InventarioTienda {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);

        String[] productos = {"Pan", "Leche", "Arroz", "Huevos"}; 
        double[] precios = {3000, 4000, 5000, 12000}; 
        int[] cantidades = {10, 8, 15, 20}; 
        int[] ventas = {5, 3, 7, 10};

        int opcion = 0;

        while (opcion != 4) {
            try {
                System.out.println("\n===== SISTEMA DE INVENTARIO =====");
                System.out.println("1. Consultar producto.");
                System.out.println("2. Realizar compra.");
                System.out.println("3. Generar informe.");
                System.out.println("4. Salir.");
                System.out.print("Seleccione una opción: ");
                opcion = entrada.nextInt();
                entrada.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        System.out.println("\nIngrese el nombre del producto: ");
                        String nombreProducto = entrada.nextLine().trim();

                        boolean encontrado = false;

                        // Recorremos los productos
                        for (int i = 0; i < productos.length; i++) {
                            // Verificamos que el producto a buscar no sea vacio e ignoramos mayusculas y
                            // minusculas
                            if (productos[i] != null && productos[i].equalsIgnoreCase(nombreProducto)) {
                                encontrado = true;

                                System.out.println("\nProducto: " + productos[i]);
                                System.out.println("Precio: $" + precios[i]);
                                System.out.println("Cantidad disponible: " + cantidades[i]);

                                // Presentamos los estados dependiendo de la cantidad
                                if (cantidades[i] >= 3)
                                    System.out.println("Estado: Disponible");
                                else if (cantidades[i] > 0)
                                    System.out.println("Estado: Pronto a Agotarse.");
                                else
                                    System.out.println("Estado: Agotado.");

                                break;
                            }
                        }

                        if (!encontrado)
                            System.out.println("El producto no existe.");

                        break;
                    case 2:
                        System.out.println("\nIngrese el nombre del producto: ");
                        String productoCompra = entrada.nextLine().trim();

                        System.out.println("Ingrese la cantidad del producto: ");
                        int cantidadCompra = entrada.nextInt();
                        entrada.nextLine(); // Limpieza de buffer

                        boolean productoEncontrado = false;

                        for (int i = 0; i < productos.length; i++) {
                            // Verificamos que el producto a comprar no sea vacio e ignoramos mayusculas y
                            // minusculas
                            if (productos[i] != null && productos[i].equalsIgnoreCase(productoCompra)) {
                                productoEncontrado = true;

                                // Validamos que la cantidad no sea negativa
                                if (cantidadCompra <= 0) {
                                    System.out.println("La cantidad debe ser mayor que cero.");
                                    break;
                                }

                                // Comparamos cantidades disponibles con las que se van a comprar
                                if (cantidades[i] >= cantidadCompra) {
                                    double total = precios[i] * cantidadCompra;

                                    // Quitamos de stock y agregamos ventas
                                    cantidades[i] -= cantidadCompra;
                                    ventas[i] += cantidadCompra;

                                    System.out.println("\nCompra realizada correctamente.");
                                    System.out.println("Producto: " + productos[i]);
                                    System.out.println("Cantidad: " + cantidadCompra);
                                    System.out.println("Total: $" + total);
                                    System.out.println("Existencias restantes: " + cantidades[i]);
                                } else {
                                    System.out.println("No hay suficiente inventario.");
                                }

                                break;
                            }
                        }

                        if (!productoEncontrado)
                            System.out.println("El producto no existe.");
                        break;
                    case 3:
                        System.out.println("\n===== INFORME INVENTARIO =====");

                        for (int i = 0; i < productos.length; i++) {
                            // Validamos que existan productos
                            if (cantidades[i] == 0) {
                                System.out.println(productos[i] + " - AGOTADO");
                                continue;
                            }

                            // Mostramos el informe de los productos
                            System.out.println(productos[i] + " | Precio: $" + precios[i] + " | Stock: " + cantidades[i]
                                    + " | Ventas: " + ventas[i]);
                        }

                        System.out.println("\nProductos más vendidos: ");

                        int mayorVenta = ventas[0];
                        int posicionMayor = 0;

                        // Recorremos cada producto hasta encontrar la mayor venta
                        for (int i = 1; i < ventas.length; i++) {
                            if (ventas[i] > mayorVenta) {
                                mayorVenta = ventas[i];
                                posicionMayor = i;
                            }
                        }

                        System.out.println(productos[posicionMayor] + " - " + mayorVenta + " unidades vendidas.");

                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número válido");
                entrada.nextLine(); // Limpieza de buffer
            }
        }

        entrada.close();
    }
}