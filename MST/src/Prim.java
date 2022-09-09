import java.io.File;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Artorias
 */
public class Prim {
    public static void main(String[]args) throws Exception {
        File f=new File("input.txt");
        Scanner sc=new Scanner(f);
        int l = sc.nextInt();
        //int m = sc.nextInt();
        int matrix[][] = new int[l + 1][l + 1];
        
        while (sc.hasNextLine()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            matrix[a][b] = c;
           // matrix[b][a] = c;
        }
        //Print
        System.out.println("Adjacency matrix:");
        for (int i = 0; i < matrix.length; i++)
            System.out.print(i+" ");
        System.out.println();
        for (int i = 1; i < matrix.length; i++) {
            System.out.print(i+" ");
            for (int j = 1; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        mstPrim(matrix,4);
    }
    public static void mstPrim(int[][]G,int source){
        //Initialization 
        int size=G.length;
        int dist[]=new int[size];
        int parent[]=new int[size];
        boolean[]visited=new boolean[size];
        for(int i=1;i<size;i++){
            dist[i]=Integer.MAX_VALUE;   //have to be inf
            parent[i]=-1;
            visited[i]=false;
        }
        dist[source]=0;
        int minIndex=source;
        
        for(int i=1;i<size;i++){
            //Extracting minimum index..... 
            //checks if the vertex is visited or not
            int mindist=Integer.MAX_VALUE;
            for(int v=1;v<size;v++){                              
                if(visited[v]==false && mindist>dist[v]){     //comparing 2 distances to select the lowest vertex
                    mindist=dist[v];
                    minIndex=v;             
                }  
            }
            visited[minIndex]=true;           
            //Finding path
            //runs 2ndary loop
            //checks if vertecies are connected
            //checks if vertecies have been visited
            /*
              checks if the edge of the selected vertecies are lower than the v th vertex's distance form it's parent, 
              ie: 2-3 has weight of 3 currently but we are now comparing 3's distance form parent which is 2, since the 
              weight is lower, then we take that edge
            */
            for(int v=1;v<size;v++){
                if(G[minIndex][v]!=0 && visited[v]==false && G[minIndex][v]<dist[v]){
                    parent[v]=minIndex;
                    dist[v]=G[minIndex][v];
                }
            }           
        }
        
        //Printing
        for(int i=1; i<size;i++){
            if(parent[i]!=-1)
                System.out.println("Edge Found: "+parent[i]+" --> "+ i+" Weight: "+ G[i][parent[i]]);
        }
    }
}

