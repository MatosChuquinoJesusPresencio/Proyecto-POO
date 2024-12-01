/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author megap
 */
public class ControladorObtenerFechas {
    
    //Metodo para obtener la fecha actual
    public static String obtenerFechaActual() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(formatter);
    }
    
    //Metodo para sumar dias a la fecha actual 
    public static String obtenerFechaConDias(int diasASumar) {
        LocalDate fechaActual = LocalDate.now();
    
        // Sumar los días deseados a la fecha actual
        LocalDate nuevaFecha = fechaActual.plusDays(diasASumar);

        // Formatear la nueva fecha en el formato deseado
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return nuevaFecha.format(formatter);
    }
}
