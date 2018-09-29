package com.test;

public class ShellSort {
    public static void shellSort(int [] data){
        int h = 1;
        while(h<=data.length/3){
            h = h*3+1;//增量
        }
        while(h>0){
            for(int i =h;i<data.length;i+=h){
                if(data[i]<data[i-h]){
                    int tmp = data[i];
                    int j = i-h;

                while(j>=0&&data[j]>tmp){
                    data[j+h] = data[j];
                    j-=h;
                }
                data[j+h] = tmp;
             }
            }
            h=(h-1)/3;
        }
    }

    public static void main(String[] args) {
        int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
        shellSort(a);
        for (int i = 0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

    }

}
