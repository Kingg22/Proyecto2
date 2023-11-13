import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

class SpaClass {
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
        // Descuento Especial por semana completa internado y es el tratamiento de menor costo
        if (tipoT == 'B' && calcularDiasInternado() >= 5 && calcularDiasInternado() <= 7) {
            descuento = descuento + (calcularCostoDia() * 0.50F);

        }
        return descuento;
    }

    public String MostrarDescuentoEspecial() {
        String mensajeDD = "";

        if (calcularDiasInternado() >= 5 && calcularDiasInternado() <= 7)
        {
            if (tipoT == 'A') {
                mensajeDD = "Tiene derecho a tratamiento B o C (1 dia gratis!!)";
            } else if (tipoT == 'C') {
                mensajeDD = "Tiene derecho al tratamiento C (1 dia gratis!!)";
            } else if (tipoT == 'B') {
                mensajeDD = "Se le aplico un descuento de 50% en 1 día de su tratamiento";

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

class Porcentaje {
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
        return porcentajeA;
    }

    public float calcularPorcentajeB() {
        float porcentajeB;
        porcentajeB = (float) tipoB / pacientesT * 100;
        return porcentajeB;
    }

    public float calcularPorcentajeC() {
        float porcentajeC;
        porcentajeC = (float) tipoC / pacientesT * 100;
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

public class Spa {
    public static void main(String[] args) {
        // Variable de trabajo de todo el programa
        // Botones de opciones
        String opcion[] = { "Ver Servicios", "Registrarse", "Salir" };
        String opcion2[] = { "A", "B", "C", "Regresar" };
        String opcion3[] = { "Regresar" };
        // Variables para el control de opciones
        int servicio = 0, menu2 = 0, cont1 = 0;
        // Iconos de cada menu en el programa
        ImageIcon iconA = new ImageIcon("tratamientoA.jpg");
        ImageIcon iconB = new ImageIcon("tratamientoB.jpg");
        ImageIcon iconC = new ImageIcon("tratamientoC.jpg");
        ImageIcon iconD = new ImageIcon("Welcome.png");
        ImageIcon iconE = new ImageIcon("Spa.png");
        ImageIcon iconFinal = null;
        // Mensajes para el menu de servicios del programa
        String tratamientoA = "SERVICIO A (Hot Stones Massage):\nUn maravilloso masaje realizado con calidas piedras volcanicas,\naceite de almendras y aceites esenciales de romero y tomillo.";
        String tratamientoB = "SERVICIO B (Aromaterapia):\nAprovecha de aceites esenciales de las plantas para mejorar el\nequilibrio de la mente, el cuerpo y el espiritu.";
        String tratamientoC = "SERVICIO C (Lodoterapia):\nLimpia los poros, exfolia la piel muerta, y disfruta de una piel\nsuave y tersa, simplemente un tratamiento desintoxicantes,\nrevitalizantes, anti-fatiga y seboreguladores.";
        // Datos de entraada
        String nombre, tratamiento, fecha, fecha2, mensajefinal = "";
        int edad = 0;
        char sexo = 'A', tratamientoFin;
        String opcionTrat[] = { "A", "B", "C" }; // Opciones de tratamiento
        // Uso de fecha del sistema y fecha especifica
        LocalDate fechaInicio = LocalDate.now(), fechaFin = LocalDate.of(1, 1, 1);
        // Cracion del contructor del formato de fecha "dd/MM/yyyy"
        DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Objetos de las clases
        SpaClass objSpa = new SpaClass(); // Clase Spaclass
        DecimalFormat objDecimal = new DecimalFormat("0.00"); // Constructor para el formato de numeros
        Porcentaje objPorcentaje = new Porcentaje();// Clase Porcentaje

        // variable de Validaciones y porcentajes (Contadores)
        int pacientes = 0, pacientes60 = 0, pacientes25 = 0, pacientesGratis = 0, totalA = 0, totalB = 0, totalC = 0;

        do {// Menu principal de todo el programa
            int tipo = JOptionPane.showOptionDialog(null, "        BIENVENIDO\n      SPA ARMONIA", "SPA ARMONIA", 0,
                    JOptionPane.QUESTION_MESSAGE, iconD, opcion, "");

            if (tipo == 0) { // Menu para mostrar los servicios al cliente
                do {
                    servicio = JOptionPane.showOptionDialog(null, "\t\tSERVICIOS DISPONIBLES", "SPA ARMONIA", 0,
                            JOptionPane.QUESTION_MESSAGE, iconD, opcion2, "");

                    if (servicio == 0) {
                        menu2 = JOptionPane.showOptionDialog(null, tratamientoA, "SPA ARMONIA",
                                0,
                                JOptionPane.QUESTION_MESSAGE, iconA, opcion3, null);
                    } else if (servicio == 1) {
                        menu2 = JOptionPane.showOptionDialog(null, tratamientoB, "SPA ARMONIA", 0,
                                JOptionPane.QUESTION_MESSAGE, iconB, opcion3, "");
                    } else if (servicio == 2) {
                        menu2 = JOptionPane.showOptionDialog(null, tratamientoC, "SPA ARMONIA", 0,
                                JOptionPane.QUESTION_MESSAGE, iconC, opcion3, "");
                    } else {
                        menu2 = 3;// Salida del menu
                    }
                } while (menu2 != 3); // iteracion del menu de servicios

            } else if (tipo == 1) {
                // Registro de usuario
                try { // Bloque de control de excepciones try
                      // Entrada del nombre del paciente
                    nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre", "SPA ARMONIA",
                            JOptionPane.INFORMATION_MESSAGE);
                    while (edad < 18) { // Validacion y entrada de la edad del paciente
                        edad = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingrese su edad", "SPA ARMONIA", JOptionPane.INFORMATION_MESSAGE));
                    }
                    while (sexo != 'M' && sexo != 'F') { // Validacion y entrada del sexo del paciente
                        sexo = (JOptionPane
                                .showInputDialog(null, "Sexo: M/F", "SPA ARMONIA", JOptionPane.INFORMATION_MESSAGE)
                                .charAt(0));
                        sexo = Character.toUpperCase(sexo);
                    } 
                    // Eleccion del tratamiento por el paciente
                    tratamiento = (String) JOptionPane.showInputDialog(null,
                            "¿Tramiento a elegir?",
                            "Spa Armonia", JOptionPane.QUESTION_MESSAGE, iconE, opcionTrat,
                            opcionTrat[0]);
                    tratamientoFin = tratamiento.charAt(0);

                    // Mensaje y icono final (Factura)
                    if (tratamientoFin == 'A') {
                        mensajefinal = "\n" + tratamientoA;
                        iconFinal = iconA;
                    } else if (tratamientoFin == 'C') {
                        mensajefinal = "\n" + tratamientoC;
                        iconFinal = iconC;
                    } else if (tratamientoFin == 'B') {
                        mensajefinal = "\n" + tratamientoB;
                        iconFinal = iconB;
                    }

                    // Fecha de entrada
                    fecha = JOptionPane.showInputDialog(null,
                            "Introduzca la fecha de entrada (dd/MM/yyyy): ",
                            fechaInicio.format(fechaFormato)); // Entrada con formato (dd/MM/yyyy)
                    System.out.println(fechaInicio); // Borrar despues de verificar
                    fechaInicio = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Formateo
                    System.out.println(fechaFin); // Borrar despues de verificar

                    // Fecha de salida
                    while (ChronoUnit.DAYS.between(fechaInicio, fechaFin) <= 0) {
                        fecha2 = JOptionPane.showInputDialog(null,
                                "Introduzca la fecha de salida (dd/MM/yyyy): ", // Entrada con formato (dd/MM/yyyy)
                                fechaInicio.format(fechaFormato));
                        fechaFin = LocalDate.parse(fecha2, DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Formateo
                    }

                    // Asignacion de los datos entrada 1
                    objSpa.AsignarDatos(nombre, edad, sexo, tratamientoFin, fechaInicio, fechaFin);

                    // Contadores de paciente, porcentajes y pacientes con descuento especial
                    pacientes++;
                    if (objSpa.devolverEdad() > 60)
                        pacientes60++;
                    else if (objSpa.devolverEdad() < 25)
                        pacientes25++;
                    switch (objSpa.devolverTipoTratamiento()) {
                        case 'A':
                            totalA++;
                            break;
                        case 'B':
                            totalB++;
                            break;
                        case 'C':
                            totalC++;
                            break;
                    }
                    if (objSpa.calcularDiasInternado() >= 5 && objSpa.calcularDiasInternado() <= 7)
                    {
                        if (objSpa.devolverTipoTratamiento() == 'A') {
                            pacientesGratis++;
                        } else if (objSpa.devolverTipoTratamiento() == 'C') {
                            pacientesGratis++;
                        } else if (objSpa.devolverTipoTratamiento() == 'B') {
                            pacientesGratis++;

                        }
                    }

                    // Impresion de factura con todos los datos requeridos
                    JOptionPane.showMessageDialog(null,
                            "                                     SPA ARMONIA \n                                  FACTURA CLIENTE"
                                    + "\nCliente: " + objSpa.devolverNombre()
                                    + "\nEdad: "
                                    + objSpa.devolverEdad()
                                    + "\nSexo: " + objSpa.devolverSexo() + "\nDías de estancia: "
                                    + objSpa.calcularDiasInternado()
                                    + "\nFecha de entrada: " + (objSpa.devolverFecha1()).format(fechaFormato)
                                    + "     Fecha de salida: "
                                    + objSpa.devolverFecha2().format(fechaFormato) + mensajefinal

                                    + "\nCosto del tratamiento escogido:\n" + objSpa.calcularCosto() + '$'
                                    + "\nDescuentos:\n"
                                    + objSpa.calcularDescuentos() + '$' + "\nTotal a pagar:\n" + objSpa.calcularTotal()
                                    + '$'
                                    + "\n\nTiene un descuento adicional: \n"
                                    + objSpa.MostrarDescuentoEspecial(),
                            "Regrese pronto", JOptionPane.INFORMATION_MESSAGE, iconFinal);

                    // Datos inicializados nuevamente para la iteracion
                    sexo = 'H';
                    edad = 0;
                    fechaFin = LocalDate.of(1, 1, 1);
                    fechaInicio = LocalDate.now();

                    // catch de formato de numero y formato de fecha
                } catch (NumberFormatException num) {
                    JOptionPane.showMessageDialog(null, "El valor insertado no es un numero sadf" + num);
                } catch (DateTimeException time) {
                    JOptionPane.showMessageDialog(null, "La de fecha no fue insertada de forma correcta " + time);
                }

            } else {

                // Asignacion de los datos a la segunda clase, porcentajes
                objPorcentaje.asignarDatos(totalA, totalB, totalC, pacientes);

                // Impresion de reghistro final
                JOptionPane.showMessageDialog(null,
                        "                       SPA ARMONIA \n                 REGISTRO DE CLIENTES"
                                + "\nTotal de pacientes: "
                                + pacientes + "\nPersonas mayores a 60 años: " + pacientes60
                                + "\nPersonas menores a 25 años: " + pacientes25
                                + "\nPorcentaje del tratamiento A: "
                                + objDecimal.format(objPorcentaje.calcularPorcentajeA()) + "%"
                                + "\nPorcentaje del tratamiento B: "
                                + objDecimal.format(objPorcentaje.calcularPorcentajeB()) + "%"
                                + "\nPorcentaje del  tratamiento C: "
                                + objDecimal.format(objPorcentaje.calcularPorcentajeC()) + "%"
                                + "\nTotal de paciente con tratamietos gratis: "
                                + pacientesGratis);
                cont1 = 1;// Contador para que el programa salga y termine ejecucucion
            }
        } while (cont1 == 0); // Iteracion del programa y mensaje principal "Menu"
    }
}
