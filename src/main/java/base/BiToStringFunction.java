package base;

import javafx.util.Pair;

/**
 * @author PanBingYu
 * @description
 * @date 2020-03-05 16:19
 */
@FunctionalInterface
public interface BiToStringFunction<K, V> {

    String generateString(Pair<K, V> input);

}
