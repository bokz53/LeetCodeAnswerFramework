import base.BaseMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00462_minMoves2 extends BaseMain {

    /**
     *给定一个非空整数数组，找到使所有数组元素相等所需的最小移动数，其中每次移动可将选定的一个元素加1或减1。 您可以假设数组的长度最多为10000。
     *
     * 例如:
     *
     * 输入:
     * [1,2,3]
     *
     * 输出:
     * 2
     *
     */

    public static void main(String[] args) {

        List<int[]> inputIntList = new ArrayList<>();

        inputIntList.add(new int[]{1,2,3});
        inputIntList.add(new int[]{1,0,0,8,6});

        LC00462_minMoves2 lc = new LC00462_minMoves2();

        tryYourAnswer(lc::minMoves2, inputIntList, Arrays::toString, String::valueOf);
    }


    public int minMoves2(int[] nums) {

        int mid = Arrays.stream(nums).sorted().skip(nums.length / 2).findFirst().orElse(0);

        int result = 0;
        for (int num : nums) {
            result += Math.abs(mid - num);
        }
        return result;
    }


    /**
     *
     * 都在说找中位数，又没给证明，这也叫题解?
     * 这题不用想什么中位数：设 a <= x <= b，将 a 和 b 都变化成 x 为最终目的，
     * 则需要步数为 x-a+b-x = b-a，即两个数最后相等的话步数一定是他们的差，x 在 a 和 b 间任意取；
     * 所以最后剩的其实就是中位数；
     * 那么直接排序后首尾指针计算就好：
     *
     */
    public int answer(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int result = 0;

        while (i < j) {
            result += (nums[j]-nums[i]);
            i++;
            j--;
        }
        return result;
    }
}
