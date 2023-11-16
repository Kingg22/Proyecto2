package clases;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;

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
        ImageIcon iconA = new ImageIcon("resources/imagenes/tratamientoA.jpg");
        ImageIcon iconB = new ImageIcon("resources/imagenes/tratamientoB.jpg");
        ImageIcon iconC = new ImageIcon("resources/imagenes/tratamientoC.jpg");
        ImageIcon iconD = new ImageIcon("resources/imagenes/Welcome.png");
        ImageIcon iconE = new ImageIcon("resources/imagenes/Spa.png");
        ImageIcon iconFinal = null;
        // Mensajes para el menu de servicios del programa
        String tratamientoA = "SERVICIO A (Hot Stones Massage):\nUn maravilloso masaje realizado con calidas piedras volcanicas,\naceite de almendras y aceites esenciales de romero y tomillo.";
        String tratamientoB = "SERVICIO B (Aromaterapia):\nAprovecha de aceites esenciales de las plantas para mejorar el\nequilibrio de la mente, el cuerpo y el espiritu.";
        String tratamientoC = "SERVICIO C (Lodoterapia):\nLimpia los poros, exfolia la piel muerta, y disfruta de una piel\nsuave y tersa, simplemente un tratamiento desintoxicantes,\nrevitalizantes, anti-fatiga y seboreguladores.";
        // Datos de entraada
        String nombre = "", tratamiento, mensajefinal = "", inputSexo, inputEdad, inputFechaInicio = "", inputFechaFin;
        Integer edad = 0, respuesta;
        char sexo = 'A', tratamientoFin = 'l';
        String opcionTrat[] = { "A", "B", "C" }; // Opciones de tratamiento
        // Uso de fecha del sistema y fecha especifica
        LocalDate fechaInicio = null, fechaFin = null;
        // Cracion del contructor del formato de fecha "dd/MM/yyyy"
        DateTimeFormatter fechaFormato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Objetos de las clases
        SpaClass objSpa = new SpaClass(); // Clase Spaclass
        DecimalFormat objDecimal = new DecimalFormat("0.00"); // Constructor para el formato de numeros
        Porcentaje objPorcentaje = new Porcentaje();// Clase Porcentaje

        // variable de Validaciones y porcentajes (Contadores)
        int pacientes = 0, pacientes60 = 0, pacientes25 = 0, pacientesGratis = 0, totalA = 0, totalB = 0, totalC = 0;
        JOptionPane.showMessageDialog(null, "Grupo: \nRey Acosta 8-1024-1653 \nPatrick Villaroel E-8-206126"
                + "\nNathan Carrasco 8-1010-606 \nCarlos Cedeno 8-1019-137",
                "Proyecto 2", JOptionPane.INFORMATION_MESSAGE);
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
                    do {
                        nombre = JOptionPane.showInputDialog(null, "Ingrese su nombre", "SPA ARMONIA",
                                JOptionPane.QUESTION_MESSAGE);
                        if (nombre == null) {
                            // El usuario presionó Cancelar
                            respuesta = JOptionPane.showConfirmDialog(null,
                                    "¿Esta seguro que quiere salir del programa?: ",
                                    "SPA ARMONIA", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null);
                            switch (respuesta) {
                                case 0: // El usuario presionó Cancelar
                                    System.exit(0);
                                    break;

                                case 1:
                                    sexo = 'l';
                                    break;
                            }
                        } else if (nombre.isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                    "Nombre no valido. Por favor, ingrese un nombre valido o presione Cancelar para salir.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } while (nombre == null || nombre.isEmpty());

                    while (edad == null || edad < 18) {
                        inputEdad = JOptionPane.showInputDialog(null, "Ingrese su edad: ", "SPA ARMONIA",
                                JOptionPane.QUESTION_MESSAGE);

                        // Verificar si el usuario ha cancelado
                        if (inputEdad == null) { // Salir del programa si el usuario cancela

                            respuesta = JOptionPane.showConfirmDialog(null,
                                    "¿Esta seguro que quiere salir del programa?: ",
                                    "SPA ARMONIA", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null);
                            switch (respuesta) {
                                case 0:
                                    System.exit(0);
                                    break;

                                case 1:
                                    edad = 0;
                                    break;
                            }

                        } else if (inputEdad.isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                    "Nombre no valido. Por favor, ingrese un nombre valido o presione Cancelar para salir.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        } else if (!inputEdad.isEmpty()) {
                            edad = Integer.parseInt(inputEdad);
                            // Verificar si la edad es menor de 18
                            if (edad < 18) {
                                JOptionPane.showMessageDialog(null, "La edad debe ser igual o mayor a 18.",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }

                    }
                    while (sexo != 'M' && sexo != 'F') { // Validacion y entrada del sexo del paciente
                        inputSexo = JOptionPane.showInputDialog(null, "Sexo: M/F", "SPA ARMONIA",
                                JOptionPane.QUESTION_MESSAGE);

                        // Verificar si el usuario ha cancelado
                        if (inputSexo == null) {

                            respuesta = JOptionPane.showConfirmDialog(null,
                                    "¿Esta seguro que quiere salir del programa?: ",
                                    "SPA ARMONIA", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null);
                            switch (respuesta) {
                                case 0:
                                    System.exit(0);
                                    break;

                                case 1:
                                    sexo = 'l';
                                    break;
                            }
                        } else {
                            // Verificar si la entrada no está vacía y es un carácter
                            if (!inputSexo.isEmpty()) {
                                sexo = Character.toUpperCase(inputSexo.charAt(0));
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Sexo no valido. Por favor, ingrese 'M' o 'F' o cancele para salir.",
                                        "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                    // Eleccion del tratamiento por el paciente
                    while (tratamientoFin != 'A' && tratamientoFin != 'B' && tratamientoFin != 'C') {

                        tratamiento = (String) JOptionPane.showInputDialog(null,
                                "¿Tramiento a elegir?",
                                "Spa Armonia", JOptionPane.QUESTION_MESSAGE, iconE, opcionTrat,
                                opcionTrat[0]);
                        if (tratamiento == null) {
                            respuesta = JOptionPane.showConfirmDialog(null,
                                    "¿Esta seguro que quiere salir del programa?: ",
                                    "SPA ARMONIA", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null);
                            switch (respuesta) {
                                case 0:
                                    System.exit(0);
                                    break;

                                case 1:
                                    fechaInicio = null;
                                    break;
                            }

                        } else {
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
                        }
                    }
                    // Fecha de entrada
                    do {
                        inputFechaInicio = JOptionPane.showInputDialog(null,
                                "Introduzca la fecha de entrada (dd/MM/yyyy) :",
                                (LocalDate.now()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                        // Verificar si el usuario ha cancelado

                        if (inputFechaInicio == null) {
                            respuesta = JOptionPane.showConfirmDialog(null,
                                    "¿Esta seguro que quiere salir del programa?: ",
                                    "SPA ARMONIA", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null);
                            switch (respuesta) {
                                case 0:
                                    System.exit(0);
                                    break;

                                case 1:
                                    fechaInicio = null;
                                    break;
                            }
                        } else if (!inputFechaInicio.isEmpty()) {
                            fechaInicio = LocalDate.parse(inputFechaInicio, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Fecha no valida. Por favor, ingrese una fecha valida o cancele para salir.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                            System.out.println(fechaInicio);
                        }

                    } while (fechaInicio == null);

                    // Entrada de la fecha de salida
                    do {
                        inputFechaFin = JOptionPane.showInputDialog(null,
                                "Introduzca la fecha de salida (dd/MM/yyyy): ",
                                (LocalDate.now()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

                        // Verificar si el usuario ha cancelado
                        if (inputFechaFin == null) {
                            respuesta = JOptionPane.showConfirmDialog(null,
                                    "¿Esta seguro que quiere salir del programa?: ",
                                    "SPA ARMONIA", JOptionPane.YES_NO_OPTION,
                                    JOptionPane.QUESTION_MESSAGE, null);
                            switch (respuesta) {
                                case 0:
                                    System.exit(0);
                                    break;

                                case 1:
                                    fechaFin = null;
                                    break;
                            }
                        }
                        if (!inputFechaFin.isEmpty()) {
                            fechaFin = LocalDate.parse(inputFechaFin, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                        } else {
                            JOptionPane.showMessageDialog(null,
                                    "Fecha no valida. Por favor, ingrese una fecha valida o cancele para salir.",
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } while (fechaFin == null || ChronoUnit.DAYS.between(fechaInicio, fechaFin) <= 0);

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
                    if (objSpa.calcularDiasInternado() >= 5 && objSpa.calcularDiasInternado() <= 7) {
                        // mensaje de descuento especial si aplica
                        JOptionPane.showMessageDialog(null, "Tiene un descuento adicional: \n"
                                + objSpa.MostrarDescuentoEspecial(),
                                "Felicidades!", JOptionPane.INFORMATION_MESSAGE);
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
                                    + "\nSexo: " + objSpa.devolverSexo() + "\nDias de estancia: "
                                    + objSpa.calcularDiasInternado()
                                    + "\nFecha de entrada: " + (objSpa.devolverFecha1()).format(fechaFormato)
                                    + "     Fecha de salida: "
                                    + objSpa.devolverFecha2().format(fechaFormato) + mensajefinal
                                    + "\nCosto del tratamiento escogido:\n" + objSpa.calcularCosto() + '$'
                                    + "\nDescuentos:\n"
                                    + objSpa.calcularDescuentos() + '$' + "\nTotal a pagar:\n" + objSpa.calcularTotal()
                                    + '$',
                            "Regrese pronto", JOptionPane.INFORMATION_MESSAGE, iconFinal);

                    // Datos inicializados nuevamente para la iteracion
                    nombre = "";
                    sexo = 'A';
                    edad = null;
                    fechaFin = null;
                    fechaInicio = null;

                    // catch de formateo de numero y formato de fecha
                } catch (NumberFormatException num) {
                    JOptionPane.showMessageDialog(null, "El valor insertado no es un numero sadf" + num, "Error",
                            JOptionPane.ERROR_MESSAGE);
                } catch (DateTimeException time) {
                    JOptionPane.showMessageDialog(null, "La de fecha no fue insertada de forma correcta " + time,
                            "Error", JOptionPane.ERROR_MESSAGE);
                } catch (StringIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "Error: indice fuera de rango " + e, "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            } else {

                // Asignacion de los datos a la segunda clase, porcentajes
                objPorcentaje.asignarDatos(totalA, totalB, totalC, pacientes);

                // Impresion de resumen final
                JOptionPane.showMessageDialog(null,
                        "                       SPA ARMONIA \n                 REGISTRO DE CLIENTES"
                                + "\nTotal de pacientes: "
                                + pacientes + "\nPersonas mayores a 60 a: " + pacientes60
                                + "\nPersonas menores a 25 a: " + pacientes25
                                + "\nPorcentaje del tratamiento A: "
                                + objDecimal.format(objPorcentaje.calcularPorcentajeA()) + "%"
                                + "\nPorcentaje del tratamiento B: "
                                + objDecimal.format(objPorcentaje.calcularPorcentajeB()) + "%"
                                + "\nPorcentaje del  tratamiento C: "
                                + objDecimal.format(objPorcentaje.calcularPorcentajeC()) + "%"
                                + "\nTotal de paciente con tratamietos gratis: "
                                + pacientesGratis,
                        "Resumen", 1);
                cont1 = 1;// Contador para que el programa salga y termine ejecucucion
            }
        } while (cont1 == 0); // Iteracion del programa y mensaje principal "Menu"
    }
}
