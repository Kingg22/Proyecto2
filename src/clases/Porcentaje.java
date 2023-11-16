package clases;

public class Porcentaje {
    /*
     * Esta clase se enfoca solo en sacar los porcentajes de pacientes por tipo de
     * tratamiento
     * Se decidió hacer otra clase ya que esta tiene todos sus partes (asignar,
     * calcular, devolver) y no requiere ninguna información de la otra clase.
     * 
     * ATRIBUTOS de la clase
     */
    private int tipoA, tipoB, tipoC, pacientesT;

    public void asignarDatos(int tA, int tB, int tC, int totalPacientes) {
        tipoA = tA;
        tipoB = tB;
        tipoC = tC;
        pacientesT = totalPacientes;
    }

    public float calcularPorcentajeA() {
        float porcentajeA;
        porcentajeA = (float) tipoA / pacientesT * 100;
        if (pacientesT == 0)
            porcentajeA = 0.00F;
        return porcentajeA;
    }

    public float calcularPorcentajeB() {
        float porcentajeB;
        porcentajeB = (float) tipoB / pacientesT * 100;
        if (pacientesT == 0)
            porcentajeB = 0.00F;
        return porcentajeB;
    }

    public float calcularPorcentajeC() {
        float porcentajeC;
        porcentajeC = (float) tipoC / pacientesT * 100;
        if (pacientesT == 0)
            porcentajeC = 0.00F;
        return porcentajeC;
    }

    public int devolverTipoA() {
        return tipoA;
    }

    public int devolverTipoB() {
        return tipoB;
    }

    public int devolverTipoC() {
        return tipoC;
    }

    public int devolverTotalPacientes() {
        return pacientesT;
    }
}