package net.inator.qb2.booleanclauses;

import net.inator.qb2.Query;
import net.inator.qb2.listables.Listable;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 4:26 PM
 */
public class In {
    private Listable listable;
    private Query subQuery;

    public In(Listable listable) {
        this.listable = listable;
    }

    public In(Query subQuery) {
        this.subQuery = subQuery;
    }

    @Override
    public String toString() {
        if(listable!=null) {
            return listable.toString();
        }
        if(subQuery!=null) {
            return subQuery.toString();
        }

        return super.toString();
    }
}
