import java.util.Arrays;
import java.util.Comparator;

/**
 * Autocomplete program.
 *
 * @author Isaac Weiss (icw0001)
 * @version 2020-10-03
 */
public class Autocomplete {
    private Term[] termArray;
    /**
     * Initializes a data structure from the given array of terms.
     * This method throws a NullPointerException if terms is null.
     */
    public Autocomplete(Term[] terms) {
        if (terms == null) {
            throw new NullPointerException();
        }
        Arrays.sort(terms);
        termArray = terms;
    }

    /**
     * Returns all terms that start with the given prefix, in descending order of weight.
     * This method throws a NullPointerException if prefix is null.
     */
    public Term[] allMatches(String prefix) {
        if (prefix == null) {
            throw new NullPointerException();
        }
        int length = prefix.length();
        Term term = new Term(prefix, 0);
        Comparator<Term> comp = termArray[0].byPrefixOrder(length);
        int firstIndex = BinarySearch.<Term>firstIndexOf(termArray, term, comp);
        int lastIndex = BinarySearch.<Term>lastIndexOf(termArray, term, comp);
        if (firstIndex == -1 && lastIndex == -1) {
            return new Term[0];
        }
        int matchesSize = (lastIndex - firstIndex) + 1;
        Term[] allMatches = new Term[matchesSize];
        /**if (matchesSize == 1) {
            allMatches[0] = termArray[firstIndex];
            return allMatches;
        }
        for (int i = firstIndex; i < lastIndex; i++) {
            for (int j = 0; j < matchesSize; j++) {
                allMatches[j] = termArray[i];
            }
        }*/
        allMatches = Arrays.copyOfRange(termArray, firstIndex, lastIndex+1);
        Comparator<Term> comp2 = allMatches[0].byDescendingWeightOrder();
        Arrays.sort(allMatches, comp2);
        return allMatches;
    }

    /**public static void main(String[] args) {
        Term[] terms = new Term[8];
        terms[0] = new Term("auburn football", 1000);
        terms[1] = new Term("auburn university", 700);
        terms[2] = new Term("auburn football schedule", 800);
        terms[3] = new Term("auburn hair", 500);
        terms[4] = new Term("alabama state", 1000);
        terms[5] = new Term("the witcher 3", 150);
        terms[6] = new Term("trump", 500);
        terms[7] = new Term("aub athletics", 250);
        Autocomplete a = new Autocomplete(terms);
        Term[] results = new Term[8];
        results = a.allMatches("aubu");
        for (Term b : results) {
            System.out.println(b);
        }
    }*/

}