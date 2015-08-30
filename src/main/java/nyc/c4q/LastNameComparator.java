package nyc.c4q;

import java.util.Comparator;

/**
 * Created by c4q-Abass on 8/30/15.
 */

public class LastNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person lhs, Person rhs) {
        return Double.compare(lhs.lastName.charAt(0), rhs.lastName.charAt(0));
    }
}