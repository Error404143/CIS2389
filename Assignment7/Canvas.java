import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Canvas {
   protected char[][] canvas;

   public Canvas() {
      canvas = new char[10][10];
      fillCanvas();
   }

   public Canvas(int height, int width) {
      canvas = new char[height][width];
      fillCanvas();
   }

   private void fillCanvas() {
      for (int r = 0; r < canvas.length; r++) {
         for (int c = 0; c < canvas[r].length; c++) {
            canvas[r][c] = ' ';
         }
      }
   }

   public void paint(char ch, int row, int col) {
      if (row >= 0 && row < canvas.length && col >= 0 && col < canvas[row].length) {
         canvas[row][col] = ch;
      }
   }

   public void paintByInstructions(File f) throws FileNotFoundException {
      Scanner scan = new Scanner(f);
      while (scan.hasNext()) {
         int row = scan.nextInt();
         int col = scan.nextInt();
         char ch = scan.next().charAt(0);
         paint(ch, row, col);
      }
      scan.close();
   }

   public String toString() {
      StringBuilder sb = new StringBuilder();
      int width = canvas[0].length;

      sb.append("=".repeat(width + 2)).append("\n");
      for (int r = 0; r < canvas.length; r++) {
         sb.append("|");
         for (int c = 0; c < canvas[r].length; c++) {
            sb.append(canvas[r][c]);
         }
         sb.append("|").append("\n");
      }
      sb.append("=".repeat(width + 2));

      return sb.toString();
   }
}