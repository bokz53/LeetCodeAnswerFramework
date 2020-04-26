package base;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-19 09:59
 */
@FunctionalInterface
public interface AnswerFunction<I, O> {

    O doIt(I i);
}
