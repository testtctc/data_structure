package com.tc.datastruct.queue;


//FIFO
public class Myqueue<T> {
    T [] internalarray;

    int maxsize;
    //指针
    int front=0;
    //尾部元素指针
    int rear=-1;
    //元素个数
    int size=0;
    public  Myqueue(int maxsize){
        this.maxsize =maxsize;
        internalarray =  (T[]) new Object [maxsize];
    }

    //添加
    public void push(T element){
        if (isFull()){
            System.out.println("can't add more elements for it exced the limit");
        }
        if (rear==maxsize-1){
            rear=0;
            internalarray[rear]=element;
        }
        else{
            internalarray[++rear]=element;

        }
        size ++;
    }

    //删除
    public T pop(){
        if (isEmpty()){
            System.out.println("there is no element");
            return null;
        }
        else{
            T v = internalarray[front];
            internalarray[front]=null;
            front++;
            //重置游标
            if (front==maxsize){
                front =0;
            }
            return v;
        }


    }

    public  boolean isFull(){
        return  (size == maxsize);

    }
    public  boolean isEmpty(){
        return  (size==0);

    }


    public int length(){
        return size;
    }


    public void display(){
        if (isEmpty()){
            System.out.println("{}");
            return;
        }

        StringBuilder builder = new  StringBuilder();
        builder.append("{");
        for (int i = 0;i<size;i++){
            int index = i + front;
            if (index >= maxsize){
                index= index - maxsize;
            }
            builder.append(internalarray[index]);
            if (i<size-1) builder.append(",");
        }
        builder.append("}");
        System.out.println(builder.toString());



    }

}
