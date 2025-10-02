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

}
