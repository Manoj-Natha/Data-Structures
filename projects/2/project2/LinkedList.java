import java.util.Scanner;
import java.io.File;


public class LinkedList
{
   private Node head;
   private Node tail;
   int size;

   public void addnode(int x)
   {
      
      if(head== null && tail==null)
      {
         head = new Node(x, head);
         tail = head;
         size++;
         return;
      }
      else if(x<=head.data)
         {
            head = new Node(x, head);
            size++;            
            return;               
         }
       
      else if( x>tail.data)
      {
         tail.next = new Node(x, null);
         tail = tail.next;         
         size++;
         return;               
      }
      
      Node p = head;            
      while (p.next != null)
      {
         Node q = p.next;
         
         if(x>=p.data && x<=q.data)
         {
            p.next = new Node(x, q); 
            size++;
            break;               
         }
         p = p.next;   
      }

   
   }
   
   public static void Add(LinkedList l1,LinkedList l2,LinkedList l3,int n)
   {
   int i1,i2,i3;
   
   i1=l1.size;
   i2=l2.size;
   i3=l3.size;
   
   if(i1<=i2 && i1<=i3)
   {
      l1.addnode(n);
      System.out.println("Added "+n+" to queue List1");
   }
   else if(i2<=i1 && i2<=i3)
   {
      l2.addnode(n);
      System.out.println("Added "+n+" to queue List2");
   }
   else
   {
      l3.addnode(n);
      System.out.println("Added "+n+" to queue List3");
   }
   
   }
   
   public boolean delete(int x)
   {  
      if(head==null && tail==null)
      {
      return false;      
      }      
      else if(head.data==x)
      {         
         head=head.next;
         size--;
         return true;
      }
      else if(tail.data==x)
      {
          Node p = head;     
         while(p.next.data!=x)
         {
         p=p.next;
         }
         tail=p;
         tail.next=null;
         size--;
         return true;
      }
      else
      {
      Node p = head;
            
      while (p.next != null)
      {
         Node q = p.next;
         if(x == q.data)
         {
         p.next=q.next;
         size--;
         return true;
         }
         p = p.next;   
      }
            return false; 
     }
   
   
   }
   
   public static void Cancel(LinkedList l1,LinkedList l2,LinkedList l3,int n)
   {
   if(l1.delete(n))
      System.out.println("Deleted "+n);
   else if(l2.delete(n)) 
      System.out.println("Deleted "+n);
   else if(l3.delete(n)) 
      System.out.println("Deleted "+n);
   else
            System.out.println("Error no node with value "+n+" was not found");      
   }
   
   public static void Remove(LinkedList l1,LinkedList l2,LinkedList l3)
   {
   int min=2147483647;
   int flag=0;

   if(l1.head!=null)
   {   if(l1.head.data<min)
         {
         min=l1.head.data;   
         flag=1;
         }
   }
   if(l2.head!=null)
   {   if(l2.head.data<min)
        {
         min=l2.head.data;
         flag=2;
         }
   }
   if(l3.head!=null)
   {
      if(l3.head.data<min)
      {
      min=l3.head.data;           
      flag=3;
      }
   }
   
   if(flag==0)
   {
      System.out.println("Error in removing. All the Lists are empty..!! ");
   }
   
   else if(flag==1 )
   {
         System.out.println("Removed "+l1.head.data);       
         l1.head = l1.head.next;
         l1.size--;

   }
   else if(flag==2)
   {
         System.out.println("Removed "+l2.head.data);
         l2.head = l2.head.next;
         l2.size--;

   }
   else if(flag==3)
   {
         System.out.println("Removed "+l3.head.data);       
         l3.head = l3.head.next;
         l3.size--;

   }
   
   
   
   

   
   }
   

   public static void Print(LinkedList l1,LinkedList l2,LinkedList l3)
   {
   System.out.println(l1);
   System.out.println(l2);
   System.out.println(l3); 
   }

   public String toString()
   {
     
      if(head==null)
      {
      return new String("[ ]");
      }
      else
      {
      StringBuilder sb = new StringBuilder("[ ");
      Node p = head;      
      while (p.next != null)
      {
         sb.append(p.data + ", ");
         p = p.next;
      }
      sb.append(p.data + "]");
      return new String(sb);
      }      
      
   }


   private static class Node
   {
      int data;
      Node next;

      Node(int d, Node n)
      {
         data = d;
         next = n;
      }
   }
   
    public static void main(String args[])
   {
      LinkedList list1 = new LinkedList();
      LinkedList list2 = new LinkedList();
      LinkedList list3 = new LinkedList();
      
      try
      {
      Scanner sc=new Scanner(new File("input.txt"));
      String number;
      int num;
      while(sc.hasNext())
			{
				String s = sc.nextLine();
				char c = s.charAt(0);
				switch (c) {
				case 'A':
					number = s.replaceAll("[^0-9]", "");
					num = Integer.parseInt(number);
					Add(list1,list2,list3,num);
					break;
				
				case 'C':
					number = s.replaceAll("[^0-9]", "");
					num = Integer.parseInt(number);
					Cancel(list1,list2,list3,num);
					break;
					
				case 'R':
					Remove(list1,list2,list3);
					break;
					
				case 'P':
					Print(list1,list2,list3);
					break;
				default:
					System.out.println("Line is not proper in input file");
					break;
				}
			}   
      }
      
      catch(Exception E)
      {
      System.out.println("Expection found in the main file..!!");
      }
    
    
   }
   
   
}