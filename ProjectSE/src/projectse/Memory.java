/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.util.HashMap;

/**
 * Represents the memory where to store the values ​​of the variables 
 * 
 */
public class Memory {
    private HashMap<String, ComplexNumber> variables;
    private ComplexStack stack;
    
    public Memory(ComplexStack stack) {
        this.variables = new HashMap<>();
        this.stack = stack;
    }

    public Memory() throws Exception {
        throw new Exception("Not supported");
    }
    
    /**
     * Takes the top element from the stack and saves it into the HashMap
     * @param name represents the key in the HashMap 
     */
    public void saveNumberInMemory(String name){
        if(variables.containsKey(name))
            variables.remove(name);
        variables.put(name, stack.peek());
    }   
    
    /**
     * Pushes the value of the variable onto the stack
     * @param name represent the key of element to push
     * 
     */
    public void getNumberFromMemory(String name){
        stack.add(variables.get(name));
    }
    
    /**
     * Takes the top element from the stack and adds it to the value of the variable "name"
     * storing the result of the addiction into "name"
     * @param name represents the key of element to increment
     */
    public void incrementNumberFromMemory(String name){
        if(!variables.containsKey(name))
            this.saveNumberInMemory(name);
        ComplexNumber temp = variables.get(name).add(stack.peek());
        variables.remove(name);
        variables.put(name, temp);
    }
    
    /**
     * Takes the top element from the stack and subtracts it from the value of the variable "name"
     * storing the result of the subtraction into "name"
     * @param name represents the key of element to increment
     */
    public void decrementNumberFromMemory(String name){
        if(!variables.containsKey(name))
            this.saveNumberInMemory(name);
        ComplexNumber temp = variables.get(name).subtract(stack.peek());
        variables.remove(name);
        variables.put(name, temp);
    }
}
