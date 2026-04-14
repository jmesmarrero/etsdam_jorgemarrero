package com.tienda;


import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CarritoServiceTest {

    CarritoService service = new CarritoService();

    // ---------- SUBTOTAL ----------

    @Test
    void testSubtotalVariosProductos() {
        List<Producto> carrito = List.of(
                new Producto("teclado", 30, 2),
                new Producto("raton", 10, 1)
        );

        double resultado = service.calcularSubtotal(carrito);
        assertEquals(70, resultado);
    }

    @Test
    void testSubtotalUnProducto() {
        List<Producto> carrito = List.of(
                new Producto("monitor", 100, 1)
        );

        double resultado = service.calcularSubtotal(carrito);
        assertEquals(100, resultado);
    }

    @Test
    void testSubtotalCarritoVacio() {
        List<Producto> carrito = List.of();

        double resultado = service.calcularSubtotal(carrito);
        assertEquals(0, resultado);
    }

    // ---------- DESCUENTO ----------

    @Test
    void testDescuentoCero() {
        double resultado = service.aplicarDescuento(100, 0);
        assertEquals(100, resultado);
    }

    @Test
    void testDescuentoValido() {
        double resultado = service.aplicarDescuento(100, 10);
        assertEquals(90, resultado);
    }

    @Test
    void testDescuento100() {
        double resultado = service.aplicarDescuento(100, 100);
        assertEquals(0, resultado);
    }

    @Test
    void testDescuentoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.aplicarDescuento(100, -10);
        });
    }

    @Test
    void testDescuentoMayor100() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.aplicarDescuento(100, 150);
        });
    }

    // ---------- ENVÍO ----------

    @Test
    void testEnvioMenor100() {
        double resultado = service.calcularEnvio(50);
        assertEquals(5, resultado);
    }

    @Test
    void testEnvioMayorIgual100() {
        double resultado = service.calcularEnvio(100);
        assertEquals(0, resultado);
    }

    // ---------- TOTAL ----------

    @Test
    void testTotalSinDescuento() {
        List<Producto> carrito = List.of(
                new Producto("teclado", 50, 1)
        );

        double total = service.calcularTotal(carrito, 0);
        assertEquals(55, total);
    }

    @Test
    void testTotalConDescuento() {
        List<Producto> carrito = List.of(
                new Producto("teclado", 100, 1)
        );

        double total = service.calcularTotal(carrito, 10);
        assertEquals(90, total);
    }

    @Test
    void testTotalConEnvioGratis() {
        List<Producto> carrito = List.of(
                new Producto("monitor", 200, 1)
        );

        double total = service.calcularTotal(carrito, 0);
        assertEquals(200, total);
    }
}