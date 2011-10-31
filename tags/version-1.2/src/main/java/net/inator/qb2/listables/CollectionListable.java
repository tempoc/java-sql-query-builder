package net.inator.qb2.listables;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/26/11
 * Time: 7:57 PM
 */
public class CollectionListable<T> extends ArrayListable<T> {

    @SuppressWarnings("unchecked")
    public CollectionListable(Collection<T> c) {
        super((T[]) c.toArray());
    }
}
