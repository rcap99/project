/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package projectse;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * This class extends the stack data structure of the java.util library providing a stack of
 *  {@link ComplexNumber} with the functionalities of dup, swap, over, clear and  drop 
 *  expected for our calculator
 * 
 * @see java.util
 * @see Stack
 * @author Group11
 */
public class ComplexStack extends Stack<ComplexNumber> {

    /**
     *  Constructor of the class {@link ComplexStack} that calls the constructor of the generic stack data structure included in the {@link java.util} library
     *  @see ComplexStack
     */
    public ComplexStack() {
        super();
    }
    
    /**
     *   This method pushes a copy of the last element.
     *   It allows us to operate on a copy of the last element.
     * 
     *   @throws EmptyStackException it throws an {@link EmptyStackException} if the stack is empty
     *  
     */
    public void dup()throws EmptyStackException{
        if (isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber b=peek();
        push(b);
    }
        
    /**
     *  This method exchanges the last two elements on the top of the stack.
     *  It allows us to change the order of the operations.
     *   
     * @throws EmptyStackException it throws an {@link EmptyStackException} if the stack is empty
     */
    public void swap() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber b1=pop();
        if(isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber b2=pop();
        push(b1);
        push(b2);
    }
    
    /**
     *  This method pushes a copy of the second last element on the top of the stack.
     *  It allows us to operate on a copy of the second last element.
     *  @throws EmptyStackException it throws an {@link EmptyStackException} if the stack is empty
     */
    public void over()throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber last=pop();
        if(isEmpty()){
            push(last);
            throw new EmptyStackException();
        }
        ComplexNumber secondlast=pop();
        push(secondlast);
        push(last);
        push(secondlast);
    }
    /**
    *   This method overrides the clear method of the {@link java.util} library.
    *   It allows us to insert new numbers in the stack.
    *   @throws EmptyStackException it throws an {@link EmptyStackException} if the stack is empty
    */
    @Override
    public void clear()throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        super.clear();
        
    }
    
    /**
     *  This method removes the last element of the stack.
     *  It allows us to insert a new number if we chose the wrong one. 
     * @throws EmptyStackException it throws an {@link EmptyStackException} if the stack is empty
     */
    public void drop() throws EmptyStackException{
        if(isEmpty()){
            throw new EmptyStackException();
        }
        pop();
    }
    
}
