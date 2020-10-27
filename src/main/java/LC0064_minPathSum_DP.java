import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0064_minPathSum_DP extends BaseMain {

    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     *   [1,3,1],
     * [1,5,1],
     * [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     */

    public static void main(String[] args) {

        List<int[][]> inputStrList = new ArrayList<>();

        inputStrList.add(new int[][]{
                {1, 4, 8, 6, 2, 2, 1, 7},
                {4, 7, 3, 1, 4, 5, 5, 1},
                {8, 8, 2, 1, 1, 8, 0, 1},
                {8, 9, 2, 9, 8, 0, 8, 9},
                {5, 7, 5, 7, 1, 8, 5, 5},
                {7, 0, 9, 4, 5, 6, 5, 6},
                {4, 9, 9, 7, 9, 1, 9, 0}
        });
        inputStrList.add(new int[][]{
                {1, 4},
                {4, 7}
        });
        inputStrList.add(new int[][]{
                {1, 0}
        });
        inputStrList.add(new int[][]{
                {1, 1, 8},
                {1, 1, 1},
                {4, 2, 1}
        });

        LC0064_minPathSum_DP lc = new LC0064_minPathSum_DP();

        tryYourAnswer(lc::minPathSum, inputStrList);
    }


    // 使用数组存储
    public int minPathSum(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[] array = new int[m];
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m - 1; j++) {
                if (i == 0 && j == 0) {
                    array[j] = grid[i][j];
                } else if (i == 0) {
                    array[j] = array[j - 1] + grid[i][j];
                } else if (j == 0) {
                    array[j] = array[j] + grid[i][j];
                } else {
                    array[j] = grid[i][j] + Math.min(array[j], array[j-1]);
                }
            }
        }
        return array[m - 1];
    }

}
