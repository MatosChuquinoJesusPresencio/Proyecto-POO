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
    
    //Atributos del Usuario
    private String idUusario;
    private String Nombre;
    private String apellidoP;
    private String apellidoM;
    private String Email;
    private String Contrasena;
    private String fechaNacimiento;
    private String tipoDocumento;
    private String Documento;
    
    //Constructor del Usuario
    public Usuario(String idUusario, String Nombre, String apellidoP, String apellidoM, String Email, 
            String Contrasena, String fechaNacimiento, String tipoDocumento, String Documento) {
        this.idUusario = idUusario;
        this.Nombre = Nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.Email = Email;
        this.Contrasena = Contrasena;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDocumento = tipoDocumento;
        this.Documento = Documento;
    }
    
    //Metodos Getters and Setters
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
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getDocumento() {
        return Documento;
    }
    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }   
    
    //Metodo abstract para mostrar los datos del cliente en el menu
    public abstract String Bienvenida();
}
