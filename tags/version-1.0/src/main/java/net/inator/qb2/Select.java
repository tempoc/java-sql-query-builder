package net.inator.qb2;

import net.inator.qb2.listables.Listable;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/26/11
 * Time: 7:24 PM
 */
public class Select {
    private Listable listable;

    public Select(String selectable) {
        this.listable = Listable.parse(selectable);
    }

    public <T> Select(T... a) {
        this.listable = Listable.parse(a);
    }

    public <T> Select(Collection<T> c) {
        this.listable = Listable.parse(c);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("select ").append(listable.toString());
        return sb.toString();
    }
}
