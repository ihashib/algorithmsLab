
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
public class Dijkstra {
    public static void main(String[]args)throws Exception {
        File f=new File("Input.txt");
        Scanner sc=new Scanner(f);
        int l = sc.nextInt();
        //int m = sc.nextInt();
        int matrix[][] = new int[l + 1][l + 1];
        
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
        dig(matrix,1);
    }
    //Dijkstra's algo
    public static void dig(int G[][], int source){
        //Initialization 
        int size=G.length;
        int dist[]=new int[size];  //from parent
        int parent[]=new int[size];
        boolean[]visited=new boolean[size];
        for(int i=0;i<size;i++){
            dist[i]=Integer.MAX_VALUE;
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
                if(visited[v]==false && mindist > dist[v]){        //comparing 2 distances to select the lowest vertex                                                                          
                    mindist=dist[v];                                      
                    minIndex=v;
                }  
            }
            //System.out.println(minIndex);
            visited[minIndex]=true;
            
            //Finding path
            //runs 2ndary loop
            //checks if vertecies are connected
            //checks if vertecies have been visited
            /*
                checks if the addition of the distance of the vertex from the parent and the weight of the edge between minIndex 
                and v is lower than v's current distance from it's parent. If lower, then v th vertex's parent is changed to minIndex
                and distance is changed to the distance from it's current parent. IE: 3rd vertex's distance from parent is 2 and 
                the edge's weight connecting 3 and 2 vertex is 1, so adds to 3. 2nd vertex's current distance from it's current 
                parent is 4. So 2nd vertex's parent will change to 3 and 2nd vertex's distance from 3 is 3 now, since 3rd vertex's
                ditance from it's parent is 2 and the weight of the edge connectin 2 and 3 is 1, so 2+1=3.
            */
            for(int v=1;v<size;v++){
                if(G[minIndex][v]!=0 && visited[v]==false && (dist[minIndex]+G[minIndex][v]) < dist[v]){
                    parent[v] = minIndex;
                    dist[v] = dist[minIndex] + G[minIndex][v];                    
                }
            } 
        }

        System.out.println("Vertex   Distance from Source"); 
        for (int i = 2; i < size; i++){
            System.out.println(parent[i]+" to "+i+"     "+dist[i]);
        }
        System.out.println();
        //Backtrack
        for(int m=2;m<size;m++){
            int n=m, k=parent[n];
            System.out.print(n+" ==> "+(n=k));           //Calling destination's parent and storing the destination's parent to a variable
            while(n!=1){         
                System.out.print(" ==> "+(k=parent[n])); //as long as we don't reach root, we call the parent's parent and store the parent's 
                n=k;                                     //parent to a variable, then call that parent's parent until we reach the root
            }
            System.out.println();
        }        
    }
}