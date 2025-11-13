public class MixedFraction extends Fraction implements Comparable<MixedFraction> {
   private int whole;

   public MixedFraction(ProperFraction pf) {
      super(pf.getNumerator(), pf.getDenominator());
      this.whole = 0;
      normalize();
   }

   public MixedFraction(ImproperFraction inf) {
      super(inf.getNumerator(), inf.getDenominator());
      this.whole = 0;
      normalize();
   }

   public MixedFraction(int whole, ProperFraction pf) {
      super(pf.getNumerator(), pf.getDenominator());
      this.whole = whole;
      normalize();
   }

   public MixedFraction(int whole, int n, int d) {
      super(n, d);
      this.whole = whole;
      normalize();
   }

   private void normalize() {
      if (denominator == 0) return;
      if (Math.abs(numerator) >= denominator) {
         whole += numerator / denominator;
         numerator = numerator % denominator;
      }
      if (numerator < 0 && whole > 0) {
         whole -= 1;
         numerator = denominator + numerator;
      }
   }

   public Fraction toFraction() {
      int n = whole * denominator + numerator;
      return new Fraction(n, denominator);
   }

   @Override
   public String toString() {
      if (whole == 0 && numerator == 0) return "0";
      if (whole == 0) return numerator + "/" + denominator;
      if (numerator == 0) return String.valueOf(whole);
      return whole + " " + numerator + "/" + denominator;
   }

   @Override
   public int compareTo(MixedFraction other) {
      double thisValue = whole + (double) numerator / denominator;
      double otherValue = other.whole + (double) other.numerator / other.denominator;
      return Double.compare(thisValue, otherValue);
   }
}
