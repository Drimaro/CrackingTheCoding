package chapter1;

/**
 * 1.3
 */
public class SpaceReplacer {
    public static void main(String[] args) {
        String testString = "String where spaces should be replaced";
        String resultString = new String(replaceSpace(testString));
        System.out.println(resultString);
    }

    private static char[] replaceSpace(String str) {
        char[] chars = str.toCharArray();
        int spacesCount = 0;

        for (char c : chars) {
            if (c == ' ') spacesCount++;
        }

        if (spacesCount == 0) return chars;

        int finalSize = chars.length + spacesCount * 2; // one space is replaces by %, so only 2 char adds per each
        char[] result = new char[finalSize];

        int j = result.length - 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                result[j] = '0';
                result[j-1] = '2';
                result[j-2] = '%';
                j -=3;
            } else {
                result[j] = chars[i];
                j--;
            }
        }

        return result;
    }
}