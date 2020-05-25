import base.BaseMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC001013_canThreePartsEqualSum extends BaseMain {

    /**
     */

    public static void main(String[] args) {

        List<int[]> inputStrList = new ArrayList<>();

        inputStrList.add(new int[]{18,12,-18,18,-19,-1,10,10});
        inputStrList.add(new int[]{0,2,1,-6,6,-7,9,1,2,0,1});
        inputStrList.add(new int[]{0});
        inputStrList.add(new int[]{0,1});
        inputStrList.add(new int[]{0,1,2});
        inputStrList.add(new int[]{0,2,1,-6,6,7,9,-1,2,0,1});
        inputStrList.add(new int[]{3,3,6,5,-2,2,5,1,-9,4});


        LC001013_canThreePartsEqualSum lc = new LC001013_canThreePartsEqualSum();

        tryYourAnswer(lc::canThreePartsEqualSum, inputStrList, Arrays::toString, String::valueOf);
    }


    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i : A){
            sum += i;
        }
        if(sum%3 != 0){
            // 总和不是3的倍数，直接返回false
            return false;
        }

        // 使用双指针,从数组两头开始一起找，节约时间
        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];

        // 使用left + 1 < right 的原因，防止只能将数组分成两个部分
        // 例如：[1,-1,1,-1]，使用left < right作为判断条件就会出错
        while(left + 1 < right){
            if(leftSum == sum/3 && rightSum == sum/3){
                // 左右两边都等于 sum/3 ，中间也一定等于
                return true;
            }
            if(leftSum != sum/3){
                // left = 0赋予了初值，应该先left++，在leftSum += A[left];
                leftSum += A[++left];
            }
            if(rightSum != sum/3){
                // right = A.length - 1 赋予了初值，应该先right--，在rightSum += A[right];
                rightSum += A[--right];
            }
        }
        return false;
    }

}
