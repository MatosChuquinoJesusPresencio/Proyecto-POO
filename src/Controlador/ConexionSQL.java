/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ParametroBase;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author megap
 */
public class ConexionSQL implements ParametroBase{
    
    //Metodo para obtener la conexion a la base de datos
    public static Connection getConexion() {
    
        //Verificar el driver sql
        try{
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e){           
            JOptionPane.showMessageDialog(null, "Driver mal instalado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        Connection Conexion = null;
        
        //Verificar la conexion a sql
        try {       
            
            Conexion = DriverManager.getConnection(URL, USER, PASSWORD);         
        } catch (SQLException e) {          
            JOptionPane.showMessageDialog(null, "Error en la Conextion: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);         
        }
        return Conexion;
    }
}
