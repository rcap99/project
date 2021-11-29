/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author andrea
 */
public class CustomOperation implements Operation{
    
    private List<String> operations;
    private Calculator calculator;
    
    public CustomOperation(String s, Calculator calculator){
        this.operations = new LinkedList<>(); 
        operations.addAll(Arrays.asList(s.split(" ")));
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        for (int i=0; i<operations.size();i++){
            String operation = operations.get(i);
            calculator.execute(operation);
        }
    }

    @Override
    public void modify(String s) {
        operations.clear();
        operations.addAll(Arrays.asList(s.split(" ")));
    }
    
}
