/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Plan; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author megap
 */
public class ControladorPlan {

    //Metodo para cargar los planes
    public static ArrayList<Plan> cargarPlanes(String Plan) {
        
        ArrayList<Plan> tipoPlanes = new ArrayList<>(0); 
        String consulta = "SELECT idPlan, Detalles, tipoPlan, Precio, duracionDias, Gigas, Beneficios, Apps FROM [Plan] WHERE tipoPlan = ?";
        
        try (Connection conexion = ConexionSQL.getConexion();
         PreparedStatement pst = conexion.prepareStatement(consulta)){
            
            //Pasamos el parametro a la consulta
            pst.setString(1, Plan);
            
            ResultSet rs = pst.executeQuery();
                       
            while (rs.next()){
                
                //Creamos un nuevo plan
                Plan plan = new Plan(
                    rs.getString("idPlan"),
                    rs.getString("Detalles"),
                    rs.getString("tipoPlan"),
                    rs.getDouble("Precio"),
                    rs.getInt("duracionDias"),
                    rs.getInt("Gigas"),
                    rs.getString("Beneficios"),
                    rs.getString("Apps")
                );
                
                //Almacenamos el plan creado
                tipoPlanes.add(plan);
            }
            
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cargar los planes", "Error", JOptionPane.ERROR_MESSAGE);
        } 
        return tipoPlanes;
    }
}
