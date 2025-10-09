/**
*
* Using your previous Fraction class, add the following accessor and mutator methods
*  -getNumerator() -> returns the numerator 
*  -getDenominator() -> returns the denominator
*  -reduce() -> reduces the numerator and denominator by the greatest common divisor.
*
**/
public class Fraction{
   private int numerator;
   private int denominator;
   
   public Fraction(int n, int d){
      numerator = n;
      denominator = d;
   }

   public Fraction(int n){
     numerator = n;
     denominator = 1;
   }

   
   public String toString() {
     return numerator + "/" + denominator;
   }
   
   public int getNumerator() {
      return numerator;
   }

   public int getDenominator() {
      return denominator;
   }

   public void reduce() {

       for (int i = 2; i <= numerator && i <= denominator; i++) {
          if (numerator % i == 0 && denominator % i == 0) {
             numerator = numerator / i;
             denominator = denominator / i;
             i = 1;
          }
       }

       if (denominator < 0) {
          numerator = -numerator;
          denominator = -denominator;
       }
  }
   
}
