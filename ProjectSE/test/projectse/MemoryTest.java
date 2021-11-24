/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author pc
 */
public class MemoryTest {
    @Test
    public void testSaveNumberInMemory(){
        ComplexNumber z = new ComplexNumber(2.4,3.7); 
        ComplexStack cs = new ComplexStack();
        Memory m = new Memory(cs);
        cs.push(z);
        m.saveNumberInMemory("a");
        m.getNumberFromMemory("a");
        assertEquals(z, cs.peek());
    }
    @Test
    public void testIncrementNumberInMemory(){
        ComplexNumber z = new ComplexNumber(2.4,3.7); 
        ComplexNumber x = new ComplexNumber(1.1,0.3);
        ComplexNumber y = new ComplexNumber(2.4,3.6);
        ComplexStack cs = new ComplexStack();
        Memory m = new Memory(cs);
        cs.push(z);
        m.saveNumberInMemory("a");
        cs.push(x);
        m.incrementNumberFromMemory("a");
        m.getNumberFromMemory("a");
        assertTrue(z.add(x).equals(cs.pop()));
        assertFalse(z.add(y).equals(cs.pop()));
    }
    @Test
    public void testDecrementNumberInMemory(){
        ComplexNumber z = new ComplexNumber(2.4,3.7); 
        ComplexNumber x = new ComplexNumber(1.1,0.7);
        ComplexNumber y = new ComplexNumber(2.4,3.6);
        ComplexStack cs = new ComplexStack();
        Memory m = new Memory(cs);
        cs.push(z);
        m.saveNumberInMemory("a");
        cs.push(x);
        m.decrementNumberFromMemory("a");
        m.getNumberFromMemory("a");
        assertTrue(z.subtract(x).equals(cs.pop()));
        assertFalse(z.subtract(y).equals(cs.pop()));
    }
}
