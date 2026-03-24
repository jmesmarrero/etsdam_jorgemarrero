package com.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotasTest {

    @Test
    void testMediaSimple(){
        assertEquals(7, CalculadoraNotas.calcularMedia(new int[]{6,7,8}));
    }

    @Test
    void testMediaDecimal(){
        assertEquals(8.5, CalculadoraNotas.calcularMedia(new int[]{10,9,8,7}));
    }

    @Test
void testListaVacia() {
    assertThrows(IllegalArgumentException.class,
        () -> CalculadoraNotas.calcularMedia(new int[]{}));
}

@Test
void testNotaFueraDeRango() {
    assertThrows(IllegalArgumentException.class,
        () -> CalculadoraNotas.calcularMedia(new int[]{5, 12, 7}));
}

}

