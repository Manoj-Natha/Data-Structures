public class sort{

   private static void bucketSort( Integer [ ] a )
    { 
      int maximum=-1;
         for(int i=0;i<a.length;i++)
         {
            if(a[i]>maximum)
            maximum=a[i];
         }    

      Integer[] b= new Integer[maximum+1]; 
      
         for(int i=0;i<b.length;i++)
         {
               b[i]=0;   
         }
         
         
         for(int i=0;i<a.length;i++)
         {
               b[a[i]]++;   
         }
         
         
         
         int k=0;
         for(int i=0;i<b.length;i++){
            if( b[i] != 0){     
             for( int j = 0; j < b[i]; j++){
                  a[k++]=i;
             }
            }
         }
      
      
      System.out.println("\nAfter sort:");    
      for(int i=0;i<a.length;i++)
         System.out.print("\t"+a[i]);    

                  
    }

   public static void main(String[] args){
      
      
      Integer a[]={6,1,9,2,4,7,8,1,5,9,2,1};
      
      sort.bucketSort(a);
   
     
   
   }





}

