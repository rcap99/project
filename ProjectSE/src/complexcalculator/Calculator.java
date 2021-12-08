/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complexcalculator;

import complexcalculator.operation.Operation;
import complexcalculator.operation.CustomOperation;
import complexcalculator.stack.ComplexStack;
import complexcalculator.alert.AlertEmptyVariables;
import complexcalculator.alert.AlertRestoreVariables;
import complexcalculator.alert.AlertOperationName;
import complexcalculator.alert.AlertSaveVariables;
import complexcalculator.alert.AlertNumberElements;
import complexcalculator.alert.AlertBase;
import complexcalculator.alert.AlertInvalidOperationSequence;
import complexcalculator.alert.AlertUnsupportedOperationName;
import complexcalculator.alert.AlertInvalidOperation;
import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Set;
import static complexcalculator.FXMLDocumentController.showAlert;


/**
 * This class represent the calculator and it is directly controlled by the Controller class. It has a member {@link ComplexStack}
 * and {@link Memory} to perform all the operations.
 * 
 * @author Group11
 */
public class Calculator implements Serializable{
    private final Set<String> basicOperations = new HashSet<>(Arrays.asList("+","-","*","/","sqrt","+-"));;
    private final Set<String> stackOperations = new HashSet<>(Arrays.asList("dup", "swap", "clear", "over", "drop"));
    private final Set<String> trascendentalOperations = new HashSet<>(Arrays.asList("mod", "arg", "sin", "cos", "tan", "asin", "acos", "atan", "pow", "log", "exp"));
    private ComplexStack stack;
    private Memory memory;
    private AlertBase alert;
    
    /**
     *  Default constructor for Calculator that creates empty {@link ComplexStack} and {@link Memory} objects.
     */
    public Calculator(){
        stack = new ComplexStack();
        memory = new Memory(stack);
    }
    
    /**
     * Executes an operations. It a complex number is provided, it will be added to the stack. Otherwise, the corresponding operation will be executed.
     * 
     * @param s String of the operation to be executed.
     * @return int return code. 0 if the operation has been executed, -1 if there are not enough elements into the stack, -2 if s is not a valid operation.
     */
    public int execute(String s){
        String patternComplex = "(([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)\\s*|([-+]?\\d+\\.?\\d*)|([-+]?\\d*\\.?\\d+)\\s*\\s*([-+]?\\s*\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)i)|([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)i";
        if(s.matches(patternComplex)){
            ComplexNumber x = ComplexNumber.parse(s);
            stack.push(x);
            return 0;
        }
        if(basicOperations.contains(s)){
            return executeBasicOperation(s);
        }
        if(stackOperations.contains(s)){
            return executeStackOperation(s);
        } 
        else if(trascendentalOperations.contains(s)){
            return executeTrascendentalOperation(s);
        }
        int returnValueVariables = executeVariablesOperation(s);
        int returnValueCustom = executeCustomOperationsOperation(s);
        if(returnValueVariables==-2 && returnValueCustom==-2){
            alert=new AlertInvalidOperation(s);
            alert();
            return -2;
        }
        return returnValueVariables > returnValueCustom ? returnValueCustom : returnValueVariables;
    }
    
    /**
     * This method returns the complex stack used in this Calculator object.
     * @return stack ComplexStack object
     */
    public ComplexStack getComplexStack(){
        return this.stack;
    }

    /**
     * This method returns the set of Basic Operation used in our calculator
     * @return set
     */
    public Set<String> getBasicOperations() {
        return basicOperations;
    }
    /**
     * This method returns the set of Stack Operation used in our calculator
     * @return set
     */
    public Set<String> getStackOperations() {
        return stackOperations;
    }
    /**
     * This method calls the showAlert method defined in the controller
     */
    public void alert(){
        showAlert(alert.getAlertType(),alert.getTitle(),alert.getCustomAlert(),alert.getCustomText());
    }
    /**
     * This method gets the AlertBase object used in this calculator
     * @return AlertBase object
     */
    public AlertBase getAlert() {
        return alert;
    }
    /**This method modifies the AlertBase object used in this calculator
     * 
     * @param alert the new AlertBase object
     */
    public void setAlert(AlertBase alert) {
        this.alert = alert;
    }
    
    private int executeBasicOperation(String s){
        ComplexNumber c1, c2;
        try{
            c1 = stack.pop();
        } catch(EmptyStackException ex){
            alert=new AlertNumberElements(s);
            alert();
            return -1;
        }
        switch(s){
            case "+":
                try{
                    c2 = stack.pop();
                } catch(EmptyStackException ex){
                    stack.push(c1);
                    alert=new AlertNumberElements(s);
                    alert();
                    return -1;
                }    
                stack.push(c1.add(c2));
                break;
            case "-":
                try{
                    c2 = stack.pop();
                } catch(EmptyStackException ex){
                    stack.push(c1);
                    alert=new AlertNumberElements(s);
                    alert();
                    return -1;
                }
                stack.push(c2.subtract(c1));
                break;
            case "*":
                try{
                    c2 = stack.pop();
                } catch(EmptyStackException ex){
                    stack.push(c1);
                    alert=new AlertNumberElements(s);
                    alert();
                    return -1;
                }
                stack.push(c1.multiplication(c2));
                break;
            case "/":
                try{
                    c2 = stack.pop();
                } catch(EmptyStackException ex){
                    stack.push(c1);
                    alert=new AlertNumberElements(s);
                    alert();
                    return -1;
                }
                stack.push(c2.division(c1));
                break;
            case "sqrt":
                stack.push(c1.sqrt());
                break;
            case "+-":
                stack.push(c1.invertSign());
                break;
        }
        return 0;
    }
    
    private int executeStackOperation(String s){
        if(s.equalsIgnoreCase("clear")){
            stack.clear(); 
        }
        if(s.equalsIgnoreCase("drop")){
            try{
               stack.drop(); 
            } catch(EmptyStackException ex){
                alert=new AlertNumberElements(s);
                alert();
                return -1;
            }
        }
        if(s.equalsIgnoreCase("dup")){
            try{
               stack.dup(); 
            } catch(EmptyStackException ex){
                 alert=new AlertNumberElements(s);
                 alert();
                return -1;
            }
        }
        if(s.equalsIgnoreCase("swap")){
            try{
               stack.swap(); 
            } catch(EmptyStackException ex){
                 alert=new AlertNumberElements(s);
                 alert();
                return -1;
            }
        }
        if(s.equalsIgnoreCase("over")){
            try{
               stack.over(); 
            } catch(EmptyStackException ex){
                 alert=new AlertNumberElements(s);
                 alert();
                return -1;
            }
        }
        return 0;
    }
    
    private int executeTrascendentalOperation(String s){
        ComplexNumber c1;
        try{
            c1 = this.stack.pop();
        } catch(EmptyStackException ex){
            alert=new AlertNumberElements(s);
            alert();
            return -1;
        }
        switch(s){
            case "mod":
                stack.push(new ComplexNumber(c1.abs(), 0));
                break;
            case "arg":
                this.stack.push(new ComplexNumber(c1.phase(), 0));
                break;
            case "sin":
                this.stack.push(c1.sin());
                break;
            case "cos":
                this.stack.push(c1.cos());
                break;
            case "tan":
                this.stack.push(c1.tan());
                break;
            case "asin":
                this.stack.push(c1.arcSin());
                break;
            case "acos":
                this.stack.push(c1.arcCos());
                break;
            case "atan":
                this.stack.push(c1.arcTan());
                break;
            case "log":
                this.stack.push(c1.logarithm());
                break;
            case "pow":
                ComplexNumber exp;
                try{
                    exp = stack.pop();
                } catch(EmptyStackException ex){
                    stack.push(c1);
                    alert=new AlertInvalidOperation(s);
                    alert();
                    return -1;
                }
                this.stack.push(c1.power(exp.getRe()));
                break;
            case "exp":
                stack.push(c1.exp());
                break;
        }
        return 0;
    }
    
    private int executeVariablesOperation(String s){
        if(s.matches(">[a-zA-Z]")){
            try{
                memory.saveNumberInMemory(s.substring(1).toLowerCase());
                return 0;
            } catch(EmptyStackException ex){
                alert=new AlertNumberElements(s);
                alert();
                return -1;
            }
        }
        if(s.matches("<[a-zA-Z]")){
            try {
                memory.getNumberFromMemory(s.substring(1).toLowerCase());
                return 0;
            } catch (Exception ex) {
                alert=new AlertEmptyVariables(s);
                alert();
                return -1;
            }
        }
        if(s.matches("\\+[a-zA-Z]")){
            try{
                memory.incrementNumberFromMemory(s.substring(1).toLowerCase());
                return 0;
            } catch(EmptyStackException ex){
                alert=new AlertNumberElements(s);
                alert();
                return -1;
            }
        }
        if(s.matches("-[a-zA-Z]")){
            try{
                memory.decrementNumberFromMemory(s.substring(1).toLowerCase());
                return 0;
            } catch(EmptyStackException ex){
                alert=new AlertNumberElements(s);
                alert();
                return -1;
            }
        }
        if(s.matches("save")){
            memory.saveMemory();
            alert=new AlertSaveVariables(memory.getVariables());
            alert();
            return 0;
        }
        if(s.matches("restore")){
            try{
                memory.restoreMemory();
                alert=new AlertRestoreVariables(memory.getVariables());
                alert();
                return 0;
            } catch(EmptyStackException ex){
                alert=new AlertEmptyVariables(s);
                alert();
                return -1;
            }
        }
        return -2;
    }
    
    private int executeCustomOperationsOperation(String s){
        if(s.matches("\\w*:.*")){
            Operation op;
            try{
                op = new CustomOperation(s.split(":")[1].trim());
            } catch(Exception ex){
                alert=new AlertInvalidOperationSequence(s);
                alert();
                return -1;
            }
            String name = s.split(":")[0];
            if(basicOperations.contains(name) || stackOperations.contains(name)){
                alert=new AlertOperationName(s);
                alert();
                return -1;
            }
            ComplexNumber.insertCustomOperation(name, op);
            return 0;
        }
        if(ComplexNumber.getOperationsNames().contains(s)){
            Operation op = ComplexNumber.getOperation(s);
            ComplexStack tmpStack = (ComplexStack)stack.clone();
            int returnValue = 0;
            for(String o: op.getOperations()){
                returnValue = execute(o);
            }
            if(returnValue != 0)
                stack = tmpStack;
            return returnValue;
        }
        if(s.matches("modify\\s\\w*:.*")){
            int startIndex = s.split(" ")[0].length() + 1;
            String name = s.substring(startIndex).split(":")[0];
            String newOp = s.substring(startIndex).split(":")[1].trim();
            Operation op = ComplexNumber.getOperation(name);
            if(op == null){
                alert=new AlertUnsupportedOperationName(s);
                alert();
                return -1;
            }
            try{
                op.modify(newOp);
                return 0;
            } catch(Exception ex){
                alert=new AlertInvalidOperationSequence(s);
                alert();
                return -1;
            }
        }
        if(s.matches("del\\s\\w*")){
            String name = s.split(" ")[1];
            Operation op = ComplexNumber.getOperation(name);
            if(op == null){
                alert=new AlertUnsupportedOperationName(s);
                alert();
                return -1;
            }
            ComplexNumber.deleteCustomOperation(name);
            return 0;
        }
        return -2;
    }
}
