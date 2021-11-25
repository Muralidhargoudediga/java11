package com.mediga;

import java.nio.charset.StandardCharsets;
import java.text.Normalizer;
import java.text.RuleBasedCollator;
import java.util.Locale;

public class CollatorTest {
    public static void main(String[] args) {
        String s1 = new String("??????".getBytes(StandardCharsets.UTF_16), StandardCharsets.UTF_16);
        String s2 = new String("??????".getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        RuleBasedCollator collator = (RuleBasedCollator) RuleBasedCollator.getInstance(Locale.JAPANESE);
        String s = new String(collator.getRules().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        System.out.println("Compare:" + collator.compare(s1, s2));

        String str = Normalizer.normalize(s1, Normalizer.Form.NFC);
        String str1 = Normalizer.normalize(s2, Normalizer.Form.NFC);

        System.out.println( str );
        System.out.println( str1 );

        System.out.println( "Compare Normalized text:" + str.compareTo(str1));

        int n = '2' - 48;
        System.out.println(n);

        int[] arr = {1, 2};
        arr[1]++;
        System.out.println(arr[1]);

        char[] c = new char[2];
        c[0] = 51;
        System.out.println(c[0]);
    }
}
