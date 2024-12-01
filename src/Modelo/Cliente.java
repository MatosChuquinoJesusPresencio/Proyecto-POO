/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ConexionSQL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author megap
 */
public final class Cliente extends Usuario{
    
    //Atributos Cliente
    private String fechaRegistro;
    private ArrayList<Linea> Lineas;
    private ArrayList<Factura> Facturas;
    private String Estado;

    //Constructor cuando el cliente se registra
    public Cliente(String idUusario, String Nombre, String apellidoP, String apellidoM, String Email, String Contrasena, String fechaNacimiento, 
            String tipoDocumento, String Documento, String fechaRegistro) {
        super(idUusario, Nombre, apellidoP, apellidoM, Email, Contrasena, fechaNacimiento, tipoDocumento, Documento);
        this.fechaRegistro = fechaRegistro;
        this.Lineas = new ArrayList<>(0); 
        this.Facturas = new ArrayList<>(0);
        this.Estado = "ACTIVO";
    }
    
    //Constructor cunado el cliente se loguea
    public Cliente(String idUusario, String Nombre, String apellidoP, String apellidoM, String Email, String Contrasena, String fechaNacimiento, 
            String tipoDocumento, String Documento, String fechaRegistro, String Estado) {
        super(idUusario, Nombre, apellidoP, apellidoM, Email, Contrasena, fechaNacimiento, tipoDocumento, Documento);
        this.fechaRegistro = fechaRegistro;
        this.Lineas = cargarLineasCliente(ConexionSQL.getConexion());    
        this.Facturas = cargarFacturasCliente(ConexionSQL.getConexion());
        this.Estado = Estado;
    }
    
    //Metodos Getters and Setters
    public String getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String Estado) {
        this.Estado = Estado;
    } 
    public ArrayList<Linea> getLineas() {
        return Lineas;
    }
    public void setLineas(ArrayList<Linea> Lineas) {
        this.Lineas = Lineas;
    }

    public ArrayList<Factura> getFacturas() {
        return Facturas;
    }
    public void setFacturas(ArrayList<Factura> Facturas) {
        this.Facturas = Facturas;
    }
    
    //Metodo para cargar el arrays de lineas del cliente
    public ArrayList<Linea> cargarLineasCliente(Connection conexion) {
        
        //Instruccion SQL para obtener las lineas con el id del cliente
        String Consulta = "SELECT idLinea, Telefono, Estado, idPlan, fechaInicioPlan, fechaFinPlan, idCliente " +
                   "FROM Linea WHERE idCliente = ?";
        
        ArrayList<Linea> lineasCliente = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(Consulta)) {
            
            //Pasamos el parametro a la consulta
            ps.setString(1, this.getIdUusario());

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
    
    public ArrayList<Factura> cargarFacturasCliente(Connection conexion) {
        
        //Instruccion SQL para obtener las lineas con el id del cliente
        String Consulta = "SELECT idFactura, idUsuario, fechaEmision, fechaVencimiento, Total, estadoPago, metodoPago " +
                   "FROM Factura WHERE idUsuario = ?";
        
        ArrayList<Factura> facturasCliente = new ArrayList<>();

        try (PreparedStatement ps = conexion.prepareStatement(Consulta)) {
            
            //Pasamos el parametro a la consulta
            ps.setString(1, this.getIdUusario());

            try (ResultSet rs = ps.executeQuery()) {
                
                //Se obtinen los atributos de la linea, se crea el objeto y se almacena en el arrays de lineas               
                while (rs.next()) {                   
                    Factura factura = new Factura(
                        rs.getInt("idFactura"),
                        rs.getString("idUsuario"),
                        rs.getString("fechaEmision"),
                        rs.getString("fechaVencimiento"),
                        rs.getDouble("Total"),
                        rs.getString("estadoPago"),
                        rs.getString("metodoPago")
                    );       
                    
                facturasCliente.add(factura);
                }
            }            
        } catch (SQLException e) {
            System.out.println("Error al cargar las líneas: " + e.getMessage());
        }
        
        return facturasCliente;
    }
    
    //Metodo para hallar el numero de lineas del array del cliente
    public int getNumeroLineas() {
        return this.Lineas.size();
    }
    
    //Override del metodo Bienvenida
    @Override
    public String Bienvenida() {
        return "Bienvenido " + getApellidoP() + " " + getApellidoM() + ", " + getNombre();
    }
}