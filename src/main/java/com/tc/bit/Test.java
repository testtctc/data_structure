package com.tc.bit;

public class Test {
    private static int bitNum=32;
    public static void main(String[] args) {
        int number = 4;
        //原始数二进制
        printInfo(number);
        number = number << 1;
        //左移一位
        printInfo(number);
        number = number >> 1;
        //右移一位
        printInfo(number);

        int  num2=-10;
        printInfo(num2);
        printInfo(num2 >>>1 );
        printInfo(~2 );
        printInfo(Integer.MIN_VALUE);
        printInfo(Integer.MAX_VALUE);
        printInfo(Integer.MIN_VALUE+1);



    }

    /**
     * 输出一个int的二进制数
     * @param num
     */
    private static void  printInfo(int num){
        String binaryStr = Integer.toBinaryString(num);
        while(binaryStr.length() < bitNum){
            binaryStr = "0"+binaryStr;
        }
        System.out.println(binaryStr);
    }



}
