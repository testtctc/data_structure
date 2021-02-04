package com.tc.al.recursive;
import com.tc.al.sort.SortDemo;

public class Dish {

    //盘子移动
    //最大的放最下面
    //复制数组
    public static void move(int[] arr,String from_,String to_,String temp_){
        if (arr.length <=0){
            return;
        }
        int head = arr[0];
        int[] left= new int[arr.length-1];
        System.arraycopy(arr,1,left,0,arr.length-1);
        move(left,from_,temp_,to_);
        System.out.println("move " + head + " from " + from_ + " to " + to_) ;
        move(left,temp_,to_,from_);
    }



}
