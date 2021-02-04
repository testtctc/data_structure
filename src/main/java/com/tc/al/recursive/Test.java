package com.tc.al.recursive;

import com.tc.al.sort.SortDemo;

public class Test {
    public static void main(String[]args){
        System.out.println(Factor.factor(5));

        int[] arr = {4,5,6};

        SortDemo.mergesort(arr);
        int[] arr_temp= new int[arr.length];
        for(int j = arr.length-1;j>=0;j--){
            arr_temp[arr.length-1-j]=arr[j];
        }

        arr=arr_temp;

        Dish.move(arr,"a","b","c");

        System.out.println(arr);

        System.out.println(Power.power(2,3));






    }

}
