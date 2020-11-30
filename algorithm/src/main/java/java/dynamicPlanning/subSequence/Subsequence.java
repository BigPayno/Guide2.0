package java.dynamicPlanning.subSequence;

/**
 * 子序列
 *
 * @author payno
 * @date 2020/07/05
 */
public interface Subsequence {
    /**
     * 存在
     *
     * @param source str1
     * @param sub str2
     * @return boolean
     */
    boolean exist(String source,String sub);
}
