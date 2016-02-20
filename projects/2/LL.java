// Ozbirn, 09/16/15
//
public class LL
{
   private Node head;
   private Node tail;
   int size;

   public void addFront(int x)
   {
      head = new Node(x, head);
      if (tail == null)
        tail = head;
      size++;
   }

   public void addTail(int x)
   {
      if (tail == null)
         addFront(x);
      else
      {
         tail.next = new Node(x, null);
         tail = tail.next;
         size++;
      }
   }
   
   public void remove(int idx)
   {
      if (idx < 0 || idx > size - 1)
         throw new IndexOutOfBoundsException();
      else
      {
         if (head == tail)  
         {
            head = tail = null;
         }
         else if (idx == 0) 
         {
            head = head.next;
         }
         else if (idx == size - 1)
         {
            Node p = head;
            for (int i=0; i < idx-1; i++)
               p = p.next;
            p.next = null;    
            tail = p;
         }
         else
         {
            Node p = head;
            for (int i=0; i < idx-1; i++)
               p = p.next;
            p.next = p.next.next;
         }
         size--;
      }   
   }

   public String toString()
   {
      StringBuilder sb = new StringBuilder("[ ");
      
      Node p = head;      
      while (p != null)
      {
         sb.append(p.data + " ");
         p = p.next;
      }
     
      sb.append("]");
      return new String(sb);
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
      LL list = new LL();
    
      //for (int i = 10; i>0; i--)
      //   list.addFront(i);
      
      for (int i = 1; i<=10; i++)
         list.addTail(i);
          
      System.out.println(list);
      
      list.remove(0);
      System.out.println(list);
      list.remove(8);
      System.out.println(list);
      list.remove(5);
      System.out.println(list);     
   }
}

