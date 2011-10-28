package net.inator.qb2.listables;

/**
 * Created by IntelliJ IDEA.
 * User: tempoc
 * Date: 10/26/11
 * Time: 7:46 PM
 */
public class StringListable extends Listable {
    private String s;

    public StringListable(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }
}
