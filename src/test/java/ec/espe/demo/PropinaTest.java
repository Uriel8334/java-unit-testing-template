package ec.espe.demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PropinaTest {

    @Test
    void totalConPropina_calculaPropinaNormal() {
        double subtotal = 100.0;
        double porcentaje = 10.0;
        double esperado = 110.0;

        double obtenido = Propina.totalConPropina(subtotal, porcentaje);

        assertEquals(esperado, obtenido, 0.000001);
    }

    @Test
    void totalConPropina_subtotalNegativo_lanzaExcepcion() {
        assertThrows(IllegalArgumentException.class,
                () -> Propina.totalConPropina(-1.0, 10.0));
    }
}
