import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public String reverseWords(String s) {
        List words = Arrays.asList(s.split(" "));
        Collections.reverse(words);
        String reverse = String.join(" ", words);
        return reverse;
    }
}
