import java.util.Scanner;

class Square
   {
   private int side;
   
   Square()
   {
      side=1;
   }
   
   Square(int s)
   {
      side=s;
   }
   
   public int getArea()
   {
      return side*side;
   }

}


public class TestSquare
{
   public static void main(String[] args)
   {
      Scanner s=new Scanner(System.in);
      Square a = new Square();
      System.out.println("Enter the side of square b :");
      int b_s= s.nextInt();
      Square b = new Square(b_s);
      
      System.out.println("The area of square a is "+ a.getArea());
      System.out.println("The area of square b is "+ b.getArea());
   }
}