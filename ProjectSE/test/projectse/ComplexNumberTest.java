/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package projectse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.*;

/**
 *
 * @author PRINCIPAL
 */
public class ComplexNumberTest {
    
     @Test
    public void testAdd(){
    ComplexNumber a=new ComplexNumber(5.2,7.3);
    ComplexNumber b=new ComplexNumber(1.1,2.1);
    ComplexNumber a1=new ComplexNumber(5,0);
    ComplexNumber a3=new ComplexNumber(2.2,-1.2);
    ComplexNumber c1= a.add(b);
    ComplexNumber c2= a1.add(a1);
    ComplexNumber c3= a.add(a3);
    assertEquals("6.3 + 9.4i",c1.toString());
    
    }
}
