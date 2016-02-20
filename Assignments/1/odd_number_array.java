import java.util.Scanner;

public class odd_number_array
{
   
   public static void main(String[] args)
   {
      Scanner scanner = new Scanner(System.in);
      int[] a= new int[30];
      System.out.println("Enter number of items in the array:");
      int x = scanner.nextInt();
      for(int i=0;i<x;i++)
      {
      a[i]=scanner.nextInt();
      }
           
      //int[] a={1,2,3,4,5,6};
      
      int o=odd_count(a,0); 
      System.out.println("The number of odd numbers in the array is "+o);
      
      
   }


   public static int odd_count(int a[], int i)
   {
      if (i == a.length-1)
          return 0;
      else 
      {       
         if((a[i])%2 != 0 )            
            return 1 + odd_count(a,i+1);  
         else
            return 0 + odd_count(a,i+1);   
      }
      
   }
}
