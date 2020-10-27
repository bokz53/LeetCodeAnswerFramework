import base.BaseMain;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0035_Search_Insert_Position extends BaseMain {

    /**
     *
     */

    public static void main(String[] args) {

        List<Pair<int[], Integer>> inputStrList = new ArrayList<>();

//        inputStrList.add(new Pair<>(new int[]{}, 0));
//        inputStrList.add(new Pair<>(new int[]{0}, 0));
//        inputStrList.add(new Pair<>(new int[]{0,2}, 0));
        inputStrList.add(new Pair<>(new int[]{1,3,5,6}, 5));
        inputStrList.add(new Pair<>(new int[]{1,3,5,6}, 2));
        inputStrList.add(new Pair<>(new int[]{1,3,5,6}, 7));
        inputStrList.add(new Pair<>(new int[]{1,3,5,6}, 0));

        LC0035_Search_Insert_Position lc = new LC0035_Search_Insert_Position();

        tryYourAnswer(lc::searchInsert, inputStrList,
                (pair) -> Arrays.toString(pair.getKey()) + "==" + pair.getValue()
                , String::valueOf);
    }


    public int searchInsert(int[] nums, int target) {

        int result = 0;

        for (int num : nums) {
            if (target > num) {
                result++;
            } else {
                return result;
            }
        }
        return result;
    }
}
