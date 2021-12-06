/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package projectse;


import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author PRINCIPAL
 */
public class ComplexNumberTest {
        Calculator c;
    ComplexNumber n1;
    ComplexNumber n2;
    ComplexNumber n3;
    ComplexNumber n4;
    ComplexNumber n5;
    
    @Before
    public void setUp(){
        n1 = new ComplexNumber(1.0, 2.0);
        n2 = new ComplexNumber(-1.0, 2.0);
        n3 = new ComplexNumber(1.4, -2.0);
        n4 = new ComplexNumber(0, 2.0);
        n5 = new ComplexNumber(1.0, 0);
    }
    
    @Test
    public void testParse(){
        assertEquals(n1, ComplexNumber.parse("1 + 2i"));
        assertEquals(n1, ComplexNumber.parse("1+2i"));
        assertEquals(n1, ComplexNumber.parse("1 +2i"));
        assertEquals(n1, ComplexNumber.parse("1+ 2i"));
        assertEquals(n2, ComplexNumber.parse("-1 + 2i"));
        assertEquals(n3, ComplexNumber.parse("1.4 - 2i"));
        assertEquals(n4, ComplexNumber.parse("2i"));
        assertEquals(n5, ComplexNumber.parse("1"));
    }
    
    @Test
    public void testAdd(){
       ComplexNumber c1=new ComplexNumber(5.2,3.2);
       ComplexNumber c2=new ComplexNumber(1.2,2.2);
       ComplexNumber c3=c1.add(c2);
       assertEquals("6.4+5.4i",c3.toString());
       
       ComplexNumber c4=new ComplexNumber(5.2,0);
       ComplexNumber c5=new ComplexNumber(1.2,0);
       ComplexNumber c6=c4.add(c5);
       assertEquals("6.4",c6.toString());
       
       ComplexNumber c7=new ComplexNumber(5.2,8.2);
       ComplexNumber c8=new ComplexNumber(1.2, -1.1);
       ComplexNumber c9=c7.add(c8);
       assertEquals("6.4+7.1i",c9.toString());
       
       ComplexNumber c10=new ComplexNumber(0,2);
       ComplexNumber c11=new ComplexNumber(0,2);
       ComplexNumber c12=c10.add(c11);
       assertEquals("4.0i",c12.toString());
    }
    
   @Test
    public void testSubtract(){
    ComplexNumber c1=new ComplexNumber(5.2,3.2);
       ComplexNumber c2=new ComplexNumber(1.2,2.2);
       ComplexNumber c3=c1.subtract(c2);
       assertEquals("4.0+1.0i",c3.toString());
       
    ComplexNumber c4=new ComplexNumber(5.2,0);
       ComplexNumber c5=new ComplexNumber(1.2,0);
       ComplexNumber c6=c4.subtract(c5);
       assertEquals("4.0",c6.toString());
       
    }
    
    @Test
    public void testMultiplication(){
    ComplexNumber c1=new ComplexNumber(5.2,3.2);
       ComplexNumber c2=new ComplexNumber(1.2,2.2);
       ComplexNumber c3=c1.multiplication(c2);
       assertEquals("-0.8000000000000007+15.280000000000001i",c3.toString());
 
       ComplexNumber c4=new ComplexNumber(5,0);
       ComplexNumber c5=new ComplexNumber(1,0);
       ComplexNumber c6=c4.multiplication(c5);
       assertEquals("5.0",c6.toString());
       
       ComplexNumber c7=new ComplexNumber(0,3);
       ComplexNumber c8=new ComplexNumber(0,3);
       ComplexNumber c9=c7.multiplication(c8);
       assertEquals("-9.0",c9.toString());
       
    }
    
    @Test
    public void testDivision(){
    ComplexNumber c1=new ComplexNumber(5.2,3.2);
       ComplexNumber c2=new ComplexNumber(1.2,2.2);
       ComplexNumber c3=c1.division(c2);
       assertEquals("2.114649681528662-1.210191082802548i",c3.toString());
 
       ComplexNumber c4=new ComplexNumber(6,0);
       ComplexNumber c5=new ComplexNumber(2,0);
       ComplexNumber c6=c4.division(c5);
       assertEquals("3.0",c6.toString());
       
       ComplexNumber c7=new ComplexNumber(0,3);
       ComplexNumber c8=new ComplexNumber(0,3);
       ComplexNumber c9=c7.division(c8);
       assertEquals("1.0",c9.toString());
       
    }
    
    @Test
    public void testInvertSign(){
    ComplexNumber c1=new ComplexNumber(5.2,3.2);
       assertEquals("-5.2-3.2i",c1.invertSign().toString());
       
    ComplexNumber c2=new ComplexNumber(5.2,0);
       assertEquals("-5.2",c2.invertSign().toString());
       
    ComplexNumber c3=new ComplexNumber(-5.2,-3.2);
       assertEquals("5.2+3.2i",c3.invertSign().toString());
    }
    
     @Test
    public void testSqrt(){
       ComplexNumber c1=new ComplexNumber(1,81);
       ComplexNumber c2= c1.sqrt();
       assertEquals("6.403365232606779+6.324799309239564i", c2.toString());
       
       ComplexNumber c3=new ComplexNumber(64,0);
       ComplexNumber c4= c3.sqrt();
       assertEquals("8.0",c4.toString());
       
       ComplexNumber c5=new ComplexNumber(-64,0);
       ComplexNumber c6= c5.sqrt();
       assertEquals("0.0625-8.0i",c6.toString());
       
       ComplexNumber c7=new ComplexNumber(0,81);
       ComplexNumber c8= c7.sqrt();
       assertEquals("6.3639610306789285+6.363961030678927i",c8.toString());
       
    }
       
      @Test
       public void testAbs(){
       ComplexNumber c1=new ComplexNumber(3,4);
       Double c2=c1.abs();
       assertEquals("5.0", c2.toString());
       
       ComplexNumber c3=new ComplexNumber(3,0);
       Double c4=c3.abs();
       assertEquals("3.0", c4.toString());
       
       ComplexNumber c5=new ComplexNumber(0,3);
       Double c6=c5.abs();
       assertEquals("3.0", c6.toString());
       
       ComplexNumber c7=new ComplexNumber(-3,-4);
       Double c8=c7.abs();
       assertEquals("5.0", c8.toString());  
     }
      
      @Test
       public void testPhase(){
       ComplexNumber c1=new ComplexNumber(1,1);
       Double c2=c1.phase();
       assertEquals("0.7853981633974483", c2.toString());
       
       ComplexNumber c3=new ComplexNumber(1,0);
       Double c4=c3.phase();
       assertEquals("0.0", c4.toString());
       
       ComplexNumber c5=new ComplexNumber(0,2);
       Double c6=c5.phase();
       assertEquals("1.5707963267948966", c6.toString());
       
       ComplexNumber c7=new ComplexNumber(-1,-1);
       Double c8=c7.phase();
       assertEquals("-2.356194490192345", c8.toString());
    }
       
    @Test
    public void testPower(){
        ComplexNumber c1=new ComplexNumber(2,2);
        assertEquals(c1.power(3), new ComplexNumber(-16,16));
        assertEquals(n1.power(4),new ComplexNumber(-7,-24));
        assertEquals(n3.power(2),new ComplexNumber(-2.04,-5.6));
    }
    @Test
    public void testLogarithm(){
        assertEquals(n1.logarithm(),new ComplexNumber(0.8047189562170503,1.1071487177940904));
        assertEquals(n2.logarithm(),new ComplexNumber(0.8047189562170503,2.0344439357957027));
        assertEquals(n3.logarithm(),new ComplexNumber(0.8925352405386292,-0.960070362405688));
        assertEquals(n4.logarithm(),new ComplexNumber(0.6931471805599453,1.5707963267948966));
        assertEquals(n5.logarithm(),new ComplexNumber(0,0));
    }
    
    @Test
    public void testSin(){
        assertEquals(n1.sin(), new ComplexNumber(3.165778513216168,1.9596010414216063));
        assertEquals(n2.sin(),new ComplexNumber(-3.165778513216168,1.9596010414216063));
        assertEquals(n3.sin(),new ComplexNumber(3.7074547279421126,-0.6164471012197608));
        assertEquals(n4.sin(),new ComplexNumber(0.0,3.626860407847019));
        assertEquals(n5.sin (),new ComplexNumber(0.8414709848078965,0.0));
    }
    
    @Test
    public void testCos(){
        assertEquals(n1.cos(), new ComplexNumber(2.0327230070196656,-3.0518977991518));
        assertEquals(n2.cos(),new ComplexNumber(2.0327230070196656,3.0518977991518));
        assertEquals(n3.cos(),new ComplexNumber(0.6394496526450827,3.5740886096186815));
    }
   
    @Test
    public void testTan(){
        assertEquals(n1.tan(), new ComplexNumber(0.03381282607989666,1.0147936161466338));
        assertEquals(n2.tan(),new ComplexNumber(-0.03381282607989666,1.0147936161466338));
        assertEquals(n3.tan(),new ComplexNumber(0.012705302920781703,-1.0350415813550153));
        assertEquals(n4.tan(),new ComplexNumber(0.0,0.9640275800758169));
        assertEquals(n5.tan(),new ComplexNumber(1.5574077246549018,0.0));
    }
  
    @Test
    public void testExp(){
        assertEquals(n1.exp(), new ComplexNumber(-1.1312043837568135,2.4717266720048188));
        assertEquals(n2.exp(),new ComplexNumber(-0.1530918656742263,0.33451182923926226));
        assertEquals(n3.exp(),new ComplexNumber(-1.6875586377684881,-3.6873828951154524));
        assertEquals(n4.exp(),new ComplexNumber(-0.4161468365471424,0.9092974268256817));
        assertEquals(n5.exp(),new ComplexNumber(2.718281828459045,0.0));
    }
    @Test
    public void testArcTan(){
        assertEquals(n1.arcTan(),new ComplexNumber(1.3389725222944935,0.4023594781085251));
        assertEquals(n2.arcTan(),new ComplexNumber(-1.3389725222944935,0.4023594781085251));
        assertEquals(n3.arcTan(),new ComplexNumber(1.3138364862956298,-0.3272657532959752));
        assertEquals(n4.arcTan(),new ComplexNumber(1.5707963267948966,0.5493061443340549));
        assertEquals(n5.arcTan(),new ComplexNumber(0.7853981633974483,0));
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