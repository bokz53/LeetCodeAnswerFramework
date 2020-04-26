import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0027_Remove_Element extends BaseMain {

    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1:
     * <p>
     * 给定 nums = [3,2,2,3], val = 3,
     * <p>
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     */

    public static void main(String[] args) {

        int[] a1 = {3, 2, 2, 3};
        int v1 = 3;

        int[] a2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int v2 = 2;

        int[] a3 = {3, 3};
        int v3 = 3;
        LC0027_Remove_Element lc = new LC0027_Remove_Element();
        //        System.out.println(lc.removeElement(a1,v1));
        //        System.out.println(lc.removeElement(a2,v2));
        System.out.println(lc.removeElement(a3, v3));
    }


    public int removeElement(int[] nums, int val) {
        if (val == 0 || nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            if (nums[0] == val) {
                nums = new int[0];
                return 0;
            } else {
                return 1;
            }
        }

        int head = 0;
        int tail = nums.length - 1;
        int elCount = nums.length;


        return elCount;
    }

    private void swapElement(int val1, int val2, int[] nums) {
        int temp = nums[val1];
        nums[val1] = nums[val2];
        nums[val2] = temp;
    }
}
