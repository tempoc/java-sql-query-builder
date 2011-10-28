package net.inator.qb2;

import net.inator.qb2.booleanclauses.BooleanExpression;
import net.inator.qb2.booleanclauses.In;
import net.inator.qb2.listables.Listable;

import java.util.Collection;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 10:42 AM
 */
public class Where {
    private String clause;
    private BooleanExpression booleanExpression;

    public Where(String clause) {
        this.clause = clause;
    }

    public Where(BooleanExpression booleanExpression) {
        this.booleanExpression = booleanExpression;
    }

    public boolean isEmpty() {
        return (clause==null && booleanExpression ==null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("where");

        if(clause!=null) {
            sb.append(" ").append(clause);
        } else {
            sb.append(" ").append(booleanExpression.toString());
        }

        return sb.toString();
    }
}
