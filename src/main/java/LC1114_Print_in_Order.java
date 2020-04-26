import base.BaseMain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC1114_Print_in_Order extends BaseMain {
    private int n;
    private CountDownLatch fooCount = new CountDownLatch(0);
    private CountDownLatch barCount = new CountDownLatch(1);

    /**
     *
     */

    public static void main(String[] args) {

        List<String> inputStrList = new ArrayList<>();
        List<Integer> inputIntList = new ArrayList<>();

        inputStrList.add("inputString");

        inputIntList.add(0);

        LC1114_Print_in_Order lc = new LC1114_Print_in_Order();

        tryYourAnswer(lc::methodA, inputStrList);
    }


    public String methodA(String s) {
        return "helloWorld";
    }


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            fooCount.await();

            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooCount = new CountDownLatch(1);
            barCount.countDown();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {


            barCount.await();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            barCount = new CountDownLatch(1);
            fooCount.countDown();
        }
    }
}
