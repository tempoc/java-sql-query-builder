package net.inator.qb2;

import java.util.Collection;

/**
 * This class is the main query infrastructure builder.
 * Use it to start a query from the ground up.
 *
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/26/11
 * Time: 7:21 PM
 */
public class Q {
    private Select select;
    private From from;
    private Where where;
    private OrderBy orderBy;

    public Q select(String s) {
        select = new Select(s);
        return this;
    }

    public Q select(Object... o) {
        select = new Select(o);
        return this;
    }

    public <T> Q select(Collection<T> c) {
        select = new Select(c);
        return this;
    }

    public Q from(String s) {
        from = new From(s);
        return this;
    }

    public Q from(Object... o) {
        from = new From(o);
        return this;
    }

    public <T> Q from(Collection<T> c) {
        from = new From(c);
        return this;
    }

    public Q join(String s) {
        if(from==null) throw new IllegalStateException();
        from.getJoins().add(new Join(s));
        return this;
    }

    public Q leftOuterJoin(String s) {
        if(from==null) throw new IllegalStateException();
        from.getJoins().add(new Join(Join.JoinType.LEFT_OUTER, s));
        return this;
    }

    public Q where(String s) {
        where = new Where(s);
        return this;
    }

    public Q where(Where where) {
        this.where = where;
        return this;
    }

    public Q orderBy(String orderBy) {
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

    /**
     * Returns true iff {@code test} is not null and true if a boolean or non-empty if a collection
     * @param test Object to be tested
     * @return Whether the Object makes for a good query parameter
     * @since 1.1
     */
    public static boolean validate(Object test) {
        return test!=null
                && (
                    (!(test instanceof Collection) && !(test instanceof Boolean))
                    || (test instanceof Collection && !((Collection) test).isEmpty())
                    || (test instanceof Boolean) && ((Boolean) test)
                );
    }
}
