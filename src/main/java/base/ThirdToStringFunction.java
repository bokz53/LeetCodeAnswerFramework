package base;

import base.tuple.Tuple3;

/**
 * @author PanBingYu
 * @description
 * @date 2020-03-05 16:19
 */
@FunctionalInterface
public interface ThirdToStringFunction<Q, W, E> {

    String generateString(Tuple3<Q, W, E> input);

}
