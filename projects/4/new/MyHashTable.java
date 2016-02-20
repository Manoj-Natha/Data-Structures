
public class MyHashTable {

	private static int tableSize = 10007;
	private static String arr[] = new String[tableSize];
	
	public static class Node
    {        
		String data;            				
        int count;
        Node next; 
        
    	public Node(String str1){
    		data = str1;
    		next = null;
    	}
    }
	 
	public static Node head=null; //Head Pointer of Duplicate Elements Linked List 	

	
	public void Insert( String str ) // to hash a new value into hash table
   {
		
		int offset = 1;									//Initializing the offset to 1
      
      int idx = findHash(str);                  // idx has the hash value
		while( arr[idx] != null )						//Check for Collision i.e, some value is already present 
		{

			if( str.equals(arr[idx]) )
			{
				contains(head, str);
				break;
			}
			else
			{
				idx += offset; //Quadratic Probing Logic(Incrementing the offset by 2 and adding to the previous Index) 
            offset += 2;					 
				
				
				if( idx > tableSize)	//Check whether the index crosses the table size 
					idx = idx - tableSize;
			}
		}
		arr[idx] = str;	// Inserting in the next available position of HashTable
	}
   
   
   public int findHash(String key) // to find the hash value of the string
   {
      int hashVal = 0;
   
      for( int i = 0; i < key.length( ); i++ )
         hashVal = 37 * hashVal + key.charAt( i );
      
      hashVal %= tableSize;
      if( hashVal < 0 )
         hashVal += tableSize;
   
      return hashVal;
   }
	
	public static void contains( Node x, String data)
	{	
		if(x==null) //Initializing the head of the List
		{
			head = new Node(data);
			head.count++;
			return;
		}
	
	
		if( x.data.equals(data) )	//if head of the Linked List has the duplicate number sent as argument
		{
			head.count++;
			return;	
		}
		else
		{	
         if(x.next!=null)
            x=x.next;

			while(x!=null)// to traverse all the nodes
			{
				if( x.data.equals(data) ) 	// if the Duplicate entry already exists just increase the previous exting count
				{
					x.count++;
					return;	
				}
				else
				{	
					if(x.next!=null)
                  x = x.next;
               else
                  break;   
				}
			}	
		}

		Node t = new Node(data); //new node to be inserted at the end of the linked list 
		t.count++;
		x.next = t;
	}
	
	//Method to find Duplicates which is called in Main Function
	public void FindDuplicates()
	{
      Node x=head;
	   while(x != null)
		{
			System.out.println("The element " + x.data + " is present " + (x.count+1) + " times totally including original value");
			x = x.next;
		}
	}
		
}

