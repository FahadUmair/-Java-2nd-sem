package Fractions;


import java.io.*;


/** This class provides an implementation of the Fraction class as a ratio p/q
  * of two integers p and q, q != 0).
  *
  * @see Fraction
  *
  * @author D. Hughes
  *
  * @version 1.0 (Feb. 2016)                                                     */

public class RatioFraction implements Fraction, Serializable {
    
    
    private static final long  serialVersionUID = 987654321L;
    
    private int num;
    private int den;
    /* Instance varibales */
    
    
    /** This constructor produces the fraction n/d.
      *
      * @param n the numerator
      * @param d the denominator (non-zero)
      *
      * @exception ZeroDenominatorException if the result would have a zero
      * denominator.                                                             */
    public RatioFraction(){
     this(0,1);
    }
    public RatioFraction ( int n, int d ) {
        
      num=n;
      den=d;
      normalize();
        
    }; // constructor
    
    
    /** This method returns the numerator of the fraction. It is for
      * interoperability and should only be used by implementation classes.
      *
      * @return int the numerator.                                               */
    
    public int getNumerator ( ) {
        
        return num;
        
    }; // numerator
    
    
    /** This method returns the denominator of the fraction. It is for
      * interoperability and should only be used by implementation classes.
      *
      * @return int the numerator.                                               */
    
    public int getDenominator ( ) {
        
        return den;
        
    }; // denominator
    
    
    /** This method returns the fraction expressed as a String in the form
      * "snnnn/dddd" where s is the sign (i.e. - if negative) nnnn are the digits
      * of the numerator and dddd are the digits of the denominator.
      *
      * @return String the string representation.                                */
    
    public String toString ( ) {
        
        return num +"/"+den;
        
    }; // toString
    
    
    /** This method returns a negative value is the fraction is less than the other
      * fraction, 0 if it is equal to the other fraction or positive if it is
      * greater than the other fraction.
      *
      * @param f the fraction for comparison.
      *
      * @return int &lt;0 for less, =0 for equal &gt;0 for greater than f        */
    
    public int compareTo ( Fraction f ) {
        
        return num*f.getDenominator()-f.getNumerator()*den;
        
    }; // compareTo
    
    
    /** This method returns a new fraction that is the sum of this fraction and
      * another.
      *
      * @param f the other addend
      *
      * @return Fraction this + f                                                */
    
    public Fraction add ( Fraction f ) {
        
        return new RatioFraction(num*f.getDenominator()+f.getNumerator()*den,den*f.getDenominator());
        
    }; // add
    
    
    /** This method returns a new fraction that is the difference between this
      * fraction and another.
      *
      * @param f the subtrahend
      *
      * @return Fraction this - f                                                */
    
    public Fraction sub ( Fraction f ) {
        
        return new RatioFraction(num*f.getDenominator()-f.getNumerator()*den,den*f.getDenominator());
        
    }; // sub
    
    
    /** This method returns a new fraction that is the product of this fraction
      * and another.
      * 
      * @param f the multiplier
      *
      * @return Fraction this * f                                                */
    
    public Fraction mul ( Fraction f ) {
        
        return new RatioFraction(num*f.getNumerator(),den*f.getDenominator());
        
    }; // mul
    
    
    /** This method returns a new fraction that is the quotient of this fraction
      * and another.
      *
      * @param f the divisor
      *
      * @return Fraction this / f
      *
      * @exception ZeroDenominatorException if the result would have a zero
      * denominator.                                                             */
    
    public Fraction div ( Fraction f ) {
        
        return new RatioFraction(num*f.getDenominator(),den*f.getNumerator());
        
    }; // div
    
    
    /** This method places the fraction into its cannonical (normal) form.       */
    
    private void normalize ( ) {
        
      int sign; //sign for fraction
      int div;  //divisor
      
      if(den==0)
        throw new ZeroDenominatorException();
      
      if(num==0)
       den=1;
      
      if((num<0)^(den<0)){
      
        sign=-1;
      
      }else sign=1;
      
      div=gcd(Math.abs(num),Math.abs(den));
      num=sign*Math.abs(num)/div;
      den=Math.abs(den)/div;
      
    }; // normalize
    
    
    /** This method determines the greatest common divisor (gcd) of two positive
      * integers.                                                                */
    
    private int gcd ( int n, int m ) {
        
        if ( n == 0 | m == 0 ) {
            n = 1;
        }
        else {
            while ( n != m ) {
                if ( n > m ) {
                    n = n - m;
                }
                else {
                    m = m - n;
                };
            };
        };
        return n;
        
    }; // gcd
    
    
} // RationalFraction