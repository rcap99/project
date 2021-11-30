/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents the operation defined by the user
 * 
 */
public class CustomOperation implements Operation{
    
    private List<String> operations;
    private Calculator calculator;
    
    /**
     * Costructor of class {@link CustomOperation}, it create an instance of class LinkedList included in {@link java.util} library
     * @param s contains the sequence of operations 
     * @param calculator represents the calculator that execute the operations
     */
    public CustomOperation(String s, Calculator calculator) throws Exception{
        this.operations = new LinkedList<>(); 
        operations.addAll(Arrays.asList(s.split(" ")));
        this.calculator = calculator;
        if(check()==-1)
            throw new Exception();
    }

    /**
     * Execute the sequence of custom operation on the calculator
     */
    @Override
    public void execute() {
        for (int i=0; i<operations.size();i++){
            String operation = operations.get(i);
            calculator.execute(operation);
        }
    }
    /**
     * This method clears the list of operations defined for this custom operation and inserts a new list of operations
     * @param s
     * @return 
     */
    @Override
    public void modify(String s) throws Exception{
        operations.clear();
        operations.addAll(Arrays.asList(s.split(" ")));
        if(check()==-1)
            throw new Exception();
    }
    /**
     * This method checks if the operations defined for this custom operation are valid
     * @return 
     */
    public int check(){
        for(String s:operations){
            if(!calculator.getBasicOperations().contains(s)&&!calculator.getStackOperations().contains(s)&&!ComplexNumber.getOperationsNames().contains(s))
                return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<operations.size();i++){
            s.concat(operations.get(i));
            s.concat(" ");
        }
        return s;
    }

}
