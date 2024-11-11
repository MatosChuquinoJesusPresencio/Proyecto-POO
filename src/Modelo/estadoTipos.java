/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

/**
 *
 * @author megap
 */
public interface estadoTipos{
    public static final String [] estadoCliente = {"ACTIVO","SUSPENDIDO"};
    public static final String [] estadoPago = {"PENDIENTE","PAGADA","VENCIDA"};
    public static final String [] tipoPlan = {"PREPAGO","POSTPAGO","EMPRESARIAL"};
    public static final String [] estadoLinea = {"ACTIVA","CANCELADA","SUSPENDIDA"};
    
    public static final String [] metodoPago = {"TARJETA","EFECTIVO","DIGITAL"};
}
