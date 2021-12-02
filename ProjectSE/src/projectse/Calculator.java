/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import java.io.Serializable;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javafx.scene.control.Alert;
import static projectse.FXMLDocumentController.showAlert;

/**
 * This class represent the calculator and it is directly controlled by the Controller class. It has a member {@link ComplexStack}
 * and {@link Memory} to perform all the operations.
 * 
 * @author Group11
 */
public class Calculator implements Serializable{
    private final Set<String> basicOperations;
    private final Set<String> stackOperations;
    private ComplexStack stack;
    private Memory memory;
    
    /**
     *  Default constructor for Calculator that creates empty {@link ComplexStack} and {@link Memory} objects.
     */
    public Calculator(){
        stack = new ComplexStack();
        memory = new Memory(stack);
        basicOperations = new HashSet<>(Arrays.asList("+","-","*","/","sqrt","+-"));
        stackOperations = new HashSet<>(Arrays.asList("dup", "swap", "clear", "over", "drop"));
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
                return 0;
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
            } else if(s.matches("\\w*:.*")){
                Operation op;
                try{
                    op = new CustomOperation(s.split(":")[1].trim());
                } catch(Exception ex){
                    return -4;
                }
                String name = s.split(":")[0];
                if(basicOperations.contains(name) || stackOperations.contains(name)){
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
                    return -5;
                }
                try{
                    op.modify(newOp);
                } catch(Exception ex){
                    return -4;
                }
                return 0;
            }
            else if(s.matches("del\\s\\w*")){
                String name = s.split(" ")[1];
                Operation op = ComplexNumber.getOperation(name);
                if(op == null){
                    return -5;
                }
                ComplexNumber.deleteCustomOperation(name);
                return 0;
            } else if(s.matches("save")){
                memory.saveMemory();
                this.alertSaveVariables();
                return 0;
            } else if(s.matches("restore")){
                try{
                    memory.restoreMemory();
                    this.alertRestoreVariables();
                } catch(EmptyStackException ex){
                    return -6;
                }
                return 0;
            }
                
        }
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
     * This method prepares the strings that have to be shown when an error occurs
     * and calls the showAlert method defined in the controller
     * @param returnValue
     * @param operation 
     */
    public void alertError(int returnValue,String operation){
        String customText,customAlert;
        switch(returnValue){
            case -2:
                customAlert="Insert a valid operation";
                customText="Unsopperted operation for " + operation;
                break;
            case -3:
                customAlert="Insert a valid operation name";
                customText="You cannot use \"" + operation.split(":")[0] + "\" as custom operation name";
                break;
            case -4:
                customAlert="Insert a valid operation sequence";
                customText="The operation sequence \"" + operation.split(":")[1] + "\" is invalid";
                break;
            case -6:
                customAlert="Save variables first.";
                customText="There aren't saved variables!";
                break;
            default:
                customAlert="Insert the correct number of elements in the stack";
                customText="There aren't enough elements in the stack to execute the operation of "+operation;
                break;
        }
        showAlert(Alert.AlertType.ERROR,"Fatal Error",customAlert,customText);
        }  
    /**
     * This method prepares the strings that have to be shown to inform the user about the state of the saving operation
     * and calls the showAlert method defined in the controller
     */
    public void alertSave(){
        Set<String> op=ComplexNumber.getOperationsNames();
        if (!op.isEmpty()){
            String customText="Operation/s Saved";
            String customAlert="The operation/s of: \n";
            for(String s: op){
                customAlert+="- "+s+"\n";
            }
        customAlert+="has/have been saved";
        showAlert(Alert.AlertType.INFORMATION,"Saving Done",customAlert, customText);
        }
        else{
            String customAlert="Define at least one operation!";
            String customText="There aren't operations that need to be saved!";
            showAlert(Alert.AlertType.ERROR,"Saving Failed",customAlert,customText);
        }
    }
    /**
     * This method prepares the strings that have to be shown to inform the user about the state of the reload operation
     * and calls the showAlert method defined in the controller 
     */
    public void alertReload(Set<String> op){
        if (!op.isEmpty()){
            String customText="Operation/s Reloaded";
            String customAlert="The operation/s of: \n";
            for(String s: op){
                customAlert+="- "+s+"\n";
            }
        customAlert+="has/have been reloaded";
        showAlert(Alert.AlertType.INFORMATION,"Reloading Done",customAlert, customText);
        }
        else{
            String customAlert="Save at least one operation!";
            String customText="There aren't operations that need to be reloaded!";
            showAlert(Alert.AlertType.ERROR,"Reloading Failed",customAlert,customText);
        }
    }
    
    /**
     * This method prepares the strings that have to be shown to inform the user about the delete of all 
     * custom operations stored in file and calls the showAlert method defined in the controller
     */
    public void alertClear(){
        String customAlert="The operation/s has/have been deleted";
        String customText="Operation/s Deleted";
        showAlert(Alert.AlertType.INFORMATION,"Clear Done",customAlert,customText);
    }
    
    /**
     * This method prepares the strings that have to be shown to inform the user about the state of the saving variables
     * and calls the showAlert method defined in the controller
     */
    public void alertSaveVariables(){
        HashMap<String, ComplexNumber> v = this.memory.getVariables();
        if (v!=null){
            String customText="Variable/s Saved";
            String customAlert="The variable/s: \n";
            for(String k: v.keySet()){
                customAlert+="- "+k+": "+v.get(k)+"\n";
            }
        customAlert+="has/have been saved";
        showAlert(Alert.AlertType.INFORMATION,"Saving Done",customAlert, customText);
        }
        else{
            String customAlert="Error in saving variables!";
            String customText="It's not possible to save variable/s!";
            showAlert(Alert.AlertType.ERROR,"Saving Failed",customAlert,customText);
        }
    }
    
    /**
     * This method prepares the strings that have to be shown to inform the user about the state of the restoring variables
     * and calls the showAlert method defined in the controller
     */
    public void alertRestoreVariables(){
        HashMap<String, ComplexNumber> v = this.memory.getVariables();
        if (v!=null){
            String customText="Variable/s Restored";
            String customAlert="The variable/s: \n";
            for(String k: v.keySet()){
                customAlert+="- "+k+": "+v.get(k)+"\n";
            }
        customAlert+="has/have been restored";
        showAlert(Alert.AlertType.INFORMATION,"Restoring Done",customAlert, customText);
        }
        else{
            String customAlert="Error in restoring variables!";
            String customText="It's not possible to restore variable/s!";
            showAlert(Alert.AlertType.ERROR,"restoring Failed",customAlert,customText);
        }
    }
}
