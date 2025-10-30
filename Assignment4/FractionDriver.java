import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FractionDriver {
   public static void main(String[] args) throws FileNotFoundException {
      // Open the file values.txt
      Scanner fin = new Scanner(new File("values.txt"));

      System.out.println("Reading fractions from file:\n");

      // Read each pair of numbers from file
      while (fin.hasNextInt()) {
      int n = fin.nextInt();

      if (!fin.hasNextInt()) {
         System.out.println("Warning: No denominator found for " + n + ". Skipping...");
         break;
      }

      int d = fin.nextInt();

      try {
         Fraction f = new Fraction(n, d);
         System.out.println("Original: " + f);
         f.reduce();
         System.out.println("Reduced: " + f);
         System.out.println();
      } catch (IllegalArgumentException e) {
         System.out.println("Error creating " + n + "/" + d + ": " + e.getMessage());
         }
      }

      fin.close();

      System.out.println("Testing math operations:\n");
      Fraction f1 = new Fraction(1, 2);
      Fraction f2 = new Fraction(3, 4);

      System.out.println(f1 + " + " + f2 + " = " + f1.add(f2));
      System.out.println(f1 + " - " + f2 + " = " + f1.subtract(f2));
      System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));
      System.out.println(f1 + " / " + f2 + " = " + f1.divide(f2));

      int result = f1.compareTo(f2);
      if (result < 0)
         System.out.println(f1 + " is less than " + f2);
      else if (result > 0)
         System.out.println(f1 + " is greater than " + f2);
      else
         System.out.println(f1 + " is equal to " + f2);
   }
}
