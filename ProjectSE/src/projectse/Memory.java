/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Stack;

/**
 * Represents the memory where to store the values ​​of the variables 
 * 
 */
public class Memory implements Serializable{
    private HashMap<String, ComplexNumber> variables;
    private ComplexStack stack;
    private Stack<HashMap<String,ComplexNumber>> variablesStack;
    
    /**
     * Constructor of class {@link Memory}, it create an instance of class HashMap included in {@link java.util} library
     * @param stack represents the complex stack associated with the memory
     */
    public Memory(ComplexStack stack) {
        this.variables = new HashMap<>();
        this.stack = stack;
        variablesStack=new Stack<>();
    }

    /**
     * Takes the top element from the stack and saves it into the HashMap
     * @param name represents the key in the HashMap 
     */
    public void saveNumberInMemory(String name)throws EmptyStackException{
        if (stack.isEmpty()){
            throw new EmptyStackException();
        }
        if(variables.containsKey(name))
            variables.remove(name);
        variables.put(name, stack.pop());
    }   
    
    /**
     * Pushes the value of the variable onto the stack
     * @param name represent the key of element to push
     * 
     */
    public void getNumberFromMemory(String name){
        ComplexNumber temp = variables.get(name);
        if(temp!=null)
            stack.add(temp);
    }
    
    /**
     * Takes the top element from the stack and adds it to the value of the variable "name"
     * storing the result of the addiction into "name"
     * @param name represents the key of element to increment
     */
    public void incrementNumberFromMemory(String name)throws EmptyStackException{
        if (stack.isEmpty()){
            throw new EmptyStackException();
        }
        if(!variables.containsKey(name))
            this.saveNumberInMemory(name);
        ComplexNumber temp = variables.get(name).add(stack.pop());
        variables.remove(name);
        variables.put(name, temp);
    }
    
    /**
     * Takes the top element from the stack and subtracts it from the value of the variable "name"
     * storing the result of the subtraction into "name"
     * @param name represents the key of element to increment
     */
    public void decrementNumberFromMemory(String name)throws EmptyStackException{
        if (stack.isEmpty()){
            throw new EmptyStackException();
        }
        if(!variables.containsKey(name))
            this.saveNumberInMemory(name);
        ComplexNumber temp = variables.get(name).subtract(stack.pop());
        variables.remove(name);
        variables.put(name, temp);
    }
    /**
     * This method saves the Map of variables in a stack of variables
     */
    public void saveMemory(){
        variablesStack.push(variables);
    }
    /**
     * This method restores the Map of variables from the stack of variables
     */
    public void restoreMemory(){
        variables=variablesStack.pop();
    }
}
