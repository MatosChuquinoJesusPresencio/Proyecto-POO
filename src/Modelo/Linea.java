/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author megap
 */
public class Linea {
    
    //Atributos de la linea
    private int idLinea;
    private int Telefono;
    private String Estado;
    private String Plan; 
    private String fechaIncioPlan;
    private String fechaFinPlan;
    private String idUsuario;
    
    //Constructor de la Linea
    public Linea(int idLinea, int Telefono, String Estado, String Plan, String fechaIncioPlan, String fechaFinPlan, String idUsuario) {
        this.idLinea = idLinea;
        this.Telefono = Telefono;
        this.Estado = Estado;
        this.Plan = Plan;
        this.fechaIncioPlan = fechaIncioPlan;
        this.fechaFinPlan = fechaFinPlan;
        this.idUsuario = idUsuario;
    } 
    
    //Metodos Getters and Getters
    public int getTelefono() {
        return Telefono;
    }
    public void setTelefono(int Telefono) {
        this.Telefono = Telefono;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    public String getPlan() {
        return Plan;
    }
    public void setPlan(String Plan) {
        this.Plan = Plan;
    }
    public String getFechaIncioPlan() {
        return fechaIncioPlan;
    }
    public void setFechaIncioPlan(String fechaIncioPlan) {
        this.fechaIncioPlan = fechaIncioPlan;
    }
    public String getFechaFinPlan() {
        return fechaFinPlan;
    }
    public void setFechaFinPlan(String fechaFinPlan) {
        this.fechaFinPlan = fechaFinPlan;
    }   
    public int getIdLinea() {
        return idLinea;
    }
    public void setIdLinea(int idLinea) {
        this.idLinea = idLinea;
    }
    public String getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    } 
}
