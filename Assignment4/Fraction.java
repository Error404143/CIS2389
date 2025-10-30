public class Fraction {
   private int numerator;
   private int denominator;

   public Fraction(int n, int d) {
      if (d == 0) {
         throw new IllegalArgumentException("Cannot have 0 in denominator.");
      }
      numerator = n;
      denominator = d;
   }

   public Fraction(int n) {
      numerator = n;
      denominator = 1;
   }

   public int getNumerator() {
      return numerator;
   }

   public int getDenominator() {
      return denominator;
   }

   public Fraction add(Fraction f) {
      int n = (numerator * f.denominator) + (f.numerator * denominator);
      int d = denominator * f.denominator;
      return new Fraction(n, d);
   }

   public Fraction subtract(Fraction f) {
      int n = (numerator * f.denominator) - (f.numerator * denominator);
      int d = denominator * f.denominator;
      return new Fraction(n, d);
   }

   public Fraction multiply(Fraction f) {
      int n = numerator * f.numerator;
      int d = denominator * f.denominator;
      return new Fraction(n, d);
   }

   public Fraction divide(Fraction f) {
      int n = numerator * f.denominator;
      int d = denominator * f.numerator;
      return new Fraction(n, d);
   }

   public int compareTo(Fraction f) {
      int left = numerator * f.denominator;
      int right = f.numerator * denominator;
      if (left < right) {
         return -1;
      } else if (left > right) {
         return 1;
      } else {
         return 0;
      }
   }

   public void reduce() {
      int smaller;
      if (numerator < denominator) {
         smaller = numerator;
      } else {
         smaller = denominator;
      }

      for (int i = smaller; i > 1; i--) {
         if (numerator % i == 0 && denominator % i == 0) {
            numerator = numerator / i;
            denominator = denominator / i;
            break; 
         }
      }
   }

   public String toString() {
      return numerator + "/" + denominator;
   }
}
