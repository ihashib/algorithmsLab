/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dfs_task01;

/**
 *
 * @author Hasib
 */
import java.io.File;
import java.util.Scanner;

public class DFS_task01 {

    /**
     * @param args the command line arguments
     */
    static int time=0;
    public static void main(String[]args) throws Exception {
        //Reading file using scanner
        File file = new File("input.txt");
        Scanner sc = new Scanner(file);

        int l = sc.nextInt();
        int m = sc.nextInt();
        int matrix[][] = new int[l + 1][m + 1];

        while (sc.hasNextLine()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            matrix[a][b] = 1;
        }
        //Print
        System.out.println("Adjacency matrix:");
        for (int i = 0; i < matrix.length; i++)
            System.out.print(i);
        System.out.println();
        for (int i = 1; i < matrix.length; i++) {
            System.out.print(i);
            for (int j = 1; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        //call method
        DFS(matrix);
    }
    static void DFS(int matrix[][]){
        int n=matrix.length;
        int color []=new int[n];
        int parent []=new int [n];
        int d []=new int [n];
        int f []=new int [n];
        //initialization
        for(int i=1;i<n;i++){
            color[i]=0;        //all nodes set to white
            parent[i]=-1;      //all nodes set to no parents
        }
        //for discovering nodes only
        System.out.println("Discovered nodes: ");
        for(int u=1;u<n;u++){
            if(color[u]==0){
                System.out.print(u + " ");
            }
        }
        System.out.println("\nProcessed Nodes: ");
        //Checking and sending source node to dfs visit
        for(int u=1;u<n;u++){
            if(color[u]==0){
                dfsVisit(matrix,u,color,parent,d,f);
                System.out.print(u + " ");
            }
        }
        System.out.println();
    }
    static void dfsVisit(int [] [] adj,int u, int [] color, int [] parent, int [] d, int [] f){
        color[u]=1;    //node is now grey
        time++;
        d[u]=time;
        //checking for child nodes and visiting child's child nodes
        for(int v=1; v<adj.length; v++){
            if(adj[u][v]==1 && color[v]==0){
                parent[v]=u;
                dfsVisit(adj,v,color,parent,d,f);
                System.out.print(v + " ");
            }
        }
        color[u]=2;   //node is now black
        time++;
        f[u]=time;
    }
}
