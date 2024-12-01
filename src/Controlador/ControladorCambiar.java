/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author megap
 */
public class ControladorCambiar {
    
    //Metodo para cambiar la contrasena o Email del usuario
    public static void cambiarDato (String tipoDato, String Contrasena, String datoActualizado, String idUsuario){
        
        String Consulta = "UPDATE Usuario SET " + tipoDato + " = ? WHERE idUsuario = ? AND Contrasena = ?";
        
        try (PreparedStatement pstmt = ConexionSQL.getConexion().prepareStatement(Consulta)) {
            
                //Pasamos los parametros a la consulta
                pstmt.setString(1, datoActualizado); 
                pstmt.setString(2, idUsuario); 
                pstmt.setString(3, Contrasena);
            
                int filasActualizadas = pstmt.executeUpdate();
                
                //Si filasActualizadas es 1, se actualizo correctamente
                //Si no, salta un error y se maneja
                if (filasActualizadas > 0) {
                    JOptionPane.showMessageDialog(null, tipoDato + " actualizado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, tipoDato + " incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                }          
                
        } catch (SQLException e) {
            
            JOptionPane.showMessageDialog(null, "Error al actualizar: " + tipoDato + ": " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
}
