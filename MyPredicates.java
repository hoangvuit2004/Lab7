import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
    public static <T> void remove(Collection<T> coll, Predicate<T> p) {
        // TODO
    }

    // Remove every object, obj, from coll for which
    // pr.test(obj) is false. (That is, retain the
    // objects for which the predicate is true.)
    public static <T> void retain(Collection<T> coll, Predicate<T> p) {
        // TODO
    }

    // Return a Set that contains all unique objects, obj,
    // from the collection, coll, such that p.test(obj)
    // is true.
    public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
        // TODO
        return null;
    }

    // Return the index of the first item in list
    // for which the predicate is true, if any.
    // If there is no such item, return -1.
    public static <T> int find(Collection<T> coll, Predicate<T> p) {
        // TODO
        return -1;
    }
}
