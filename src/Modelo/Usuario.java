/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author megap
 */
public abstract class Usuario {
    private String idUusario;
    private String Nombre;
    private String apellidoP;
    private String apellidoM;
    private String Email;
    private String Contrasena;
    private String fechaNacimiento;
    
    public Usuario(){}

    public String getIdUusario() {
        return idUusario;
    }
    public void setIdUusario(String idUusario) {
        this.idUusario = idUusario;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getApellidoP() {
        return apellidoP;
    }
    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }
    public String getApellidoM() {
        return apellidoM;
    }
    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String Email) {
        this.Email = Email;
    }
    public String getContrasena() {
        return Contrasena;
    }
    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFecha(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }        
}
