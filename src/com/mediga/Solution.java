package com.mediga;

class Solution {
    public static void main(String[] args) {
        String s = "fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffgggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        if(s == null) {
            return "";
        }
        Integer[][] dp = new Integer[s.length()][s.length()];
        longestPalindrome(s, 0, s.length()-1, dp);
        int i = 0, j = s.length()-1;
        String result = "";
        while(i <= j) {
            Integer m = dp[i][j];
            Integer n = dp[i+1][j];
            Integer k = dp[i][j-1];
            if(dp[i][j] == j-i+1) {
                result = s.substring(i, j+1);
                break;
            } else if(dp[i][j].equals(dp[i+1][j])) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static int longestPalindrome(String s, int i, int j, Integer[][] dp) {
        if(i > j) {
            return 0;
        }
        if(i == j) {
            dp[i][j] = 1;
        }

        if(dp[i][j] == null) {
            if(s.charAt(i) == s.charAt(j)) {
                int remainingLen = j-i-1;
                if(remainingLen == longestPalindrome(s, i+1, j-1, dp)) {
                    dp[i][j] = remainingLen + 2;
                    return dp[i][j];
                }
            }

            int s1 = longestPalindrome(s, i+1, j, dp);
            int s2 = longestPalindrome(s, i, j-1, dp);
            dp[i][j] = Math.max(s1, s2);
        }
        return dp[i][j];
    }
}
