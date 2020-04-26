package interview;

import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC_IW004_tw_dimensional_arrays extends BaseMain {

    /**
     *
     */

    public static void main(String[] args) {

        int[][] array1 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 20}
        };
        int target1 = 11;


        int[][] array2 = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        int target2 = 5;


        int[][] array3 = {
                {1}
        };
        int target3 = 1;

        int[][] array4 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int target4 = 19;

        int[] aa3 = {1, 5, 9, 17, 20};


        LC_IW004_tw_dimensional_arrays lc = new LC_IW004_tw_dimensional_arrays();

        //        System.out.println(lc.findNumberIn2DArray(array1, target1));
        System.out.println(lc.findNumberIn2DArray(array2, target2));
        System.out.println(lc.findNumberIn2DArray(array3, target3));
        System.out.println(lc.findNumberIn2DArray(array4, target4));
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (0 >= matrix.length || 0 >= matrix[0].length) {
            return false;
        }

        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int xPointer = 0;
        int yPointer = colLength - 1;


        while (xPointer < rowLength && matrix[xPointer][yPointer] < target) {
            xPointer++;
        }

        if (xPointer >= rowLength) {
            xPointer = rowLength - 1;
        }

        while (xPointer < rowLength) {
            while (yPointer >= 0) {
                if (matrix[xPointer][yPointer] == target) {
                    return true;
                }
                yPointer--;
            }
            yPointer = colLength - 1;
            xPointer++;
        }
        return false;

    }


    public boolean answer(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (target < matrix[i][j]) {
                i--;
            } else if (target > matrix[i][j]) {
                j++;
            } else if (target == matrix[i][j]) {
                return true;
            }
        }
        return false;
    }


}
