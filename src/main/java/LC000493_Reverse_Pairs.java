import base.BaseMain;

import java.util.ArrayList;
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


        inputIntList.add(new int[]{1,3,2,3,1});
        inputIntList.add(new int[]{2,4,3,5,1});

        LC000493_Reverse_Pairs lc = new LC000493_Reverse_Pairs();

        tryYourAnswer(lc::reversePairs, inputIntList);
    }


    public int reversePairs(int[] nums) {
        return 0;
    }
}
