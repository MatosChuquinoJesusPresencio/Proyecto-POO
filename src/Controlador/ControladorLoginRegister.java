/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Cliente;
import Modelo.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author megap
 */
public class ControladorLoginRegister {
    
    //Metodo para loguear al Cliente
    public static Usuario loguearCliente(String Documento, String Contrasena) {
        

        String consultaUsuario = "SELECT * FROM Usuario WHERE Documento = ? AND Contrasena = ?";
        String consultaCliente = "SELECT * FROM Cliente WHERE idUsuario = ?";
        
        try (PreparedStatement pstUsuario = ConexionSQL.getConexion().prepareStatement(consultaUsuario)){
            
            //Pasamos los parametros a la consulta
            pstUsuario.setString(1, Documento);
            pstUsuario.setString(2, Contrasena);
            
            ResultSet rsUsuario = pstUsuario.executeQuery();
            
            //Si no encuentra el usuario devuelve null
            if (!rsUsuario.next()){
                JOptionPane.showMessageDialog(null, "No se encontraron las credenciales.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
            // Extraer datos de la tabla Usuario
            String idUsuario = rsUsuario.getString("idUsuario");
            String Nombre = rsUsuario.getString("Nombre");
            String apellidoP = rsUsuario.getString("apellidoP");
            String apellidoM = rsUsuario.getString("apellidoM");
            String Email = rsUsuario.getString("Email");
            String fechaNacimiento = rsUsuario.getString("fechaNacimiento");
            String tipoDocumento = rsUsuario.getString("tipoDocumento");
            String documento = rsUsuario.getString("Documento");
            
            try (PreparedStatement pstCliente = ConexionSQL.getConexion().prepareStatement(consultaCliente)){
                
                //Pasamo el parametro a la consulta
                pstCliente.setString(1, idUsuario);
                
                ResultSet rsCliente = pstCliente.executeQuery();
                
                if (rsCliente.next()){
                    String fechaRegistro = rsCliente.getString("fechaRegistro");
                    String Estado = rsCliente.getString("Estado");
                
                    //Creamos un objeto Cliente
                    Cliente Cliente = new Cliente(idUsuario, Nombre, apellidoP, apellidoM, 
                                   Email, Contrasena, fechaNacimiento, tipoDocumento, documento, fechaRegistro, Estado);
                    
                    return Cliente;
                }
                
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se pudo extraer el cliente.", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(e.getMessage());
                return null;
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return null;
    }
    
    //Metodo para generar un nuevo id del cliente
    public static String nuevoIdCliente() {
        
        //Id por defecto si no hay registros
        String nuevoId = "USR0001";

        String consulta = "SELECT TOP 1 idUsuario FROM Usuario ORDER BY idUsuario DESC";
        try (PreparedStatement pst = ConexionSQL.getConexion().prepareStatement(consulta);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                //Almacena el ultimo id
                String ultimoId = rs.getString("idUsuario");
                
                //Suma mas 1 el id almacenado
                int numero = Integer.parseInt(ultimoId.substring(3)); 
                numero++;
                nuevoId = String.format("USR%04d", numero);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo generar nuevo id.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return nuevoId;
    }
    
    //Metodo para registrar al cliente
    public static Cliente registrarCliente(String Nombre, String apellidoP, String apellidoM,
                                       String Email, String Contrasena, String fechaNacimiento,
                                       String tipoDocumento, String Documento) {
        
        //Genera un id para el cliente                               
        String idUsuario = nuevoIdCliente();
    
        String consulta1 = "INSERT INTO Usuario (idUsuario, Nombre, apellidoP, apellidoM, Email, Contrasena, " +
                        "fechaNacimiento, tipoDocumento, Documento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
        String consulta2 = "INSERT INTO Cliente (idUsuario, fechaRegistro, numLineas, Estado) VALUES (?, GETDATE(), 0, 'ACTIVO')";
    
        try (PreparedStatement insertUsuario = ConexionSQL.getConexion().prepareStatement(consulta1);
            PreparedStatement insertCliente = ConexionSQL.getConexion().prepareStatement(consulta2)) {
        
            ConexionSQL.getConexion().setAutoCommit(false);
        
            //Pasamos los parametros a la consulta
            insertUsuario.setString(1, idUsuario);
            insertUsuario.setString(2, Nombre);
            insertUsuario.setString(3, apellidoP);
            insertUsuario.setString(4, apellidoM);
            insertUsuario.setString(5, Email);
            insertUsuario.setString(6, Contrasena);
            insertUsuario.setString(7, fechaNacimiento);
            insertUsuario.setString(8, tipoDocumento);
            insertUsuario.setString(9, Documento);
        
        int rowsInsertedUsuario = insertUsuario.executeUpdate();
        
        //Si rowsInsertedUsuario es 1, se inserto correctamente
        //Si no, salta un error y se maneja
        if (rowsInsertedUsuario > 0) {

            //Inserta el usuario
            insertCliente.setString(1, idUsuario);
            
            int rowsInsertedCliente = insertCliente.executeUpdate();
            
            if (rowsInsertedCliente > 0) {
                
                ConexionSQL.getConexion().commit(); 
                
                String fechaRegistro = ControladorObtenerFechas.obtenerFechaActual();
                
                //Crea un objeto cliente y lo devuelve
                Cliente Cliente = new Cliente (idUsuario, Nombre, apellidoP, apellidoM,
                                   Email, Contrasena, fechaNacimiento, tipoDocumento, Documento, fechaRegistro);
                
                return Cliente;
            } else {
                // Si falla la inserción en Cliente, se revierte
                ConexionSQL.getConexion().rollback(); 
                JOptionPane.showMessageDialog(null, "Error al insertar el Cliente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Si falla la inserción en Usuario, se revierte
            ConexionSQL.getConexion().rollback(); 
            JOptionPane.showMessageDialog(null, "Error al insertar al Usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al regsitrar al usuario.", "Error", JOptionPane.ERROR_MESSAGE);        
        }
        return null; 
    }   
    
    //Metodo para validar las entradas del frmRegister
    public static boolean validacionesDatos (String Nombre, String apellidoP, String apellidoM, String numDocumento, String Contrasena,
            String Email, String tipoDocumento, String fechaNacimiento){
        if (Nombre.isEmpty() || apellidoP.isEmpty() || numDocumento.isEmpty() || Contrasena.isEmpty() || Email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }      
        if (!Validaciones.validarNombre(Nombre)) {
            JOptionPane.showMessageDialog(null, "Nombre inválido. Debe contener una o dos palabras.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Validaciones.validarApellido(apellidoP)) {
            JOptionPane.showMessageDialog(null, "Apellido paterno inválido. Debe contener solo una palabra.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Validaciones.validarApellido(apellidoM)) {
            JOptionPane.showMessageDialog(null, "Apellido materno inválido. Debe contener solo una palabra.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Validaciones.validarDocumento(numDocumento, tipoDocumento)) {
            JOptionPane.showMessageDialog(null, "Número de documento inválido para el tipo seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Validaciones.validarEmail(Email)) {
            JOptionPane.showMessageDialog(null, "Correo electrónico inválido.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Validaciones.validarFechaNacimiento(fechaNacimiento)) {
        JOptionPane.showMessageDialog(null, "Fecha de nacimiento inválida. Formato correcto: dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
