/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complexcalculator;
import complexcalculator.ComplexNumber;
import complexcalculator.ComplexStack;
import complexcalculator.Memory;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import static org.junit.Assert.*;
import org.junit.*;
/**
 *
 * @author pc
 */
public class MemoryTest {
    private ComplexNumber z;
    private ComplexNumber x;
    private ComplexNumber y;
    private ComplexStack cs;
    private Memory m;
    private Stack<HashMap<String,ComplexNumber>> variablesStack;
    
    @Before
    public void setUp(){
        z = new ComplexNumber(2.4,3.7); 
        x = new ComplexNumber(1.1,0.3);
        y = new ComplexNumber(2.4,3.6);
        cs = new ComplexStack();
        m = new Memory(cs);
         
    }
    
    @Test
    public void testSaveNumberInMemory() throws Exception{
        cs.push(z);
        m.saveNumberInMemory("a");
        m.getNumberFromMemory("a");
        assertEquals(z, cs.peek());
    }
    @Test
    public void testIncrementNumberInMemory() throws Exception{
        cs.push(z);
        m.saveNumberInMemory("a");
        cs.push(x);
        m.incrementNumberFromMemory("a");
        m.getNumberFromMemory("a");
        assertTrue(z.add(x).equals(cs.pop()));
    }
    @Test
    public void testDecrementNumberInMemory() throws Exception{
        cs.push(z);
        m.saveNumberInMemory("a");
        cs.push(x);
        m.decrementNumberFromMemory("a");
        m.getNumberFromMemory("a");
        assertTrue(z.subtract(x).equals(cs.pop()));
    }
    
    @Test
    public void testSaveMemory(){
        cs.push(z);
        m.saveNumberInMemory("a");
        m.saveMemory();
       variablesStack=m.getVariablesStack();
       for(HashMap<String,ComplexNumber> m:variablesStack){
           for(Entry<String, ComplexNumber> s:m.entrySet()){
               assertEquals(s.getKey(), "a");
               assertEquals(s.getValue(),new ComplexNumber(2.4,3.7));
           }
       }
    }
    @Test
    public void testRestoreMemory(){
        cs.push(z);
        m.saveNumberInMemory("a");
        m.saveMemory();
        m.restoreMemory();
       variablesStack=m.getVariablesStack();
       for(HashMap<String,ComplexNumber> m:variablesStack){
           for(Entry<String, ComplexNumber> s:m.entrySet()){
               assertEquals(s.getKey(), "a");
               assertEquals(s.getValue(),new ComplexNumber(2.4,3.7));
           }
    }
    }
    @After
    public void cleanUp(){
        z =null;
        x =null;
        y =null;
        cs =null;
        m =null;
    }
}
