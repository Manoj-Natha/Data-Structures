
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.io.File;

public class MyHashTable
{

    public MyHashTable( )
    {
        this( DEFAULT_TABLE_SIZE );
    }


    public MyHashTable( int size )
    {
         int tsize=nextPrime(size); 
         theLists = new LinkedList[tsize];
         
    }

    public void insert(String x)
    {
         int p=myhash(x);
         List whichList = theLists[p];
         int flag=0;
   
         for(int i=0;i<whichList.size();i++)
         {

            HashEntry t=whichList.get(i);
            
            
            if(t.element.equals(x))
            {
               flag++;   
               t.count++;
               if(!dupElements.contains(x))
                  dupElements.add(x);
            }
               
         }
         if(flag==0)
         {
            HashEntry h=new HashEntry(x);
            whichList.add(h);
            currentSize++;
         }    
    }
    
    
    
    private int myhash(String key)
    {
        //int hashVal = x%tablesize;
        
        int hashVal = 0;

        for( int i = 0; i < key.length( ); i++ )
            hashVal = 37 * hashVal + key.charAt( i );

        hashVal %= tableSize;
        if( hashVal < 0 )
            hashVal += tableSize;

        return hashVal;
    }
    
    private static final int DEFAULT_TABLE_SIZE = 5003;

        /** The array of Lists. */
    private List [ ] theLists; 
    private List dupElements; 
    private int tableSize;
    private int currentSize;
    
    
    private static class HashEntry
    {
        public String element;   // the element
        public int count;  // number of times the phone number is inserted

        public HashEntry()
        {
            element  = "null";
            count = 0;
        }
        
        public HashEntry(String e)
        {
            element  = e;
            count = 1;
        }
        
        
    }
    private static int nextPrime( int n )
    {
        if( n % 2 == 0 )
            n++;

        for( ; !isPrime( n ); n += 2 )
            ;

        return n;
    }

    private static boolean isPrime( int n )
    {
        if( n == 2 || n == 3 )
            return true;

        if( n == 1 || n % 2 == 0 )
            return false;

        for( int i = 3; i * i <= n; i += 2 )
            if( n % i == 0 )
                return false;

        return true;
    }


        // Simple main
    public static void main( String [ ] args )
    {
       
        long startTime = System.currentTimeMillis( );
        
         try 
         {
            Scanner sc = new Scanner(new File("ph.txt"));
            MyHashTable H = new MyHashTable( );
            while (sc.hasNext())
            {
               String ph = sc.nextLine();
               H.insert(ph);
            }
            
            System.out.println("no of nodes inserted is :"+H.currentSize);
            System.out.println("no of duplicate nodes found is :"+H.dupElements.size());            
         }
         catch (Exception e)
         {
            System.out.println("Exception " + e);
            System.exit(1);
         }
        
        long endTime = System.currentTimeMillis( );
        
        System.out.println( "Elapsed time: " + (endTime - startTime) );
    }

}

    
    
    
    