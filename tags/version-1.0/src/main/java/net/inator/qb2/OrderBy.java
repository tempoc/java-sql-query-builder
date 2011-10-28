package net.inator.qb2;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/27/11
 * Time: 4:46 PM
 */
public class OrderBy {
    private final String orderBy;

    public OrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("order by ").append(orderBy);

        return sb.toString();
    }
}
