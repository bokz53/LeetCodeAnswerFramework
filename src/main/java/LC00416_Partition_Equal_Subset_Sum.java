import base.BaseMain;
import utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00416_Partition_Equal_Subset_Sum extends BaseMain {

    /**
     * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，
     * 使得两个子集的元素和相等。
     *
     * 注意:
     *
     * 每个数组中的元素不会超过 100
     * 数组的大小不会超过 200
     * 示例 1:
     *
     * 输入: [1, 5, 11, 5]
     *
     * 输出: true
     *
     * 解释: 数组可以分割成 [1, 5, 5] 和 [11].
     *  
     *
     * 示例 2:
     *
     * 输入: [1, 2, 3, 5]
     *
     * 输出: false
     *
     * 解释: 数组不能分割成两个元素和相等的子集.
     *
     */

    public static void main(String[] args) {

        List<int[]> inputIntList = new ArrayList<>();

        inputIntList.add(new int[]{1, 5, 11, 5});
        inputIntList.add(new int[]{1, 2, 3, 5});
        inputIntList.add(new int[]{1, 2, 5});
        inputIntList.add(new int[]{2, 2, 3, 5});
        inputIntList.add(new int[]{1});
        inputIntList.add(new int[]{2});

        LC00416_Partition_Equal_Subset_Sum lc = new LC00416_Partition_Equal_Subset_Sum();

        tryYourAnswer(lc::canPartition, inputIntList, Arrays::toString, boo -> boo ? "可" : "不可");
    }


    // 递归dp，超时
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0 || nums.length == 1 || nums.length == 0) {
            return false;
        }

        int target = sum / 2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;

        if (nums[0] <= target) {
            dp[nums[0]] = true;
        }


        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                // 每次加一个数进来的时候判断一下是否满足条件
                if (dp[target]) {
                    return true;
                } else {
                    dp[j] = dp[j] || dp[j-nums[i]];
                }
            }
        }

        // 如果所有数都加进去了，那么就要看最后一个数加进去后有没有满足条件了
        return dp[dp.length-1];
    }

}


