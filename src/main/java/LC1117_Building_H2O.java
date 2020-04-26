import base.BaseMain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-17 15:56
 */


public class LC1117_Building_H2O extends BaseMain {

    private final Semaphore hSem = new Semaphore(2);
    private final Semaphore oSem = new Semaphore(1);
    private final CyclicBarrier barrier = new CyclicBarrier(3);

    private static final int GROUP_H_LIMIT = 2;
    private static final int GROUP_O_LIMIT = 1;
    private static final int GROUP_TOTAL_LIMIT = GROUP_H_LIMIT + GROUP_O_LIMIT;

    // Initialize group count.
    private AtomicInteger groupCount = new AtomicInteger(0);

    /**
     *
     */

    public static void main(String[] args) {

        String str = "HHHOOO";

        LC1117_Building_H2O lc = new LC1117_Building_H2O();
        lc.methodA(str);
    }


    public String methodA(String s) {

        Runnable releaseHydrogen = () -> System.out.print("H");
        Runnable releaseOxygen = () -> System.out.print("O");

        char[] chars = s.toCharArray();
        for (char item : chars) {
            if (item == 'O') {
                new Thread(() -> {
                    try {
                        oxygen(releaseOxygen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } else {
                new Thread(() -> {
                    try {
                        hydrogen(releaseHydrogen);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }


        }


        return "helloWorld";
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {

        hSem.acquire();
        //        try {
        //            barrier.await();
        //        } catch (BrokenBarrierException e) {
        //            e.printStackTrace();
        //        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        resetIfNeeded();

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {

        oSem.acquire();
        //        try {
        //            barrier.await();
        //        } catch (BrokenBarrierException e) {
        //            e.printStackTrace();
        //        }
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        releaseOxygen.run();
        resetIfNeeded();
    }

    private void resetIfNeeded() {
        // If the current group is ready, release permits and try another.
        if (this.groupCount.compareAndSet(GROUP_TOTAL_LIMIT, 0)) {
            this.hSem.release(GROUP_H_LIMIT);
            this.oSem.release(GROUP_O_LIMIT);
        }
    }

}
