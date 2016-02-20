import java.util.Scanner;

class father{
   public String name;
   Scanner s= new Scanner(System.in);

   father(){
   System.out.println("Enter the name of the parent:");
   name=s.next();
   }
   
   public void display(){
   System.out.println("name of the parent: "+name);
   } 
   
}


class son extends father{
   public String sname;

   son(){
   System.out.println("Enter the name of the son:");
   sname=s.next();
   }
   
   public void display(){
   super.display();
   System.out.println("name of the son: "+ sname);
   } 
   
}

public class fatherSon{
   public static void main(String[] args)
   {
      son s=new son();
      s.display();
   }

}