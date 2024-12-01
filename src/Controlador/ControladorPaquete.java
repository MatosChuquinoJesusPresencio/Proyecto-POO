/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Modelo.Paquete;
/**
 *
 * @author megap
 */
public class ControladorPaquete {
      
    //Metodo que devuelve un ArrayList de objetos con los atributos del paquete
    public static ArrayList<Paquete> obtenerDatosPaquetes(){
        
        //Inicializamos el arraylist
        ArrayList<Paquete> datosPaquetes = new ArrayList<>();
        
        String Consulta = "SELECT * FROM paqueteAdicional";
        try (PreparedStatement pst = ConexionSQL.getConexion().prepareStatement(Consulta)){
            
            try (ResultSet rs = pst.executeQuery()){
                while(rs.next()){
                    
                    //Obtenemos los datos del paquete 
                    int idPaquete = rs.getInt("idPaquete");
                    String Nombre = rs.getString("Nombre");
                    String Descripcion = rs.getString("Descripcion");
                    double precioUnitario = rs.getDouble("precioUnitario");
                    int duracionDias = rs.getInt("duracionDias");
                    
                    //Creamos el objeto paquete y lo guardamos
                    Paquete Paquete = new Paquete(idPaquete, Nombre, Descripcion, precioUnitario, duracionDias);
                    datosPaquetes.add(Paquete);
                }
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar los paquetes: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return datosPaquetes;
    }
}
