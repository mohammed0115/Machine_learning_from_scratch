/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package K_Mean.simple;

import java.util.Arrays;

/**
 *
 * @author MusaCompany
 */
public final class KMean {
 private final int k ;
 private final double Centriod[][];
 private final double OldCenteriod[][];
 private final double data[][];
 private final double distance [];
 private final double clustered[][];

 @SuppressWarnings("empty-statement")
    public KMean(int k, double[][] data) {
        this.k = k;
        this.data = data;
        clustered=new double[data.length][3];
        
        distance=new double [k];
        Centriod=new double [k][2];
        OldCenteriod=new double[k][2];
        int iteration=0;
        
            initialCentroid();
        while(Error()>0){
            printArray(Centriod);
        for(int i=0;i<this.data.length;i++){
            for(int j=0;j<this.data[i].length-1;j++)
            {
                    
                 for (int l=0;l<this.distance.length;l++)
                 {
                 distance[l]=this.distance(data[i][j], data[i][(j+1)], this.Centriod[l][0], this.Centriod[l][1]);
                     System.out.println("distance "+l+":"+distance[l]);
                 }
                System.out.println("all distances is:");
                printArray(distance);
              this.clustered[i][0]= getMinumDistance()==0?1:getMinumDistance()==1?2:3;
                System.out.println("x="+data[i][j]);
                
                System.out.println("y="+data[i][(j+1)]);
              
              this.clustered[i][1]=data[i][j];
              this.clustered[i][2]=data[i][(j+1)];
            }
        
        }
        UpdateCentroid();
        printCluster();
        
        iteration++;
        
            System.out.println("----------------------------------------------------------");  
            System.out.println("iteration  :"+iteration+"   the Error :"+Error());
            System.out.println("-----------------------------------------------------------");
            
            
            System.out.println("New Centeriod :");
            this.printArray(this.Centriod);
            System.out.println("the Old Centriod:");
            this.printArray(this.OldCenteriod);
        }
        
        
        
       
    }

     public KMean(int k,double data[]) {
      ONeDKmean oNeDKmean = new ONeDKmean(k,data);
      this.k=k;
       this.data=new double [][]{};
        clustered=new double[data.length][3];
        
        distance=new double [k];
        Centriod=new double [k][2];
        OldCenteriod=new double[k][2];
     }
    
    
    
 
 
 private void printCluster(){
     System.out.println("k cluster      :   x    :   y   ");
     for (double[] clustered1 : this.clustered) {
         System.out.print("Cluster " + clustered1[0] + "  ");
         System.out.print("    " + clustered1[1] + "  ");
         System.out.println("  " + clustered1[2] + "  ");
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
             centroidy += clustered1[2];
             sum++;
             System.out.println("c="+i+"  sumx="+centroidx);
         }
     }
       if(sum!=0){
       this.Centriod[i-1][0]=(centroidx/sum);
       this.Centriod[i-1][1]=(centroidy/sum);
       sum=0;
       centroidx=0;
       centroidy=0;
       }
 }



 }
 
 
 
 
 private double Error(){
     double error=0;
   for(int i=0;i<this.Centriod.length;i++)
     {
         for (int j=0;j<this.Centriod[i].length;j++)
           {
               error+=(Math.pow(this.Centriod[i][j]-this.OldCenteriod[i][j], 2));
           }
    }
 
 return Math.sqrt(error);
 }
 private void makeOldCentriod(){
    for(int i=0;i<this.Centriod.length;i++){
        System.arraycopy(this.Centriod[i], 0, this.OldCenteriod[i], 0, this.Centriod[i].length);
    }
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
       for(int j=0;j<this.data[i].length-1;j++)
       {
        Centriod[i][0]=data[i][j];  
         Centriod[i][1]=data[i][(j+1)];
       }
 
 }
     
 }
 
 private double distance (double X,double Y,double a,double b){
     return Math.pow((Math.pow((X-a), 2))+(Math.pow((Y-b), 2)),0.5);
 }
private int getMinumDistance(){
double min=this.distance[0];
for(int i=1;i<this.distance.length;i++)
{
    if(min>this.distance[i])
        min=this.distance[i];

}

    System.out.println("min k="+min);
   
    System.out.println("we selected cluster :"+binarySearch(this.distance,0,this.distance.length, min));
    
return binarySearch(this.distance,0,this.distance.length, min);
}
    
int binarySearch(double arr[], int l, int r, double x)
{
    
   if (r >= l)
   {
        if (arr[l] == x)  
            return l;
        return binarySearch(arr, l+1, r, x);
   }
 
   // We reach here when element is not 
   // present in array
   return -1;
}

}
