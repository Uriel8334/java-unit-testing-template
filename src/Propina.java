// Declaración de la clase Propina.
// En Java, toda funcionalidad debe estar contenida dentro de una clase.
public class Propina {

    /**
     * Método que calcula el total a pagar incluyendo la propina.
     * 
     *
     * @param subtotal monto base de la cuenta (debe ser mayor o igual a 0)
     * @param porcentajePropina porcentaje de propina (entre 0 y 100)
     * @return el total a pagar (subtotal + propina)
     * @throws IllegalArgumentException si los valores no cumplen las reglas
     */
    public static double totalConPropina(double subtotal, double porcentajePropina) {

        // Validación 1:
        // Si el subtotal es negativo, el dato no tiene sentido en el contexto del problema.
        if (subtotal < 0) {
            // Se lanza una excepción para indicar un uso incorrecto del método.
            throw new IllegalArgumentException("El subtotal no puede ser negativo");
        }

        // Validación 2:
        // El porcentaje de propina debe estar entre 0 y 100.
        if (porcentajePropina < 0 || porcentajePropina > 100) {
            // Si no cumple esta condición, también se lanza una excepción.
            throw new IllegalArgumentException("La propina debe estar entre 0 y 100");
        }

        // Cálculo de la propina:
        // Se divide el porcentaje entre 100.0 para obtener un valor decimal.
        // Ejemplo: 10% → 0.10
        double propina = subtotal * (porcentajePropina / 100.0);

        // Se retorna el total a pagar:
        // subtotal original + valor calculado de la propina.
        return subtotal + propina;
    }
}
