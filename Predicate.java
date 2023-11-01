import java.util.*;

public interface Predicate<T> {
    public boolean test(T obj);
    public static <T> void remove(Collection<T> coll, Predicate<T> p) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (p.test(element)) {
                iterator.remove();
            }
        }
    }
    public static <T> void retain(Collection<T> coll, Predicate<T> p) {
        Iterator<T> iterator = coll.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (!p.test(element)) {
                iterator.remove();
            }
        }
    }
    public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
        Set<T> list = new HashSet<>();
        List<T> copy = new ArrayList<>(coll);
        Iterator<T> iterator = copy.iterator();
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (!p.test(element)) {
                list.add(element);
                iterator.remove();
            }
        }

        return list;
    }
    public static <T> int find(Collection<T> coll, Predicate<T> p) {
        int index = 0;
        for (T element : coll) {
            if (p.test(element)) {
                return index;
            }
            index++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Collection<Integer> numbers = new java.util.ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Loại bỏ các số chẵn khỏi danh sách
        Predicate<Integer> evenPredicate = n -> n % 2 == 0;
        retain(numbers, evenPredicate);

        // In danh sách sau khi loại bỏ
        System.out.println(numbers); // Kế
    }
    }


