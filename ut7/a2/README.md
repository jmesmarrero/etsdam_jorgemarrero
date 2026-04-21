 Práctica de Refactorización – Gestión de Pedidos
====================================================

 Objetivo de la práctica
--------------------------

El objetivo de esta práctica es mejorar la calidad del código analizado previamente mediante la aplicación de técnicas de refactorización.

En la práctica anterior se identificaron diversos _code smells_ (malos olores de código), relacionados con problemas de diseño, legibilidad y mantenibilidad.

En esta práctica se corrigen dichos problemas **sin modificar el comportamiento del programa**.

 Restricciones importantes
----------------------------

*   El programa debe funcionar exactamente igual que el original
    
*   No se debe modificar la funcionalidad
    
*   Solo se mejora la estructura interna del código
    

 Enfoque aplicado
-------------------

Se ha trabajado sobre el mismo programa de gestión de pedidos, aplicando mejoras progresivas para conseguir un código:

*   Más claro
    
*   Más organizado
    
*   Más mantenible
    
*   Más escalable
    

1. Revisión inicial
----------------------

Se detectaron los siguientes problemas:

*   Nombres de variables poco descriptivos (n, p, c)
    
*   Lógica concentrada en el método main
    
*   Código poco modular
    
*   Uso de números mágicos (como 0.1, 100, 5)
    
*   Falta de separación de responsabilidades
    

2. Refactorización del código
--------------------------------

###  Renombrado

Se sustituyeron nombres poco descriptivos por nombres claros:

AntesDespuésnnombrepprecioccantidadlistaproductos

###  Extracción de métodos

Se crearon métodos con responsabilidad única:

*   calcularSubtotal()
    
*   calcularTotal()
    
*   mostrarProducto()
    
*   aplicarEnvio()
    
*   esClienteVIP()
    

Mejora la legibilidad y reutilización del código.

###  Eliminación de código duplicado

*   Se centralizó el cálculo del subtotal dentro de la clase Producto
    

 Evita repetir lógica y facilita futuros cambios.

### Simplificación de condiciones

*   Se encapsularon condiciones en métodos como esClienteVIP()
    

Mejora la claridad del código.

### División de métodos largos

*   El método main ahora solo coordina la ejecución
    

Se evita un método sobrecargado.

3. Mejora del diseño
------------------------

Se reorganizó el código en **3 clases principales**:

### Producto

Responsabilidad:

*   Representar un producto
    
*   Calcular su subtotal
    

```java
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
```

### Pedido

Responsabilidad:

*   Gestionar los productos
    
*   Calcular el total del pedido
    
*   Aplicar envío
    

```java
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
```

### Main

Responsabilidad:

*   Ejecutar el programa
    
```java
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
```

4. Cumplimiento de requisitos
--------------------------------

- El programa mantiene exactamente el mismo comportamiento
- No se ha eliminado ninguna funcionalidad
- El código compila y se ejecuta correctamente
- Se han aplicado mejoras progresivas
- Se ha mejorado la estructura interna sin alterar la lógica

5. Documentación del código

Se ha añadido documentación utilizando comentarios JavaDoc en todas las clases y métodos principales del sistema.

La documentación permite mejorar la comprensión del código y facilita su mantenimiento y escalabilidad.