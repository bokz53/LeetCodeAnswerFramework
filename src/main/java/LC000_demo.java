import base.BaseMain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC000_demo extends BaseMain {

    /**
     *
     */

    public static void main(String[] args) {

        List<String> inputStrList = new ArrayList<>();
        List<Integer> inputIntList = new ArrayList<>();

        inputStrList.add("inputString");

        inputIntList.add(0);

        LC000_demo lc = new LC000_demo();

        tryYourAnswer(lc::methodA, inputStrList);
    }


    public String methodA(String s) {
        return "helloWorld";
    }
}
