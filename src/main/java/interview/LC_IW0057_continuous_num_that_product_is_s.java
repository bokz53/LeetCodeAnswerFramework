package interview;

import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC_IW0057_continuous_num_that_product_is_s extends BaseMain {

    /**
     * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
     * <p>
     * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：target = 9
     * 输出：[[2,3,4],[4,5]]
     */

    public static void main(String[] args) {

        List<Integer> inputIntList = new ArrayList<>();

        inputIntList.add(9);
        inputIntList.add(15);
        //        inputIntList.add(5);

        LC_IW0057_continuous_num_that_product_is_s lc = new LC_IW0057_continuous_num_that_product_is_s();

        tryYourAnswer(lc::findContinuousSequence, inputIntList, i -> {
            StringBuilder sb = new StringBuilder();
            for (int[] item : i) {
                sb.append("[");
                for (int lowItem : item) {
                    sb.append(lowItem).append(", ");
                }
                sb.delete(sb.length() - 2, sb.length());
                sb.append("], ");
            }
            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        });
    }


    public int[][] findContinuousSequence(int target) {
        if (target == 0) {
            return null;
        }

        List<int[]> resultList = new ArrayList<>();
        int left = 1;
        int right = 2;
        while (left < target - 1) {
            if (this.getContinuousSum(left, right) < target) {
                right++;
                continue;
            }

            if (this.getContinuousSum(left, right) == target) {
                resultList.add(this.generateContinuousSequence(left, right));
                right++;
                continue;
            }

            if (this.getContinuousSum(left, right) > target) {
                if (right == left + 1) {
                    // 后面不用比了
                    break;
                }
                left++;
            }
        }

        int[][] result = new int[resultList.size()][];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    private int getContinuousSum(int head, int tail) {
        return (head + tail) * (tail - head + 1) / 2;
    }

    private int[] generateContinuousSequence(int head, int tail) {
        if (tail <= head) {
            throw new IllegalArgumentException();
        }
        int[] temp = new int[tail - head + 1];
        for (int i = 0; i < tail - head + 1; i++) {
            temp[i] = head + i;
        }
        return temp;
    }

    public static int[] toPrimitive(final Integer[] array) {
        int length = array.length;
        int[] ary = new int[length];
        for (int i = 0; i < length; i++) {
            ary[i] = array[i] == null ? 0 : array[i];
        }
        return ary;
    }


}


