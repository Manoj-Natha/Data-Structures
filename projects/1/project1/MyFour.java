import java.util.Scanner;

public class MyFour<T>
{
   
   private T item1;
   private T item2;
   private T item3;
   private T item4;
   
   MyFour( T i1,T i2,T i3,T i4)
   {
      item1 = i1;
      item2 = i2;
      item3 = i3;
      item4 = i4;
   }
   
   public boolean allEqual()
   {
      if(item1.equals(item2) && item2.equals(item3) && item3.equals(item4) )
      return true;
      else 
      return false;
   } 
   
   public void shiftLeft()
   {
      T temp=item1;
      item1=item2;
      item2=item3;
      item3=item4;
      item4=temp;
   }
   
   public String toString()
   {
      String s= "("+item1+", "+item2+", "+item3+", "+item4+")";
      return s;
   }
    
   public static void main(String args[])
   {
      MyFour<String> m1=new MyFour<String>("manoj","manoj","manoj","manoj");
      System.out.println("The string of m1 is "+m1.toString());
      System.out.println("The result of m1.allEqual() is "+m1.allEqual());
      MyFour<Integer> m2=new MyFour<Integer>(1,2,3,4);
      System.out.println("The string of m2 is "+m2.toString());
      System.out.println("The result of m2.allEqual() is "+m2.allEqual());
      m2.shiftLeft();
      System.out.println("After applying shiftLeft the string of m2 is "+m2.toString());
   }
}