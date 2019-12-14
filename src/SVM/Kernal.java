/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SVM;

import Statistic.unGroupedData1;
import java.util.Arrays;
import projectlearning.Matrix;

/**
 *
 * @author Mohammed kamal
 */
public class Kernal {
     private double F[];
     private double L[];
     private double varience;
     private double mean;
     public Kernal(double x[]) throws Exception {
     unGroupedData1 s=new unGroupedData1();
     this.mean=s.mean(x);
     this.varience=s.Variance(x);
     Arrays.fill(L, mean);
     Matrix m=new Matrix();
     this.F=m.DivisionByScaller(m.Substract(x, this.L), this.varience);
     }
     public double[] getF() {
          return F;
     }

     public void setF(double[] F) {
          this.F = F;
     }
     
     
}
