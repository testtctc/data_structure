package com.tc.datastruct.array;
import java.util.Iterator;

public class ArrayDemo {
    final static int LIMIT=100;
    final static double factor =0.8;
    private int[] internalarrry;
    private int size=0;
    private int limit;
    public ArrayDemo(int limit){
        this.limit =limit;
        internalarrry= new int[limit];
    }

    public ArrayDemo(){
        this.limit= LIMIT;
        internalarrry= new int[limit];
    }

    //插入元素
    public boolean add(int element){
            resize_array();
        internalarrry[size++]=element;
            return true;
    }



    public boolean addall(int[] array){
        boolean s = true;
        for(int i = 0;i<array.length;i++){
            if ( ! add(array[i])){
                s= false;
                break;
            }
        }
        return s;
    }


    /**
     * 查找元素并返回元素的位置
     * @param element
     * @return
     */
    public int find(int element){
        for (int i =0;i<size;i++){
            if (internalarrry[i] ==element){
                return i;
            }
        }
        return -1;
    }

    public int get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < size){
            return internalarrry[index];
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    //删除元素
    public void delete(int element){
        int index = find(element);
        if (index == -1){
            System.out.println("元素不存在");
        }
        else{
            for(int i = index;i<size-1;i++){
                internalarrry[i]=internalarrry[i+1];
            }
        }
    }

    public void resize_array(){
        //容量直接翻倍
        if (limit * factor < size){
            limit = limit * 2;
            int[] arr= new int[limit];
            for (int i = 0 ; i<size;i++){
                arr[i]= internalarrry[i];
            }
            internalarrry =arr;
        }
    }

    /***
     * 修改数值
     * @param oldvalue
     * @param newvalue
     * @return
     */
    public boolean moidfy(int oldvalue,int newvalue){
        int index =find(oldvalue);
        if (index== -1){
            System.out.println("do not find value");
            return false;
        }
        else{
            internalarrry[index]=newvalue;
            return true;
        }
    }

    public int length(){
        return size;
    }

    public String dispaly(){
        StringBuilder builder = new  StringBuilder();
        builder.append("{");
        for (int i = 0;i<size;i++){
            builder.append(internalarrry[i]);
            if (i<size-1) builder.append(",");
        }
        builder.append("}");
        return builder.toString();
    }

    public Iterator<Integer> iterator(){
        return new Iterator<Integer>() {
            private int index=0;
            @Override
            public boolean hasNext() {
                return index< size;
            }

            @Override
            public Integer next() {
                return internalarrry[index++];
            }
        };

    }

}


