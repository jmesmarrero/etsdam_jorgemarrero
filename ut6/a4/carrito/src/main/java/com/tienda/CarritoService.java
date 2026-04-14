package com.tienda;

import java.util.List;

public class CarritoService {

    // 1. Calcular subtotal
    public double calcularSubtotal(List<Producto> carrito) {
        double subtotal = 0;

        for (Producto p : carrito) {
            subtotal += p.getPrecio() * p.getCantidad(); 
        }

        return subtotal;
    }

    // 2. Aplicar descuento
    public double aplicarDescuento(double subtotal, double descuento) {

        if (descuento < 0 || descuento > 100) { 
            throw new IllegalArgumentException("Descuento inválido");
        }

        double cantidadDescuento = subtotal * descuento / 100;
        return subtotal - cantidadDescuento;
    }

    // 3. Calcular envío
    public double calcularEnvio(double subtotal) {
        if (subtotal >= 100) { 
            return 0;
        } else {
            return 5;
        }
    }

    // 4. Calcular total
    public double calcularTotal(List<Producto> carrito, double descuento) {

        double subtotal = calcularSubtotal(carrito);

        double conDescuento = aplicarDescuento(subtotal, descuento);

        double envio = calcularEnvio(subtotal);

        return conDescuento + envio;
    }
}