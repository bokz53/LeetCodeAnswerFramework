package base;

import base.tuple.Tuple3;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-19 10:02
 */


public class BaseMain {

    public static <I, O> O tryYourAnswer(AnswerFunction<I, O> answerFunction, I input) {

        O result = answerFunction.doIt(input);

        System.out.println("--------------开始测试你的答案---------------");
        System.out.println(String.valueOf(result));
        System.out.println("--------------你的答案输出完毕---------------");
        return result;
    }

    public static <I, O> List<O> tryYourAnswer(AnswerFunction<I, O> answerFunction, List<I> inputList) {

        return tryYourAnswer(answerFunction, inputList, Objects::toString);
    }

    public static <I, O> List<O> tryYourAnswer(AnswerFunction<I, O> answerFunction, List<I> inputList, ToStringFunction<O> resultTsFunc) {

        return tryYourAnswer(answerFunction, inputList, String::valueOf, resultTsFunc);
    }

    public static <I, O> List<O> tryYourAnswer(AnswerFunction<I, O> answerFunction, List<I> inputList, ToStringFunction<I> inputTsFunc, ToStringFunction<O> tsfunction) {

        long startTime = System.currentTimeMillis();

        List<O> resultList = new ArrayList<>();
        AtomicInteger times = new AtomicInteger(1);
        System.out.println("--------------开始测试你的答案---------------");
        inputList.forEach(i -> {
            O result = answerFunction.doIt(i);
            resultList.add(result);

            System.out.println("测试" + times + " : [" + inputTsFunc.generateString(i) + "]\t ====> \t[" + tsfunction.generateString(result) + "]");
            times.getAndIncrement();
        });
        System.out.println("--------------你的答案输出完毕---------------");

        long endTime = System.currentTimeMillis();
        System.out.println("总耗时" + (endTime - startTime) + "毫秒，平均耗时" + (endTime - startTime) / inputList.size() + "毫秒");
        return resultList;
    }


    /**
     * 二元入参
     */
    public static <I, U, O> O tryYourAnswer(BiAnswerFunction<I, U, O> answerFunction, I input1, U input2) {

        O result = answerFunction.doIt(input1, input2);

        System.out.println("--------------开始测试你的答案---------------");
        System.out.println(String.valueOf(result));
        System.out.println("--------------你的答案输出完毕---------------");
        return result;
    }

    public static <I, U, O> List<O> tryYourAnswer(BiAnswerFunction<I, U, O> answerFunction, List<Pair<I, U>> inputList) {

        return tryYourAnswer(answerFunction, inputList, String::valueOf, String::valueOf);
    }

    public static <I, U, O> List<O> tryYourAnswer(BiAnswerFunction<I, U, O> answerFunction,
                                                  List<Pair<I, U>> inputList,
                                                  BiToStringFunction<I, U> inputTsFunc,
                                                  ToStringFunction<O> tsfunction) {

        long startTime = System.currentTimeMillis();

        List<O> resultList = new ArrayList<>();
        AtomicInteger times = new AtomicInteger(1);
        System.out.println("--------------开始测试你的答案---------------");
        inputList.forEach(i -> {
            O result = answerFunction.doIt(i.getKey(), i.getValue());
            resultList.add(result);

            System.out.println("测试" + times + " : [" + inputTsFunc.generateString(i) + "]\t ====> \t[" + tsfunction.generateString(result) + "]");
            times.getAndIncrement();
        });
        System.out.println("--------------你的答案输出完毕---------------");

        long endTime = System.currentTimeMillis();
        System.out.println("总耗时" + (endTime - startTime) + "毫秒，平均耗时" + (endTime - startTime) / inputList.size() + "毫秒");
        return resultList;
    }

    /**
     * 多元入参
     */
    public static <Q, W, E, O> List<O> tryYourAnswer(ThirdAnswerFunction<Q, W, E, O> answerFunction,
                                                     List<Tuple3<Q, W, E>> inputList) {
        return tryYourAnswer(answerFunction, inputList, String::valueOf, String::valueOf);
    }

    public static <Q, W, E, O> List<O> tryYourAnswer(ThirdAnswerFunction<Q, W, E, O> answerFunction,
                                                     List<Tuple3<Q, W, E>> inputList,
                                                     ThirdToStringFunction<Q, W, E> inputTsFunc,
                                                     ToStringFunction<O> tsFunction) {

        long startTime = System.currentTimeMillis();

        List<O> resultList = new ArrayList<>();
        AtomicInteger times = new AtomicInteger(1);
        System.out.println("--------------开始测试你的答案---------------");
        inputList.forEach(i -> {
            O result = answerFunction.doIt(i.getFirst(), i.getSecond(), i.getThird());
            resultList.add(result);

            System.out.println("测试" + times + " : [" + inputTsFunc.generateString(i) + "]\t ====> \t[" + tsFunction.generateString(result) + "]");
            times.getAndIncrement();
        });
        System.out.println("--------------你的答案输出完毕---------------");

        long endTime = System.currentTimeMillis();
        System.out.println("总耗时" + (endTime - startTime) + "毫秒，平均耗时" + (endTime - startTime) / inputList.size() + "毫秒");
        return resultList;
    }
}
