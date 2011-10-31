package net.inator.qb2.booleanexpressions;

import net.inator.qb2.Q;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/31/11
 * Time: 1:13 PM
 */
public class ExpList extends ArrayList<CharSequence> {

    public boolean addIn(String e, String in) {
        return add(new StringExp(e).in(in));
    }

    public <T> boolean addIn(String e, T... in) {
        return add(new StringExp(e).in(in));

    }

    public <T> boolean addIn(String e, Collection<T> in) {
        return add(new StringExp(e).in(in));

    }

    public boolean addIn(String e, Q in) {
        return add(new StringExp(e).in(in));
    }
}
