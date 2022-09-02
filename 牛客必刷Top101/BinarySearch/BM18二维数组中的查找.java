package BinarySearch;

/**
 * @author psj
 * @date 2022/7/15 9:49
 * @File: BM18二维数组中的查找.java
 * @Software: IntelliJ IDEA
 */
public class BM18二维数组中的查找 {
    public boolean Find(int target, int[][] array) {
        int row = array.length - 1;
        int col = 0;
        while (row >= 0 && col < array[0].length) {
            if (target == array[row][col]) {
                return true;
            } else if (target < array[row][col]) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}
