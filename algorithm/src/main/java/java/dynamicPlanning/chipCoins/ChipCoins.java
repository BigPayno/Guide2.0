package java.dynamicPlanning.chipCoins;

/**
 * 芯片的变化
 *
 * @author payno
 * @date 2020/07/04
 */
public interface ChipCoins {
    /**
     * 硬币改变
     *
     * @param coins  硬币种类
     * @param amount 凑的总值
     * @return int
     */
    int coinsChange(int[] coins,int amount);
}
