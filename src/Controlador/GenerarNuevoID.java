/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author megap
 */
public class GenerarNuevoID {
    
    //Metodo para generar un nuevo id
    public static int nuevaID(String datoEntrante){
        String datoAlmacenado;
        if (datoEntrante.equals("Detalle")){
            datoAlmacenado = "detalleFactura";
        } else {
            datoAlmacenado = datoEntrante;
        }
        
        String query = "SELECT MAX(id" +  datoEntrante + ") FROM " + datoAlmacenado;  
        
        try (Statement stmt = ConexionSQL.getConexion().createStatement();
                
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                // Si la tabla tiene registros, incrementamos el último idFactura
                return rs.getInt(1) + 1;
            } else {
                // Si la tabla está vacía, se comienza de 1
                return 1;
            }
         } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al generar un id Factura.", "Error", JOptionPane.ERROR_MESSAGE);
         }
        return 1;
    }
}
