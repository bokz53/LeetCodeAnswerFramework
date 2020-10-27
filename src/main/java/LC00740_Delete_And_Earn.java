import base.BaseMain;
import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00740_Delete_And_Earn extends BaseMain {

    /**
     * 给定一个整数数组 nums ，你可以对它进行一些操作。
     *
     * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。
     * 之后，你必须删除  每个  等于 nums[i] - 1 或 nums[i] + 1 的元素。
     *
     * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [3, 4, 2]
     * 输出: 6
     * 解释:
     * 删除 4 来获得 4 个点数，因此 3 也被删除。
     * 之后，删除 2 来获得 2 个点数。总共获得 6 个点数。
     * 示例 2:
     *
     * 输入: nums = [2, 2, 3, 3, 3, 4]
     * 输出: 9
     * 解释:
     * 删除 3 来获得 3 个点数，接着要删除两个 2 和 4 。
     * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
     * 总共获得 9 个点数。
     * 注意:
     *
     * nums的长度最大为20000。
     * 每个整数nums[i]的大小都在[1, 10000]范围内。
     *
     */

    public static void main(String[] args) {

        List<int[]> inputIntList = new ArrayList<>();


//        inputIntList.add(new int[]{});
//        inputIntList.add(new int[]{1});
        inputIntList.add(new int[]{3,4,2});
        inputIntList.add(new int[]{2, 2, 3, 3, 3, 4});

        LC00740_Delete_And_Earn lc = new LC00740_Delete_And_Earn();

        tryYourAnswer(lc::deleteAndEarn, inputIntList, Arrays::toString, String::valueOf);
    }



    // n+2000 分桶排序
    public int deleteAndEarn(int[] nums) {

        int[] memo = new int[10001];

        // 分桶
        for (int num : nums) {
            memo[num]++;
        }

        int last = 0;
        int pre = 0;

        for (int n = 1; n < memo.length; n++) {
            if (memo[n] == 0) {
                continue;
            }
            int sum = 0;
            sum = Math.max(pre, n*memo[n] + last);

            last = pre;
            pre = sum;
        }

        return pre;
    }
}
