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
   private ComplexNumber c1;
   private ComplexNumber c2;
   
   @Before
   public void setUp(){
       cstack=new ComplexStack();
       c1=new ComplexNumber(1.1,1.1);
       c2=new ComplexNumber(2.2,2.2);
   }
    
   @Test(expected=EmptyStackException.class)
   public void testDup(){
       cstack.push(new ComplexNumber(1.1,1.1));
       cstack.dup();
       assertEquals(c1, cstack.pop());
       assertEquals(c1, cstack.pop());
       assertTrue(cstack.isEmpty());
       cstack.dup();
   }
   
   @Test(expected=EmptyStackException.class)
   public void testSwap(){ 
       cstack.push(new ComplexNumber(1.1,1.1));
       cstack.push(new ComplexNumber(2.2,2.2));
       cstack.swap();
       assertEquals(c1, cstack.pop());
       assertEquals(c2, cstack.pop());
       assertTrue(cstack.isEmpty());
       cstack.swap();
   }
   
   @Test(expected=EmptyStackException.class)
   public void testOver(){
       cstack.push(new ComplexNumber(1.1,1.1));
       cstack.push(new ComplexNumber(2.2,2.2));
       cstack.over();
       assertEquals(c1,cstack.pop());
       assertEquals(c2,cstack.pop());
       assertEquals(c1,cstack.pop());
       assertTrue(cstack.isEmpty());
       cstack.over();
   }
   
   @Test(expected=EmptyStackException.class)
   public void testClear(){
       cstack.push(new ComplexNumber(1.1,1.1));
       cstack.push(new ComplexNumber(2.2,2.2));
       cstack.clear();
       assertTrue(cstack.isEmpty());
       cstack.clear();
   }        
           
   @After 
   public void cleanUp(){
       cstack=null;
       c1=null;
       c2=null;
   }
   
}
