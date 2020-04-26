package base;

/**
 * @author PanBingYu
 * @description
 * @date 2019-12-19 09:59
 */
@FunctionalInterface
public interface BiAnswerFunction<I, U, O> {

    O doIt(I i, U u);
}
