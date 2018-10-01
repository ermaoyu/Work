package com.test;

public class zuiduanluojing {
    /**
     * 给定一个数字,从左上角只能往右移和往下移,
     * 求它移到右下角的最短路径
     * */
    public static int walk(int[][] matrix,int i,int j){
        if(i == matrix.length - 1&&j == matrix[0].length - 1){
            return matrix[i][j];
        }
        if (i == matrix.length -1){
            return matrix[i][j] + walk(matrix,i,j+1);
        }
        if (j == matrix[0].length -1){
            return matrix[i][j] + walk(matrix,i+1,j);
        }
        int right = walk(matrix,i + 1,j);
        int down = walk(matrix,i,j + 1);
        return matrix[i][j] + Math.min(right,down);
    }

    public static void main(String[] args) {
        int[][] a = {{1,2,3,4},{1,3,4,5},{0,1,2,0},{3,1,7,8}};
        System.out.println(walk(a,0,0));
    }
}
