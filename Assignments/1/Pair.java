import java.util.*;

public class Pair<T>
{

   public void seta(T x)
   {
      a=x;
   }
   
   public T geta()
   {
      return a;
   }
   
   
   public void setb(T x)
   {
      b=x;
   }
   
   public T getb()
   {
      return b;
   }   
   
   private T a;
   private T b;
   
   
   public static void main (String args[])
   {
      Pair<String> p = new Pair<String>();
      System.out.println("Enter the value of p.a:");
      Scanner scanner = new Scanner(System.in);
      String sa=scanner.nextLine();
      p.seta(sa);
      
      System.out.println("Enter the value of p.b:");
      String sb=scanner.nextLine();
      p.setb(sb);
      
      System.out.println("the values of p.a and p.b are : " + p.geta() +" and "+  p.getb());      
   }
   
}