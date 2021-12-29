package TwoPointers;

/**
 * Squaring a Sorted Array (easy)
 *
 * Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.
 */
public class SortedArraySquares {

    /**
     * Time Complexity O(N)
     * Space Complexity O(N)
     */
    public static int[] makeSquares(int[] arr) {
        int[] squares = new int[arr.length];
        int front = 0;
        int back = arr.length - 1;
        int squareIndex = squares.length - 1;
        while (squareIndex >= 0) {
            if (Math.pow(arr[front], 2) <= Math.pow(arr[back], 2)) {
                squares[squareIndex] = (int) Math.pow(arr[back], 2);
                back--;
            } else {
                squares[squareIndex] = (int) Math.pow(arr[front], 2);
                front++;
            }
            squareIndex--;
        }
        return squares;
    }

    public static void main(String[] args) {
        int[] result = SortedArraySquares.makeSquares(new int[]{-2, -1, 0, 2, 3});
        // Expected Output: [0, 1, 4, 4, 9]
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[]{-3, -1, 0, 1, 2});
        // Expected Output: [0, 1, 1, 4, 9]
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}
