import base.BaseMain;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-18 20:53
 */


public class LC006_ZigZag_Conversion extends BaseMain {

    public static void main(String[] args) {

        List<Pair<String, Integer>> inputStrList = new ArrayList<>();

        inputStrList.add(new Pair<>("AB", 1));
        inputStrList.add(new Pair<>("1234567890ABCDE", 4));
        inputStrList.add(new Pair<>("1234567890ABCDEFGHIJKLNM", 5));
//        inputStrList.add(new Pair<>("LEETCODEISHIRIN", 3));
        inputStrList.add(new Pair<>("LEETCODEISHIRING", 3));

        LC006_ZigZag_Conversion lc = new LC006_ZigZag_Conversion();

        tryYourAnswer(lc::convert, inputStrList);
    }

    public String answer(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }



    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List[] array = new List[numRows];

        for (int i = 0; i < numRows; i++) {
            array[i] = new ArrayList<>();
        }


        int gapLineNum = numRows - 2;
        boolean isReverse = false;

        for (int curP = 0; curP < s.length(); ) {

            if (!isReverse) {
                // 正
                String str ;
                if (curP + numRows >= s.length()) {
                    str = s.substring(curP);
                } else {
                    str = s.substring(curP, curP + numRows);
                }


                this.fillArray(array, str.split(""), isReverse);
                curP = curP + numRows;
                isReverse = !isReverse;
            } else {
                // 倒
                String str;

                if (curP + (numRows - 2) > s.length()) {
                    str = s.substring(curP);
                } else {
                    str = s.substring(curP, curP + (numRows - 2));
                }

                for (int i = 0; i < str.length(); i++) {
                    StringBuilder sb = new StringBuilder(" ");
                    for (int j = 0; j < i; j++) {
                        sb.append(" ");
                    }
                    String substring = str.substring(i, i + 1);
                    sb.append(substring);
                    for (int j = i; j < numRows - 3; j++) {
                        sb.append(" ");
                    }
                    sb.append(" ");
                    this.fillArray(array, sb.toString().split(""), isReverse);
                }
                isReverse = !isReverse;
                curP = curP + (numRows - 2);
            }

        }
        this.printZigZag(array);
        return this.generateString(array);
    }

    private void fillArray(List[] array, String[] fill, boolean isReverse) {
        if (!isReverse) {
            for (int i = 0; i < fill.length; i++) {
                array[i].add(fill[i]);
            }
        } else {
            for (int i = array.length - 1; i >= 0; i--) {
                array[i].add(
                        fill[fill.length - 1 - i]
                );
            }
        }
    }


    private String generateString(List[] array) {
        StringBuilder sb = new StringBuilder();
        for (List i : array) {
            String o = String.valueOf(i.stream().reduce((s1, s2) -> s1.toString().concat(s2.toString())).orElse(""));
            sb.append(o);
        }
        return sb.toString().replaceAll(" ", "");
    }

    private void printZigZag(List[] array) {
        for (List i : array) {
            String o = String.valueOf(i.stream().reduce((s1, s2) -> s1.toString().concat(s2.toString())).orElse(""));
            System.out.println(o);
        }
    }

}
