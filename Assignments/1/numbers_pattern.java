import java.util.Scanner;

public class numbers_pattern
{
   
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter any number:");
      int x = scanner.nextInt();
      System.out.println("The number is "+ x);
      Display(x);
   }


   public static void Display(int x)
   {
   if(x==0)
         System.out.print("0 "); 
   else
     {
        System.out.print(x+" "); 
        Display(x-1);
        System.out.print(x+" "); 
     }
   }

}