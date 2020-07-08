package base.tuple;

import java.util.Objects;

/**
 * @author PanBingYu
 * @description
 * @date 2020-05-25 16:37
 */


public class Tuple3<Q, W, E> {

    private Q first;

    private W second;

    private E third;

    public Tuple3(Q first, W second, E third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Tuple3() {
    }

    public Q getFirst() {
        return first;
    }

    public void setFirst(Q first) {
        this.first = first;
    }

    public W getSecond() {
        return second;
    }

    public void setSecond(W second) {
        this.second = second;
    }

    public E getThird() {
        return third;
    }

    public void setThird(E third) {
        this.third = third;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tuple3<?, ?, ?> tuple3 = (Tuple3<?, ?, ?>) o;
        return Objects.equals(first, tuple3.first) &&
                Objects.equals(second, tuple3.second) &&
                Objects.equals(third, tuple3.third);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second, third);
    }

    @Override
    public String toString() {
        return first +
                "=" + second +
                "=" + third;
    }
}
