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
    public void setIdPlan(String idPlan) {
        this.idPlan = idPlan;
    }
    public String getDetalles() {
        return Detalles;
    }
    public void setDetalles(String Detalles) {
        this.Detalles = Detalles;
    }
    public String getTipoPlan() {
        return tipoPlan;
    }
    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }
    public double getPrecio() {
        return Precio;
    }
    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    public int getDuracionDias() {
        return duracionDias;
    }
    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }
    public int getGigas() {
        return Gigas;
    }
    public void setGigas(int Gigas) {
        this.Gigas = Gigas;
    }
    public String getBeneficios() {
        return Beneficios;
    }
    public void setBeneficios(String Beneficios) {
        this.Beneficios = Beneficios;
    }
    public String getApps() {
        return Apps;
    }
    public void setApps(String Apps) {
        this.Apps = Apps;
    }
}
