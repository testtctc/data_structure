package com.tc.al.dynamic;


public class Test {

    public static void main(String[] args){
        int[] weights={4,3,1};
        int[] values={3000,2000,1500};
        Bag bag= new Bag(values,weights,4);
        dispaly(bag.max_values());
        System.out.println("==========更换顺序==========");
        //更换物品顺序顺序
        int[] weights_1={3,4,1};
        int[] values_1={2000,3000,1500};
        Bag bag_1= new Bag(values_1,weights_1,4);
        dispaly(bag_1.max_values());
    }

    //展现数组
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

}
