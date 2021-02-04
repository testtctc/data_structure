package com.tc.al.dynamic;

import java.util.Arrays;

//最长公共子字符串
public class SubString {
    char[] seq1;
    char[] seq2;
    int num1;
    int num2;
    int[][] matrix;

    public SubString(char[] seq1,char[] seq2){
        this.seq1=seq1;
        this.seq2=seq2;
        this.num1= seq1.length;
        this.num2= seq2.length;
        matrix= new int[num1+1][num2+1];
        //初始化
        for(int j=0;j<num2+1;j++) matrix[0][j]=0;
        for(int i=0;i<num1+1;i++) matrix[i][0]=0;

    }



    public int max_values(){
        for(int i =1;i<num1+1;i++){
            for(int j =1;j<num1+1;j++){
                matrix[i][j]=local_max(i,j);
            }
        }

        //直接返回最大值
        int max_value=matrix[num1][0];
        for(int v:matrix[num1]){
            if (v>max_value) max_value=v;
        }
        return max_value;
    }

    public int local_max(int row, int column){

        if (seq1[row-1]==seq2[column-1]){
                return 1+ matrix[row-1][column-1];
        }
        else{
            return Math.max(matrix[row-1][column],matrix[row][column-1]);
        }
    }


    public static void main(String[] args ){

        char[] seq1 = "abcedl".toCharArray();
        char[] seq2 = "abdefl".toCharArray();
        SubString s= new SubString(seq1,seq2);
        System.out.println(s.max_values());
    }


}
