// Importa la anotación @Test, que indica a JUnit que un método es una prueba
import org.junit.jupiter.api.Test;

// Importa de forma estática todos los métodos de Assertions,
// como assertEquals y assertThrows, para poder usarlos sin escribir
// Assertions.assertEquals(...)
import static org.junit.jupiter.api.Assertions.*;

// Declaración de la clase de pruebas.
// Por convención, se llama igual que la clase a probar + "Test".
class PropinaTest {

    // Esta anotación indica que el método es una prueba unitaria.
    @Test
    void totalConPropina_calculaPropinaNormal() {

        // =========================
        // ARRANGE (Preparar)
        // =========================
        // Se definen los datos de entrada que usaremos en la prueba.
        double subtotal = 100.0;        // monto base
        double porcentaje = 10.0;       // porcentaje de propina
        double esperado = 110.0;        // resultado que esperamos obtener

        // =========================
        // ACT (Actuar)
        // =========================
        // Se ejecuta el método que queremos probar.
        // Este es el método "bajo prueba".
        double obtenido = Propina.totalConPropina(subtotal, porcentaje);

        // =========================
        // ASSERT (Afirmar)
        // =========================
        // Se comprueba que el resultado obtenido es igual al esperado.
        // El tercer parámetro (delta) se usa para evitar errores por decimales.
        assertEquals(esperado, obtenido, 0.000001);
    }

    // Segunda prueba: caso sin propina
    @Test
    void totalConPropina_sinPropina_devuelveSubtotal() {

        // Ejecutamos el método con 0% de propina
        double obtenido = Propina.totalConPropina(50.0, 0.0);

        // Verificamos que el resultado sea exactamente el subtotal
        assertEquals(50.0, obtenido, 0.000001);
    }

    // Tercera prueba: caso límite con propina al 100%
    @Test
    void totalConPropina_propinaAl100_porcentajeMaximo() {

        // Si la propina es del 100%, el total debe ser el doble del subtotal
        double obtenido = Propina.totalConPropina(20.0, 100.0);

        // Se espera que el total sea 40.0
        assertEquals(40.0, obtenido, 0.000001);
    }

    // Cuarta prueba: caso incorrecto (subtotal negativo)
    @Test
    void totalConPropina_subtotalNegativo_lanzaExcepcion() {

        // En este caso NO queremos un valor de retorno.
        // Queremos comprobar que el método se protege
        // y lanza una excepción cuando recibe datos inválidos.

        assertThrows(
                // Tipo de excepción que esperamos
                IllegalArgumentException.class,

                // Código que debe lanzar la excepción
                () -> Propina.totalConPropina(-1.0, 10.0)
        );
    }

    // Quinta prueba: porcentaje de propina fuera del rango permitido
    /*@Test
    void totalConPropina_propinaFueraDeRango_lanzaExcepcion() {

        // De nuevo, comprobamos que el método lance una excepción
        // cuando el porcentaje de propina es inválido (> 100)
        assertThrows(
                IllegalArgumentException.class,
                () -> Propina.totalConPropina(10.0, 200.0)
        );
    }*/
}
