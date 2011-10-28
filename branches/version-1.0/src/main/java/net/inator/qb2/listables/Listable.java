package net.inator.qb2.listables;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/26/11
 * Time: 7:39 PM
 */
public abstract class Listable {

    public static Listable parse(String s) {
        return new StringListable(s);
    }

    public static <T> Listable parse(T... a) {
        return new ArrayListable<T>(a);
    }

    public static <T> Listable parse(Collection<T> c) {
        return new CollectionListable<T>(c);
    }
}
