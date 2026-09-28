package com.mycompany.Sistemainventario;

import java.util.Scanner;

public class Sistemainventario {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Arreglos con la información de los productos
        String[] productos = {"Arroz", "Leche", "Pan", "Huevos", "Aceite"};
        double[] precios = {4000, 3500, 2000, 12000, 8500};
        int[] cantidades = {10, 0, 8, 15, 5};
        int[] vendidos = {20, 15, 30, 25, 10};

        System.out.println("====================================");
        System.out.println("       SISTEMA DE INVENTARIO");
        System.out.println("====================================");

        // 1. INSTRUCCIÓN ALTERNATIVA (IF - ELSE)
        System.out.println("\n--- VERIFICACIÓN DE PRODUCTOS ---");

        for (int i = 0; i < productos.length; i++) {

            if (cantidades[i] > 0) {
                System.out.println(productos[i] + " está disponible. "
                        + "Cantidad: " + cantidades[i]);
            } else {
                System.out.println(productos[i] + " está agotado.");
            }
        }

        // 2. INSTRUCCIÓN REPETITIVA (FOR)
        System.out.println("\n--- LISTADO DEL INVENTARIO ---");

        for (int i = 0; i < productos.length; i++) {
            System.out.println(
                    (i + 1) + ". " + productos[i]
                    + " | Precio: $" + precios[i]
                    + " | Cantidad: " + cantidades[i]
            );
        }

        // 3. INSTRUCCIÓN DE SALTO (CONTINUE)
        System.out.println("\n--- PRODUCTOS DISPONIBLES ---");

        for (int i = 0; i < productos.length; i++) {

            if (cantidades[i] == 0) {
                continue;
            }

            System.out.println(productos[i]
                    + " tiene " + cantidades[i]
                    + " unidades disponibles.");
        }

        // 4. CALCULAR EL PRECIO TOTAL DE UNA COMPRA
        System.out.println("\n--- REALIZAR COMPRA ---");

        System.out.print("Ingrese el número del producto (1-5): ");
        int opcion = teclado.nextInt();

        if (opcion >= 1 && opcion <= productos.length) {

            int posicion = opcion - 1;

            System.out.print("Ingrese la cantidad que desea comprar: ");
            int cantidadCompra = teclado.nextInt();

            if (cantidadCompra <= cantidades[posicion]) {

                double total = cantidadCompra * precios[posicion];

                System.out.println("\nProducto: " + productos[posicion]);
                System.out.println("Cantidad: " + cantidadCompra);
                System.out.println("Precio unitario: $" + precios[posicion]);
                System.out.println("Total de la compra: $" + total);

            } else {
                System.out.println("No hay suficientes unidades disponibles.");
            }

        } else {
            System.out.println("Producto no válido.");
        }

        // 5. INFORME DE PRODUCTOS MÁS VENDIDOS
        System.out.println("\n--- INFORME DE PRODUCTOS VENDIDOS ---");

        for (int i = 0; i < productos.length; i++) {

            System.out.println(productos[i]
                    + " - Unidades vendidas: "
                    + vendidos[i]);
        }

        // Buscar el producto más vendido
        int mayorVenta = vendidos[0];
        int posicionMayor = 0;

        for (int i = 1; i < vendidos.length; i++) {

            if (vendidos[i] > mayorVenta) {
                mayorVenta = vendidos[i];
                posicionMayor = i;
            }
        }

        System.out.println("\nProducto más vendido: "
                + productos[posicionMayor]);

        System.out.println("Cantidad vendida: "
                + mayorVenta);

        System.out.println("\n====================================");
        System.out.println("       FIN DEL PROGRAMA");
        System.out.println("====================================");

        teclado.close();
    }
}