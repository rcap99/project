/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.util.HashMap;

/**
 *
 * @author pc
 */
public class Memory {
    private HashMap<String, ComplexNumber> variables;
    private ComplexStack stack;

    public Memory(ComplexStack stack) {
        this.variables = new HashMap<>();
        this.stack = stack;
    }
    
    public void saveNumberInMemory(String name){
        if(variables.containsKey(name))
            variables.remove(name);
        variables.put(name, stack.pop());
    }   
    
    public ComplexNumber getNumberFromMemory(String name){
        return variables.get(name);
    }
    
    public void incrementNumberFromMemory(String name){
        if(!variables.containsKey(name))
            this.saveNumberInMemory(name);
        ComplexNumber temp = variables.get(name).add(stack.pop());
        variables.remove(name);
        variables.put(name, temp);
    }
    
    public void decrementNumberFromMemory(String name){
        if(!variables.containsKey(name))
            this.saveNumberInMemory(name);
        ComplexNumber temp = variables.get(name).subtract(stack.pop());
        variables.remove(name);
        variables.put(name, temp);
    }
}
