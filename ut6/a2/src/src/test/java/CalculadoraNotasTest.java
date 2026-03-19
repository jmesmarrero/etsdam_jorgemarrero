import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.docencia.CalculadoraNotas;


public class CalculadoraNotasTest {

    @Test
    void testMediaCorrecta() {
        assertEquals(7, CalculadoraNotas.calcularMedia(new int[]{6,7,8}));
    }

    @Test
    void testMediaConDecimales() {
        assertEquals(6, CalculadoraNotas.calcularMedia(new int[]{5,6,7}));
    }

    @Test
    void testUnaSolaNota() {
        assertEquals(10, CalculadoraNotas.calcularMedia(new int[]{10}));
    }

    @Test
    void testListaVacia() {
        assertThrows(IllegalArgumentException.class,
            () -> CalculadoraNotas.calcularMedia(new int[]{}));
    }

    @Test
    void testNotaFueraDeRango() {
        assertThrows(IllegalArgumentException.class,
            () -> CalculadoraNotas.calcularMedia(new int[]{3, 15}));
    }
}
