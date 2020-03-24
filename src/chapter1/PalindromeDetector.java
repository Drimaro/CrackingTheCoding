package chapter1;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.4
 */
public class PalindromeDetector {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Tact Coa"));
    }

    private static boolean isPalindrome(String str) {
        // todo check even
        Map<Character, Integer> symbolsCount = new HashMap<>();
        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch == ' ') continue;
            symbolsCount.compute(ch, (k, cnt) -> cnt == null ? 1 : ++cnt);
        }

        // todo if failed check at most one odd
        System.out.println(symbolsCount);
        long oddCnt = symbolsCount.values().stream().filter(cnt -> cnt % 2 != 0).limit(2).count();
        return oddCnt <= 1;
    }
}
