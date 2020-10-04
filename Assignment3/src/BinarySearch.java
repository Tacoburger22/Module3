import java.util.Arrays;
import java.util.Comparator;

/**
 * Implements binary search for the autocomplete program.
 *
 * @author Isaac Weiss (icw0001)
 * @version 2020-10-03
 */
public class BinarySearch {

    /**
     * Returns the index of the first key in a[] that equals the search key,
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) {
            throw new NullPointerException();
        }
        Arrays.sort(a, comparator);
        int firstIndex = -1;
        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (comparator.compare(key, a[mid]) < 0) {
                right = mid - 1;
            }
            else if (comparator.compare(key, a[mid]) > 0) {
                left = mid + 1;
            }
            else {
                firstIndex = mid;
                right = mid - 1;
            }
        }
        return firstIndex;
    }

    /**
     * Returns the index of the last key in a[] that equals the search key,
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if (a == null || key == null || comparator == null) {
            throw new NullPointerException();
        }
        Arrays.sort(a, comparator);
        int lastIndex = -1;
        int left = 0;
        int right = a.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (comparator.compare(key, a[mid]) < 0) {
                right = mid - 1;
            }
            else if (comparator.compare(key, a[mid]) > 0) {
                left = mid + 1;
            }
            else {
                lastIndex = mid;
                left = mid + 1;
            }
        }
        return lastIndex;
    }

}
