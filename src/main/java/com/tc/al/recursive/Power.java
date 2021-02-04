package com.tc.al.recursive;

public class Power {
    public static int power(int a,int b){
        if (a==0 || a==1){
            return a;
        }

        if (b>1){
            int x= a*a;
            int y = b/2;
            if(y % 2 ==1){
                return power(x,y) * a;
            }
            else {
                return power(x,y);
            }
        }
        else if(b==1){
            return a;
        }
        else{
            //b==0
            return 1;
        }
    }


}
