import base.BaseMain;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC0067_Add_Binary extends BaseMain {

    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     *
     * 输入为 非空 字符串且只包含数字 1 和 0。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例 2:
     *
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     *
     */

    public static void main(String[] args) {

        List<Pair<String, String>> inputStrList = new ArrayList<>();

        inputStrList.add(new Pair<>("11", "1"));
        inputStrList.add(new Pair<>("1", "1"));
        inputStrList.add(new Pair<>("1", "0"));
        inputStrList.add(new Pair<>("0", "0"));
        inputStrList.add(new Pair<>("1010", "1011"));

        LC0067_Add_Binary lc = new LC0067_Add_Binary();

        tryYourAnswer(lc::addBinary, inputStrList,
                pair -> (pair.getKey()) + "+" + (pair.getValue()),
                Objects::toString);

    }


    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int pointer = 0;

        boolean isCarry = false;
        while (pointer < a.length() || pointer < b.length()) {

            char temp1;
            char temp2;

            if (pointer < a.length()) {
                temp1 = a.charAt(a.length() - 1 - pointer);
            } else {
                temp1 = '0';
            }

            if (pointer < b.length()) {
                temp2 = b.charAt(b.length() - 1 - pointer);
            } else {
                temp2 = '0';
            }

            isCarry = this.handleAdd(result, temp1, temp2, isCarry);

            pointer++;
        }

        if (isCarry) {
            result.append('1');
        }

        return result.reverse().toString();
    }


    private boolean handleAdd(StringBuilder result, char a, char b, boolean isCarry) {
        if (a == '1' && b == '1') {
            result.append(isCarry ? '1' : '0');
            return true;
        } else if (a == '0' && b == '0') {
            result.append(isCarry ? '1' : '0');
            return false;
        } else {
            if (isCarry) {
                result.append('0');
                return true;
            } else {
                result.append('1');
                return false;
            }
        }
    }
}
