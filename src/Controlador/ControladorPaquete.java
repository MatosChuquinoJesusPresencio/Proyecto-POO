/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author megap
 */
public class ControladorPaquete {
      
    //Metodo que devuelve un ArrayList de objetos con los atributos del paquete
    public static ArrayList<Object[]> obtenerDatosPaquetes(){
        
        //Inicializamos el arraylist
        ArrayList<Object[]> datosPaquetes = new ArrayList<>();
        
        String Consulta = "SELECT idPaquete, Descripcion, precioUnitario, duracionDias FROM paqueteAdicional";
        try (PreparedStatement pst = ConexionSQL.getConexion().prepareStatement(Consulta)){
            
            try (ResultSet rs = pst.executeQuery()){
                while(rs.next()){
                    //Obtenemos un arreglos
                    Object[] paquete = {
                        rs.getInt("idPaquete"),
                        rs.getString("Descripcion"),
                        rs.getDouble("precioUnitario"),
                        rs.getInt("duracionDias")
                    };
                    
                    //Guardamos el arreglo en el ArrayList
                    datosPaquetes.add(paquete);
                }
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar los paquetes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return datosPaquetes;
    }
}
