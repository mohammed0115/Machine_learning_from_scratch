
package projectlearning;

import java.util.Arrays;

public class Matrix  {
   private  double a[][];
   private double b[][];
   private double  result[][];
   private double element;
   private double DetermineOfMinor[][];
   private static final double PI=(22d/7d);
   private static final double DNorm=Math.pow(2*PI,0.5);
   public  Matrix(){}
   public Matrix(double a[][],double b[][]){
    this.a=a; this.b=b;}
   public  Matrix(double a[][]){}
   public double[][]  Add(double a[][],double b[][]) throws Exception{
       result=new double[a.length][a[0].length];
       if(a.length==b.length&&a[0].length==b[0].length )
       {
              for(int i=0;i<a.length;i++){
                         for(int j=0;j<a[i].length;j++){
                               result[i][j]=(a[i][j]+b[i][j]);
                                                       }  
                                          }
       }else
       {
       throw new Exception("defferen size");
       }
       
       return result; } 
   public double[][]  Substract(double a[][],double b[][]) throws Exception{
       result=new double[a.length][a[0].length];
        if(a.length==b.length&&a[0].length==b[0].length )
       {
              for(int i=0;i<a.length;i++){
                         for(int j=0;j<a[i].length;j++){
                               result[i][j]=(a[i][j]-b[i][j]);
                                                       }  
                                          }
       }else
       {
       throw new Exception("defferen size");
       }
    return result; }
   public double[][]  Maltiply(double a[][],double b[][]) throws Exception{
       result=new double[a.length][b[0].length];
    if(a[0].length==b.length)
       {
           double s=0;
              for(int i=0;i<a.length;i++){
                    for(int j=0;j<b[0].length;j++){
                               for(int k=0;k<b.length;k++)
                                    { s=s+(a[i][k]*b[k][j]);}
                               result[i][j]=s;
                               s=0;
                               
                               
                                                       }  
                                          }
       }else
       {
       throw new Exception("defferen size");
       }   
       
       
    return result; }
   public double[][]  getIdentity(double a[][]){
   result=new double[a[0].length][a[0].length];
   for(int i=0;i<result.length;i++){
   result[i][i]=1;}
       
    return result; }
   public double[][]  transpose(double a[][]){
        result=new double[a[0].length][a.length]; 
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                    result[j][i]=a[i][j];
                                                   }
        
                                   }
    return result; }
   public double[][]  Inverst(double a[][]) throws Exception{
     
       
     return  this.MultiplyMatrixByScalar(this.transpose(this.MatrixCo_Factor(this.MatrixDetermineOfminoreOf(a) )),1/this.determinant(a));
      }
   public double[]  Substract(double x[],double y[]) throws Exception
    {
         double z[]=new double [x.length];
       if(x.length==y.length){
            for(int i=0;i<x.length;i++)
               {
                    z[i]=x[i]+y[i];
               }
       return z;
       }else
       {throw new Exception ("Different size");}
    
    }
   public double [][] MultiplyMatrixByScalar(double a[][],double scalar){
       
        result=new double[a.length][a[0].length];
   for(int i=0;i<a.length;i++)
                    { 
               for(int j=0;j<a[i].length;j++)
                         {
                          result[i][j]=(scalar*a[i][j]);
                          
                         }
                 
                    }     
      
   
   return result;}
   public double[]  DivisionByScaller(double a[],double b){
        double z[]=new double[a.length];
        for(int i=0;i<a.length;i++)
        {
             z[i]=a[i]/b;
        }
    return z; }
   public double[][]  MatrixDetermineOfminoreOf(double a[][]) throws Exception{
     result=new double[a.length][a[0].length];
          if(a.length==a[0].length){
                 for(int i=0;i<a.length;i++){
                         for(int j=0;j<a[i].length;j++){
                          this.Minor(a, i, j);
                         }}}else{
              throw new Exception("array should be square matrix");}
    return result; }
   public void Minor(double a[][],int x,int y) throws Exception
   {
      double matrix[][]=new double [a.length-1][a[0].length-1]; 
     int k=0;int u=0;
                for(int i=0;i<a.length;i++)
                    { k=0;
                         for(int j=0;j<a[i].length;j++)
                         { 
                              if(j!=y&&x!=i)
                                     {   
                                         
                                     matrix[u][k]=a[i][j];
                                    
                                     k++;
                                     }
                        
                          }                   
            if(x!=i)
                u++;
                    }
                 result[x][y]=determinant( matrix);
    
      
      
   
   }
   public  double determinant(double[][] mat) throws Exception
    {
      int size=mat.length;
      double det = 0;
   if(size==mat[0].length){   
    
    if(size == 1)
        det = mat[0][0];
    else if (size == 2)
        det = mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1];
    else
    {
        for(int j1 = 0; j1 < size; j1++)
        {
            double[][] m = new double[size-1][size-1];
            for(int k = 0; k < (size-1); k++)
                m[k] = new double[size-1];
            for(int i = 1; i < size; i++)
            {
                int j2 = 0;
                for(int j = 0; j < size; j++)
                {
                    if(j == j1)
                        continue;
                    m[i-1][j2] = mat[i][j];
                    j2++;
                }
            }
            det += Math.pow(-1.0,  j1 ) * mat[0][j1] * determinant(m);
            
        }
    }}else throw new Exception("array should be square matrix");
       
    return det;
}
   public double [][] MatrixCo_Factor(double a[][])
   {  
    for(int i=0;i<a.length;i++)
                    { 
               for(int j=0;j<a[i].length;j++)
                         {
                          result[i][j]=Math.pow(-1, i+j)*a[i][j];
                         
                         }
                
              
                    }     
     
  return result; }
    public double [][]Cos(double a[][])
   {
      this.result=new double[a.length][a[0].length];  
     for(int i=0;i<a.length;i++)
     {
       for(int j=0;j<a[i].length;j++)
       {
            this.result[i][j]=Math.cos(a[i][j]);
            
       }
     }
   return this.result;
   }
   public void Fill(double a[][],double x)
   {
   for(int i=0;i<a.length;i++)
     {
       for(int j=0;j<(a[i].length);j++)
       {
            a[i][j]=1;
       }
     }
   }
   public double [][]Mean(double a[][]) throws Exception
    {
         
      this.result=new double[a.length][a[0].length];
      double built[][]=new double[1][a.length];
         this.Fill(built, 1);
            this.result=this.MultiplyMatrixByScalar(this.Maltiply(built, a),( 1.0/(a.length)));
            
      
    
    
    return result;
    } 
   public double [][]Fill(double a[][],double x[][])throws Exception
   {
        if(a[0].length==x.length)
            for(int i=0;i<a.length;i++)
               {
                    for(int j=0;j<a[i].length;j++)
                              for(int k=0;k<x[0].length;k++)
                                    {
                                         a[i][j]=x[j][k];
                                    }
               }        
                                                                                                                
                                                                                                                
                                                                                                                
           else 
             throw new Exception ("Different Size");
        return a;
   
   }
   
   public double [][]StandardDiviasion(double a[][]) throws Exception
   {
   return this.sqrt(this.Variance(a));   }
   public double [][]Variance(double a[][]) throws Exception
   {
   this.result=new double[a.length][a[0].length];
      double built[][]=new double[a.length][a[0].length];
         this.Fill(built, this.transpose(this.Mean(a)));
            this.result=this.MultiplyMatrixByScalar((this.SUM(this.pow(this.Substract(a, built), 2))), 1.0/(a.length));
            
      
    
    
    return result;
   
   
   }
   public double [][] SUM(double a[][]) throws Exception{
    
    this.result=new double[a.length][a[0].length];
      double built[][]=new double[1][a.length];
         this.Fill(built, 1);
            this.result=this.Maltiply(built, a);
            
      
    
    
    return result;
    
    } 
   public double [][]pow(double a[][],int pow)
   {
        this.result=new double[a.length][a[0].length];
     for(int i=0;i<a.length;i++)
     {
       for(int j=0;j<a[i].length;j++)
       {
            this.result[i][j]=Math.pow(a[i][j],pow);
            
       }
     }
   return this.result;
   }    
   public double [][]log(double a[][])                                                                                                     
   {
        
      this.result=new double[a.length][a[0].length];
     for(int i=0;i<a.length;i++)
     {
       for(int j=0;j<a[i].length;j++)
       {
            this.result[i][j]=Math.log(a[i][j]);
            
       }
     }
   return this.result;
   }
   public double[][]Exp(double a[][])
   {
   
    this.result=new double[a.length][a[0].length];
     for(int i=0;i<a.length;i++)
     {
       for(int j=0;j<a[i].length;j++)
       {
            this.result[i][j]=Math.exp(a[i][j]);
            
       }
     }
   return this.result;
   
   }
   
   public boolean equals(double a[][],double b[][])
   { boolean t=true;
     for(int i=0;i<a.length;i++)
     {
       for(int j=0;j<a[i].length;j++)
       {
           if(a[i][j]==b[i][j]);
           else t=false;
                
            
       }
     }
   return t;
   } 
   public double [][]sqrt(double a[][])
   {
        
      this.result=new double[a.length][a[0].length];
     for(int i=0;i<a.length;i++)
     {
       for(int j=0;j<a[i].length;j++)
       {
            this.result[i][j]=Math.sqrt(a[i][j]);
            
       }
     }
   return this.result;
   }
   public double []log(double a[])
   {
        
        double z[]=new double [a.length];
     for(int i=0;i<a.length;i++)
     {
       
            z[i]=Math.log(a[i]);
            
       
     }
   return z;
   } 
   public double []Cos(double a[])
   {
        double z[]=new double [a.length];
     for(int i=0;i<a.length;i++)
     {
       
            z[i]=Math.cos(a[i]);
            
       
     }
   return z;
   }   
   
   public double [][] XMinusMeu(double [][]a,double Meu[][]) throws Exception
   {
   
   return this.Substract(a, Meu);
   
   
   }
   public double [][]DotProduct(double [][]a,double [][]b) throws Exception
   {
     this.result=new double[a.length][a[0].length];
  
     if(a.length==b.length&&a[0].length==b[0].length)
          for(int i=0;i<a.length;i++)
       {
            for(int j=0;j<a[i].length;j++)
                 {
                     
                           this.result[i][j]=(a[i][j]*b[i][j]);
                         
                 }
       
       }
     else throw new Exception("Can not dot Substract different Size");
   
   return this.result;
   }
   public double [][]XDivY(double [][]a,double [][]b) throws Exception
   {
     this.result=new double[a.length][a[0].length];
  
     if(a.length==b.length&&a[0].length==b[0].length)
          for(int i=0;i<a.length;i++)
       {
            for(int j=0;j<a[i].length;j++)
                 {
                     
                           this.result[i][j]=((a[i][j])/(b[i][j]));
                         
                 }
       
       }
     else throw new Exception("Can not dot Substract different Size");
   
   return this.result;
   }
   public double [][]Z_Values(double a[][]) throws Exception{
    this.result=new double[a.length][a[0].length];
      double built[][]=new double[a.length][a[0].length];
      
      double built1[][]=new double[a.length][a[0].length];
         this.Fill(built, this.transpose(this.Mean(a)));
         this.Fill(built1,this.transpose( this.StandardDiviasion(a)));
         
         
   
   return this.XDivY(this.XMinusMeu(a, built), built1);
   
   
   }
   
   
   public double [][]NormalDistribution(double a[][]) throws Exception
   {
   double one[][]=new double[a.length][a[0].length];
   double tow[][]=new double[a.length][a[0].length];
        System.out.println("DNorm="+DNorm);
   this.Fill(tow, this.transpose(( this.MultiplyMatrixByScalar(this.StandardDiviasion(a),DNorm))));
   this.Fill(one,1);
  // this.Exp( this.MultiplyMatrixByScalar(this.pow(this.Z_Values(a), 2), -0.5));
  return this.DotProduct(this.XDivY(one, tow), this.Exp( this.MultiplyMatrixByScalar(this.pow(this.Z_Values(a), 2), -0.5)));
  
   }
   
   public static void main(String []args) throws Exception
        {
        Matrix a=new Matrix();
        double f[][]=new double[][]
        {
          
         {1},
         {2},
         {3},
         {4},
         {5},
         {6},
         {7},
         {8},
         {9},
         {10},
         {11}
         
                                                                                                            
        };
     double  u[][]=a.StandardDiviasion(f);
     
    //u= a.MatrixCo_Factor(u);
       // System.out.println(a.determinant(f));
      for(int i = 0; i < u.length; i++){
    for(int j = 0; j < u[0].length; j++)
    {
    System.out.print(" "+u[i][j]);
    }System.out.println();
      }

       
        }
}
