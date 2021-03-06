package indexers;

 import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
/*import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
*/
import Jama.Matrix;
import indexers.IdfIndexer;
import indexers.TfIndexer;
import indexers.VectorGenerator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.math3.linear.RealMatrix;


public class IndexersTest {



    private static VectorGenerator vectorGenerator;
    private  static Map<String,Reader> documents;
  

    public  static void setUp() throws Exception {
    vectorGenerator = new VectorGenerator();
    documents = new LinkedHashMap<String,Reader>();
    BufferedReader reader = new BufferedReader(
      new FileReader("D:\\Dropbox\\sandeep2\\2.txt"));
    String line = null;
    while ((line = reader.readLine()) != null) {
      String[] docTitleParts = StringUtils.split(line, ";");
      documents.put(docTitleParts[0], new StringReader(docTitleParts[1]));
      
      System.out.println(docTitleParts[0]+ " "+ docTitleParts[1] );
    }
  }
    
    
    public static void testVectorGeneration() throws Exception {
    vectorGenerator.generateVector(documents);
    prettyPrintMatrix("Term Frequencies", vectorGenerator.getMatrix(), 
      vectorGenerator.getDocumentNames(), vectorGenerator.getWords(), 
      new PrintWriter(System.out, true));
  }
  
    
    private static Matrix BuidAdjMatrix(Matrix matrix,PrintWriter writer){
    
        System.out.println("===Buiding Adj Matrix====================");
        double[][] vals = new double[3][3];
       
        Matrix a = new Matrix(vals);
        
        
    
        for (int i = 0;i<7;i++){
            for(int j = 0;j<7;j++){
         
                
                if (matrix.get(i, j)>0)
                {
                    
                 a.set(i, j, 1);
                
                        writer.printf("%8.4f", a.get(i, j));
                }else{
                
                writer.printf("%8.4f", a.get(i, j));
                
                }
         
                 }
        
        
        }
        return a ;
    
    }
    
    
    
    
    private  static void prettyPrintMatrix(String legend, Matrix matrix, 
      String[] documentNames, String[] words, PrintWriter writer) {
    writer.printf("=== %s ===%n", legend);
    writer.printf("%15s", " ");
    for (int i = 0; i < documentNames.length; i++) {
      writer.printf("%8s", documentNames[i]);
    }
    writer.println();
    for (int i = 0; i < words.length; i++) {
      writer.printf("%15s", words[i]);
      for (int j = 0; j < documentNames.length; j++) {
        
          writer.printf("%8.4f", matrix.get(i, j));
        
        
      }
      writer.println();
    }
    writer.flush();
  }

    
    private  static Matrix AdjPrintMatrix(String legend, Matrix matrix, 
      String[] documentNames, String[] words, PrintWriter writer) {
    writer.printf("=== %s ===%n", legend);
    writer.printf("%15s", " ");
    for (int i = 0; i < documentNames.length; i++) {
      writer.printf("%8s", documentNames[i]);
    }
    writer.println();
    for (int i = 0; i < words.length; i++) {
      writer.printf("%15s", words[i]);
      for (int j = 0; j < documentNames.length; j++) {
        
         if((matrix.get(i, j))>0)
         {
            double answer = matrix.get(i, j);
            answer = 1;
          writer.printf("%8.4f", answer);
         
            // System.out.println(1);
             
         }else{
         
            // System.out.println(0);
          writer.printf("%8.4f", matrix.get(i, j));
          }        
          //writer.printf("%8.4f", matrix.get(i, j));
        
        
      }
      writer.println();
    }
    writer.flush();
    
    return matrix;
  }
    
    
    
    public static Matrix testTfIndexer() throws Exception {
 
        vectorGenerator.generateVector(documents);
    
        TfIndexer indexer = new TfIndexer();

    Matrix tfMatrix = indexer.transform(vectorGenerator.getMatrix());
    
      //BuidAdjMatrix(tfMatrix,new PrintWriter(System.out, true));
    
    
     prettyPrintMatrix("Term Frequency", tfMatrix, 
      vectorGenerator.getDocumentNames(), vectorGenerator.getWords(), 
      new PrintWriter(System.out, true));
     
     System.out.println("============================");
     
    /* AdjPrintMatrix("Adj Term Frequency", tfMatrix, 
      vectorGenerator.getDocumentNames(), vectorGenerator.getWords(), 
      new PrintWriter(System.out, true));*/
    return tfMatrix; 
  }
    
    
    
     
    
    
    
public static void main(String argsp[]){
        try {
 
            setUp();
            //testVectorGeneration();
          // testTfIndexer();
       Matrix tfMatrix =   testTfIndexer();
    
       Matrix adjMatrix = AdjPrintMatrix("Adj Term Frequency", tfMatrix, 
      vectorGenerator.getDocumentNames(), vectorGenerator.getWords(), 
      new PrintWriter(System.out, true));
          
            
       // convert to regular array double for adj 
       double adj[][] = adjMatrix.getArray();
       
       
       
            
            
            
            
            
       
          
        } catch (Exception ex) {
            Logger.getLogger(IndexersTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }




}
    
    
    
 
 
