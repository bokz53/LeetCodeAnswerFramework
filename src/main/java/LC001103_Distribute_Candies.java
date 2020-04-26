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


public class LC001103_Distribute_Candies extends BaseMain {

    /**
     *
     */

    public static void main(String[] args) {

        List<Pair<Integer, Integer>> inputList = new ArrayList<>();

        inputList.add(new Pair<>(7, 4));
        inputList.add(new Pair<>(10, 3));
        inputList.add(new Pair<>(7, 4));

        LC001103_Distribute_Candies lc = new LC001103_Distribute_Candies();

        List<int[]> ints = tryYourAnswer(lc::distributeCandies, inputList);
        System.out.println("sdfsdfdsf");
    }


    public int[] distributeCandies(int candies, int num_people) {
        int remain = 0;
        int[] result = new int[num_people];
        remain = candies % num_people;

        if (candies < (1 + num_people) * num_people / 2) {
            for (int i = 0; i < num_people; i++) {
                if (i + 1 > candies) {
                    result[i] = candies;
                    break;
                } else {
                    result[i] = i + 1;
                    candies -= i + 1;
                }
            }
        } else {
            int times = candies / num_people;
            for (int i = 0; i < times; i++) {

                for (int j = 0; j < num_people; j++) {

                    if (times * num_people + j + 1 > candies) {
                        result[j] += candies;
                        break;
                    }

                    result[j] += times * num_people + j + 1;
                    candies -= times * num_people + j + 1;
                }
            }
        }
        return result;
    }
}
//0a+1
//1a+1
//2a+1
//3a+1
//
//        i(n*n)/2+n

