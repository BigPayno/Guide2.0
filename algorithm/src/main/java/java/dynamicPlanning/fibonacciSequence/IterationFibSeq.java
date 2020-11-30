package java.dynamicPlanning.fibonacciSequence;

/**
 * 迭代fib seq
 *
 * @author payno
 * @date 2020/07/04
 */
public class IterationFibSeq implements FibonacciSequence{

    /**
     * fib 迭代 自底向上
     *
     * @param n n
     * @return int
     */
    @Override
    public int fib(int n) {
        if(n==1||n==2){
            return 1;
        }else{
            int[] memento = new int[n+1];
            memento[1] = 1;
            memento[2] = 1;
            for (int i = 3; i < n+1; i++) {
                memento[i] = memento[i-1]+memento[i-2];
            }
            return memento[n];
        }
    }
}
