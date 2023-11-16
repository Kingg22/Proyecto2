package clases;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class SpaClass {
    // Atributos de la clase
    private String nombre;
    private int edad;
    private char sexo, tipoT;
    private LocalDate fechaInicio, fechaFin;

    public void AsignarDatos(String name, int old, char sex, char tipo, LocalDate fecha1, LocalDate fecha2) {
        nombre = name;
        edad = old;
        sexo = sex;
        tipoT = Character.toUpperCase(tipo);
        fechaInicio = fecha1;
        fechaFin = fecha2;
    }

    public float calcularCostoDia() {
        float costoDia = 0F;
        // este metodo solo se utiliza para determinar los costos asociados al tipo de
        // tratamiento escogido
        if (tipoT == 'A')
            costoDia = 280.00F;
        else if (tipoT == 'B')
            costoDia = 195.00F;
        else if (tipoT == 'C')
            costoDia = 250.00F;

        return costoDia;
    }

    public long calcularDiasInternado() {
        long dias;
        dias = ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        return dias;
    }

    public float calcularCosto() {
        float costo;
        // multiplica el costo por dia del tratamiento escogido por todos los dias
        // internado
        costo = calcularCostoDia() * calcularDiasInternado();
        return costo;
    }

    public float calcularDescuentos() {
        float descuento = 0.00F; // inicializar
        // Descuento por edad
        if (edad > 60)
            descuento = (calcularCosto() * 0.25F);
        else if (edad >= 45 && edad <= 50 && (sexo == 'F'))
            descuento = (calcularCosto() * 0.15F);
        // Descuento Especial por semana completa internado y es el tratamiento de menor
        // costo
        if (tipoT == 'B' && calcularDiasInternado() >= 5 && calcularDiasInternado() <= 7) {
            descuento = descuento + (calcularCostoDia() * 0.50F);

        }
        return descuento;
    }

    public String MostrarDescuentoEspecial() {
        String mensajeDD = "";

        if (calcularDiasInternado() >= 5 && calcularDiasInternado() <= 7) {
            if (tipoT == 'A') {
                mensajeDD = "Tiene derecho a tratamiento B o C (1 dia gratis!!)";
            } else if (tipoT == 'C') {
                mensajeDD = "Tiene derecho al tratamiento C (1 dia gratis!!)";
            } else if (tipoT == 'B') {
                mensajeDD = "Se le aplico un descuento de 50% en 1 dia de su tratamiento";

            }
        }
        return mensajeDD;
    }

    public float calcularTotal() {
        float total;
        total = calcularCosto() - calcularDescuentos();
        return total;
    }

    public String devolverNombre() {
        return nombre;
    }

    public int devolverEdad() {
        return edad;
    }

    public char devolverSexo() {
        return sexo;
    }

    public char devolverTipoTratamiento() {
        return tipoT;
    }

    public LocalDate devolverFecha1() {
        return fechaInicio;
    }

    public LocalDate devolverFecha2() {
        return fechaFin;
    }

}