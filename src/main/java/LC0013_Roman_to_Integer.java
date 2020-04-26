import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0013_Roman_to_Integer extends BaseMain {

    /**
     *
     */

    public static void main(String[] args) {

        List<String> inputStrList = new ArrayList<>();
        List<Integer> inputIntList = new ArrayList<>();

        inputStrList.add("MCMXCIV");

        inputIntList.add(0);

        LC0013_Roman_to_Integer lc = new LC0013_Roman_to_Integer();

        tryYourAnswer(lc::romanToInt, inputStrList);
    }


    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
