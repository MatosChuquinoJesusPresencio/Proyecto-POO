/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author megap
 */
public class Empleado extends Usuario {
    private String fechaContratacion;
    private double Salario;
    
    public Empleado() {}
    
    public String getFechaContratacion() {
        return fechaContratacion;
    }
    public void setFechaContratacion(String fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }
    public double getSalario() {
        return Salario;
    }
    public void setSalario(double Salario) {
        this.Salario = Salario;
    }
  
}
