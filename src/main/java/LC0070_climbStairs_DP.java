import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0070_climbStairs_DP extends BaseMain {

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数
     */

    public static void main(String[] args) {

        List<Integer> inputIntList = new ArrayList<>();

        inputIntList.add(2);
        inputIntList.add(3);

        LC0070_climbStairs_DP lc = new LC0070_climbStairs_DP();

        tryYourAnswer(lc::climbStairs, inputIntList);
    }


    public int climbStairs(int n) {

        int[] arr = new int[n + 1];

        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
