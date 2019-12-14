/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SVM;

import java.util.Arrays;
import projectlearning.Matrix;

/**
 *
 * @author Mohammed kamal
 */
public class CostFunction {
     
     private double MinimumCost;

     public CostFunction(double Cons,double Y[][], double theta[][],double X[][]) throws Exception {
      Matrix m=new Matrix();
//     m.Maltiply(Y,m.Maltiply(m.transpose(theta), X));
     double id[][]=m.getIdentity(Y);
///     Arrays.fill(id, 1);
//     m.Maltiply(m.Substract(id, Y), m.Maltiply(m.transpose(theta), X));
  //   m.MultiplyMatrixByScalar(theta, 0.5);
          
          X=new double[][]{{1,2,3}};
        
         double xx[][]= m.Maltiply(m.transpose(X), X);
//           X=m.pow(X);
         for (int i=0;i<xx.length;i++)
         for (int j=0;j<xx[i].length;j++)      
         {System.out.print("xx="+xx[i][j]);
         // System.out.println("\tpow="+X[i][j]);
         }
     }

    

     public double getMinimumCost() {
          return MinimumCost;
     }

     public void setMinimumCost(double MinimumCost) {
          this.MinimumCost = MinimumCost;
     }
     
}
