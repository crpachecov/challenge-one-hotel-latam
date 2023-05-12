package model;

import java.time.LocalDate;
import java.time.Period;

public class CalcularCosto {

    public static float calcularCostoPorDias(LocalDate fechaInicio, LocalDate fechaFin) {
        int dias;
        final float costoPorDia = 10;
        float costoTotal;

        try {
            if (fechaInicio.isAfter(fechaFin)) {
                throw new IllegalArgumentException("La fecha de inicio no puede ser después de la fecha de fin");
            }else {
                // Calcular el número de días entre las dos fechas
                dias = Period.between(fechaInicio, fechaFin).getDays() + 1;

                // Calcular el costo total
                costoTotal = costoPorDia* dias;
            }

            return costoTotal;

        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }


}
