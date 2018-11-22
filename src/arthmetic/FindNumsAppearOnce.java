package arthmetic;

import java.util.Arrays;

public class FindNumsAppearOnce {
    /**
     *一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
     * 请写程序找出这两个只出现一次的数字。
     * */
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null && array.length == 0 ){
          return;
        }
        int num = 0;
        for (int i = 0; i < array.length ; i++) {
            num = (num ^ array[i]);//异或的结果是出现一次的两个数
        }
        int count = 0;//记录标志位
        for (; count < array.length; count++) {
            if ((num & (1<<count))!=0){//第一个为1的位置
                break;
            }
        }
        num1[0] = 0;
        num2[0] = 0;
        for (int i = 0;i < array.length;i++){
            if ((array[i]&(1<<count))!=0){//标志位为1的一组
                num1[0] ^=array[i];
            }else {//标志位为0的一组
                num2[0] ^=array[i];
            }
        }
    }
}
