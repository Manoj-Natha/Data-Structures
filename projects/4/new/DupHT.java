import java.util.Scanner;
import java.io.File;

public class DupHT {

	public static void main(String[] args) 
	{	
      // To find the time for running the program we note down the start time
		long sTime = System.currentTimeMillis();		
		
		try 
		{
			MyHashTable H = new MyHashTable();			// H is the object of MyHashTable class 
			Scanner sc = new Scanner(new File("ph.txt"));
			
			while( sc.hasNext() )
			{	
				String pno = sc.nextLine(); // pno is the phone-number to be inserted into the hash table
				H.Insert(pno); // to insert pno into the hash table 
			}
			
			H.FindDuplicates(); // calling the find duplicate function
		}
		catch (Exception e)
		{
			System.out.println("Exception " + e);
			System.exit(1);
		}
		
      // to record the end time of the process running
		long eTime   = System.currentTimeMillis();
		long tTime = eTime - sTime; //total time is start - end
		System.out.println("Time Taken to Run the Program is " + tTime);		
	}
}
