package com.tc.al.sort;

import java.util.Arrays;
import java.util.zip.CheckedOutputStream;

//排序算法
public class SortDemo {

    //冒泡排序:对比并交换元素
    //复杂度n^^2
    //每一轮都选择一个最大的元素放在最后面
    //特点：数组结尾有序
    public static void bubblesort(int[] array){
        for(int i = 0;i< array.length -1;i++){
            boolean flag=true;
            for(int j = 0;j< array.length - i - 1;j++){
                if (array[j] > array[j+1]){
                    swap(array,j,j+1);
                    flag=false;
                }
            }
            //排序完成
            if (flag) break;
        }
    }

    //选择排序


    /**
     *  选择排序
     *  特点：数组开头有序
     *
     *
     * @param array
     */
    public static  void  selectsort(int[] array){
        for(int i = 0 ;i< array.length-1;i++){
            int index=i;
            //找到最小值
            for(int j = i+1;j<array.length;j++){
                if (array[index] > array[j]){
                    index=j;
                }
            }

            if(index!= i){
                swap(array,i,index);
            }

        }
    }


    //插入排序

    /**
     *
     * 直接插入排序基本思想
     * 是每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止
     *
     * 特点：数组前面有序，依次插入到有序的队列中
     * @param array
     */
    public static void  insertsort(int[] array){
        for (int j = 1;j<array.length;j++){
            int temp= array[j];
            int i = j-1;

            //移动元素
            while (i >=0 && temp < array[i]){
                array[i+1]= array[i];
                i--;
            }
            array[i+1]=temp;
        }


    }

    //归并排序
    //合并两个有序列表
    public static void  mergesort(int[] array){
        sortmerge(array,0,array.length-1);
    }

    private static void sortmerge(int[] array,int start,int end){
        //及时终止
        if (start >= end){
            return;
        }
        int mid  = (start + end)/2;
        sortmerge(array,start,mid);
        sortmerge(array,mid+1,end);
        merge(array,start,mid,end);
    }


    public static void merge(int [] arr,int start,int mid,int high){

        //有且仅有一个元素时，不再排序
        if (start >= high){
            return;
        }
        //临时数组的开始索引
        int k=0;
        int i =start;
        int j = mid+1;
        int [] temp= new int[high -start +1];
        while (i <=mid && j <=high){
            if (arr[i]<arr[j]){
                temp[k++]= arr[i++];
            }
            else{
                temp[k++]=arr[j++];
            }
        }

        while (i<=mid && j>high){
            temp[k++]=arr[i++];
        }

        while (i>mid && j<=high){
            temp[k++]=arr[j++];
        }

        //拷贝数组
        for(int l =start;l<=high;l++){
            arr[l]=temp[l-start];
        }

    }

    //堆排序
    //类似于选择排序，每次选出最大的一个值，放在树的末尾
    //自上而下调整树
    //树的结构
    public static  void  heapsort(int[] array){
        for(int i =0;i<array.length-1;i++){
            int len=array.length-i;
            shiftUp(array,len);

            //永远最大的元素放在最后
            swap(array,0,len-1);

        }

    }

    //自下而上调整元素，选出最大的元素
    public static void shiftUp(int[] arr,int len){
        int start_index=len/2-1;
        for(int i = start_index;i>=0;i--){
            int left_index =i*2+1;
            int right_index = i*2+2;
            if (right_index >len-1){
                if (arr[i] < arr[left_index]){
                    swap(arr,i,left_index);
                }
            }
            else{
                int left= arr[left_index];
                int right= arr[right_index];
                int big_index;
                if (left > right){
                    big_index=left_index;
                }else{
                    big_index=right_index;
                }
                //互换
                if(arr[i] < arr[big_index]){
                    swap(arr,i,big_index);
                }
            }
        }
    }




    //交换两个元素的位置
    public static void swap(int [] arr , int i ,int j){
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j]=temp;
    }

    public static void dispaly(int []  arr){
        StringBuilder builder = new  StringBuilder();
        builder.append("{");
        for (int i = 0;i<arr.length;i++){
            builder.append(arr[i]);
            if (i< arr.length-1) builder.append(",");
        }

        builder.append("}");
        System.out.println(builder.toString());
    }



    //快速排序
    //https://www.cnblogs.com/ysocean/p/8032632.html
    //基本思路，找到一个中间点，左边的小于该点，右边的大于该点
    public static void quicksort(int[] arr){
         quicksort(arr,0,arr.length-1);

    }
    public static void quicksort(int[] arr,int left_index,int right_index){
        if (left_index >=right_index){
            return;
        }
        int mid = findmid(arr,left_index,right_index);
        quicksort(arr,left_index,mid-1);
        quicksort(arr,mid+1,right_index);
    }

    //找到一个中间点， 然后互换
    public static int findmid(int[] arr,int left_index,int right_index){
        int target=arr[left_index];
        int i=left_index;
        //当前点
        int j= right_index+1;
        while (i<j){
            while (arr[++i]<=target){}
            while (arr[--j]>target ){}
            if (i<j){
                swap(arr,i,j);
            }

        }
        swap(arr,left_index,j);
        return j;
    }




    // 基数排序
    // https://www.cnblogs.com/luomeng/p/10639926.html
    // 根据位置进行排序，同样适用于字符串
    public static void radixSort(int[] arr){
        int maxvalue= findMax(arr);
        int digit= findDigit(maxvalue);
        for(int d =1,base=1;d<=digit;d++,base=base*10){
            //辅助数组
            int[] tmp =  new int[arr.length];
            int[] count=new int[10];
            //统计计算
            for (int i =0;i<arr.length;i++) {
                count[findBucketIndex(arr[i], base)]++;
            }
            //累计基数
            for(int j =1;j<count.length;j++){
                count[j]=count[j]+count[j-1];
            }

            //放置元素
            for (int i=arr.length-1;i>=0;i--) {
                int v= arr[i];
                tmp[--count[findBucketIndex(v,base)]]=v;
            }

            //拷贝元素
            System.arraycopy(tmp,0,arr,0,arr.length);
        }
    }

    //获取数组最大值
    public static int findMax(int[] arr){
        int tmp= arr[0];
        for(int i=1;i<=arr.length-1;i++){
            if (arr[i] > tmp) tmp=arr[i];
        }
        return tmp;
    }

    //获取某个数的位数
    public static int findDigit(int value){
        int base=10;
        int digit=1;
        while ( value / base >0 ){
            digit++;
            base=base*10;
        }
        return digit;
    }


    //获取目标桶的位置
    public static int findBucketIndex(int value,int base){
        return value / base % 10;
    }


}
