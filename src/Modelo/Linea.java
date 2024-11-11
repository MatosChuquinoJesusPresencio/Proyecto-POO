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
    private int Telefono;
    private String Estado;
    private String Plan; 
    private String fechaIncioPlan;
    private String fechaFinPlan;
    
    public Linea(){}

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
}
