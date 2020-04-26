import base.BaseMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC00125_Valid_Palindrome extends BaseMain {

    /**
     * 判读输入的括号是否有效（是否一一闭合），会有{}[]()3种括号混合输入。
     */

    public static void main(String[] args) {

        List<String> inputStrList = new ArrayList<>();

        inputStrList.add("");
        inputStrList.add("a");
        inputStrList.add(".");
        inputStrList.add("a.a");
        inputStrList.add(".....");
        inputStrList.add(".....a");
        inputStrList.add(".....ab");
        inputStrList.add("a.....");
        inputStrList.add("ab.....");
        inputStrList.add("race a car");
        inputStrList.add("A man, a plan, a canal: Panama");

        LC00125_Valid_Palindrome lc = new LC00125_Valid_Palindrome();

        tryYourAnswer(lc::isPalindrome, inputStrList);
    }


    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        if (s.length() == 1) {
            return true;
        }

        s = s.toLowerCase();

        int head = 0;
        int tail = s.length() - 1;

        char[] chars = s.toCharArray();
        while (head <= tail) {
            while (!isInRange(chars[head])) {
                head++;
                if (head >= s.length()) {
                    return true;
                }
            }
            while (!isInRange(chars[tail])) {
                tail--;
                if (tail < 0) {
                    return true;
                }
            }

            if (chars[head] != chars[tail]) {
                return false;
            }
            if (head == tail - 1 || head == tail) {
                return true;
            }
            head++;
            tail--;
        }

        return true;
    }

    private boolean isInRange(char c) {
        return (57 >= c && 48 <= c) || (90 >= c && 65 <= c) || (122 >= c && 97 <= c);
    }
}
