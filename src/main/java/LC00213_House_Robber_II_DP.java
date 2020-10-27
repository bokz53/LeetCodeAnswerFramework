import base.BaseMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00213_House_Robber_II_DP extends BaseMain {

    /**
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     *
     * 这个地方所有的房屋都围成一圈，这意味着第一个房屋和最后一个房屋是紧挨着的。
     *
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
     * 系统会自动报警。
     *
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
     *
     * 示例 1:
     *
     * 输入: [2,3,2]
     * 输出: 3
     * 解释: 你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
     *
     *
     * 示例 2:
     *
     * 输入: [1,2,3,1]
     * 输出: 4
     * 解释: 你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     *
     *
     * 解决思路在于，分解子问题。
     * 首尾房子相连，无非就是3种可能。
     * 1 偷首 ， 2 偷尾  ，
     * 3 首尾都不偷（不用考虑，因为不存在副收益，情况1和2的可选范围比3大，所以肯定收益大）
     *
     * 那么就可以分解成两个 打家劫舍I 来解决了。
     *
     * 要注意的是，使用dp数组的方法，每格里记录的是“从0个房子抢到第i个房子的 最大 收益”
     * 所以，dp[1] = Math.max(nums[1], nums[0])
     */


    public static void main(String[] args) {

        List<int[]> inputIntList = new ArrayList<>();

        inputIntList.add(new int[]{});
        inputIntList.add(new int[]{0});
        inputIntList.add(new int[]{0, 1});
        inputIntList.add(new int[]{2, 1});
        inputIntList.add(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5});
        inputIntList.add(new int[]{1, 1, 3, 6, 7, 10, 7, 1, 8, 5, 9, 1, 4, 4, 3});
        inputIntList.add(new int[]{2, 3, 2});
        inputIntList.add(new int[]{1, 2, 3, 1});

        LC00213_House_Robber_II_DP lc = new LC00213_House_Robber_II_DP();

        tryYourAnswer(lc::rob, inputIntList, Arrays::toString, String::valueOf);
    }


    //
    public int rob(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp0 = new int[nums.length-1];
        int[] dp1 = new int[nums.length-1];

        // 偷了第一间
        dp0[0] = nums[0];
        dp0[1] = Math.max(nums[0], nums[1]);
        for (int n = 2; n < nums.length - 1; n++) {
            dp0[n] = Math.max(dp0[n - 2] + nums[n], dp0[n - 1]);
        }

        // 没偷第一间
        dp1[0] = nums[1];
        dp1[1] = Math.max(nums[2], nums[1]);
        for (int n = 2; n < nums.length-1; n++) {
            dp1[n] = Math.max(dp1[n - 2] + nums[n+1], dp1[n - 1]);
        }
        return Math.max(dp0[dp0.length-1], dp1[dp1.length-1]);
    }

}
