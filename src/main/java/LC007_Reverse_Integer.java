import base.BaseMain;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC007_Reverse_Integer extends BaseMain {


    public static void main(String[] args) {

        String inputStr = "inputString";
        int inputInt = -2147483648;

        LC007_Reverse_Integer lc = new LC007_Reverse_Integer();

        tryYourAnswer(lc::reverse, inputInt);
    }

    public int reverse(int x) {
        int result = 0;
        int copy = x;
        while (copy != 0) {
            int temp = copy % 10;
            copy /= 10;

            if (Integer.MAX_VALUE / 10 < result
                    || (Integer.MAX_VALUE / 10 == result && temp > 7)) {
                return 0;
            }
            if (Integer.MIN_VALUE / 10 > result
                    || (Integer.MIN_VALUE / 10 == result && temp < -8)) {
                return 0;
            }
            result = result * 10 + temp;
        }
        return result;
    }
}
