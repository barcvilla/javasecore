/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch03.poo.paquete_a;

/**
 *
 * @author PC
 */
public class EnElMismoPaquete {
    public static void main(String[] args) {
        Modificadores modificadores = new Modificadores();
        //modificadores.publico = "Accediendo desde el mismo paquete";
        //System.out.println(modificadores.publico);
        
        /*No funciona*/
        /*Esta linea siguiente da error ya que el atributo de Modificadores es privado*/
        //modificadores.privado = "accediendo desde el privado";
        
        /*si funciona*/
        //modificadores.porDefector = "Accediendo desde el mismo paquete";
        //System.out.println(modificadores.porDefector);
        
        modificadores.protegido = "Accediendo desde el mismo paquete";
        System.out.println(modificadores.protegido);
    }
}
