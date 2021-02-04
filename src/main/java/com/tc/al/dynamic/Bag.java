package com.tc.al.dynamic;


import java.util.Map;

/**
 * 背包问题
 */
public class Bag {
    //价值
    private int[] values;
    //重量
    private int[] weights;
    //容量
    private int volume;
    //物品数量
    private int num;
    //价值矩阵
    int[][] matrix;

    public Bag(int[] values,int[] weights,int volume){
        this.values=values;
        this.weights=weights;
        this.volume=volume;
        this.num=this.values.length;
        int[][] matrix= new int[num+1][volume+1];
        //初始化第一行--没有物品
        for(int i = 0 ; i<volume+1;i++){
            matrix[0][i]=0;
        }
        //初始哈第一列--容量为0
        for(int j = 0 ; j<num+1;j++){
            matrix[j][0]=0;
        }

        this.matrix=matrix;

    }

    //返回每个包的最大价值
    public int[] max_values(){
        for (int i =1;i<num+1;i++){
            for(int j =1;j<volume+1;j++){
                int current_weight=this.weights[i-1];
                int current_value=this.values[i-1];
                matrix[i][j]=local_max(i,j,current_weight,current_value);
            }
        }
        return matrix[num];

    }

    //局部最大价值
    //column->当前背包容量
    //row截止到目前为止已经尝试装入的物品
    //weight 当前物品重量
    //value 当前物品价值
    public int local_max(int row,int column,int weight,int value){
        if (column< weight){
            return matrix[row-1][column];
        }
        else{
            //对于每一次决策而言，只有装或者不装
            //不能重复装入
            return Math.max(matrix[row-1][column],value + matrix[row-1][column-weight]);


        }
    }
}
