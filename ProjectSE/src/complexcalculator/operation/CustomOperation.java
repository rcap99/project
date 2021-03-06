package complexcalculator.operation;

import complexcalculator.ComplexNumber;
import java.io.Serializable;
import java.util.*;

/**
 * Represents the operation defined by the user
 * 
 */
public class CustomOperation implements Operation,Serializable{
    
    private List<String> operations;
    private final Set<String> basicOperations = new HashSet<>(Arrays.asList("+","-","*","/","sqrt","+-"));
    private final Set<String> stackOperations = new HashSet<>(Arrays.asList("dup", "swap", "clear", "over", "drop"));
    private final Set<String> variablesOperations = new HashSet<>(Arrays.asList("(\\s*)>[a-zA-Z]", "(\\s*)<[a-zA-Z]", "save", "restore", "(\\s*)\\+[a-zA-Z]", "(\\s*)\\-[a-zA-Z]"));
    private final String patternComplex = "(([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)|([-+]?\\d+\\.?\\d*)|([-+]?\\d*\\.?\\d+)([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)i)|([-+]?\\d+\\.?\\d*|[-+]?\\d*\\.?\\d+)i";
    private final Set<String> trascendentalOperations = new HashSet<>(Arrays.asList("mod", "arg", "sin", "cos", "tan", "asin", "acos", "atan", "pow", "log", "exp"));
    
    /**
     * Constructor of class {@link CustomOperation}, it create an instance of class LinkedList included in {@link java.util} library
     * @param s contains the sequence of operations 
     * @throws Exception this method generates an @link{Exception} if the user inserts an invalid operation
     */
    public CustomOperation(String s) throws Exception{
        this.operations = new LinkedList<>(); 
        operations.addAll(Arrays.asList(s.split(" ")));
        if(check()==-1)
            throw new Exception();
    }

    /**
     * This method clears the list of operations defined for this custom operation and inserts a new list of operations
     * @param s a string representing the new sequence of operation associated with this object
     * 
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
     * @return int
     */
    public int check(){
        for(String s:operations){
            if(!basicOperations.contains(s) && !stackOperations.contains(s) && !ComplexNumber.getOperationsNames().contains(s) && !s.matches(patternComplex) && !trascendentalOperations.contains(s)){
                for(String x: variablesOperations){
                    if(s.matches(x))
                        return 0;
                }
                return -1;
            }
        }
        return 0;
    }
    /**
     * This method a string representation for this object
     * @return String
     */
    @Override
    public String toString() {
        String s="";
        for(int i=0;i<operations.size();i++){
            s+=operations.get(i);
            s+=" ";
        }
        return s;
    }

    /**
     * This method returns the list of operations contained in this object 
     * @return List
     */
    @Override
    public List<String> getOperations() {
        return operations;
    }
    
    

    
}
