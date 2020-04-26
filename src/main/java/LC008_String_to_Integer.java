import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC008_String_to_Integer extends BaseMain {

    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * <p>
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
     * <p>
     * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
     * <p>
     * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
     * <p>
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
     * <p>
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */


    public static void main(String[] args) {

        List<String> inputStrList = new ArrayList<>();
        List<Integer> inputIntList = new ArrayList<>();

        //        inputStrList.add("words and 987");
        //        inputStrList.add("   -42");
        inputStrList.add("-91283472332");
        //        inputStrList.add("42");
        //        inputStrList.add("+");
        //        inputStrList.add("-+2");
        //        inputStrList.add(" ");

        LC008_String_to_Integer lc = new LC008_String_to_Integer();

        tryYourAnswer(lc::myAtoi, inputStrList);
    }


    public int myAtoi(String str) {

        if (null == str || "".equals(str)) {
            return 0;
        }

        int numStartPoint = 0;
        int numEndPoint = 0;

        int currentPoint = 0;
        char currentChar = str.charAt(currentPoint);
        boolean isPlus = true;

        int result = 0;

        // 获取开头
        while (true) {

            if (('0' <= currentChar && currentChar <= '9')) {
                break;
            } else if (currentChar == '-') {
                currentPoint++;
                if (currentPoint > str.length() - 1) {
                    return 0;
                }
                currentChar = str.charAt(currentPoint);
                isPlus = false;
                break;
            } else if (currentChar == '+') {
                currentPoint++;
                if (currentPoint > str.length() - 1) {
                    return 0;
                }
                currentChar = str.charAt(currentPoint);
                isPlus = true;
                break;
            } else if (currentChar == ' ') {
                currentPoint++;
                if (currentPoint > str.length() - 1) {
                    return 0;
                }
                currentChar = str.charAt(currentPoint);
            } else {
                return 0;
            }
        }
        numStartPoint = currentPoint;
        if ('0' > str.charAt(numStartPoint) || str.charAt(numStartPoint) > '9') {
            return 0;
        }

        while (('0' <= currentChar && currentChar <= '9')) {
            currentPoint++;
            if (currentPoint <= str.length() - 1) {
                currentChar = str.charAt(currentPoint);
            } else {
                break;
            }
        }
        numEndPoint = currentPoint;

        int temp2 = Integer.parseInt(str.substring(numStartPoint, numStartPoint + 1));
        result = result * 10 + temp2;
        result = isPlus ? result : result * -1;
        numStartPoint++;

        while (numEndPoint > numStartPoint) {
            int temp = Integer.parseInt(str.substring(numStartPoint, numStartPoint + 1));
            temp *= isPlus ? 1 : -1;
            if (Integer.MAX_VALUE / 10 < result
                    || (Integer.MAX_VALUE / 10 == result && temp > 7)) {
                return Integer.MAX_VALUE;
            }
            if (Integer.MIN_VALUE / 10 > result
                    || (Integer.MIN_VALUE / 10 == result && temp < -8)) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + temp;
            numStartPoint++;
        }

        return result;
    }
}
