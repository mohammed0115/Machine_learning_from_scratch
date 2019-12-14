/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KNN;

import java.util.Arrays;

/**
 *
 * @author Mohammed kamal
 */
public final class KNN {
private final int k;
private final double data[][];
private final double Distance[];
private final double TestValue[][];
private final double SortedDistance[];
private final double KNearestNeighbors[][];
private  String Label[];
private String MyLabelis[];
private String nearesLable[];
int majority[];
public KNN(int k, double[][] data, double[][] TestValue, String [] Label) {
          this.k = k;
          this.data = data;
          this.TestValue = TestValue;
          this.Distance=new double[data.length];
          this.SortedDistance=new double[data.length];
          this.KNearestNeighbors=new double[k][data[0].length];
          this.nearesLable=new String[k];
          this.Label=Label;
          this.majority=new int[k];
          
          this.printArray(data);
          this.printLabel(Label);
          System.out.println("\nTotal Label is:");
          this.MyLabelis=TotalLabel();
          
          // begin from test 1  to N 
          for(int i=0;i<TestValue.length;i++)
            {
                 
                 System.out.println("-----------------------------------------");
                 this.ComputeDistanceBetweenSampleAndData(i);
                 System.out.println(" \nFirst Compute the Distance  :\n");
                 this.printArray(Distance);
                 this.CopyData(Distance, this.SortedDistance);
                 System.out.println("-----------------------------------------");
                  Arrays.sort(this.SortedDistance);
                 System.out.println("\n Sort the distance :\n");
                 this.printArray(this.SortedDistance);
                this.TakeNearestNeighbors();
                 this.getNearestLabel();
                 
                 System.out.println("-----------------------------------------");
                 System.out.println(" show what its Label\n ");
                 this.printLabel();
       System.out.println("the Decision  to Label test"+(i+1)+" :"+this.GetMajority());
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
           System.out.print(a[j]+" \n");
       }
 
 }

public KNN(int k, double[][] data, double[][] TestValue) {
          this.k = k;
          this.data = data;
          this.TestValue = TestValue;
          this.Distance=new double[data.length];
          this.SortedDistance=new double[data.length];
          this.KNearestNeighbors=new double[k][data[0].length];
          // begin from test 1  to N 
          for(int i=0;i<TestValue.length;i++)
            {
                 this.ComputeDistanceBetweenSampleAndData(i);
                 this.CopyData(Distance, this.SortedDistance);
                 Arrays.sort(this.SortedDistance);
                 this.TakeNearestNeighbors();
            }
          
     }
private void ComputeDistanceBetweenSampleAndData(int row ){
for(int i=0;i<data.length;i++)
   {
        for(int j=0;j<data[i].length;j++)
            {
             this.Distance[i]+=Math.pow(this.TestValue[row][j]-data[i][j], 2);
            }
    this.Distance[i]=Math.sqrt(this.Distance[i]);
    
   }

}
private void CopyData(double a[],double b[]){
     System.arraycopy(a, 0, b, 0, a.length);

}     
@SuppressWarnings("empty-statement")
private void TakeNearestNeighbors(){
 for(int i=0;i<k;i++)
    {
         double near=this.SortedDistance[i];
        int index=Search(Distance,0,Distance.length,near);
      for(int j=0;j<this.KNearestNeighbors[i].length;j++)
      { 
           this.KNearestNeighbors[i][j]=this.data[index][j];;
           
      }
      this.nearesLable[i]=this.Label[index];
    }
} 
private double[] MakeRegression(double data[][]){  
     
     
     return null;
} 
private double ApplySimpleMajority(){
     
     
     
     return 0;}


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





private void getNearestLabel()
{
     int index=0;
     for(int i=0;i<this.data.length;i++)
       {
            for(int j=0;j<this.data[i].length;j++)
               {
                    if(this.data[i][j]==this.KNearestNeighbors[index<k?index:0][j])
                    {
                       
                         
                         this.nearesLable[index<k?index:0]=this.Label[i];
                           
                    
                    }
               }
            index=index<=k?index++:0;
       }




}


public String [] TotalLabel()
{ String name=this.Label[0]+" ";
  
   for(int i=1;i<this.Label.length;i++)
   {
    if(!this.Label[i].equals(name)&&!name.contains(Label[i])) {
         name+=this.Label[i]+" ";
         
     } 
   }
   
   String NewLabel[]=name.split(" ");
     System.out.println("+-----------------+");
     System.out.println("|    Label        |");
     System.out.println("+-----------------+");
     for (String NewLabel1 : NewLabel) {
          System.out.println("|  " + NewLabel1 + "            |");
          System.out.println("+-----------------+");
     }
   return NewLabel;

}

private int  GetMajority()
{
int count[]=new int[this.MyLabelis.length];
     //System.out.println(Arrays.toString(this.nearesLable));
for(int i=0;i<count.length;i++)
     for (String nearesLable1 : this.nearesLable) {
          if (!this.MyLabelis[i].equals(nearesLable1)) {
          } else {
               count[i]++;
                 }
          
          
     }


return Arrays.binarySearch(count, this.Max(count));

}



private int Max(int count[]){
int min=count[0];
for(int i=1;i<count.length;i++)
{
    if(min<count[i])
        min=count[i];

}

    return min;
} 


private void printLabel(){
     System.out.println(Arrays.toString(this.nearesLable));;

}
private void printLabel(String l[]){
     System.out.println(Arrays.toString(l));;

}

public static void main(String[] args) {
//     
// double data[][]={{85,85},{80,90},{65,70},{72,95},{71,80},{83,78},{70,96},{68,80},{64,65},{69,70},{75,80},{75,70},{72,90},{81,75}};
//String Label[]=  { "no",     "no",   "no",   "no",   "no",  "yes", "yes", "yes", "yes", "yes", "yes", "yes", "yes" ,"yes"}; 
//// 
     
// double data[][]={{7,7},{7,4},{3,4},{1,4},{4,4}};
//String Label[]=  { "false",     "false",   "true",   "true","true"}; 
//// 

double data[][]=new double[81][1];
String Label[]=new String [81];

      double k=0;
      
     int i=0;
       for(int j=0;j<81;j++)
          {
               
                   
                    data[j][0]=(k);Label[j]=(k>=1.5&&k<2.5?"passed":k>=2.5&&k<3?"good":k>=3&&k<3.5?"very-good":k>=3.5&&k<=4?"execlent":"failed");  
                    k=k+(0.050000004);     
              
  
     switch (j) {
          case 20:
               i++;
               break;
          case 40:
               i++;
               break;
          case 60:
               i++;
               break;
          default:
               break;
     }
           
          }
 
     System.out.println("data="+data[60][0]);
     System.out.println(Label[60]);


double test[][]={{1.25}};
KNN KNN=new KNN(1,data,test,Label);

    
     }
     
}
