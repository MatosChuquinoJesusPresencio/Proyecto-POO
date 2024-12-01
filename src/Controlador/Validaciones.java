/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author megap
 */
public class Validaciones {
    
    //Validacion del nombre del cliente
    public static boolean validarNombre(String nombre) {
        return nombre.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ]{2,}(\\s[A-Za-záéíóúÁÉÍÓÚñÑ]{2,})?$");
    }
    
    //Validacion de los apellidos
    public static boolean validarApellido(String apellido) {
        return apellido.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ]{2,}$");
    }

    //Validacion del numero de documento
    public static boolean validarDocumento(String documento, String tipoDocumento) {
        return switch (tipoDocumento) {
            case "DNI" -> documento.matches("\\d{8}");
            case "Pasaporte" -> documento.matches("\\d{9}");
            default -> false;
        };
    }
    
    //Validacion del Email
    public static boolean validarEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }
    
    //Validacicion de la fecha de nacimiento
    public static boolean validarFechaNacimiento(String fecha) {
        return fecha.matches("^\\d{2}/\\d{2}/\\d{4}$");
    }
}
