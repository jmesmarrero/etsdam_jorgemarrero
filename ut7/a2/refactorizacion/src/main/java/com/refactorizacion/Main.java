package com.refactorizacion;

/**
 * Clase principal del programa
 */
public class Main {

    public static void main(String[] args) {

        /**
         * Crea un nuevo pedido
         */
        Pedido pedido = new Pedido();

        pedido.agregarProducto(new Producto("Teclado", 30, 2));
        pedido.agregarProducto(new Producto("Raton", 15, 3));
        pedido.agregarProducto(new Producto("Monitor", 200, 1));

        /**
         * Calculael total del pedido
         */
        double total = pedido.calcularTotal();

        System.out.println("TOTAL PEDIDO: " + total);

        if (pedido.esClienteVIP(total)) {
            System.out.println("Cliente VIP");
        }
    }
}