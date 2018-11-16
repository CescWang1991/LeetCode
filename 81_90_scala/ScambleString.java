public class ScambleString {
    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopq";
        String s2 = "efghijklmnopqcadb";
        System.out.println(ScambleString.isScramble(s1, s2));
    }

    public static boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int n = s1.length();
        if(s1.equals(s2)){
            return true;
        }

        for(int i = 1; i < n; i++){
            if(
                    (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i)))
                            || (isScramble(s1.substring(0, i), s2.substring(n-i)) && isScramble(s1.substring(i), s2.substring(0, n-i))))
            {
                return true;
            }
        }
        return false;
    }
}
