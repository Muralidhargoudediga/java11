package com.mediga;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.*;

public class ScannerTest {
    public static void main(String[] args) {
        /*InputStream is = new ScannerTest().getClass().getResourceAsStream( "Sample-SQL-File-LARGE-Rows.sql" );
        String script = convertStreamToString( is );
        System.out.println( script.length() );
        System.out.println( -123 / 10);
        System.out.println( -123 % 10);
        long n = 9223372036854775807L;
        int k = (int)(n + 2);
        if( n > Integer.MAX_VALUE ) {
            System.out.println("true");
        }
        char c = 'a';
        int i = c;
        boolean f= c > '0';
        System.out.println(i + "   " + f + "   " + k);*/
       // System.out.println(letterCombinations("23"));
        System.out.println("abc".indexOf("abcd"));
        System.out.println( 4 << 1);
        System.out.println("god".hashCode());
        System.out.println("dog".hashCode());
        Runnable r = () -> System.out.println();
        System.out.println(OffsetDateTime.now());
        Random random = new Random();
        random.nextInt();
        System.out.println(longestValidParentheses(")("));
    }

    public static String convertStreamToString( InputStream is ) {
        try (Scanner s = new Scanner( is, StandardCharsets.UTF_8.name() ).useDelimiter( "\\A" )) {
            //return s.hasNext() ? s.next() : "";
            String str;
            while(s.hasNextLine()) {
               str = s.nextLine();
               System.out.println( str );
            }
            return s.hasNextLine() ? s.nextLine() : "";
        }
    }

    public static  List<String> letterCombinations(String digits) {
        char[][] chars = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        List<String> result = new ArrayList<>();
        for(int i = 0; i < digits.length(); i++) {
            int d = Integer.valueOf(digits.charAt(i));
            List<String> temp = result;
            result = new ArrayList<>();
            for(int j = 0; j < chars[d-2].length; j++) {
                if(i == 0) {
                    result.add(String.valueOf(chars[d-2][j]));
                } else {
                    for(String s : temp) {
                        result.add(s + chars[d-2][j]);
                    }
                }
            }
        }
        return result;
    }

    public static int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}

