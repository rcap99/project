/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectse;

import java.util.EmptyStackException;
import org.junit.*;
import static org.junit.Assert.*;


public class ComplexStackTest {
    
   private ComplexStack cstack;
   
   @Before
   public void setUp(){
       cstack=new ComplexStack();
   }
    
   @Test(expected=EmptyStackException.class)
   public void testDup(){
       ComplexNumber c1=new ComplexNumber(1.1,1.1);
       cstack.push(new ComplexNumber(1.1,1.1));
       cstack.dup();
       assertEquals(c1, cstack.pop());
       assertEquals(c1, cstack.pop());
       assertTrue(cstack.isEmpty());
       cstack.dup();
   }
   
   @Test(expected=EmptyStackException.class)
   public void testSwap(){
       ComplexNumber c1=new ComplexNumber(1.1,1.1);
       ComplexNumber c2=new ComplexNumber(2.2,2.2);
       cstack.push(new ComplexNumber(1.1,1.1));
       cstack.push(new ComplexNumber(2.2,2.2));
       cstack.swap();
       assertEquals(c1, cstack.pop());
       assertEquals(c2, cstack.pop());
       assertTrue(cstack.isEmpty());
       cstack.swap();
   }
   
   @After 
   public void cleanUp(){
       cstack=null;
   }
   
}
