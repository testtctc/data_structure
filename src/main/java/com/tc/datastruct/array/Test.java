package com.tc.datastruct.array;

import com.tc.datastruct.array.ArrayDemo;

import java.util.Arrays;
import java.util.Iterator;

public class Test {
    public static void main(String[] args){
        int [] arr = {2,3,5};
        ArrayDemo c = new ArrayDemo(100);
        Arrays.stream(arr).forEach(c::add);
        System.out.println(c.dispaly());
        Iterator<Integer> i  = c.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }





    }

}
