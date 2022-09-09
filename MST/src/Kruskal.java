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
public class Kruskal {
    public static void main(String[]args)throws Exception {
        //Read file
        File f=new File("input.txt");
        Scanner sc=new Scanner(f);
        int l = sc.nextInt();
        int matrix[][] = new int[l+1][l+1];     
        while (sc.hasNextLine()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            matrix[a][b] = c;
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
        //calling method
        mstKruskal(matrix);
    }
    //Kruskal mathod
    public static void mstKruskal(int G[][]){
        int size=G.length;
        int parent[]=new int [size];
        int NumberOfEdges=1;                    //not 0 because when the loop starts, it gets one edge already.
        int minWeight=0,total=0;
        int u=0,v=0,r=0,s=0;
        for(int i=1;i<size;i++)
            parent[i]=-1;
        
        while(NumberOfEdges<size-1){
            minWeight =Integer.MAX_VALUE;
            for(int i=1; i<size;i++){
                for(int j=1; j<size; j++){      //finding the edge with lowest weight, minWeight                                                                                                   
                    if(minWeight>G[i][j] && G[i][j]!=0){      // comparing edge weight of G[i][j] with minWeight
                        minWeight = G[i][j];
                        u=r=i;                  // v and u is used to detect circle, thus, r s is used for removing the used edge
                        v=s=j;
                    }
                }
            }
            if(parent[u]!=-1)   
                u= parent[u];                  //check's if both have same parent, if both have same parent then it'll form a circle
            
            if(parent[v]!=-1){                  //corr: can't be 0, cuz vertex is 0
                v=parent[v];
            }
            if(v!=u){
                NumberOfEdges++;
                System.out.println("Edge Found: "+(r)+"-->"+(s)+" Weight: "+minWeight);
                total+=minWeight;
                parent[v]=u;                 //Because if vatecies are i=u=1 and j=v=3(i is row, which is parent and j is collumn)
            }
            G[r][s]=G[s][r]=0;               //removing used edge
        }
        System.out.println("minimum Weight: "+total);
    }
}
/*
#Algorithm
    *find edge with lowest edge, take the vertecies 
    *check if the vertecies have same parent
    *Update parent array with the vartecies
    *Remove the used edges with 0(out side the loop)
*/