import base.BaseMain;
import utils.TreeNode;
import utils.TreeNodeUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 14:29
 */


public class LC00491_Increasing_Subsequences extends BaseMain {


    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     *
     * 示例:
     *
     * 输入: [4, 6, 7, 7]
     * 输出: [
     * [4, 6],
     * [4, 7],
     * [4, 6, 7],
     * [4, 6, 7, 7],
     * [6, 7],
     * [6, 7, 7],
     * [7,7],
     * [4,7,7]
     * ]
     * 说明:
     *
     * 给定数组的长度不会超过15。
     * 数组中的整数范围是[-100,100]。
     * 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。
     *
     */


    public static void main(String[] args) {

        List<int[]> inputStrList = new ArrayList<>();

        inputStrList.add(new int[]{0,1,2,3});
//        inputStrList.add(new int[]{4,6,7,7});

        LC00491_Increasing_Subsequences lc = new LC00491_Increasing_Subsequences();


        tryYourAnswer(lc::findSubsequences, inputStrList, String::valueOf, i -> {
            StringBuilder s = new StringBuilder("\n");

            for (List<Integer> outList : i) {
                s.append("[ ");
                s.append(outList.stream().map(String::valueOf).reduce((s1, s2) -> s1.concat(", ").concat(s2)).orElse(""));
                s.append(" ]\n");

            }
            return s.toString();
        });

    }


    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null) {
            return null;
        }
        dfs(0, Integer.MIN_VALUE, nums);
        return res;
    }

    private void dfs(int curIndex, int preValue, int[] nums) {
        if (curIndex >= nums.length) {  // 遍历结束
            if (temp.size() >= 2) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }

        if (nums[curIndex] >= preValue) {   // 将当前元素加入，并向后遍历
            temp.add(nums[curIndex]);
            dfs(curIndex + 1, nums[curIndex], nums);
            temp.remove(temp.size() - 1);
        }
        if (nums[curIndex] != preValue) {   // 不遍历 重复元素
            dfs(curIndex + 1, preValue, nums);  // 将下一个元素加入，并向后遍历
        }
    }

}
