package study.dynamicPlanning.subSequence.longestCommonSubSequence;

/**
 * 最长的子序列
 *
 * @author payno
 * @date 2020/07/05
 */
public interface LongestCommonSubsequence {
    /**
     * 两个字符串的最长公共子序列
     *
     * @param str1 str1
     * @param str2 str2
     * @return {@link char[]}
     */
    int[][] of(String str1, String str2);
}
