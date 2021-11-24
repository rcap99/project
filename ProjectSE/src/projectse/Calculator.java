/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Calculator {
    private Set<String> basicOperations;
    private ComplexStack stack;
    private Memory memory;
    
    public Calculator(){
        stack = new ComplexStack();
        memory = new Memory(stack);
        basicOperations = new HashSet<>(Arrays.asList("add","subtract","multiply","divide","sqrt","inversion"));
    }
    
    public void execute(String s){
        String patternComplex = "(([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)\\s*|([-+]?\\d+\\.?\\d*)|([-+]?\\d*\\.?\\d+)\\s*\\s*([-+]?\\s*\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)i)|([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)i";
        ComplexNumber c1, c2;
        if(s.matches(patternComplex)){
            ComplexNumber x = this.parse(s);
            stack.push(x);
        } else{
            if(basicOperations.contains(s)){
                c1 = this.stack.pop();
                switch(s){
                    case "add":
                        c2 = this.stack.pop();
                        this.stack.push(c1.add(c2));
                        break;
                    case "subtract":
                        c2 = this.stack.pop();
                        this.stack.push(c1.subtract(c2));
                        break;
                    case "multiply":
                        c2 = this.stack.pop();
                        this.stack.push(c1.multiplication(c2));
                        break;
                    case "divide":
                        c2 = this.stack.pop();
                        this.stack.push(c1.division(c2));
                        break;
                    case "sqrt":
                        this.stack.push(c1.sqrt());
                        break;
                    case "inversion":
                        this.stack.push(c1.invertSign());
                        break;
                }
            } else if(s.matches(">\\w")){
                memory.saveNumberInMemory(s.substring(1));
            } else if(s.matches("<\\w")){
                memory.getNumberFromMemory(s.substring(1));
            } else if(s.matches("\\+\\w")){
                memory.incrementNumberFromMemory(s.substring(1));
            } else if(s.matches("-\\w")){
                memory.decrementNumberFromMemory(s.substring(1));
            }
        }
    }
    
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
    
    public ComplexStack getComplexStack(){
        return this.stack;
    }
    
    public ArrayList<ComplexNumber> getList(){
        stack=getComplexStack();
        ArrayList<ComplexNumber> l=new ArrayList<>(stack);
        Collections.reverse(l);
        
        ArrayList<ComplexNumber> subList=new ArrayList<>();
        int i=0;
        for(ComplexNumber x: l){
            if(i<18){
                subList.add(x);
            }
            i++;
        }
        
        return subList;
    }
    
}
