package zuoshengsuanfa.jichuban.排序;

/**
 *      毛毛雨     2018/10/17
 * */
public class Code_06_有序矩阵查找 {

    public static  boolean find(int target,int[][] array){
        int row = array.length;
        int column = 0;
        //二维矩阵,行列依次递增
        //从左下开始比较
        //数组的数比target大,列+1,小行+1
        while(row >= 0 && column < array[0].length){
            if (array[row][column] == target){
                return true;
            } else if (array[row][column] > target){
                row--;
            }else {
                column++;
            }
        }
        return false;
    }

}
