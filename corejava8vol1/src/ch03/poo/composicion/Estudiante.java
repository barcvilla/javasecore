/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch03.poo.composicion;

/**
 *
 * @author PC
 */
public class Estudiante 
{
    /*Aplicamos el concepto de Composicion: En lugar de heredar de Persona, componemos un objeto Persona dentro de Estudiante*/
    public Persona persona;
    public String codigo;
    
}
