import base.BaseMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0063_Unique_Paths_II_DP extends BaseMain {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。
     * 机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
     *
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     *
     * 示例 1:
     *
     * 输入:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * 输出: 2
     * 解释:
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     *
     */

    public static void main(String[] args) {

        List<int[][]> inputStrList = new ArrayList<>();

//        inputStrList.add(new int[][]{
//                {0}
//        });
//        inputStrList.add(new int[][]{
//                {1}
//        });
//        inputStrList.add(new int[][]{
//                {0,0,1,0,0,0}
//        });
//        inputStrList.add(new int[][]{
//                {0},
//                {0},
//                {1},
//                {0},
//                {0}
//        });
        inputStrList.add(new int[][]{
                {0,0}
        });
        inputStrList.add(new int[][]{
                {1,0}
        });
        inputStrList.add(new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        });

        LC0063_Unique_Paths_II_DP lc = new LC0063_Unique_Paths_II_DP();

        tryYourAnswer(lc::uniquePathsWithObstacles, inputStrList);
    }


    // 使用数组存储
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int[] array = new int[m];

        array[0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= m-1; j++) {
                    if (obstacleGrid[i][j] == 1) {
                        array[j] = 0;
                    } else if (j-1 >= 0){
                        array[j] = array[j] + array[j-1];
                    }
            }
        }

        return array[m-1];
    }
}
