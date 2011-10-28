package net.inator.qb2;

import net.inator.qb2.listables.Listable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/26/11
 * Time: 8:50 PM
 */
public class From {
    private Listable listable;
    private List<Join> joins = new ArrayList<Join>();
    
    public From(String selectable) {
        this.listable = Listable.parse(selectable);
    }

    public <T> From(T... a) {
        this.listable = Listable.parse(a);
    }

    public <T> From(Collection<T> c) {
        this.listable = Listable.parse(c);
    }

    public List<Join> getJoins() {
        return joins;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("from ").append(listable.toString());

        if(joins!=null) {
            for(Join j : joins) {
                sb.append(" ").append(j.toString());
            }
        }

        return sb.toString();
    }
}
