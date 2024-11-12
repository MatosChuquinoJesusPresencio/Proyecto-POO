/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author megap
 */
public class ControladorLogin {
    
    public static boolean verificarDatos(String Documento, String Contrasena){
        String Consulta = "SELECT * FROM Usuario WHERE Documento = ? AND Contrasena = ?";
        
        try (Connection Conexion = ConexionSQL.getConexion();
            PreparedStatement pst = Conexion.prepareStatement(Consulta)){
            
            pst.setString(1, Documento);
            pst.setString(2, Contrasena);
            
            ResultSet rs = pst.executeQuery();
            
            return rs.next();
            
        }catch(SQLException e){
            System.out.println("Error al verificar credenciales: " + e.getMessage()); 
        }
        return false;
    }
    
    public static String nuevoIdCliente() {
        String nuevoId = "USR0001";

        String consulta = "SELECT TOP 1 idUsuario FROM Usuario ORDER BY idUsuario DESC";
        try (Connection conn = ConexionSQL.getConexion();
             PreparedStatement pst = conn.prepareStatement(consulta);
             ResultSet rs = pst.executeQuery()) {

            if (rs.next()) {
                String ultimoId = rs.getString("idUsuario");
                int numero = Integer.parseInt(ultimoId.substring(3)); 
                numero++;
                nuevoId = String.format("USR%04d", numero);
            }

        } catch (SQLException e) {
            System.out.println("Error al generar nuevo idUsuario: " + e.getMessage());
        }
        return nuevoId;
    }
    
    public static boolean registrarCliente(String Nombre, String apellidoP, String apellidoM, 
                                        String Email, String Contrasena, 
                                        String fechaNacimiento, String tipoDocumento, String Documento) {
    
        String idUsuario = nuevoIdCliente();
    
        String consulta1 = "INSERT INTO Usuario (idUsuario, nombre, apellidoP, apellidoM, Email, contrasena, " +
                       "fechaNacimiento, tipoDocumento, Documento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
        String consulta2 = "INSERT INTO Cliente (idUsuario, fechaRegistro, Estado) VALUES (?, GETDATE(), 'ACTIVO')";
    
        try (Connection conn = ConexionSQL.getConexion();
             PreparedStatement pst1 = conn.prepareStatement(consulta1);
             PreparedStatement pst2 = conn.prepareStatement(consulta2)) {
        
            conn.setAutoCommit(false);
            pst1.setString(1, idUsuario);
            pst1.setString(2, Nombre);
            pst1.setString(3, apellidoP);
            pst1.setString(4, apellidoM);
            pst1.setString(5, Email);
            pst1.setString(6, Contrasena);
            pst1.setString(7, fechaNacimiento);
            pst1.setString(8, tipoDocumento);
            pst1.setString(9, Documento);

            int rowsInsertedUsuario = pst1.executeUpdate();

            if (rowsInsertedUsuario > 0) {
                pst2.setString(1, idUsuario);
                int rowsInsertedCliente = pst2.executeUpdate();

                if (rowsInsertedCliente > 0) {
                    conn.commit();  // Si ambas inserciones fueron exitosas, confirmamos la transacción
                    return true;
                } else {
                    conn.rollback();  // Si falla la inserción en Cliente, revertimos los cambios
                    System.out.println("Error al insertar en Cliente");
                    return false;
                }
            } else {
                conn.rollback();  // Si falla la inserción en Usuario, revertimos los cambios
                System.out.println("Error al insertar en Usuario");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar cliente: " + e.getMessage());
            return false;
        }
    }
}
