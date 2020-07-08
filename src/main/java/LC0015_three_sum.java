import base.BaseMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0015_three_sum extends BaseMain {

    /**
     *
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     */

    public static void main(String[] args) {

        List<int[]> inputIntList = new ArrayList<>();

        inputIntList.add(new int[]{1});
        inputIntList.add(new int[]{1,2});
        inputIntList.add(new int[]{-1, 0, 1, 2, -1, -4});
        inputIntList.add(new int[]{-1, -1, -4, 0, 1, 2});

        LC0015_three_sum lc = new LC0015_three_sum();

        tryYourAnswer(lc::threeSum, inputIntList);
    }


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int pointer = 1;

        while (pointer < nums.length - 1) {
            int left = pointer - 1;
            int right = pointer + 1;
            if (nums[pointer] + nums[left] + nums[right] == 0) {
                result.add(Arrays.asList(nums[left], nums[pointer], nums[right]));
            }

            if (nums[pointer] < 0) {

            }

            pointer++;
        }


        return result;
    }
}
