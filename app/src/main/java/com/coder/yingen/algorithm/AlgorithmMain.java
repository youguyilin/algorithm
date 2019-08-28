package com.coder.yingen.algorithm;

/**
 * PackageName: com.coder.yingen.algorithm
 * ClassName: AlgorithmMain
 * Author: chuyingen
 * Date: 2019-05-30 17:40
 * Description:
 */
public class AlgorithmMain {
    public static void main(String args[]){
        int[] arr = {4,1,7,6,9,2,8,0,3,5};
        InsertSort.insertSort(arr,10);
        for (int a:arr){
            System.out.print(a+ " ");
        }
//        algorithm algorithm = new algorithm();
//        algorithm.QuickSortNotR(arr,0,arr.length -1);
//        for(int i = 0; i < arr.length;i++){
//            System.out.print(i + " ");
//        }
//        String originStr = "we are happy";
//        char[] str = new char[50];
//        char[] strCharArr = originStr.toCharArray();
//        for (int i= 0; i < strCharArr.length;i++){
//            str[i] = strCharArr[i];
//        }
//
//        System.out.println(com.coder.yingen.algorithm.algorithm.repalceBlankPlace(str,strCharArr.length));
    }
}
