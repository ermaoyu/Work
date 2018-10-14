package arthmetic;

public class HasPath {
    /**
     * 路径可以从矩阵中的任意一个格子开始，
     * 每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
     * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
     * 例如 a b c e s f c s a d e e
     * 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径
     * */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        int[] flag = new int[matrix.length];
        for (int i = 0;i < rows;i++){
            for (int j = 0; j < cols ; j++) {
                if (ishasPath(matrix,rows,cols,i,j,str,0,flag))return true;
            }
        }
        return false;
    }

    public boolean ishasPath(char[] matrix, int rows, int cols,int i,int j ,char[] str,int k,int[] flag){
        int index = i * cols + j;//一维数组对应二维数组的下标
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)return false;
        if (k == str.length -1)return true;
        flag[index] = 1;
        if (ishasPath(matrix,rows,cols,i -1,j,str,k + 1,flag)
                ||ishasPath(matrix,rows,cols,i +1,j,str,k + 1,flag)
                ||ishasPath(matrix,rows,cols,i ,j - 1,str,k + 1,flag)
                ||ishasPath(matrix,rows,cols,i,j + 1,str,k + 1,flag)){
            return  true;
        }
        flag[index] = 0;
        return  false;
    }
}
