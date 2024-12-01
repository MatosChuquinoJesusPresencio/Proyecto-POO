/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Factura;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author megap
 */
public class ControladorFactura {
    
    //Metodo para crear y insertar una nueva Factura
    public static Factura nuevaFactura(String idUsuario, double Total, int Dias){
        
        //Metodo para crear un nuevo id
        int nuevoID = GenerarNuevoID.nuevaID("Factura");
        
        String Consulta = "INSERT INTO Factura (idFactura, idUsuario, fechaEmision, fechaVencimiento, Total, estadoPago, metodoPago) VALUES"
                + " (?, ?, GETDATE(), DATEADD(DAY, " + Dias + ", GETDATE()), ?, 'PENDIENTE', NULL)";
        
        try (PreparedStatement stmt = ConexionSQL.getConexion().prepareStatement(Consulta)) {
            
            //Pasamos los parametros a la consulta
            stmt.setInt(1, nuevoID);
            stmt.setString(2, idUsuario);
            stmt.setDouble(3, Total);
            
            int filasAfectadas = stmt.executeUpdate();

            //Si filasAfectadas es 1, se inserto correctamente
            //Si no, salta un error y se maneja
            if (filasAfectadas > 0) {
                
            //Crea el objeto factura y lo devuelve
            return new Factura(nuevoID, idUsuario, ControladorObtenerFechas.obtenerFechaActual(), 
                    ControladorObtenerFechas.obtenerFechaConDias(Dias), Total, "PENDIENTE", "");
            
            } else {
                
                JOptionPane.showMessageDialog(null, "No se pudo insertar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
                return null;
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar la factura.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    //Metodo para insertar un detalle de la factura
    public static void nuevoDetalleDactura(int idFactura, Integer idLinea, Integer idPaquete, String Descripcion, double precioLinea,
        int cantidadPaquete, double precioUnitario){
        
        //Si idLinea es null, se supone es que es una linea prepago
        if (idLinea == null){
            JOptionPane.showMessageDialog(null, "No tiene ninguna linea prepago", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        double subTotal = cantidadPaquete * precioUnitario + precioLinea;
        
        //Genera un nuevo id para el detalle de la factura
        int nuevoID = GenerarNuevoID.nuevaID("Detalle");
        String Consulta = "INSERT INTO detalleFactura (idDetalle, idFactura, idLinea, idPaquete, Descripcion,"
                + " precioLinea, cantidadPaquete, precioUnitario, subTotal) VALUES"
                + " (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = ConexionSQL.getConexion().prepareStatement(Consulta)) {
            
            //Se pasan los parametros a la consulta
            stmt.setInt(1, nuevoID);
            stmt.setInt(2, idFactura);
            stmt.setInt(3, idLinea);
            
            //Verificamos si idPaquete es null
            if (idPaquete == null) {
                stmt.setNull(4, java.sql.Types.INTEGER);
            } else {
                stmt.setInt(4, idPaquete);
            }
            
            stmt.setString(5, Descripcion);
            stmt.setDouble(6, precioLinea);
            stmt.setInt(7, cantidadPaquete);
            stmt.setDouble(8, precioUnitario);
            stmt.setDouble(9, subTotal);           
            
            int filasAfectadas = stmt.executeUpdate();
            
            //Si filasAfectadas es 1, se inserto correctamente
            //Si no, salta un error y se maneja
            if (filasAfectadas > 0) {
                
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo insertar el detalle factura.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error al registrar el detalle factura.", "Error", JOptionPane.ERROR_MESSAGE);
        }     
    }
    
    //Metodo para obtener un ArrayList de objetos con los atributos de Factura
    public static ArrayList<Object[]> obtenerDatosFacturas(String idCliente) {
        
        //Inicializamos el ArrayList
        ArrayList<Object[]> arregloFactura = new ArrayList<>();

        String Consulta = "SELECT * FROM ObtenerFacturasPorCliente(?)";

        try (PreparedStatement stmt = ConexionSQL.getConexion().prepareStatement(Consulta)) {

            //Pasamos el parametro a la consulta
            stmt.setString(1, idCliente);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    
                    // Crea un arreglo con los datos de la fila
                    Object[] datosFactura = {
                        rs.getInt("idFactura"),
                        rs.getInt("Telefono"),
                        rs.getString("idPlan"),
                        rs.getDouble("Total"),
                        rs.getDate("fechaEmision"),
                        rs.getDate("fechaVencimiento"),
                        rs.getString("estadoPago")                      
                    };
                    //Agregamos la fila al ArrayList
                    arregloFactura.add(datosFactura);
                }
            }
            
    } catch (SQLException e) { 
        JOptionPane.showMessageDialog(null, "Error al obtener los datos: " + e.getMessage());
    }
        return arregloFactura;
    }
    
    //Metodo para actualizar el estado de la factura
    public static void ActualizarFactura(String idUsuario, int idFactura, String metodoPago){
        
        String Consulta = "UPDATE Factura SET metodoPago = ?, estadoPago = 'PAGADA' WHERE "
                + "idUsuario = ? AND idFactura = ?";
        
        try(PreparedStatement psmt = ConexionSQL.getConexion().prepareStatement(Consulta)){
            
            //Pasamos los parametros a la consulta
            psmt.setString(1, metodoPago);
            psmt.setString(2, idUsuario);
            psmt.setInt(3, idFactura);
            
            psmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Pago realizado con exito", "Exito", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException e){
            //Manejamos el error si es que sale
            JOptionPane.showMessageDialog(null, "Error al pagar la factura: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    //Metodo que obtiene el precio de la linea por el id de la linea
    public static double obtenerPrecioLinea (int idLinea){
        
        String Consulta = "SELECT P.Precio FROM Linea AS L INNER JOIN [Plan] AS P ON L.idPlan = P.idPlan WHERE L.idLinea = ?";
        
        double precio = 0;
        
        try (PreparedStatement pst = ConexionSQL.getConexion().prepareStatement(Consulta)){
            
            //Pasamos el parametro a la consulta
            pst.setInt(1, idLinea);
            
            //Comprobamos si el precio es correcta y asignamos a la variable precio
            try(ResultSet rs = pst.executeQuery()){
                if(rs.next()){
                   precio = rs.getDouble("Precio");
                }
            }
            
        } catch (SQLException e){
            
            JOptionPane.showMessageDialog(null, "Error al obtener el precio: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return precio;
    }
}
