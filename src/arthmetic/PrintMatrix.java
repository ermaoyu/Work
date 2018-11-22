package arthmetic;

import java.util.ArrayList;

public class PrintMatrix {
    /**
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
     * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
     * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length -1;//行
        int dC = matrix[0].length-1;//列
        ArrayList<Integer> list = new ArrayList<>();
        while(tR <= dR && tC <= dC){
            getArray(matrix, tR++, tC++, dR--, dC--,list);
        }
        return list;
    }
    public void getArray(int [][] a,int tR,int tC,int dR,int dC,ArrayList<Integer> list){
       if (tR == dR){//如果只有一行
           for (int i = tC;i <= dC;i++){
               list.add(a[tR][i]);
           }
       }else if (tC == dC){//只有一列
           for (int i = tR; i <= dR; i++) {
               list.add(a[i][tC]);
           }
       }else {
           int curC = tC;
           int curR = tR;
           while(curC != dC){
               list.add(a[tR][curC++]);
           }
           while(curR != dR){
               list.add(a[curR++][dC]);
           }
           while(curC != tC){
               list.add(a[dR][curC--]);
           }
           while(curR != tR){
               list.add(a[curR--][tC]);
           }
       }
    }
}
