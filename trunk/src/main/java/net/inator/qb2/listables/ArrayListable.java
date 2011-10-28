package net.inator.qb2.listables;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/26/11
 * Time: 7:51 PM
 */
public class ArrayListable<T> extends Listable {
    private T[] array;

    public ArrayListable(T... a) {

        if (a==null) throw new IllegalArgumentException();
        for(T t : a) {
            if(t==null) throw new IllegalArgumentException();
        }

        this.array = a;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        boolean notFirst = false;

        for(T t : array) {
            if(notFirst) {
                sb.append(", ");
            } else {
                notFirst = true;
            }

            sb.append(t.toString());
        }

        return sb.toString();
    }
}
