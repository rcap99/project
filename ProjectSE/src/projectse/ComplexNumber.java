
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectse;


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
      
     // return a new Complex object whose value is the reciprocal of this
    public ComplexNumber reciprocal() {
        double scale = re*re + im*im;
        return new ComplexNumber(re / scale, -im / scale);
    }
    
     // return a new Complex object whose value is (this * b)
    public ComplexNumber times(ComplexNumber b) {
        ComplexNumber a = this;
        double real = a.re * b.re - a.im * b.im;
        double imag = a.re * b.im + a.im * b.re;
        return new ComplexNumber(real, imag);
    }
    
      //division between two complex numbers
    public ComplexNumber division(ComplexNumber c2) {
        ComplexNumber c1 = this;
        return c1.times(c2.reciprocal());
    }
    
    //invert the sign of a complex number
    public ComplexNumber invertSign(){
        ComplexNumber c1=this;
        this.re=-this.re;
        this.im=-this.im;
        return c1;  
    }
    
    //sqrt of a complexNumber
    public ComplexNumber sqrt(){
    ComplexNumber csqrt = this;
    double dX, dY, dW, dR;

      if((re == 0) && (im == 0.0)) {
          csqrt.re = 0.0;
          csqrt.im = 0.0;
          return (csqrt);
      } 

      dX = Math.abs(re);
      dY = Math.abs(im);

      if( dX >= dY ) {
          dR = dY/dX;
          dW = Math.sqrt(dX)*Math.sqrt(0.5*(1.0 + Math.sqrt(1+dR*dR)));
      } else {
          dR = dX/dY;
          dW = Math.sqrt(dY)*Math.sqrt(0.5*(dR + Math.sqrt(1+dR*dR)));
      }

      if(re >= 0.0) {
         csqrt.re = dW;
         csqrt.im = im/(2.0*dW);
      } else {
         csqrt.im = (im > 0.0) ? dW : -dW;
         csqrt.re =  im/(2.0*csqrt.re);
      }

      return csqrt;
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
        if (Double.doubleToLongBits(this.re) != Double.doubleToLongBits(other.re)) {
            return false;
        }
        if (Double.doubleToLongBits(this.im) != Double.doubleToLongBits(other.im)) {
            return false;
        }
        return true;
    }

    public String getComplexString(){
        return this.toString();
    }
}