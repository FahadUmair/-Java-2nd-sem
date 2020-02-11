package Fractions;


/** This interface defines a fraction type for manipulation of fractions.
  * Fractional values are immutable.
  *
  * @author D. Hughes
  *
  * @version 1.0 (Feb. 2016)                                                     */

public interface Fraction {
    
    
    /** This method returns the numerator of the fraction. It is for
      * interoperability and should only be used by implementation classes.
      *
      * @return int the numerator.                                               */
    
    public int getNumerator ( );
    
    
    /** This method returns the denominator of the fraction. It is for
      * interoperability and should only be used by implementation classes.
      *
      * @return int the denominator.                                             */
    
    public int getDenominator ( );
    
    
    /** This method returns a negative value if the fraction is less than the other
      * fraction, 0 if it is equal to the other fraction or positive if it is
      * greater than the other fraction.
      *
      * @param f the fraction for comparison.
      *
      * @return int &lt;0 for less, =0 for equal, &gt;0 for greater  than f      */
    
    public int compareTo ( Fraction f );
    
    
    /** This method returns a new fraction that is the sum of this fraction and
      * another.
      *
      * @param f the other addend
      *
      * @return Fraction this + f                                                */
    
    public Fraction add ( Fraction f );
    
    
    /** This method returns a new fraction that is the difference between this
      * fraction and another.
      *
      * @param f the subtrahend
      *
      * @return Fraction this - f                                                */
    
    public Fraction sub ( Fraction f );
    
    
    /** This method returns a new fraction that is the product of this fraction
      * and another.
      *
      * @param f the multiplier
      *
      * @return Fraction this * f                                                */
    
    public Fraction mul ( Fraction f );
    
    
    /** This method returns a new fraction that is the quotient of this fraction
      * and another.
      *
      * @param f the divisor
      *
      * @return Fraction this / f
      *
      * @throws ZeroDenominatorException if the result would have a zero
      * denominator.                                                             */
    
    public Fraction div ( Fraction f );
    
    
} // Fraction