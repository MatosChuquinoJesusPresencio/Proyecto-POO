/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author megap
 */

//Parametros de la base de datos
public interface ParametroBase {
    public static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=Telefonia;encrypt=false;trustServerCertificate=true";
    public static final String USER = "sa";
    public static final String PASSWORD = "megapeka884";
    
}
