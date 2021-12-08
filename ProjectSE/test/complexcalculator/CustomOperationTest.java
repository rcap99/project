/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package complexcalculator;

import complexcalculator.CustomOperation;
import java.util.Arrays;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author win10
 */
public class CustomOperationTest {
    private CustomOperation customop, wrongop;
    private String operationString;
    
    @Before
    public void setUp() throws Exception{
        operationString="dup * swap dup * + sqrt";
        customop=new CustomOperation(operationString);
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
    
    @Test
    public void testGetOperations(){
        assertEquals(customop.getOperations(),Arrays.asList(operationString.split(" ")));
    }
    
    @Test(expected=Exception.class)
    public void testCheck() throws Exception{
        wrongop=new CustomOperation("dup * sap dup * + sqrt");
        assertEquals(customop.check(),0);
    }
    
    @After
    public void cleanUp(){
        customop=null;
        wrongop=null;
        operationString=null;
    }
}
