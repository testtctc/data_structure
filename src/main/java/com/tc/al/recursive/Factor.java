package com.tc.al.recursive;

public class Factor {

    public static int factor(int k){
        if (k<1) {
            return 1;
        }
        else{
            return k * factor(k-1) ;
        }
    }


}
