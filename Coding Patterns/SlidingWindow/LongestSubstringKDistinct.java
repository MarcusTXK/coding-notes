import java.util.HashMap;

/**
 * Longest Substring with maximum K Distinct Characters (medium)
 *
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 */
class LongestSubstringKDistinct {
    /**
     * Time Complexity O(N),where N is the number of characters in the input string
     * Space Complexity O(K), as we will be storing a maximum of K + 1 characters in the HashMap.
     */
    public static int findLength(String str, int k) {
        int windowStart = 0;
        int longestSubString = 0;
        int distinctCharacters = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (!frequencyMap.containsKey(current)) { // new distinct character
                distinctCharacters++;
                frequencyMap.put(current, 1);
                while (distinctCharacters > k) { // exceeds allowed limit
                    char windowStartChar = str.charAt(windowStart);
                    windowStart++;
                    int charCount = frequencyMap.get(windowStartChar);
                    charCount--;
                    if (charCount == 0) { // will no longer have this char once it is removed
                        distinctCharacters--;
                        frequencyMap.remove(windowStartChar);
                    } else {
                        frequencyMap.put(windowStartChar, charCount);
                    }
                }
            } else {
                frequencyMap.put(current, frequencyMap.get(current) + 1);
            }
            longestSubString = Math.max(longestSubString, i - windowStart + 1);
        }
        return longestSubString;
    }

    public static void main(String[] args) {
        // Expected Output: 4
        System.out.println("Length of the longest substring: " +
                LongestSubstringKDistinct.findLength("araaci", 2));
        // Expected Output: 2
        System.out.println("Length of the longest substring: " +
                LongestSubstringKDistinct.findLength("araaci", 1));
        // Expected Output: 5
        System.out.println("Length of the longest substring: " +
                LongestSubstringKDistinct.findLength("cbbebi", 3));

        // Edge Cases:
        // Expected Output: 6
        System.out.println("Length of the longest substring: " +
                LongestSubstringKDistinct.findLength("cbbebi", 10));
        // Expected Output: 0
        System.out.println("Length of the longest substring: " +
                LongestSubstringKDistinct.findLength("cbbebi", 0));
    }
}
