/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Linea;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author megap
 */
public class ControladorLinea {
    
    //Metodo para crear una nueva linea
    public static Linea nuevaLinea(String idCliente, String idPlan, int Dias, String tipoPlan){
        
        //Metodo que genera un telefono para la linea
        int telefono = generarTelefonoUnico();
        
        //Metodo que genera un id para la linea
        int nuevoID = GenerarNuevoID.nuevaID("Linea");
        
        String Consulta = "INSERT INTO Linea (idLinea, idCliente, idPlan, Telefono, Estado, fechaInicioPlan, fechaFinPlan) VALUES"
                + " (?, ?, ?, ?, ?, GETDATE(), DATEADD(DAY, " + Dias + ", GETDATE()))";
        
        try (PreparedStatement stmt = ConexionSQL.getConexion().prepareStatement(Consulta)) {
            
            //Pasamos los parametros a la linea
            stmt.setInt(1, nuevoID);
            stmt.setString(2, idCliente);
            stmt.setString(3, idPlan);
            stmt.setInt(4, telefono);
            
            //Verificamos el tipo de plan de la linea
            if (tipoPlan.equals("PREPAGO")){
                stmt.setString(5, "SUSPENDIDA");
            } else {
                stmt.setString(5, "ACTIVA");
            }
            
            int filasAfectadas = stmt.executeUpdate();
            
            //Si filasAfectadas es 1, se inserto correctamente
            //Si no, salta un error y se maneja
            if (filasAfectadas > 0) {
                
            // Se crea y devuelve el objeto linea
            return new Linea(nuevoID, telefono, idPlan, tipoPlan, 
                             ControladorObtenerFechas.obtenerFechaActual(), ControladorObtenerFechas.obtenerFechaConDias(Dias), idCliente);
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo insertar la linea.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar la linea.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    //Metodo para generar un unico numero de telefono
    public static int generarTelefonoUnico(){
        int telefono = 0;
        boolean telefonoUnico = false;

        // Generar número aleatorio entre un rango
        while (!telefonoUnico) {
            telefono = 900000000 + (int) (Math.random() * 100000000);

            // Verificar si el número ya existe en la base de datos
            String consulta = "SELECT COUNT(*) FROM Linea WHERE Telefono = ?";
            
            try (PreparedStatement numTelefono = ConexionSQL.getConexion().prepareStatement(consulta)) {
                //Pasamos el parametro a la consulta
                numTelefono.setInt(1, telefono);
                
                ResultSet rs = numTelefono.executeQuery();
                if (rs.next() && rs.getInt(1) == 0) {
                    telefonoUnico = true;
                }
            } catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Error al generar un numero de telefono.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        return telefono;  
    }
    
    //Metodo para obtener un ArrayList de objetos con los atributos de las lineas
    public static ArrayList<Object[]> obtenerLineas(String idCliente) {
        
        //Inicializamos el ArrayList
        ArrayList<Object[]> arregloLinea = new ArrayList<>();

        String Consulta = "SELECT idLinea, Telefono, idPlan, fechaInicioPlan, fechaFinPlan, Estado "
                + "FROM Linea WHERE idCliente = ? AND Estado != 'CANCELADA'";

        try (PreparedStatement stmt = ConexionSQL.getConexion().prepareStatement(Consulta)) {

            //Pasamos el parametro a la consulta
            stmt.setString(1, idCliente);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    
                    // Crea un arreglo con los datos de la fila
                    Object[] datosLinea = {
                        rs.getInt("idLinea"),
                        rs.getInt("Telefono"),
                        rs.getString("idPlan"),
                        rs.getString("Estado"),
                        rs.getDate("fechaInicioPlan"),
                        rs.getDate("fechaFinPlan")
                    };
                   //Agrega al arrayList
                    arregloLinea.add(datosLinea); 
                }
            }
            
    } catch (SQLException e) {
        
        JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
    }
        return arregloLinea;
    } 
    
    //Metodo para actualizar el estado de la linea
    public static void actualizarEstado (String Estado, int idLinea) {
        
        String Consulta = "UPDATE Linea SET Estado = ? WHERE idLinea = ?";
        
        try(PreparedStatement stmt = ConexionSQL.getConexion().prepareStatement(Consulta)){
           
            //Pasamos los parametros a la consulta
            stmt.setString(1, Estado);
            stmt.setInt(2, idLinea);
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Estado Cambiado", "Exito", JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cambiar el estado de la linea.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Metodo para obtener el estado de pago por el id de la linea
    public static String obtenerEstadoPagoPorLinea(int idLinea, String idCliente) {
        
        String estadoPago = null;
        
        String query = "SELECT dbo.ObtenerEstadoPagoPorLinea(?, ?) AS estadoPago";

        try (PreparedStatement stmt = ConexionSQL.getConexion().prepareStatement(query)) {
            
            // Pasamos los parametros a la consulta
            stmt.setInt(1, idLinea);         
            stmt.setString(2, idCliente);     

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Obtenemos el estado de pago                   
                    estadoPago = rs.getString("estadoPago");
                    
                    if (estadoPago == null){
                        return "SUSPENDIDO";
                    } 
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obterner el estado de la linea: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE    );
        }
        return estadoPago;
    }
    
    //Metodo para cargar el arrays de lineas del cliente
    public static ArrayList<Linea> cargarLineasCliente(Connection conexion, String idCliente) {
        
        //Instruccion SQL para obtener las lineas con el id del cliente
        String Consulta = "SELECT idLinea, Telefono, Estado, idPlan, fechaInicioPlan, fechaFinPlan, idCliente " +
                   "FROM Linea WHERE idCliente = ?";
        
        ArrayList<Linea> lineasCliente = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(Consulta)) {
            
            //Pasamos el parametro a la consulta
            ps.setString(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {
                
                //Se obtinen los atributos de la linea, se crea el objeto y se almacena en el arrays de lineas               
                while (rs.next()) {                   
                    Linea lineaCliente = new Linea(
                        rs.getInt("idLinea"),
                        rs.getInt("Telefono"),
                        rs.getString("Estado"),
                        rs.getString("idPlan"),
                        rs.getString("fechaInicioPlan"),
                        rs.getString("fechaFinPlan"),
                        rs.getString("idCliente")
                    );       
                    
                lineasCliente.add(lineaCliente);
                }
            }            
        } catch (SQLException e) {
            System.out.println("Error al cargar las líneas: " + e.getMessage());
        }
        
        return lineasCliente;
    }
}
