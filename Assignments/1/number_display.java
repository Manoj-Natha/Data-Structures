import java.util.Scanner;

public class number_display
{
   
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter any number:");
      int x = scanner.nextInt();
      System.out.println("The number is "+ x);
      int t= (2*x)+1;
      Display(x,1,t);
   }


   public static void Display(int n, int i, int length)
   {
      if (i == length)
      {
          System.out.println(n);
      }
      else if (i<=(length/2)) 
      {
         System.out.print(n + " ");
         Display(n-1,i+1,length);
      }
      else
      {
         System.out.print(n + " ");
         Display(n+1,i+1,length);
      }
      
   }

}