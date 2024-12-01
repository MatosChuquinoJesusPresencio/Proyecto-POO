/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author megap
 */
public class Plan {
    
    //Atributos del Plan
    private String idPlan;
    private String Detalles;
    private String tipoPlan;
    private double Precio;
    private int duracionDias;
    private int Gigas;
    private String Beneficios;
    private String Apps;

    //Constructor del Plan
    public Plan(String idPlan, String Detalles, String tipoPlan, double Precio, int duracionDias, int Gigas, String Beneficios, String Apps) {
        this.idPlan = idPlan;
        this.Detalles = Detalles;
        this.tipoPlan = tipoPlan;
        this.Precio = Precio;
        this.duracionDias = duracionDias;
        this.Gigas = Gigas;
        this.Beneficios = Beneficios;
        this.Apps = Apps;
    }

    //Metodos Getters and Setters
    public String getIdPlan() {
        return idPlan;
    }
    public String getDetalles() {
        return Detalles;
    }
    public String getTipoPlan() {
        return tipoPlan;
    }
    public int getDuracionDias() {
        return duracionDias;
    }
    public int getGigas() {
        return Gigas;
    }
    public String getBeneficios() {
        return Beneficios;
    }
    public String getApps() {
        return Apps;
    }   
    public double getPrecio() {
        return Precio;
    }
}
