/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.ch05.database.transacciones;


/**
 *
 * @author PC
 */
public class Persona {
    private int id_persona;
    private String nombre;
    private String ape_paterno;
    private String ape_materno;
    private String email;
    private String telefono;
    
    public Persona(){}
    
    public Persona(int id, String  nom, String pat, String mat, String email, String tel)
    { 
        this.id_persona = id;
        this.nombre = nom;
        this.ape_paterno = pat;
        this.ape_materno = mat;
        this.email = email;
        this.telefono = tel;
    }
    
    public void setId_persona(int id)
    {
        this.id_persona = id;
    }
    
    public int getId_persona() {
        return id_persona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe_paterno() {
        return ape_paterno;
    }

    public void setApe_paterno(String ape_paterno) {
        this.ape_paterno = ape_paterno;
    }

    public String getApe_materno() {
        return ape_materno;
    }

    public void setApe_materno(String ape_materno) {
        this.ape_materno = ape_materno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "id_persona=" + id_persona + ", nombre=" + nombre + ", ape_paterno=" + ape_paterno + ", ape_materno=" + ape_materno + ", email=" + email + ", telefono=" + telefono + '}';
    }
    
    
}
