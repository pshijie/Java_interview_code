package DynamicProgram;

/**
 * @author psj
 * @date 2022/8/4 11:38
 * @File: BM69把数字翻译成字符串.java
 * @Software: IntelliJ IDEA
 */
public class BM69把数字翻译成字符串 {
    public int solve(String nums) {
        if (nums.equals("0") || nums.charAt(0) == '0') {
            return 0;
        }
        // 当字符串为10或20时,只能翻译为J或T这一种情况(因为不能拆分为1和0或2和0,0没有含义)
        if (nums == "10" || nums == "20") {
            return 1;
        }
        // 当前字符为0时，如果前一位字符不为1或2，则无法编译(最多只有26个字符)
        for (int i = 1; i < nums.length(); i++) {
            if (nums.charAt(i) == '0') {
                if (nums.charAt(i - 1) != '1' && nums.charAt(i - 1) != '2') {
                    return 0;
                }
            }
        }
        // dp[i]表示nums[0...i]的编译方式
        int[] dp = new int[nums.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= nums.length(); i++) {
            // 当前字符前两位可以翻译为一个字母，则可以选择将前一位翻译为单个字母或前两位翻译为单个字母
            if ((nums.charAt(i - 2) == '1' && nums.charAt(i - 1) != '0') ||
                    (nums.charAt(i - 2) == '2' && nums.charAt(i - 1) > '0' &&
                            nums.charAt(i - 1) < '7')) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];  // 只能选择将前一位翻译为单个字母
            }
        }
        return dp[nums.length()];
    }
}
