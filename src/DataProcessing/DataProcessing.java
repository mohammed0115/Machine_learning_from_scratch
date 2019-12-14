/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataProcessing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mohammed kamal
 */
public class DataProcessing {
     public  double data[][],y[][];

     public DataProcessing() throws FileNotFoundException {
          
        List<Instance> instances = readDataSet("thecurrency.txt"); 
          System.out.println("size()="+instances.get(0).x.length);
         this.ToMatrix(instances);
        
          this.printArray(data);
          
     }
      
      
      
 private static  void printArray(double a[][]){
     for (double[] a1 : a) {
         for (int j = 0; j < a1.length; j++) {
             System.out.print(a1[j] + "            "  );
         }
         System.out.println("\n------");
     }
 }
private static  void printArray(double a[]){
   for(int j=0;j<a.length;j++)
       {
           System.out.print(a[j]+" ");
       }
 
 }
      
      
      
    private void ToMatrix(List<Instance> instances){
        data=new double [instances.size()][instances.get(0).x.length-1];
         y=new double[instances.size()][1];
        	for (int i=0; i<instances.size(); i++) { 
                     for (int j=0; j<data[i].length; j++) {
                                  data[i][j]=instances.get(i).x[j];
                                  y[i][0]=instances.get(i).label;
                
                                                            }
                                                            }
    
    
    }
      
      
 	public static List<Instance> readDataSet(String file) throws FileNotFoundException { 
 		List<Instance> dataset = new ArrayList<>(); 
 		try (Scanner scanner = new Scanner(new File(file))) { 
 			while(scanner.hasNextLine()) { 
 				String line = scanner.nextLine(); 
 				if (line.startsWith("#")) { 
 					continue; 
 				} 
 				String[] columns = line.split("\\s+"); 
                        //printArray(columns);
 				// skip first column and last column is the label 
 				int i = 1; 
 				double[] data = new double[columns.length-1]; 
 				for (i=2; i<columns.length; i++) { 
 					data[i-2] = Double.parseDouble(columns[i]); 
 				} 
 				double label = Double.parseDouble(columns[i-1]); 
 				Instance instance = new Instance(label, data); 
 				dataset.add(instance); 
 			} 
 		} 
 		return dataset; 
 	} 
  
 
 	public static class Instance { 
 		public double label; 
 		public double[] x; 
  
 		public Instance(double label, double [] x) { 
 			this.label = label; 
 			this.x = x; 
 		} 
 	}
}
