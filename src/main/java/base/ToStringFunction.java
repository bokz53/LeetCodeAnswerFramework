package base;

/**
 * @author PanBingYu
 * @description
 * @date 2020-03-05 16:19
 */
@FunctionalInterface
public interface ToStringFunction<I> {

    String generateString(I input);

}
