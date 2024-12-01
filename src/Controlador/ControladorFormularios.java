/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.Component;
import java.awt.Container;
import javax.swing.*;
/**
 *
 * @author megap
 */
public class ControladorFormularios {
    
    //Metodo que cambia el valor de los txt (Limpiador de txt)
    public static void limpiarCampos(Container contenedor, String valor) {
        for (Component c : contenedor.getComponents()) {
            if (c instanceof JTextField) {
                ((JTextField) c).setText(valor); 
            } else if (c instanceof Container) {
                limpiarCampos((Container) c, valor);
            }
        }
    }
    
}
