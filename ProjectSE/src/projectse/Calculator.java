/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Calculator {
    private Set<String> basicOperations;
    private ComplexStack stack;
    
    public Calculator(){
        stack = new ComplexStack();
        //initialize memory
        basicOperations = new HashSet<>(Arrays.asList("add","subtract","multiply","divide","sqrt","inversion"));
                
    }
    
    public void execute(String s){
        
        
        if(s.matches("([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)\\s*|([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)\\s*\\+\\s*([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)i|([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)i")){
            System.out.println("match");
            ComplexNumber x = this.parse(s);
            stack.push(x);
        } else{
            System.out.println("not match");
            //if(basicOperations.contains(s)){
                //execute s
            //}
            //check if s is a custom operation
                //execute s
        }
    }
    
    public ComplexNumber parse(String s){
        String[] splitted = s.split("[^-][+|-]");
        if(splitted.length == 2){
            String re = splitted[0];
            String im = splitted[1].replace("i", "");
            if(s.contains("-") && s.lastIndexOf("-") != 0)
                return new ComplexNumber(Double.parseDouble(re), -Double.parseDouble(im));
            return new ComplexNumber(Double.parseDouble(re), Double.parseDouble(im));
        } else if(s.contains("i")){
            return new ComplexNumber(0.0, Double.parseDouble(splitted[0].replace("i", "")));
        } else{
            return new ComplexNumber(Double.parseDouble(splitted[0]), 0.0);
        }
    }
    
    public ComplexStack getComplexStack(){
        return this.stack;
    }
    
    
}
