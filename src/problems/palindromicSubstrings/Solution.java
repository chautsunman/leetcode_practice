package problems.palindromicSubstrings;

import problemTypes.DynamicProgramming;
import problemTypes.StringProblem;

@StringProblem
@DynamicProgramming(dimension = 2)
public class Solution {
    public int countSubstrings(String s) {
        final int sLen = s.length();
        final boolean[][] dp = new boolean[sLen][sLen];
        int cnt = 0;
        for (int i = 0; i < sLen; i++) {
            dp[i][i] = true;
            cnt++;
        }
        for (int i = 0; i < sLen - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                cnt++;
            }
        }
        for (int palindromeLen = 3; palindromeLen <= sLen; palindromeLen++) {
            for (int i = 0; i < sLen - palindromeLen + 1; i++) {
                if (s.charAt(i) == s.charAt(i + palindromeLen - 1) && dp[i + 1][i + palindromeLen - 2]) {
                    dp[i][i + palindromeLen - 1] = true;
                    cnt++;
                }
            }
        }
        return cnt;

        // trivial solution: n3
    }
}
