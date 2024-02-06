/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Gabriel Ceballos
//Liam Karim
package dondada.javaprogrammingproject;

/**
 *
 * @author gabri
 */
import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        
        // initiate user name 
        String name; 

        // creates a do-while loop to validate name input
        do {
            name = JOptionPane.showInputDialog("Please state you name (no spaces): ");
            
            if(!name.contains(" "))
            {
                break;
            }
        } while(true); 
        
        // try catch method for exception handling
        try {
            Quiz quiz = new Quiz(name); 
        }
        
        catch (Exception e)
        {
            System.out.println("ERROR");
        }
    }
}
