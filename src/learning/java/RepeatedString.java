package learning.java;

public class RepeatedString {

    static long repeatedString(String s, long n) {
        char letter = 'a';
        long fullStringChecks = n / s.length();

        long count = s.chars().mapToObj(c -> (char) c).filter(ch -> ch == letter).count() * fullStringChecks;

        s = s.substring(0, (int) (n - fullStringChecks * s.length()));
        count += s.chars().mapToObj(c -> (char) c).filter(ch -> ch == letter).count();

        return count;
    }
}
