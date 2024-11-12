/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author megap
 */
public class ValidacionesLogin {
    
    public static boolean validarNombre(String nombre) {
        return nombre.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ]{2,}(\\s[A-Za-záéíóúÁÉÍÓÚñÑ]{2,})?$");
    }

    public static boolean validarApellido(String apellido) {
        return apellido.matches("^[A-Za-záéíóúÁÉÍÓÚñÑ]{2,}$");
    }

    public static boolean validarDocumento(String documento, String tipoDocumento) {
        switch (tipoDocumento) {
            case "DNI":
                return documento.matches("\\d{8}");
            case "Pasaporte":
                return documento.matches("\\d{9}");
            default:
                return false;
        }
    }

    public static boolean validarEmail(String email) {
        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$");
    }

    public static boolean validarFechaNacimiento(String fecha) {
        return fecha.matches("^\\d{2}/\\d{2}/\\d{4}$");
    }
}
