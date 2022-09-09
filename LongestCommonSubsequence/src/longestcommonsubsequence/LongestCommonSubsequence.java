/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longestcommonsubsequence;

/**
 *
 * @author Artorias
 */
public class LongestCommonSubsequence { 
   public static int mat[][],result=0;
   public static void main(String[] args) { 
        String s1="ACBDEA";
        String s2="ABCDA";
        char c1[]=s1.toCharArray();
        char c2[]=s2.toCharArray();
        int a=c1.length;
        int b=c2.length;
        mat=new int[a+1][b+1];
        //CALLING METHOD
        int num=lcs(c1,c2,a,b);
        //Printing
        System.out.println("LCS:"+num);    
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        } 
        System.out.print("Letters: ");
        boolean check[]=new boolean[mat.length];
        for(int i=1;i<mat[0].length;i++){           
            for(int j=1;j<mat.length;j++){                                            //checking top,diagonal,left.
                if(mat[j-1][i]!=mat[j][i] && mat[j][i-1]!=mat[j][i] && mat[j-1][i-1]!=mat[j][i]&& check[j]==false){  
                    System.out.print(c1[j-1]);                                        //if none match current mat[i][j],
                    check[j]=true;                                                    //prints j-1 th char, and jth matrix 
                    break;                                                            //isn't searched again, so once a char
                }                                                                     //is taken, it can't reapprear. then breaks
            }                                                                         //the inner loop as farther search not needed
        } 
        System.out.println();
    } 
    //LCS algo
    static int lcs(char c1[], char c2[], int a, int b) { 
        if (a==0 || b==0)                                    //2 uses, if no string and a, b eventually becomes 0 if chars mismatch
             return 0; 
        if (c1[a-1] == c2[b-1])                             //when chars match, 1 is added and lcs is again called recursively 
            result = 1 + lcs(c1, c2, a-1, b-1); 
        else
            result = Math.max(lcs(c1, c2, a, b-1), lcs(c1, c2, a-1, b)); // when chars don't match, they are cross checked with a
        mat[a][b]=result;                                                // and b. Gives max of the found results of recursion
        return result;                                                   
    }   
}