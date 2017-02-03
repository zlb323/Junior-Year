/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *Java Inheritance II
 * @author zach1
 */

public class JavaApplication3 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Adder a;
        a = new Adder();
        
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());	
        
        System.out.print(a.add(10,32) + " " + a.add(10,3) + " " + a.add(10,10) + "\n");
     
    }
    
}
