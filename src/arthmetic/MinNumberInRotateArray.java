package arthmetic;

public class MinNumberInRotateArray {
    /**
     * 输入一个非减排序的数组的一个旋转，
     * 输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，
     * 该数组的最小值为1。
     * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     * */
    public int minNumberInRotateArray(int [] array) {
            if (array == null || array.length == 0){
                return 0;
            }
            if (array.length == 1){
                return array[0];
            }
            int low = 0;
            int high = array.length-1;
            int mid = 0;
            while(array[low] > array[high]){
                if (high - low == 1){
                    mid = high;
                    break;
                }
                mid = (low + high)/2;
                if (array[mid] == array[low] && array[mid] == array[high] && array[low] == array[high]){
                    return minNUmberIndex(array,low,high);
                }
                if (array[mid] >= array[low]){
                    low = mid;
                }
                if(array[mid] <= array[high]){
                     high = mid;
                }
                }
            return array[mid];
    }
    public int minNUmberIndex(int[] array,int low,int high){
        int rs = array[low];
        for (int i = low + 1; i <= high ; i++) {
            if (rs > array[i]) {
                rs =  array[i];
            }
        }
        return rs;
    }
}
