/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.util.EmptyStackException;
import java.util.Stack;


public class ComplexStack extends Stack<ComplexNumber>{

    public ComplexStack() {
        super();
    }
    
    
    public void dup()throws EmptyStackException{
        if (this.isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber b=peek();
        push(b);
    }
        
    
    public void swap() throws EmptyStackException{
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber b1=pop();
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber b2=pop();
        push(b1);
        push(b2);
    }
    
    public void over()throws EmptyStackException{
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber last=pop();
        if(this.isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber secondlast=pop();
        push(secondlast);
        push(last);
        push(secondlast);
    }
    
    
}
