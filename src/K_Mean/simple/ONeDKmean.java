/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package K_Mean.simple;

/**
 *
 * @author Mohammed kamal
 */
public final class ONeDKmean 
{
  private final int k ;
 private final double Centriod[];
 private final double OldCenteriod[];
 private final double data[];
 private final double distance [];
 private final double clustered[][];

     public ONeDKmean(int k, double[] data) {
          this.k = k;
          this.data = data;
          this.Centriod=new double [k];
          this.OldCenteriod=new double[k];
          this.distance=new double[k];
          this.clustered=new double[data.length][2];
          int iteration=0;
          System.out.println("Hello ");
            initialCentroid();
        while(Error()>0){
            printArray(Centriod);
        for(int i=0;i<this.data.length;i++){
            
                    
                 for (int l=0;l<this.distance.length;l++)
                 {
                 distance[l]=this.distance(data[i], this.Centriod[l]);
                     System.out.println("distance "+l+":"+distance[l]);
                 }
                System.out.println("all distances is:");
                printArray(distance);
              this.clustered[i][0]= getMinumDistance()==0?1:getMinumDistance()==1?2:3;
                System.out.println("x="+data[i]);
                
                System.out.println("y="+data[i]);
              
              this.clustered[i][1]=data[i];
            
        
        }
        UpdateCentroid();
        printCluster();
        
        iteration++;
        
            System.out.println("----------------------------------------------------------");  
            System.out.println("iteration  :"+iteration+"   the Error :"+Error());
            System.out.println("-----------------------------------------------------------");
            
            
            System.out.println("New Centeriod :");
            this.printArray(this.Centriod);
            System.out.println("\n\nthe Old Centriod:");
            this.printArray(this.OldCenteriod);
             System.out.println("\n\n\n");
        }      
          
     }
     
     
 private void printCluster(){
     System.out.println("k cluster         :        x      ");
     for (double[] clustered1 : this.clustered) {
         System.out.print("Cluster     " + clustered1[0] + "  ");
         System.out.println("         " + clustered1[1] + "  ");
     }
     System.out.println("");
 }
 private void UpdateCentroid(){
double centroidx=0,centroidy=0,sum=0;
int havnoCentriod=0;
makeOldCentriod();
 for( int i=1;i<=k;i++){
     for (double[] clustered1 : this.clustered) {
         if (clustered1[0] == i) {
             centroidx += clustered1[1];
             sum++;
         }
     }
       if(sum!=0){
       this.Centriod[i-1]=(centroidx/sum);
       sum=0;
       centroidx=0;
       }
 }



 }
 private double Error(){
     double error=0;
   for(int i=0;i<this.Centriod.length;i++)
     {
         
               error+=(Math.pow(this.Centriod[i]-this.OldCenteriod[i], 2));
           
    }
 
 return Math.sqrt(error);
 }
 private void makeOldCentriod(){
    
        System.arraycopy(this.Centriod, 0, this.OldCenteriod, 0, this.Centriod.length);
    
 }
 void printArray(double a[][]){
     for (double[] a1 : a) {
         for (int j = 0; j < a1.length; j++) {
             System.out.print(a1[j] + " ");
         }
         System.out.println("\n------");
     }
 }
 void printArray(double a[]){
   for(int j=0;j<a.length;j++)
       {
           System.out.print(a[j]+" ");
       }
 
 }
 private void initialCentroid(){
 
     for( int i=0;i<k;i++){
      
        Centriod[i]=data[i];
      
 }
     
 }
 private double distance (double X,double Y){
     return Math.pow((Math.pow((X-Y), 2)),0.5);
 }
private int getMinumDistance(){
double min=this.distance[0];
for(int i=1;i<this.distance.length;i++)
{
    if(min>this.distance[i])
        min=this.distance[i];

}

    System.out.println("min k="+min);
   
    System.out.println("we selected cluster :"+Search(this.distance,0,this.distance.length, min));
    
return Search(this.distance,0,this.distance.length, min);
}
    
int Search(double arr[], int l, int r, double x)
{
    
   if (l <= r)
   {
        if (arr[l] == x)  
            return l;
        return Search(arr, ++l, r, x);
   }
 
   // We reach here when element is not 
   // present in array
   return -1;
}

     
 
     
     
}
