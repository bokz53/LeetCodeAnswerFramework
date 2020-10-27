import base.BaseMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00198_House_Robber_DP extends BaseMain {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
     * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，
     * 计算你 不触动警报装置 的情况下 ，一夜之内能够偷窃到的最高金额。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     *
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     *
     *
     *
     * 解决思路在于，不要去想着帮忙判断是否要偷这一间房子（或者偷了会不会报警），让代码去做。
     * 我们要做的，是想清楚如果偷了这间房子，那么上一间是肯定没偷，所以当前的总金额是 nums[i] + dp[i-2]
     * 如果不偷这间房子，那么总金额和之前没变化则为 dp[i-1]。
     * 如果上一间房子也没偷呢？那就等于变成了dp[i-2]而已，并没有什么变化。
     */


    public static void main(String[] args) {

        List<int[]> inputIntList = new ArrayList<>();

        inputIntList.add(new int[]{1,2,3,1});
        inputIntList.add(new int[]{2,7,9,3,1});
        inputIntList.add(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4});
        inputIntList.add(new int[]{2, 3, 4, 5, 1, 2, 3, 4, 5});

        LC00198_House_Robber_DP lc = new LC00198_House_Robber_DP();

        tryYourAnswer(lc::rob2, inputIntList, Arrays::toString, String::valueOf);
    }

    // dp数组法你会发现，其实状态方程只和n, n-1, n-2有关系。所以只需要3个变量就够了。
    public int rob(int[] nums) {

        // n-1
        int pre = 0;
        // n-2
        int last = 0;

        int tempSum = 0;

        for (int num : nums) {
            tempSum = Math.max(last + num, pre);
            last = pre;
            pre = tempSum;
        }
        return pre;
    }


    // dp数组法
    public int rob2(int[] nums) {

        int[] dp = new int[nums.length];


        for (int n = 0; n < nums.length; n++) {
            if (n == 0) {
                dp[n] = Math.max(0 + nums[n], 0);
            } else if (n == 1) {
                dp[n] = Math.max(0 + nums[n], dp[0]);
            } else {
                dp[n] = Math.max(dp[n-2] + nums[n], dp[n-1]);
            }
        }
        return dp[dp.length-1];
    }

}
