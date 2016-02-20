import java.util.Scanner;

public class Scores
{

   public static void main (String args[])
   {
      Scanner s = new Scanner(System.in);
      String names[]=new String[10];
      int scores[][]=new int[10][5];
      float average[]=new float[10];
      int total;
      for(int i=0;i<10;i++)
      {      
      System.out.println("Enter the names of the student "+(i+1));
      names[i]=s.next();
      System.out.println("Enter the 5 quiz scores of "+names[i]);
      total=0;
         for(int j=0;j<5;j++)
         {
            scores[i][j]=s.nextInt();
            total+=scores[i][j];
         }         
      average[i] = (float) total/5;   
      }
      System.out.println("Name:\tAverage:");
      for(int i=0;i<10;i++)
      { 
      System.out.println(names[i]+"\t"+average[i]);
      }         
   }

}