package base;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-19 09:59
 */
@FunctionalInterface
public interface ThirdAnswerFunction<I, U, Y, O> {

    O doIt(I i, U u, Y y);
}
