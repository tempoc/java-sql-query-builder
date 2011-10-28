package net.inator.qb2;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/26/11
 * Time: 7:21 PM
 */
public class Query {
    private Select select;
    private From from;
    private Where where;
    private OrderBy orderBy;

    public Query select(String s) {
        select = new Select(s);
        return this;
    }

    public Query select(Object... o) {
        select = new Select(o);
        return this;
    }

    public <T> Query select(Collection<T> c) {
        select = new Select(c);
        return this;
    }

    public Query from(String s) {
        from = new From(s);
        return this;
    }

    public Query from(Object... o) {
        from = new From(o);
        return this;
    }

    public <T> Query from(Collection<T> c) {
        from = new From(c);
        return this;
    }

    public Query join(String s) {
        if(from==null) throw new IllegalStateException();
        from.getJoins().add(new Join(s));
        return this;
    }

    public Query leftOuterJoin(String s) {
        if(from==null) throw new IllegalStateException();
        from.getJoins().add(new Join(Join.JoinType.LEFT_OUTER, s));
        return this;
    }

    public Query where(String s) {
        where = new Where(s);
        return this;
    }

    public Query where(Where where) {
        this.where = where;
        return this;
    }

    public Query orderBy(String orderBy) {
        this.orderBy = new OrderBy(orderBy);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        final boolean didSelect = select!=null;
        final boolean didFrom = from != null;
        final boolean didSelectOrFrom = didSelect || didFrom;
        final boolean didWhere = where != null && !where.isEmpty();
        final boolean didSelectOrFromOrWhere = didSelectOrFrom || didWhere;

        if(didSelect) {
            sb.append(select.toString());
        }
        if(didFrom) {
            if(didSelect) {
                sb.append(" ");
            }
            sb.append(from.toString());
        }
        if(didWhere) {
            if(didSelectOrFrom) {
                sb.append(" ");
            }
            sb.append(where.toString());
        }
        if(orderBy!=null) {
            if(didSelectOrFromOrWhere) {
                sb.append(" ");
            }
            sb.append(orderBy.toString());
        }

        return sb.toString();
    }
}
