/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergesort;

/**
 *
 * @author Artorias
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hasib
 */
public class MergeSort {
    public static void main(String[]args){
        int arr[]={3,33,66,2,7,99,22};
        arr=mergeSort(arr);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    static int[] mergeSort(int arr[]){
        if(arr.length<=1)
            return arr;
        int mid = arr.length/2,i=0;
        int arr1[]=new int[mid];
        int arr2[]=new int[arr.length-mid];
            
        for(int j=0;j<arr1.length;j++)
            arr1[j]=arr[i++];
        for(int k=0;k<arr2.length;k++)
            arr2[k]=arr[i++];
        mergeSort(arr1);
        mergeSort(arr2);
            
        merge(arr1,arr2,arr);
           
        return arr;
          
    }
    static void merge(int arr1[],int arr2[],int arr[]){
        int l=0,r=0,i=0;
        while(l<arr1.length && r<arr2.length){
            if(arr1[l]<arr2[r]){
                arr[i]=arr1[l];
                l++; 
            }
            else if(arr1[l]>arr2[r]){
                arr[i]=arr2[r];
                r++;
            }  
            i++;
        }
        while(l<arr1.length){
            arr[i]=arr1[l];
            l++;
            i++;
        }
        while(r<arr2.length){
            arr[i]=arr2[r];
            r++;
            i++;
        }
    }
}
