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
public class CustomOperation {
    
    private List<String> operations;
    
    public CustomOperation(String s){
        this.operations = new LinkedList<>(); 
        operations.addAll(Arrays.asList(s.split(" ")));
    }
    
}
