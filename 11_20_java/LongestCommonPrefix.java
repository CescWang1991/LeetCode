public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] strs = new String[]{"flower", "flow", "flight"};
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(strs));
    }

    /**
     * Horizontal scanning
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){ return ""; }
        else{
            String prefix = strs[0];
            for(int i = 0; i<strs.length; i++){
                while(strs[i].indexOf(prefix) != 0){
                    prefix = prefix.substring(0, prefix.length() - 1);
                    if(prefix.isEmpty()) { return ""; }
                }
            }
            return prefix;
        }
    }
}
