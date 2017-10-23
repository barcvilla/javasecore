/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch05.emun.ex1;

/**
 *
 * @author jcva175
 */
public enum Size {
    SMALL("S"),
    MEDIUM("M"),
    LARGE("L"),
    EXTRA_LARGE("XL");
    
    private String abb;
    
    private Size(String abb)
    {
        this.abb = abb;
    }
    
    public String getAbbreviation()
    {
        return abb;
    }
}
