/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author megap
 */
public class ArraysLineas implements listaLinea{
    private ArrayList<Linea> ListaLineas;
    
    public ArraysLineas (){
        ListaLineas = new ArrayList<Linea>();
    }   
    public void agregarLinea(Linea unaLinea){
        ListaLineas.add(unaLinea);
    }  
    public void modificarLinea(Linea unaLinea, int Posicion){
        ListaLineas.set(Posicion, unaLinea);
    }   
    public void cambiarEstado(int Posicion){
        
    }    
    public Linea devolverLinea(int Posicion){
        return ListaLineas.get(Posicion);
    }
    public Linea buscarLinea (int Telefono){
       return null; 
    }
}
