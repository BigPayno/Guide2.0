package study.dynamicPlanning.chipCoins;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 深度优先
 *
 * @author payno
 * @date 2020/07/04
 */
public class BaseChipCoins implements ChipCoins{

    @Override
    public int coinsChange(int[] coins, int amount) {
        if (amount == 0){
            return 0;
        }else{
            Map<Integer,int[]> memento = new HashMap<>(amount);
            memento.put(Integer.valueOf(0),new int[0]);
            for(int curAmount = 1;curAmount < amount+1;curAmount++){
                int bestResult = Integer.MAX_VALUE;
                int[] curCoinsResult,bestCoinsResult;
                for (int curCoinIndex = 0; curCoinIndex < coins.length; curCoinIndex++) {
                    curCoinsResult = memento.get(curAmount-coins[curCoinIndex]);
                    if(curCoinsResult != null&&curCoinsResult.length<bestResult){
                        bestCoinsResult = Arrays.copyOf(curCoinsResult,curCoinsResult.length+1);
                        bestCoinsResult[curCoinsResult.length] = coins[curCoinIndex];
                        bestResult = curCoinsResult.length;
                        memento.put(Integer.valueOf(curAmount),bestCoinsResult);
                    }
                }
            }
            int[] result = memento.get(Integer.valueOf(amount));
            if(result==null){
                return -1;
            }else{
                IntStream.of(result).forEach(System.err::println);
                return result.length;
            }
        }
    }
}
