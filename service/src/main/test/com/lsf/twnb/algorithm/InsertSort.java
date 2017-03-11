package com.lsf.twnb.algorithm;

/**
 * Created by liusifan on 2017/3/2.
 */
public class InsertSort<E extends Comparable<?super E>> implements Sort {
    /*private static InsertSort<> insertSort;
    private  InsertSort(){

    }
    public static InsertSort<Comparable> getInstance(){
        if(insertSort==null){
            insertSort=new InsertSort<>();
        }
        return insertSort;

    }*/
    @Override
    public void sort(Comparable[] array) {
        for (int i = 1; i < array.length; i++) {
            int j=i;
            while (j>0&&array[j].compareTo(array[j-1])<0){
                Comparable temp=array[j-1];
                array[j-1]=array[j];
                array[j]=temp;
                j--;
            }

        }
    }
}
