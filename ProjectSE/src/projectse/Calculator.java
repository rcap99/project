/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * This class represent the calculator and it is directly controlled by the Controller class. It has a member {@link ComplexStack}
 * and {@link Memory} to perform all the operations.
 * 
 * @author Group11
 */
public class Calculator {
    private Set<String> basicOperations;
    private ComplexStack stack;
    private Memory memory;
    
    /**
     *  Default constructor for Calculator that creates empty {@link ComplexStack} and {@link Memory} objects.
     */
    public Calculator(){
        stack = new ComplexStack();
        memory = new Memory(stack);
        basicOperations = new HashSet<>(Arrays.asList("+","-","*","/","sqrt","+-"));
    }
    
    /**
     * Executes an operations. It a complex number is provided, it will be added to the stack. Otherwise, the corresponding operation will be executed.
     * 
     * @param s String of the operation to be executed.
     * @return int return code. 0 if the operation has been executed, -1 if there are not enough elements into the stack, -2 if s is not a valid operation.
     */
    public int execute(String s){
        String patternComplex = "(([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)\\s*|([-+]?\\d+\\.?\\d*)|([-+]?\\d*\\.?\\d+)\\s*\\s*([-+]?\\s*\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)i)|([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)i";
        ComplexNumber c1, c2;
        if(s.matches(patternComplex)){
            ComplexNumber x = this.parse(s);
            stack.push(x);
            return 0;
        } else{
            if(basicOperations.contains(s)){
                try{
                    c1 = this.stack.pop();
                } catch(EmptyStackException ex){
                    return -1;
                }
                switch(s){
                    case "+":
                        try{
                            c2 = this.stack.pop();
                        } catch(EmptyStackException ex){
                            stack.push(c1);
                            return -1;
                        }    
                        this.stack.push(c1.add(c2));
                        return 0;
                    case "-":
                        try{
                            c2 = this.stack.pop();
                        } catch(EmptyStackException ex){
                            stack.push(c1);
                            return -1;
                        }
                        this.stack.push(c2.subtract(c1));
                        return 0;
                    case "*":
                        try{
                            c2 = this.stack.pop();
                        } catch(EmptyStackException ex){
                            stack.push(c1);
                            return -1;
                        }
                        this.stack.push(c1.multiplication(c2));
                        return 0;
                    case "/":
                        try{
                            c2 = this.stack.pop();
                        } catch(EmptyStackException ex){
                            stack.push(c1);
                            return -1;
                        }
                        this.stack.push(c2.division(c1));
                        return 0;
                    case "sqrt":
                        this.stack.push(c1.sqrt());
                        return 0;
                    case "+-":
                        this.stack.push(c1.invertSign());
                        return 0;
                }
            } else if(s.matches(">[a-zA-Z]")){
                try{
                    memory.saveNumberInMemory(s.substring(1).toLowerCase());
                } catch(EmptyStackException ex){
                    return -1;
                }
                return 0;
            } else if(s.matches("<[a-zA-Z]")){
                memory.getNumberFromMemory(s.substring(1).toLowerCase());
            } else if(s.matches("\\+[a-zA-Z]")){
                try{
                    memory.incrementNumberFromMemory(s.substring(1).toLowerCase());
                } catch(EmptyStackException ex){
                    return -1;
                }
                return 0;
            } else if(s.matches("-[a-zA-Z]")){
                try{
                    memory.decrementNumberFromMemory(s.substring(1).toLowerCase());
                } catch(EmptyStackException ex){
                    return -1;
                }
                return 0;
            } else if(s.equalsIgnoreCase("clear")){
                stack.clear(); 
                return 0;
            } else if(s.equalsIgnoreCase("drop")){
                try{
                   stack.drop(); 
                } catch(EmptyStackException ex){
                    return -1;
                }
                return 0;
            } else if(s.equalsIgnoreCase("dup")){
                try{
                   stack.dup(); 
                } catch(EmptyStackException ex){
                    return -1;
                }
                return 0;
            } else if(s.equalsIgnoreCase("swap")){
                try{
                   stack.swap(); 
                } catch(EmptyStackException ex){
                    return -1;
                }
                return 0;
            } else if(s.equalsIgnoreCase("over")){
                try{
                   stack.over(); 
                } catch(EmptyStackException ex){
                    return -1;
                }
                return 0;
            }
        }
        return -2;
    }
    
    /**
     * Parses a complex number expressed as a String and returns the corresponding ComplexNumber object.
     * 
     * @param s String to be parsed.
     * @return ComplexNumber object from s
     */
    public ComplexNumber parse(String s){
        String[] splitted = s.split("[+|-]");
        String re, im;
        if(splitted.length == 3){
            re = splitted[1];
            im = splitted[2].replace("i", "");
            if(s.contains("-") && s.lastIndexOf("-") != 0)
                return new ComplexNumber(-Double.parseDouble(re), -Double.parseDouble(im));
            return new ComplexNumber(-Double.parseDouble(re), Double.parseDouble(im));
        } else if(splitted.length == 2){
            re = splitted[0];
            im = splitted[1].replace("i", "");
            if(s.contains("-") && s.lastIndexOf("-") != 0)
                return new ComplexNumber(Double.parseDouble(re), -Double.parseDouble(im));
            return new ComplexNumber(Double.parseDouble(re), Double.parseDouble(im));
        } else if(s.contains("i")){
            return new ComplexNumber(0.0, Double.parseDouble(splitted[0].replace("i", "")));
        } else{
            return new ComplexNumber(Double.parseDouble(splitted[0]), 0.0);
        }
    }
    
    /**
     * This method returns the complex stack used in this Calculator object.
     * @return stack ComplexStack object
     */
    public ComplexStack getComplexStack(){
        return this.stack;
    }
    
    /**
     * Returns the LIFO (last in - first out) representation of the stack.
     * @return List of ComplexNumber in LIFO order
     */
    public List<ComplexNumber> getLifoList(){
       List<ComplexNumber> list=new LinkedList<>();
       
       for(ComplexNumber c: stack){
           list.add(c);
       }
       return list;
    }
    
}
