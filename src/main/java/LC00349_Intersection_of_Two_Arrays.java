import base.BaseMain;
import javafx.util.Pair;

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


public class LC00349_Intersection_of_Two_Arrays extends BaseMain {

    /**
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     *
     * 示例 1：
     *
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     *
     * 示例 2:
     *
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     *
     */

    public static void main(String[] args) {

        List<Pair<int[], int[]>> inputStrList = new ArrayList<>();

        inputStrList.add(new Pair<>(new int[]{}, new int[]{}));
        inputStrList.add(new Pair<>(new int[]{1}, new int[]{}));
        inputStrList.add(new Pair<>(new int[]{}, new int[]{1}));
        inputStrList.add(new Pair<>(new int[]{4,9,5}, new int[]{9,4,9,8,4}));
        inputStrList.add(new Pair<>(new int[]{1,2,2,1}, new int[]{2,2}));

        LC00349_Intersection_of_Two_Arrays lc = new LC00349_Intersection_of_Two_Arrays();

        tryYourAnswer(lc::intersection, inputStrList, i -> Arrays.toString(i.getKey()) + " = " + Arrays.toString(i.getValue()), Arrays::toString);
    }


    public int[] intersection(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;

        // 保证a为小数组
        if (nums1.length > nums2.length) {
            a = nums2;
            b = nums1;
        }

        int[] result = new int[nums1.length];
        int count = 0;

        Map<Integer, Boolean> map = new HashMap<>();

        for (int i : a) {
            map.put(i, true);
        }

        for (int i : b) {
            if (map.containsKey(i)) {
                result[count] = i;
                map.remove(i);
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }
}
