/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch07.generics.ex1;

/**
 *
 * @author barcvilla
 */
public class Pair_obj_type 
{
    private Object first;
    private Object second;
    
    public Pair_obj_type(Object first, Object second)
    {
        this.first = first;
        this.second = second;
    }
    
    public Object getFirst()
    {
        return first;
    }
    
    public Object getSecond()
    {
        return second;
    }
}
