/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.ConexionSQL;
import java.util.ArrayList;

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
        this.Lineas = Controlador.ControladorLinea.cargarLineasCliente(ConexionSQL.getConexion(), getIdUusario());
        this.Facturas = Controlador.ControladorFactura.cargarFacturasCliente(ConexionSQL.getConexion(), getIdUusario());
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
    
    //Override del metodo Bienvenida
    @Override
    public String Bienvenida() {
        return "Bienvenido " + getApellidoP() + " " + getApellidoM() + ", " + getNombre();
    }
}