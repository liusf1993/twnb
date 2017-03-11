package com.lsf.twnb.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by liusifan on 2017/3/2.
 */
public class MergeSort implements Sort {
    @Override
    public void sort(Comparable[] array) {

    }


    /*private E[] mergeSort(E[] array, int start, int length) {
        if(length==1){
            return array;
        }
        E[] first= Arrays.copyOfRange(array,start,(start+length)/2);
        E[] second= Arrays.copyOfRange(array,(start+length)/2,length);
        first=mergeSort(first,0,first.length);
        second=mergeSort(second,0,second.length);
        int i=0;int j=0; int k=0;
        while (j!=first.length&&k!=second.length){
            if(first[j].compareTo(second[k])<0){
                array[i]=first[j];
                j++;
            }else{
                array[i]=second[k];
                k++;
            }
            i++;
        }
        while(j<first.length){

            array[i++]=first[j++];
        }
        while(k<second.length){
            array[i++]=second[k++];
        }
        return array;
    }

    public static void main(String[] args) {
        Integer[] array=new Integer[100];
        for (int i = 0; i < 100; i++) {
            array[i]= new Random().nextInt(100);
        }
        new MergeSort<Integer>().sort(array);
    }*/


}
