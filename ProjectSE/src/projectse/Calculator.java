/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Set;
import static projectse.FXMLDocumentController.showAlert;
import projectse.alert.*;


/**
 * This class represent the calculator and it is directly controlled by the Controller class. It has a member {@link ComplexStack}
 * and {@link Memory} to perform all the operations.
 * 
 * @author Group11
 */
public class Calculator implements Serializable{
    private final Set<String> basicOperations;
    private final Set<String> stackOperations;
    private final Set<String> trascendentalOperations;
    private ComplexStack stack;
    private Memory memory;
    private AlertStrategy alert;
    
    /**
     *  Default constructor for Calculator that creates empty {@link ComplexStack} and {@link Memory} objects.
     */
    public Calculator(){
        stack = new ComplexStack();
        memory = new Memory(stack);
        basicOperations = new HashSet<>(Arrays.asList("+","-","*","/","sqrt","+-"));
        stackOperations = new HashSet<>(Arrays.asList("dup", "swap", "clear", "over", "drop"));
        trascendentalOperations = new HashSet<>(Arrays.asList("abs", "phase", "sin", "cos", "tan", "asin", "acos", "atan", "pow", "log", "exp"));
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
            ComplexNumber x = ComplexNumber.parse(s);
            stack.push(x);
            return 0;
        } else{
            if(basicOperations.contains(s)){
                try{
                    c1 = this.stack.pop();
                } catch(EmptyStackException ex){
                    alert=new AlertError1(s);
                    alert();
                    return -1;
                }
                switch(s){
                    case "+":
                        try{
                            c2 = this.stack.pop();
                        } catch(EmptyStackException ex){
                            stack.push(c1);
                            alert=new AlertError1(s);
                            alert();
                            return -1;
                        }    
                        this.stack.push(c1.add(c2));
                        return 0;
                    case "-":
                        try{
                            c2 = this.stack.pop();
                        } catch(EmptyStackException ex){
                            stack.push(c1);
                            alert=new AlertError1(s);
                            alert();
                            return -1;
                        }
                        this.stack.push(c2.subtract(c1));
                        return 0;
                    case "*":
                        try{
                            c2 = this.stack.pop();
                        } catch(EmptyStackException ex){
                            stack.push(c1);
                            alert=new AlertError1(s);
                            alert();
                            return -1;
                        }
                        this.stack.push(c1.multiplication(c2));
                        return 0;
                    case "/":
                        try{
                            c2 = this.stack.pop();
                        } catch(EmptyStackException ex){
                            stack.push(c1);
                            alert=new AlertError1(s);
                            alert();
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
                    alert=new AlertError1(s);
                    alert();
                    return -1;
                }
                return 0;
            } else if(s.matches("<[a-zA-Z]")){
                try {
                    memory.getNumberFromMemory(s.substring(1).toLowerCase());
                } catch (Exception ex) {
                    alert=new AlertError6(s);
                    alert();
                    return -6;
                }
                return 0;
            } else if(s.matches("\\+[a-zA-Z]")){
                try{
                    memory.incrementNumberFromMemory(s.substring(1).toLowerCase());
                } catch(EmptyStackException ex){
                    alert=new AlertError1(s);
                    alert();
                    return -1;
                }
                return 0;
            } else if(s.matches("-[a-zA-Z]")){
                try{
                    memory.decrementNumberFromMemory(s.substring(1).toLowerCase());
                } catch(EmptyStackException ex){
                    alert=new AlertError1(s);
                    alert();
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
                    alert=new AlertError1(s);
                    alert();
                    return -1;
                }
                return 0;
            } else if(s.equalsIgnoreCase("dup")){
                try{
                   stack.dup(); 
                } catch(EmptyStackException ex){
                     alert=new AlertError1(s);
                     alert();
                    return -1;
                }
                return 0;
            } else if(s.equalsIgnoreCase("swap")){
                try{
                   stack.swap(); 
                } catch(EmptyStackException ex){
                     alert=new AlertError1(s);
                     alert();
                    return -1;
                }
                return 0;
            } else if(s.equalsIgnoreCase("over")){
                try{
                   stack.over(); 
                } catch(EmptyStackException ex){
                     alert=new AlertError1(s);
                     alert();
                    return -1;
                }
                return 0;
            } else if(s.matches("\\w*:.*")){
                Operation op;
                try{
                    op = new CustomOperation(s.split(":")[1].trim());
                } catch(Exception ex){
                    alert=new AlertError4(s);
                    alert();
                    return -4;
                }
                String name = s.split(":")[0];
                if(basicOperations.contains(name) || stackOperations.contains(name)){
                    alert=new AlertError3(s);
                    alert();
                    return -3;
                }
                ComplexNumber.insertCustomOperation(name, op);
                return 0;
            } else if(ComplexNumber.getOperationsNames().contains(s)){
                Operation op = ComplexNumber.getOperation(s);
                ComplexStack tmpStack = (ComplexStack)stack.clone();
                int returnValue = 0;
                for(String o: op.getOperations()){
                    returnValue = execute(o);
                }
                if(returnValue != 0)
                    stack = tmpStack;
                return returnValue;
            } else if(s.matches("modify\\s\\w*:.*")){
                int startIndex = s.split(" ")[0].length() + 1;
                String name = s.substring(startIndex).split(":")[0];
                String newOp = s.substring(startIndex).split(":")[1].trim();
                Operation op = ComplexNumber.getOperation(name);
                if(op == null){
                    alert=new AlertError5(s);
                    alert();
                    return -5;
                }
                try{
                    op.modify(newOp);
                } catch(Exception ex){
                    alert=new AlertError4(s);
                    alert();
                    return -4;
                }
                return 0;
            }
            else if(s.matches("del\\s\\w*")){
                String name = s.split(" ")[1];
                Operation op = ComplexNumber.getOperation(name);
                if(op == null){
                    alert=new AlertError5(s);
                    alert();
                    return -5;
                }
                ComplexNumber.deleteCustomOperation(name);
                return 0;
            } else if(s.matches("save")){
                memory.saveMemory();
                alert=new AlertSaveVariables(memory.getVariables());
                alert();
                return 0;
            } else if(s.matches("restore")){
                try{
                    memory.restoreMemory();
                    alert=new AlertRestoreVariables(memory.getVariables());
                    alert();
                } catch(EmptyStackException ex){
                    alert=new AlertError6(s);
                    alert();
                    return -6;
                }
                return 0;
            }
            else if(trascendentalOperations.contains(s)){
                try{
                    c1 = this.stack.pop();
                } catch(EmptyStackException ex){
                    alert=new AlertError1(s);
                    alert();
                    return -1;
                }
                switch(s){
                    case "abs":
                        stack.push(new ComplexNumber(c1.abs(), 0));
                        break;
                    case "phase":
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
                            alert=new AlertError2(s);
                            alert();
                            return -2;
                        }
                        this.stack.push(c1.power(exp.getRe()));
                        break;
                    case "exp":
                        stack.push(c1.exp());
                        break;
                }
                return 0;
            }     
        }
        alert=new AlertError2(s);
        alert();
        return -2;
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
    
    public AlertStrategy getAlert() {
        return alert;
    }

    public void setAlert(AlertStrategy alert) {
        this.alert = alert;
    }
    
}