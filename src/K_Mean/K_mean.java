/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package K_Mean;

import java.util.Arrays;

/**
 *
 * @author Mohammed kamal
 */
public class K_mean {
 private final int k ;
 private final double Centriod[][];
 private final double OldCenteriod[][];
private final double data[][];
private final double distance [];
private final double clustered[][];
 public K_mean(int k, double[][] data) {
          this.k = k;
          this.data = data;
          this.Centriod=new double [k][data[0].length];
          this.OldCenteriod=new double [k][data[0].length];
          this.clustered=new double[data.length][data[0].length+1];
          this.distance=new double [k];
             this.initialCentroid();
        while(this.Error()!=0){
          
          this.printArray(this.Centriod);
          for(int i=0;i<this.data.length;i++)
          {
               this.Euclidean(i);
               this.MakeCluster(i);
               UpdateCentroid(); 
          }
          this.printCluster();
          
        
        }
          
          
          
     }
 public double[][] getCentriod() {
          return Centriod;
     }
 public double[][] getClustered() {
          return clustered;
     }
 private void UpdateCentroid(){
     makeOldCentriod();
     double []array=new double [data[0].length],sum=new double[data[0].length];
     for(int i=0;i<k;i++)
       {
            for(int j=0;j<this.clustered.length;j++)
            {
                 for(int k=1;k<this.clustered[j].length;k++)
                   {
                        if(this.clustered[j][0]==i)
                          {
                               array[k-1]+=this.clustered[j][k];
                               sum[k-1]++;
                          }
                   }
                 
            
            }
         if(sum[0]!=0) 
         for(int j=0;j<this.Centriod[i].length;j++)
            {
                this.Centriod[i][j]=(array[j]/sum[j]);
                 array[j]=0;
                 sum[j]=0;
                
            }
            
            
       }

     
     
}        
 private void makeOldCentriod(){
        for(int i=0;i<this.Centriod.length;i++){
           System.arraycopy(this.Centriod[i], 0, this.OldCenteriod[i], 0, this.Centriod[i].length);
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
 private void initialCentroid(){
 
     for( int i=0;i<k;i++){
       for(int j=0;j<this.data[i].length;j++)
       {
        Centriod[i][j]=data[i][j];  
       }
 
 }  
     
 }  
 private void printArray(double a[][]){
     for (double[] a1 : a) {
         for (int j = 0; j < a1.length; j++) {
             System.out.print(a1[j] + " ");
         }
         System.out.println("\n------");
     }
 }
 private void printArray(double a[]){
   for(int j=0;j<a.length;j++)
       {
           System.out.print(a[j]+" ");
       }
 
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
 private void Euclidean(int row){
 Arrays.fill(this.distance, 0);
      for(int i=0;i<k;i++)
        {
             for(int j=0;j<this.data[i].length;j++)
               {
                 this.distance[i]+=Math.pow((this.Centriod[i][j]-this.data[row][j]),2);
                   
               }
             this.distance[i]=Math.sqrt(this.distance[i]);
        }
      
      
      
                        }    
 private int getMinumDistance(){
double min=this.distance[0];
for(int i=1;i<this.distance.length;i++)
{
    if(min>this.distance[i])
        min=this.distance[i];

}

    
return Search(this.distance,0,this.distance.length, min);
} 
 private int Search(double arr[], int l, int r, double x){
    
   if (l < r)
   {
        if (arr[l] == x)  
            return l;
        return Search(arr, ++l, r, x);
   }
 
   // We reach here when element is not 
   // present in array
   return -1;
}
 private void MakeCluster(int row){
 this.clustered[row][0]=this.getMinumDistance();
  for(int i=1;i<this.clustered[row].length;i++)
      {
           this.clustered[row][i]=this.data[row][i-1];
      }
 
                            }    
     
}
