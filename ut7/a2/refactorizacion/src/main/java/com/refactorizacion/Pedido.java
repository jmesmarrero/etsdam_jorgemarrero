package com.refactorizacion;

import java.util.ArrayList;

/**
 * Clase que representa un pedido dentro del sistema
 */
public class Pedido {

    private ArrayList<Producto> productos;

    /**
     * Constructor de la clase Pedido
     * Iniciliza la lista de productos
     */
    public Pedido() {
        productos = new ArrayList<>();
    }

    /**
     * Aniade un producto al pedido 
     * @param producto Producto a aniadir
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Calcular el total del pedido recorriendo todos los productos
     * @return total final del producto
     */
    public double calcularTotal() {
        double total = 0;

        for (Producto producto : productos) {

            double subtotal = producto.calcularSubtotal();

            mostrarProducto(producto, subtotal);

            subtotal = aplicarEnvio(subtotal);

            total = total + subtotal;

            System.out.println("-------------------");
        }

        return total;
    }

    /**
     * Muestra por pantalla la informacion del producto
     * @param producto Producto a mostrar
     * @param subtotal Subtotal calculado
     */
    private void mostrarProducto(Producto producto, double subtotal) {
        System.out.println("Producto: " + producto.getNombre());
        System.out.println("Precio: " + producto.getPrecio());
        System.out.println("Cantidad: " + producto.getCantidad());
        System.out.println("Subtotal: " + subtotal);
    }

    /**
     * Aplica los gastos de envio segun el subtotal
     * @param subtotal Subtotal del producto
     * @return subtotal con envio aplicado si corresponde
     */
    private double aplicarEnvio(double subtotal) {
        if (subtotal > 100) {
            System.out.println("Envio gratis");
        } else {
            System.out.println("Envio: 5 euros");
            subtotal += 5;
        }
        return subtotal;
    }

    /**
     * Determina si el cliente es VIP
     * @param total Total del pedido
     * @return true si supera los 500€, false en caso contrario
     */
    public boolean esClienteVIP(double total) {
        return total > 500;
    }
}