import base.BaseMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC000493_Reverse_Pairs extends BaseMain {

    /**
     * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 
     * 我们就将 (i, j) 称作一个重要翻转对。
     *
     * 你需要返回给定数组中的重要翻转对的数量。
     */

    public static void main(String[] args) {

        List<int[]> inputIntList = new ArrayList<>();

//        inputIntList.add(new int[]{});
//        inputIntList.add(new int[]{0});
        inputIntList.add(new int[]{-5,-5});
        inputIntList.add(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647});
        inputIntList.add(new int[]{1,3,2,3,1});
        inputIntList.add(new int[]{2,4,3,5,1});

        LC000493_Reverse_Pairs lc = new LC000493_Reverse_Pairs();

        tryYourAnswer(lc::reversePairs, inputIntList, Arrays::toString, Object::toString);
    }


    public int reversePairs(int[] nums) {

        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int count = 0;
        int left = 0;
        int right = nums.length - 1;

        for (; left < nums.length - 1; left++) {
            for (right = nums.length - 1; right > left; right--) {
                if (handlePair(nums[left], nums[right])) {
                    count++;
                }
            }
        }

        return count;
    }


    private boolean isValidated(int i, int j) {
        return i > 2 * j;
    }

    private boolean handlePair(int i, int j) {

        if (i > j && (j <= 0)) {
            return true;
        }

        if (i > Integer.MAX_VALUE / 2 && j > 0) {
            return false;
        }

//        if (i <= j) {
//            return false;
//        }

        // todo

        return isValidated(i, j);
    }
}
