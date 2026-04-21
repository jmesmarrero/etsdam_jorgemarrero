package com.refactorizacion;

/**
 * Clase que representa un producto dentro del sistema.
 */
public class Producto {

    private String nombre;
    private double precio;
    private int cantidad;

    /**
     * Constructor de la clase producto
     * 
     * @param nombre   Nombre del producto
     * @param precio   Precio del producto
     * @param cantidad Cantidad comprada
     */
    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    /**
     * Calcula el subtotal del producto
     * Si la cantidad es mayor a 2, aplica un descuento del 10%
     * 
     * @return subtotal del producto con descuento si aplica
     */
    public double calcularSubtotal() {
        double subtotal = precio * cantidad;

        if (cantidad > 2) {
            subtotal -= subtotal * 0.1;
        }

        return subtotal;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }
}