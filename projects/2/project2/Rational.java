public class Rational
{
public static void main(String[] args)
{
double i=20.54;
double r=i%1;
while(r!=0)
{
i*=10;
r=i%1;
System.out.println("r value is "+r+" and i is "+i);
}

int ii=(int)i;
System.out.println("ii is "+ii);
 

}



}