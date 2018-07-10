/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch03.poo.paquete_b;

import ch03.poo.paquete_a.Modificadores;

/**
 *
 * @author PC
 */
public class EnOtroPaquete {
    public static void main(String[] args) {
        Modificadores modificadores = new Modificadores();
        //modificadores.publico = "Accediendo desde otro paquete";
        //System.out.println(modificadores.publico);
        
        /*No funciona*/
        //modificadores.porDefector = "Accediendo desde otro paquete";
        //System.out.println(modificadores.porDefector);
        
        /**No funciona*/
        //modificadores.protegido = "Accediendo desde otro paquete";
        //System.out.println(modificadores.protegido);
    }
}
