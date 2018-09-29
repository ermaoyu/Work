package arthmetic;

import java.util.ArrayList;

public class PrintMatrix {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int tL = 0;
        int tH = 0;
        int dL = matrix.length -1;
        int dH = matrix[0].length-1;
        ArrayList<Integer> list = new ArrayList<>();
        while(tL <= dL && tH <= dH){
            list = getArray(matrix, tL, tH, dL, dH);
        }
        return list;
    }
    public ArrayList<Integer> getArray(int [][] a,int tL,int tH,int dL,int dH){
        ArrayList<Integer> list = new ArrayList<>();
        if(dL == tL){
            for (int i = tH;i<= dH;i++){
                list.add(a[tL][i]);
            }
        } else if(dH == tH){
            for (int i = tL;i<= dL;i++){
                list.add(a[i][tH]);
            }
        }else {
            int currH = tH;
            int currL = tL;
            while(currL != dL){
                list.add(a[currL][tH]);
                currL ++;
            }
            while(currH != dH){
                list.add(a[dL][currH]);
                currH ++;
            } while(currL != tL){
                list.add(a[currL][dH]);
                currL --;
            } while(currH != tH){
                list.add(a[tL][currH]);
                currL --;
            }
        }
        return  list;
    }
}