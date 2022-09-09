/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


/**
 *
 * @author 17301194
 */
public class LAB1 {

    /**
     * @param args the command line arguments
     */
    File f;
    public static void main(String[] args) {
        // TODO code application logic here
        //File Scanner
        Scanner sc=null;
        LAB1 algo=new LAB1();
        algo.f=new File("input.txt");
        try {
            sc=new Scanner(algo.f);
        
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LAB1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // TODO code application logic here
        //File Scanner
        
        //Graph
        
        //Adjacency Matrix
        int size=sc.nextInt();
        int matrixUn[][] = new int[size][size];
        int matrixDir[][] = new int[size][size];
        

        
        while(sc.hasNext()){  //asking if there's more to read
            int a=sc.nextInt();
            int b=sc.nextInt();

            //Adjacency Matrix
            matrixUn[a][b]=1;
            matrixUn[b][a]=1;
            
            matrixDir[a][b]=1;
            //Adjacency List
            
            
        }
        //Adjacency List
        ArrayList<ArrayList<Integer>> listUn=new ArrayList<ArrayList<Integer>>(size); //Arraylist of ArrayList
        int c=-1;
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            ArrayList<Integer> t=null;
            if(c==-1){
                t=new ArrayList<Integer>();
                t.add(b);
            }
            else if(c==a){
                t=new ArrayList<Integer>();
                t.add(b);
            }
            else if(c!=a){
                listUn.add(t);
            }
            c=a;
        }
        //System.out.println(listUn);
        System.out.println("Undirected Graph…..\nAdjacency Matrix :-");
        System.out.print(" ");
        for(int i=0;i<matrixUn.length;i++) System.out.print(i);
        System.out.println();
        for(int i=0;i<matrixUn.length;i++){
            System.out.print(i);
            for(int j=0;j<matrixUn[0].length;j++){
                System.out.print(matrixUn[i][j]);
            }
            System.out.println();
        }
        System.out.println("Directed Graph…..\nAdjacency Matrix :-");
        System.out.print(" ");
        for(int i=0;i<matrixDir.length;i++) System.out.print(i);
        System.out.println();
        for(int i=0;i<matrixDir.length;i++){
            System.out.print(i);
            for(int j=0;j<matrixDir[0].length;j++){
                System.out.print(matrixDir[i][j]);
            }
            System.out.println();
        }
    }    
}
