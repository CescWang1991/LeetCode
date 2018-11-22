import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 140. Word Break II
 * Backtracking
 */
public class WordBreak {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s.isEmpty()) {
            return res;
        }
        HashMap dict = new HashMap();
        for(String word: wordDict) {
            if(!dict.containsKey(word)) {
                dict.put(word, 1);
            }
        }
        if(dict.containsKey(s)) {
            res.add(s);
        }
        for(int i = 0; i <= s.length()-1; i++) {
            if(dict.containsKey(s.substring(0, i+1))) {
                List<String> post = wordBreak(s.substring(i+1), wordDict);
                if(!post.isEmpty()) {
                    for(String str: post) {
                        res.add(s.substring(0, i+1)+" "+str);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }
}
