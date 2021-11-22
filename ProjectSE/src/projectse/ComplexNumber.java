
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;
import java.lang.String.*;

/**
 *
 * @author PRINCIPAL
 */
public class ComplexNumber {
     private double re;   // the real part
     private double im;   // the imaginary part

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public ComplexNumber() {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ComplexNumber(String s1, String s2){
     double re=Double.parseDouble(s1);
     double im=Double.parseDouble(s2);
    }

    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }
    
    // return a string representation of the invoking complex number
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + " - " + (-im) + "i";
        return re + " + " + im + "i";
    }
    
    //return modulus of a complex number
    public double abs(){
    return Math.hypot(re, re);
    }
    
    //return phase of a complex number in radians
     public double phase() {
        return Math.atan2(im, re);
    }
     
    //add two complex numbers 
    public ComplexNumber add(ComplexNumber c2){
        ComplexNumber c1=this;  //invoking object
        double real = c1.re + c2.re;
        double imag = c1.im + c2.im;
        return new ComplexNumber(real, imag);
    }     
     
    //subtract two complex numbers
    public ComplexNumber subtract(ComplexNumber c2){
        ComplexNumber c1=this;  //invoking object
        double real = c1.re - c2.re;
        double imag = c1.im - c2.im;
        return new ComplexNumber(real, imag);
     }
    
    //multiplicate two complex numbers
      public ComplexNumber multiplication(ComplexNumber c2) {
        ComplexNumber c1 = this;
        double real = c1.re * c2.re - c1.im * c2.im;
        double imag = c1.re * c2.im + c1.im * c2.re;
        return new ComplexNumber(real, imag);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.re) ^ (Double.doubleToLongBits(this.re) >>> 32));
        hash = 79 * hash + (int) (Double.doubleToLongBits(this.im) ^ (Double.doubleToLongBits(this.im) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        return true;
    }
      
    
}