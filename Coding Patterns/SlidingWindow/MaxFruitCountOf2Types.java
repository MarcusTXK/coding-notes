import java.util.HashMap;
/**
 * Fruits into Baskets (medium)
 *
 * Given an array of characters where each character represents a fruit tree, you are given two baskets, and your goal
 * is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type
 * of fruit.
 *
 * You can start with any tree, but you can’t skip a tree once you have started. You will pick one fruit from each tree
 * until you cannot, i.e., you will stop when you have to pick from a third fruit type.
 *
 * Write a function to return the maximum number of fruits in both baskets.
 */
class MaxFruitCountOf2Types {
    /**
     * Time Complexity O(N),where N is the number of elements in the array
     * Space Complexity O(1), as a max of 3 types of fruits will be stored in the hashmap
     */
    public static int findLength(char[] arr) {
        int windowStart = 0;
        int distinctCharacters = 0;
        int maxFruits = 0;
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (frequencyMap.containsKey(arr[i])) { // same character already present (1 of the 2 chars)
                frequencyMap.put(arr[i], frequencyMap.get(arr[i]) + 1);
                maxFruits++;
            } else {
                frequencyMap.put(arr[i], 1);
                distinctCharacters ++;
                while (distinctCharacters > 2) {
                    int freq = frequencyMap.get(arr[windowStart]);
                    if (freq >= 2) {
                        frequencyMap.put(arr[windowStart], freq - 1);
                    } else { // no more of a character
                        frequencyMap.remove(arr[windowStart]);
                        distinctCharacters--;
                    }
                    windowStart++;
                }
                maxFruits = Math.max(maxFruits, i - windowStart + 1);
            }
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        // Expected Output: 3
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'A', 'C' }));
        // Expected Output: 5
        System.out.println("Maximum number of fruits: " +
                MaxFruitCountOf2Types.findLength(new char[] { 'A', 'B', 'C', 'B', 'B', 'C' }));
    }
}
