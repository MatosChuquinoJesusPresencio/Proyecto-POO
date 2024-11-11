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
            
        }catch(Exception e){
            System.out.println("Error al verificar credenciales: " + e.getMessage()); 
        }
        return false;
    }
}
