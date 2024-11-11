/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author megap
 */
public class ConexionSQL implements ParametroBase{
    public Connection Conexion;
    public Statement st;
    public ResultSet rt;
    public PreparedStatement pst;
    
    public ConexionSQL(){
        try{
            Class.forName(DRIVER);
        } catch (Exception e){           
            JOptionPane.showMessageDialog(null, "Driver mal instalado: " + e.getMessage());
        } 
    }
    
    public static Connection getConexion() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conn;
    }
}
