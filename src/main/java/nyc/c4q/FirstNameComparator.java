package nyc.c4q;

import java.util.Comparator;

import nyc.c4q.Person;

/**
 * Created by c4q-Abass on 8/30/15.
 */
public class FirstNameComparator implements Comparator<Person> {

    @Override
    public int compare(Person lhs, Person rhs) {
        return Double.compare(lhs.firstName.charAt(0), rhs.firstName.charAt(0));
    }
}