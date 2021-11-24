package projectse;

/**
 * The ComplexNumber class manages all the main operations on complex numbers,
 * allowing to operate even on non-complex numbers in case of the absence of the 
 * imaginary part.
 * 
 * @author Group11
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
    
    /**
     * returns the String representation of a complex number 
     * @return String "a+bi"
     */
    public String toString() {
        if (im == 0) return re + "";
        if (re == 0) return im + "i";
        if (im <  0) return re + "-" + (-im) + "i";
        return re + "+" + im + "i";
    }
    
    /**
     * Calculates the modulus of a complex number
     * @return modulus
     */
    public double abs(){
    return Math.hypot(re, re);
    }
    
    /**
     * Calculates in radians the phase of a complex number
     * @return phase
     */
     public double phase() {
        return Math.atan2(im, re);
    }
     
    /**
     * Supports addition between two complex numbers
     * @param c2 the addend
     * @return the result of the addition
     */
    public ComplexNumber add(ComplexNumber c2){
        ComplexNumber c1=this;  //invoking object
        double real = c1.re + c2.re;
        double imag = c1.im + c2.im;
        return new ComplexNumber(real, imag);
    }     
     
    /**
     * Supports subtraction between two complex numbers
     * @param c2 the subtracting
     * @return the result of the subtraction
     */
    public ComplexNumber subtract(ComplexNumber c2){
        ComplexNumber c1=this;  //invoking object
        double real = c1.re - c2.re;
        double imag = c1.im - c2.im;
        return new ComplexNumber(real, imag);
     }
    
    /**
     * Supports multiplication between two complex numbers
     * @param c2 the multiplier
     * @return the result of the multiplication
     */
      public ComplexNumber multiplication(ComplexNumber c2) {
        ComplexNumber c1 = this;
        double real = c1.re * c2.re - c1.im * c2.im;
        double imag = c1.re * c2.im + c1.im * c2.re;
        return new ComplexNumber(real, imag);
    }
      
    
     /**
      * Calculates the reciprocal of a complex number
      * @return a new Complex object whose value is the reciprocal of this
      */
    public ComplexNumber reciprocal() {
        double scale = re*re + im*im;
        return new ComplexNumber(re / scale, -im / scale);
    }
    
    
    /**
     * Supports division between two complex numbers
     * @param c2 the divider
     * @return the result of the division
     */
    public ComplexNumber division(ComplexNumber c2) {
        ComplexNumber c1 = this;
        return c1.multiplication(c2.reciprocal());
    }
    
    
    /**
     * Inverts the sign of a number
     * @return a new number with inverted sign
     */
    public ComplexNumber invertSign(){
        ComplexNumber c1=this;
        this.re=-this.re;
        this.im=-this.im;
        return c1;  
    }
    
    
    /**
     * Supports the square root of a complex number
     * @return the sqrt of the number
     */
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