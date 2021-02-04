package com.tc.al.sort;

//测试
public class Test {
    public static void main(String[]args){
        int[]  arr={3,4,1};
        SortDemo.bubblesort(arr);
        SortDemo.dispaly(arr);
        int[] arr2={3,4,1};
        SortDemo.selectsort(arr2);
        SortDemo.dispaly(arr2);

        int[] arr3={3,4,1,5};
        SortDemo.insertsort(arr3);
        SortDemo.dispaly(arr3);

        System.out.println("=================mergesort====================");
        int[] arr4={3,4,1,7,2};
        SortDemo.mergesort(arr4);
        SortDemo.dispaly(arr4);
        System.out.println("=================heapsort====================");
        int[] arr5={3,4,1,7,2,5};
        SortDemo.heapsort(arr5);
        SortDemo.dispaly(arr5);
        System.out.println("=================quicksort====================");
        int[] arr6={3,4,1,7,2,5,9};
        SortDemo.quicksort(arr6);
        SortDemo.dispaly(arr6);
        System.out.println("=================radixSort====================");
        int[] arr7={3,40,1,7,2,5,9,11,20,100,1000,1005};
        SortDemo.radixSort(arr7);
        SortDemo.dispaly(arr7);

    }


}
