package ec.espe.demo;

/**
 * Mini-ejercicio: Calculadora de propina.
 * Regla: total = subtotal + subtotal*(porcentaje/100)
 */
public class Propina {

    public static double totalConPropina(double subtotal, double porcentajePropina) {
        if (subtotal < 0) {
            throw new IllegalArgumentException("El subtotal no puede ser negativo");
        }
        if (porcentajePropina < 0 || porcentajePropina > 100) {
            throw new IllegalArgumentException("La propina debe estar entre 0 y 100");
        }

        double propina = subtotal * (porcentajePropina / 100.0);
        return subtotal + propina;
    }
}
