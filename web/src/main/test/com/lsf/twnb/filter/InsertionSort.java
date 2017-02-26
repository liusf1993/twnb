package com.lsf.twnb.filter;

/**
 * Test for insertion Sort
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[100000];
        for( int i=0;i<100000;i++){
            a[i]=100000-i;
        }
        int count=0;
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp=a[j];
                    a[j]=a[j-1];
                    a[j-1]=temp;
                    ++count;
                }
            }
        }
        System.out.println("sum swap is "+count);
    }

    private static  void printArray(int[] e){
        for (int i : e) {
            System.out.print(i+"\t");
        }
        System.out.println("\n");
    }
}
