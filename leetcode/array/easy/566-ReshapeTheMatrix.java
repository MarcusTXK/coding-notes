/**
 * 566. Reshape the Matrix
 *
 * In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
 *
 * You are given an m x n matrix mat and two integers r and c representing the number of rows and the number of columns of the wanted reshaped matrix.
 *
 * The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
 *
 * If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
 */
class Solution {
    /**
     * Time complexity O(m * n), where m and n refer to the number of rows and columns of the given matrix respectively
     * Space complexity O(m * n), where m and n refer to the number of rows and columns of the given matrix respectively
     */
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int originalRowLen = mat.length;
        int originalColLen = mat[0].length;
        if (originalRowLen * originalColLen != r * c) { // invalid matrix
            return mat;
        }
        int[][] newMatrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j ++ ) {
                int elementNumber = i * c + j; // get element number in a 1D matrix
                int col = elementNumber % originalColLen;
                int row = elementNumber / originalColLen;
                newMatrix[i][j] = mat[row][col];
            }
        }
        return newMatrix;
    }
}
