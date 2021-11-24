/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator c;
    ComplexNumber n1;
    ComplexNumber n2;
    ComplexNumber n3;
    ComplexNumber n4;
    ComplexNumber n5;
    
    @Before
    public void setUp(){
        c = new Calculator();
        n1 = new ComplexNumber(1.0, 2.0);
        n2 = new ComplexNumber(-1.0, 2.0);
        n3 = new ComplexNumber(1.4, -2.0);
        n4 = new ComplexNumber(0, 2.0);
        n5 = new ComplexNumber(1.0, 0);
    }
    
    @Test
    public void testParse(){
        assertEquals(n1, c.parse("1 + 2i"));
        assertEquals(n1, c.parse("1+2i"));
        assertEquals(n1, c.parse("1 +2i"));
        assertEquals(n1, c.parse("1+ 2i"));
        assertEquals(n2, c.parse("-1 + 2i"));
        assertEquals(n3, c.parse("1.4 - 2i"));
        assertEquals(n4, c.parse("2i"));
        assertEquals(n5, c.parse("1"));
    }
    
    @After
    public void cleanUp(){
        c = null;
        n1 = null;
        n2 = null;
        n3 = null;
        n4 = null;
        n5 = null;
    }
}
