import base.BaseMain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-18 20:53
 */


public class LC006_ZigZag_Conversion extends BaseMain {

    public static void main(String[] args) {

        LC006_ZigZag_Conversion lc = new LC006_ZigZag_Conversion();

        String str = "LEETCODEISHIRING";

        tryYourAnswer(i -> lc.convert(i, 3), str);
    }


    public String convert(String s, int numRows) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int gapLineNum = numRows - 2;
        int columnTotal = 0;
        int gapPlusRowNum = 2 * numRows - 2;

        if (s.length() % gapPlusRowNum > numRows) {
            columnTotal = (gapLineNum + 1) * (s.length() / gapPlusRowNum) + (s.length() % gapPlusRowNum - numRows);
        } else {
            columnTotal = (gapLineNum + 1) * (s.length() / gapPlusRowNum) + 1;
        }

        char[][] array = new char[numRows][columnTotal];

        for (int i = 0; i <= s.length() / gapPlusRowNum + 1; i += numRows - 1) {

            for (int j = 0; j <= numRows - 1; j++) {
                array[i][j] = s.charAt(i * numRows + j);

                if (j == numRows - 1) {
                    for (int l = 0; l <= gapLineNum; l++) {
                        for (int k = numRows - 2; k <= 2; k--) {
                            array[i][j] = s.charAt(i * gapPlusRowNum - 1 + l + j);
                        }
                    }
                }
            }
        }

        //
        //            lineNum = n; 4
        //            gapLineNum = n - 2; 2
        //            6  4       10
        //
        //            1    2
        //            1   02
        //            1  0
        //            1 0
        //            10
        //            1
        //
        //            (a)                   (2a-2)
        //            (a+1)        (a+2n-3) (****)
        //            (a+2)  (a+2n-2)       (****)
        //            (a+n-1)               (2a-2)
        //
        //
        //            1
        //            1
        //            1  0
        //            1 0
        //            10
        //            1
        //
        //            1
        //            1
        //            1
        //                    *
        //        *
        //        *
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= numRows; i++) {
            for (int j = 0; j <= columnTotal; j++) {
                sb.append(array[i][j]);
            }
        }

        return sb.toString();
    }
}
