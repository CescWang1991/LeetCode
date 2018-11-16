/*
Dynamic Programming:
    dp(n) = dp(n-1) * 1 + dp(n-2) * p(n-1)
 */

import java.util.ArrayList;
import java.util.List;

public class DecodeWays {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];

        if(s.startsWith("0")){ dp[0] = 0; }
        else { dp[0] = 1; }

        for (int i = 1; i< len; i++){
            if(i == 1){
                if(Integer.parseInt(s.substring(0,2))<=26){ dp[i] = 2; }
                else { dp[i] = 1; }
            } else {
                if(Integer.parseInt(s.substring(i-1,i+1))<=26){ dp[i] = dp[i-1] + dp[i-2]; }
                else { dp[i] = dp[i-1]; }
            }
        }

        return dp[len-1];
    }
}
