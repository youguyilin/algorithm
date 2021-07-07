package com.coder.yingen.algorithm.array;

import javax.crypto.Mac;

/**
 * Created by Alex Chu on 2021/7/7.
 */
public class RotateArray {

    public void rotateArr(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++)
            for (int j = i; j < n - 1 - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
    }
}
