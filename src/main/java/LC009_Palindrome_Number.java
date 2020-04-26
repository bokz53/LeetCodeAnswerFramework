import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC009_Palindrome_Number extends BaseMain {

    /**
     *
     */

    public static void main(String[] args) {

        List<String> inputStrList = new ArrayList<>();
        List<Integer> inputIntList = new ArrayList<>();

        inputStrList.add("inputString");

        inputIntList.add(0);
        inputIntList.add(1);
        inputIntList.add(-1);
        inputIntList.add(-121);
        inputIntList.add(121);
        inputIntList.add(11);
        inputIntList.add(10);

        LC009_Palindrome_Number lc = new LC009_Palindrome_Number();

        tryYourAnswer(lc::isPalindrome2, inputIntList);
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        String str = String.valueOf(x);
        boolean isEven = str.length() % 2 == 0;

        int leftPoint = 0;
        int rightPoint = 0;

        if (isEven) {
            rightPoint = str.length() / 2;
            leftPoint = rightPoint - 1;

            while ((str.charAt(leftPoint) == str.charAt(rightPoint)) && rightPoint < str.length() - 1) {
                leftPoint--;
                rightPoint++;
            }
        } else {
            rightPoint = str.length() / 2;
            leftPoint = rightPoint;

            while ((str.charAt(leftPoint) == str.charAt(rightPoint)) && rightPoint < str.length() - 1) {
                leftPoint--;
                rightPoint++;
            }
        }

        if (rightPoint == str.length() - 1 && leftPoint == 0 && (str.charAt(leftPoint) == str.charAt(rightPoint))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
