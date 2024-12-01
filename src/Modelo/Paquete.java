/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author megap
 */
public class Paquete {
    
    //Atributos del paquete
    private int idPaquete;
    private String Nombre;
    private String Descripcion;
    private double precioUnitario;
    private int duracionDias;

    //Constructor del paquete
    public Paquete(int idPaquete, String Nombre, String Descripcion, double precioUnitario, int duracionDias) {
        this.idPaquete = idPaquete;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.precioUnitario = precioUnitario;
        this.duracionDias = duracionDias;
    }

    //Metodos getters y setters
    public int getIdPaquete() {
        return idPaquete;
    }
    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public int getDuracionDias() {
        return duracionDias;
    }
    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }
}
