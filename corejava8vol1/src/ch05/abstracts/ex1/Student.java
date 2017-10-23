/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch05.abstracts.ex1;

/**
 *
 * @author jcva175
 */
public class Student extends Person{
    private String major;
    
    public Student(String name, String major)
    {
        super(name);
        this.major = major;
    }
    
    @Override
    public String getDescription()
    {
        return "a studen majoring in " + major;
    }
    
    @Override
    public boolean equals(Object o){return false;}
}
