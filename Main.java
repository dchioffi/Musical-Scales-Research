//rates the accuracy of TET scales based on their accuracy of 5 musical ratios
class Main { 
  public static void main(String[] args) {
   for(int i = 1; i <= 1000; i++)
   {
    scale a = new scale(i);
    a.evaluate();
   }

  }
}