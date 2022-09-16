package Array;

/**
 * @author psj
 * @date 2022/9/16 10:04
 * @File: 数组中出现次数超过一半的数字NC73.java
 * @Software: IntelliJ IDEA
 */
public class 数组中出现次数超过一半的数字NC73 {
    public int MoreThanHalfNum_Solution(int[] array) {
        int count = 0;
        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
                count++;
            }
            if (num == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        return num;
    }
}
