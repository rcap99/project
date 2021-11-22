/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.util.Stack;


public class ComplexStack extends Stack<ComplexNumber>{

    public ComplexStack() {
        super();
    }
    
    
    public void dup(){
        ComplexNumber b=this.peek();
        this.push(b);
    }
    
    public void swap(){
        
    }

}
