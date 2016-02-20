import java.util.Scanner;

public class EvaluateTemperature
{
        
   public static void main(String args[])
   {
      Scanner s=new Scanner(System.in);
      System.out.print("If temperature is in Celsius then enter C else if in fahrenheit enter F : ");
      String u = s.nextLine();     
      System.out.print("Enter the temperature : ");
      float t=s.nextFloat();     
      if(u.equals("C"))
      {
//       t=((t - 32)*5)/9;
         t=(9*t/5)+32;
      }
      
      System.out.println("The temperature in Celsius is : "+t);
      
      if (t<0)
      System.out.println("Extremely Cold");
      else if(t <= 32)
      System.out.println("Very Cold");     
      else if(t <=50)
      System.out.println("Cold");     
      else if(t <=70)
      System.out.println("Mild");     
      else if(t <=90)
      System.out.println("Warm");        
      else if(t <=100)
      System.out.println("Hot");       
      else
      System.out.println("Very Hot");     
   }
}