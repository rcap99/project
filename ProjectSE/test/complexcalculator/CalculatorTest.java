/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package complexcalculator;

import complexcalculator.stack.ComplexStack;
import org.junit.*;
import static org.junit.Assert.assertEquals;


public class CalculatorTest {
    Calculator c1, c2;
    ComplexNumber n1;
    ComplexNumber n2;
    ComplexNumber n3;
    ComplexNumber n4;
    ComplexNumber n5;
    
    @Before
    public void setUp(){
        c1 = new Calculator();
        c2 = new Calculator();
        n1 = new ComplexNumber(1.0, 2.0);
        n2 = new ComplexNumber(-1.0, 2.0);
        n3 = new ComplexNumber(1.4, -2.0);
        n4 = new ComplexNumber(0, 2.0);
        n5 = new ComplexNumber(2.0, 0);
    }
    
    @Test
    public void testExecutePush(){
        ComplexStack stack1=c1.getComplexStack();
        stack1.push(n1);
        stack1.push(n2);
        stack1.push(n3);
        stack1.push(n4);
        stack1.push(n5);
        c2.execute("1+2i");
        c2.execute("-1+2i");
        c2.execute("1.4 - 2i");
        c2.execute("2i");
        c2.execute("2");
        assertEquals(stack1, c2.getComplexStack());
    }
    
    @Test
    public void testExecutBasicOperations(){
        ComplexNumber a, b;
        ComplexStack stack1=c1.getComplexStack();
        stack1.push(n1);
        stack1.push(n2);
        b = stack1.pop();
        a = stack1.pop();
        stack1.push(a.add(b));
        c2.execute("1+2i");
        c2.execute("-1+2i");
        c2.execute("+");
        assertEquals(stack1, c2.getComplexStack());
        stack1.pop();
        c2.getComplexStack().pop();
        stack1.push(n1);
        stack1.push(n2);
        b = stack1.pop();
        a = stack1.pop();
        stack1.push(a.subtract(b));
        c2.execute("1+2i");
        c2.execute("-1+2i");
        c2.execute("-");
        stack1.pop();
        c2.getComplexStack().pop();
        stack1.push(n1);
        stack1.push(n2);
        b = stack1.pop();
        a = stack1.pop();
        stack1.push(a.multiplication(b));
        c2.execute("1+2i");
        c2.execute("-1+2i");
        c2.execute("*");
        stack1.pop();
        c2.getComplexStack().pop();
        stack1.push(n1);
        stack1.push(n2);
        b = stack1.pop();
        a = stack1.pop();
        stack1.push(a.division(b));
        c2.execute("1+2i");
        c2.execute("-1+2i");
        c2.execute("/");
        stack1.pop();
        c2.getComplexStack().pop();
    }
    
    @Test
    public void testExecuteStackOperations(){
        ComplexStack stack1=c1.getComplexStack();
        stack1.push(n1);
        stack1.push(n2);
        stack1.push(n3);
        stack1.push(n4);
        stack1.push(n5);
        c2.execute("1+2i");
        c2.execute("-1+2i");
        c2.execute("1.4 - 2i");
        c2.execute("2i");
        c2.execute("2");
        stack1.dup();
        c2.execute("dup");
        assertEquals(stack1, c2.getComplexStack());
        stack1.drop();
        c2.execute("drop");
        assertEquals(stack1, c2.getComplexStack());
        stack1.over();
        c2.execute("over");
        assertEquals(stack1, c2.getComplexStack());
        stack1.swap();
        c2.execute("swap");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.execute("clear");
        assertEquals(stack1, c2.getComplexStack());
    }
    
    @Test(expected=ExceptionInInitializerError.class)
    public void testExecuteVariablesOperations(){
        ComplexStack stack1=c1.getComplexStack();
        stack1.push(n1);
        c2.getComplexStack().push(n1);
        c2.execute(">a");
        c2.execute("<a");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1.add(n5));
        c2.getComplexStack().push(n5);
        c2.execute("+a");
        c2.execute("<a");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1);
        c2.getComplexStack().push(n5);
        c2.execute("-a");
        c2.execute("<a");
        assertEquals(stack1, c2.getComplexStack());
    }
    
    @Test
    public void testExecuteTrascendentalOperations(){
        ComplexStack stack1=c1.getComplexStack();
        stack1.push(n1);
        stack1.push(stack1.pop().sin());
        c2.execute("1+2i");
        c2.execute("sin");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1);
        stack1.push(stack1.pop().cos());
        c2.execute("1+2i");
        c2.execute("cos");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1);
        stack1.push(stack1.pop().tan());
        c2.execute("1+2i");
        c2.execute("tan");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1);
        stack1.push(stack1.pop().arcSin());
        c2.execute("1+2i");
        c2.execute("asin");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1);
        stack1.push(stack1.pop().arcCos());
        c2.execute("1+2i");
        c2.execute("acos");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1);
        stack1.push(stack1.pop().arcTan());
        c2.execute("1+2i");
        c2.execute("atan");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1);
        stack1.push(new ComplexNumber(stack1.pop().abs(), 0));
        c2.execute("1+2i");
        c2.execute("mod");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1);
        stack1.push(new ComplexNumber(stack1.pop().phase(), 0));
        c2.execute("1+2i");
        c2.execute("arg");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1);
        stack1.push(stack1.pop().logarithm());
        c2.execute("1+2i");
        c2.execute("log");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1);
        stack1.push(stack1.pop().exp());
        c2.execute("1+2i");
        c2.execute("exp");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
        stack1.push(n1);
        stack1.push(n5);
        Double exp = stack1.pop().getRe();
        stack1.push(stack1.pop().power(exp));
        c2.execute("2");
        c2.execute("1+2i");
        c2.execute("pow");
        assertEquals(stack1, c2.getComplexStack());
        stack1.clear();
        c2.getComplexStack().clear();
    }
    
    @After
    public void cleanUp(){
        c1 = null;
        c2 = null;
        n1 = null;
        n2 = null;
        n3 = null;
        n4 = null;
        n5 = null;
    }
}
