import java.util.ArrayList;

public class CafeUtil {
   public CafeUtil() {
   }

   public int getStreakGoal() {
      int var1 = 0;
      byte var2 = 10;

      for(int var3 = 0; var3 <= var2; ++var3) {
         var1 += var3;
      }

      return var1;
   }

   public double getOrderTotal(double[] var1) {
      double var2 = 0.0;
      double[] var4 = var1;
      int var5 = var1.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         double var7 = var4[var6];
         var2 += var7;
      }

      return var2;
   }

   public void displayMenu(ArrayList<String> var1) {
      for(int var2 = 0; var2 < var1.size(); ++var2) {
         System.out.println("" + var2 + " " + (String)var1.get(var2));
      }

   }

   public void addCustomer(ArrayList<String> var1) {
      String var2 = "";

      while(!var2.equals("q")) {
         System.out.println("Please enter your name:");
         var2 = System.console().readLine();
         System.out.println("Hello, " + var2 + "!");
         System.out.println("There are " + var1.size() + " people in front of you");
         var1.add(var2);
         System.out.println(var1);
      }

   }

   public void printPriceChart(String var1, double var2, int var4) {
      System.out.println(var1);
      System.out.println("1 - " + var2);
      if (var4 >= 2) {
         for(int var5 = 2; var5 <= var4; ++var5) {
            System.out.println("" + var5 + " - " + var2 * (double)var5);
         }
      }

   }

   public void printPriceChart(String var1, double var2, int var4, double var5) {
      System.out.println(var1);
      System.out.println("1 - " + var2);
      if (var4 >= 2) {
         for(int var7 = 2; var7 <= var4; ++var7) {
            double var8 = var2 * (double)var7 - var5 * (double)(var7 - 1);
            System.out.println("" + var7 + " - " + var8);
         }
      }

   }

   public boolean displayMenu(ArrayList<String> var1, ArrayList<Double> var2) {
      if (var1.size() != var2.size()) {
         return false;
      } else {
         for(int var3 = 0; var3 < var1.size(); ++var3) {
            System.out.printf("%s %s -- $%.2f \n", var3, var1.get(var3), var2.get(var3));
         }

         return true;
      }
   }
}
