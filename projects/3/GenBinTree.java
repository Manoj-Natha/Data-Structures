import java.io.*;

public class GenBinTree<AnyType extends Comparable<? super AnyType>>
{

   public GenBinTree( )
   {
      root = null;
   }

   public void Add(AnyType x )
   {
      root=Add(root,x); // no need to check duplicate as root is the element to be inserted
   }

  
   public void Add(String s,AnyType x )
   {
      if(Find(root,x)==true) // To avoid duplicate nodes to be inserted into the tree. 
         System.out.println("Error In adding becuase "+x+" is a duplicate value");   
      else
         root=Add(root,s,x);
   }
   
   
   public boolean Find( AnyType x ) //Find a node whose element value is x
   {
      return Find(root,x);   
   }
   
   
   public void Remove( AnyType x ) // Remove a node with value x
   {
      Node<AnyType> t1=LocateLeaf(root,x);       
      if(t1==null) // no leaf node found with the given value
         System.out.println("Error..!! No such leaf node with value "+x+" found to delete ");         
      else        
         Remove(root,x);
        
   }
   
   public void Swap( AnyType x ) //swap the children of the node whose value is x
   {  
      Node<AnyType> t=Locate(root,x);       
      if(t==null) // If element passed value is not found
         System.out.println("Error..!! No such node with value "+x+" found to swap ");         
      else        
      {
         Node<AnyType> temp=t.left;
         t.left=t.right;
         t.right=temp;
         System.out.println("children of node "+x+" sucessfully swapped."); 
                          
      }   
   
   }      
   
   
   public void Mirror() // Mirror the whole tree 
   {   
      if( root==null ) // given tree is empty
         System.out.println( "Error in mirroring..!! Since the tree is empty" );
      else
      {
         System.out.println( "Starting the mirroring of the tree..!!" );
         Mirror(root);
         System.out.println( "Sucessfully mirrored the tree..!!" );
      }
   }
   
   public void RotateRight(AnyType x) // Right rotate the node with value x  
   {
      Node<AnyType> t=Locate(root,x); //Locate node to be rotated(with value X)
      if(t==null) // No element found with value x
         System.out.println("Error..!! No such node found to rotate");
      else if(t==root) //Root element is to be rotated
         RotateRootRight(root,x);
      else // element is found but not a not root node
         RotateRight(root,x);
   }
   
   
   public void RotateLeft(AnyType x) // Left rotate the node with value x  
   {
      Node<AnyType> t=Locate(root,x); //Locate node to be rotated(with value X)
      if(t==null)  // No element found with value x
         System.out.println("Error..!! No such node found to rotate");
      else if(t==root) //Root element is to be rotated
         RotateRootLeft(root,x);
      else // element is found but not a not root node      
         RotateLeft(root,x);
   }
   
   
   public int CountNodes() //count the number of nodes in the tree
   {
      return CountNodes(root);
   }
   
   public void Print() // Print all the elements in the tree in-order
   {
      if( root==null ) //tree is empty
         System.out.println( "The tree is empty" );
      else
         Print(root);
   }

public void PreOrder()
   {
      if( root==null )
         System.out.println( "The tree is empty" );
      else
         PreOrder(root);
   }

   
   private Node<AnyType> Add(Node<AnyType> t, AnyType x ) //this is used to add node in the root of tree
   {
      System.out.println( "New node "+x+" has been Inserted successfully..!" );
      return new Node<>( x, null, null );
   }

   
   private Node<AnyType> Add(Node<AnyType> t,String str, AnyType x ) //this is used to add node other then the root of tree 
   {
      
      if(str.length()>1 && str.charAt(0)=='L') // insert in the left
      {
         if(t.left!=null)
            Add(t.left,str.substring(1),x);            
         else 
            System.out.println( "Error Inserting. Wrong position to insert "+x );
      }
      else if(str.length()>1 && str.charAt(0)=='R') // insert in the right
      {
         if(t.right!=null)
            Add(t.right,str.substring(1),x);
         else 
            System.out.println( "Error Inserting. Wrong position to insert. "+x );      
      }
      else if(str.charAt(0)=='L') //traverse through left tree
      {
         t.left= new Node<>( x, null, null ); 
         System.out.println( "New node "+x+" has been Inserted successfully..!" );
      }
      else if(str.charAt(0)=='R') //traverse through right tree
      {
         t.right= new Node<>( x, null, null ); 
         System.out.println( "New node "+x+" has been Inserted successfully..!" );
      }
      else //given path is wrong
      {
         System.out.println("Error in adding..!! Unknown charcter found in the input string argument ");
      }       
      return t;
   }


private boolean Find( Node<AnyType> t, AnyType x ) // Find element x
   {
       
      if(t!=null)
      {
      if(x.compareTo(t.element) == 0) // if value is found return true
         return true;      
      
      if( Find( t.left,x ) == true ) //  traverse left subtree         
         return true;             
      
      return Find( t.right,x );  //  traverse right subtree                
      
      }
      
      return false; // if value is not found return false
   }   


   private Node<AnyType> LocateLeaf( Node<AnyType> t, AnyType x ) //Locate leaf node with the value x
   {
      
      
      if(t!=null)
      {
      if(x.compareTo(t.element) == 0 && t.left==null && t.right==null ) // to match value of x and also check leaf condition
         return t;      
      
      if( Locate( t.left,x ) != null ) //   traverse left subtree         
         return Locate( t.left,x );             
             
      return Locate( t.right,x );  //   traverse right subtree                 
      
      }
      
      return null; // if not found return null
      
   }
   
   private Node<AnyType> Locate( Node<AnyType> t, AnyType x ) // same as above function but no leaf condition
   {
      
      
      if(t!=null)
      {
      if(x.compareTo(t.element) == 0)
         return t;      
      
      if( Locate( t.left,x ) != null ) //   return Locate( t.left,x );         
         return Locate( t.left,x );             
             
      return Locate( t.right,x );         
      
      }
      
      return null;
      
   }
  
   
   
   public void Remove( Node<AnyType> t, AnyType x ) // Remove the node with value x
   {
         if(t!=null)
         {
         if(t.left!=null) //node before the element to be deleted is t and t.left is the node to be checked for deletion
         if(x.compareTo(t.left.element)==0 && t.left.left== null && t.left.right== null ) // to check value and leaf condition also
         {
            t.left=null; //delete node        
            System.out.println("First matching leaf node "+x+" deleted successfully..!!");
            return;
         }
         if(t.right!=null) //node before the element to be deleted is t and t.right is the node to be checked for deletion         
         if(x.compareTo(t.right.element)==0 && t.right.left== null && t.right.right== null) // to check value and leaf condition also
         {
            t.right=null; //delete node         
            System.out.println("First matching leaf node "+x+" deleted successfully..!!");
            return;
         }
         Remove( t.left,x ); //traverse left subtree
         Remove( t.right,x ); //traverse right subtree                          
         }
            
   }

   
   private void Mirror( Node<AnyType> t ) //Mirroe the tree
   {
      if( t != null )
      {
         Swap( t.element ); //swap each element of the tree
         Mirror( t.left ); //traverse left subtree
         Mirror( t.right ); //traverse right subtree
      }
   }
   

   
   private void RotateRootRight( Node<AnyType> t,AnyType x ) //rotate right the root of the tree and value x
   {          
         if(x.compareTo(t.element)==0)
         {
            System.out.println("Found matching element "+x+" to be rotated");
            Node<AnyType> k1 = t.left;
            t.left = k1.right;
            k1.right = t; 
            root=k1;
         }   
            
         
      }



   
   private void RotateRight( Node<AnyType> t,AnyType x )//rotate right the node of the tree with value x and not root
   {  
         if(t!=null) //same logic of remove to find parent node of node to be rotated
         {
               if(t.left!=null)
                  if(x.compareTo(t.left.element)==0)
                  {
                    Node<AnyType> k2=t.left;
                    if(k2.left==null)
                    {
                    System.out.println("Right Rotation can't be performed on this node "+x+" as it has no left child..!!");
                    return;
                    }                    
                    Node<AnyType> k1 = k2.left;
                    k2.left = k1.right;
                    k1.right = k2;
                    t.left=k1;
                    return;
                  }
               if(t.right!=null)         
                  if(x.compareTo(t.right.element)==0)
                  {
                     
                    Node<AnyType> k2=t.right;
                    if(k2.left==null)
                    {
                    System.out.println("Right Rotation can't be performed on this node "+x+" as it has no left child..!!");
                    return;
                    }                    
                    Node<AnyType> k1 = k2.left;
                    k2.left = k1.right;
                    k1.right = k2;
                    t.right=k1;
                    return;
                  }
               RotateRight( t.left,x );
               RotateRight( t.right,x );                          
         }
         
     }
     
   private void RotateRootLeft( Node<AnyType> t,AnyType x ) //rotate right the root of the tree and value x
   {          
         if(x.compareTo(t.element)==0)
         {
            System.out.println("Found matching element "+x+" to be rotated");
            Node<AnyType> k1 = t.right;
            t.right = k1.left;
            k1.left = t; 
            root=k1;
         }            
   }

   
   private void RotateLeft( Node<AnyType> t,AnyType x ) //rotate right the node of the tree with value x and not root
   {  
         if(t!=null) //same logic of remove to find parent node of node to be rotated
         {
               if(t.left!=null)
                  if(x.compareTo(t.left.element)==0)
                  {
                    Node<AnyType> k1 = t.left; 
                    if(k1.right==null)
                    {
                    System.out.println("Left Rotation can't be performed on this node "+x+" as it has no right child..!!");
                    return;
                    }                
                    Node<AnyType> k2 = k1.right;
                    k1.right = k2.left;
                    k2.left = k1;
                    t.left=k2;
                    return;
                  }
               if(t.right!=null)         
                  if(x.compareTo(t.right.element)==0)
                  {
                    Node<AnyType> k1 = t.right; 
                    if(k1.right==null)
                    {
                    System.out.println("Left Rotation can't be performed on this node "+x+" as it has no right child..!!");
                    return;
                    }
                    Node<AnyType> k2 = k1.right;
                    k1.right = k2.left;
                    k2.left = k1;
                    t.right=k2;
                    return;
                  }
               RotateLeft( t.left,x );
               RotateLeft( t.right,x );                          
         }
         
     }    
    
    
            
  
   private int CountNodes( Node<AnyType> t ) //find number of nodes
   {
      if( t != null )
         return 1+CountNodes( t.left )+CountNodes( t.right );
      else 
         return 0;
   }
      
   
   
   
   
   private void Print( Node<AnyType> t ) //inorder traversal to print the tre
   {
      if( t != null )
      {
         Print( t.left );
         System.out.println( t.element );
         Print( t.right );
      }
   }
   
   private void PreOrder( Node<AnyType> t )//preorder traversal to print the tre
   {
      if( t != null )
      {
         System.out.println( t.element );
         PreOrder( t.left );
         PreOrder( t.right );
      }
   }


   private static class Node<AnyType> //genric node type
   {
      AnyType element;
      Node<AnyType> left ;
      Node<AnyType> right;
   
   Node( AnyType theElement )
   {
      this( theElement, null, null );
   }

   Node( AnyType theElement, Node<AnyType> lt, Node<AnyType> rt )
   {
      element  = theElement;
      left     = lt;
      right    = rt;
   }
   }
   private Node<AnyType> root; //root node of the tree


   
   public static void main( String [ ] args )
   {
      GenBinTree<Integer> t = new GenBinTree<>( );
      
      //you change the below values
      
      t.Add(100);
      t.Add("L",10);
      t.Add("LL",300);
      t.Add("LLLL",3000);
      t.Add("LLL",400);
      t.Add("LR",20);
      t.Add("R",200);
      t.Add("RR",1);
      t.Add("RL",150);
      t.Add("LRR",500);
      t.Add("RLR",600);
      
      t.Print(); 


      System.out.println("No of nodes in tree are "+t.CountNodes());


      System.out.println("Output of Find(300) is "+t.Find(300));      
      
      System.out.println("Output of Find(2000) is "+t.Find(2000));      

      System.out.println("Output of Find(150) is "+t.Find(150));      
      
      System.out.println("Output of Find(600) is "+t.Find(600));      

         

      t.Remove(1500);
      
      t.Remove(10);
      
      t.Remove(100);
      
      
      t.Remove(400);
      System.out.println("print after deleting 400");
      t.Print();

      System.out.println("No of nodes in tree are "+t.CountNodes());

      
                 
      t.Remove(600);
      System.out.println("print after deleting 1");
      t.Print();
            
      
      t.Swap(10);
      System.out.println("Print after swaping 10:");
      t.Print();    
     
         
      t.Swap(100);
      System.out.println("Print after swaping 100:");
      t.Print();    
      

      System.out.println("No of nodes in tree are "+t.CountNodes());
      
      
      t.Mirror();
      
      System.out.println("Print after mirroring:");
      t.Print();  
  
      
      t.RotateRight(300);
      System.out.println("pre-order After rotate right");
      t.PreOrder();
      System.out.println("print After rotate right");
      t.Print();
      System.out.println("No of nodes in tree are "+t.CountNodes());
     
      
      t.RotateLeft(100);         
      System.out.println("preorder After rotate Left");
      t.PreOrder();
      System.out.println("print After rotate Left");
      t.Print();
          
   }

}