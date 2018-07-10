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
public class Heredada extends Modificadores{
    public  void saludar()
    {
        protegido = "Accediendo desde otro paquete, heredando Modificadores";
        System.out.println(protegido);
    }
    public static void main(String[] args) {
        Heredada h = new Heredada();
        h.saludar();
    }
}
