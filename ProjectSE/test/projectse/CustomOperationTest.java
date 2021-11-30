/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectse;

import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author win10
 */
public class CustomOperationTest {
    private CustomOperation customop;
    
    @Before
    public void setUp() throws Exception{
        customop=new CustomOperation("dup * swap dup * + sqrt", new Calculator());
    }
    
    @Test(expected=Exception.class)
    public void testModify() throws Exception{
        customop.modify("dup * swap dup +");
        List<String> l=customop.getOperations();
        int i=0;
        for(String s: l){
            if(i==0||i==3)
                assertEquals("dup",s);
            if(i==1)
                assertEquals("*",s);
            if(i==2)
                assertEquals("swap",s);
            if(i==4)
                assertEquals("+",s);
            i++;
            
            }
        customop.modify("d * swap");
    }
    
    @After
    public void cleanUp(){
        customop=null;
    }
}
