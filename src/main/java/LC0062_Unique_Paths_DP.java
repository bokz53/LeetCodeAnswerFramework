import base.BaseMain;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0062_Unique_Paths_DP extends BaseMain {

    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。
     * 机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * 问总共有多少条不同的路径？
     *
     *
     * 示例 1:
     * <p>
     * 输入: m = 3, n = 2
     * 输出: 3
     * 解释:
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向右 -> 向下
     * 2. 向右 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向右
     *
     *
     * 示例 2:
     * <p>
     * 输入: m = 7, n = 3
     * 输出: 28
     * <p>
     *
     */

    public static void main(String[] args) {

        List<Pair<Integer, Integer>> inputStrList = new ArrayList<>();

        inputStrList.add(new Pair<>(1, 1));
        inputStrList.add(new Pair<>(3, 2));
        inputStrList.add(new Pair<>(7, 3));
        inputStrList.add(new Pair<>(51, 9));

        LC0062_Unique_Paths_DP lc = new LC0062_Unique_Paths_DP();

        tryYourAnswer(lc::uniquePaths2, inputStrList);
    }


    // 递归解法 会超时
    public int uniquePaths(int m, int n) {

        if (n <= 1 || m <= 1) {
            return 1;
        }

        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }

    // 使用数组存储
    public int uniquePaths2(int m, int n) {

        if (n <= 1 || m <= 1) {
            return 1;
        }

        int[] array = new int[m];
        Arrays.fill(array, 1);

        for (int j = 1; j <= n - 1; j++) {
            for (int i = 0; i <= array.length-1; i++) {
                if (j <= 0 || i <= 0) {
                    array[i] = 1;
                } else {
                    array[i] = array[i - 1] + array[i];
                }
            }
        }

        return array[array.length - 1];
    }
}
