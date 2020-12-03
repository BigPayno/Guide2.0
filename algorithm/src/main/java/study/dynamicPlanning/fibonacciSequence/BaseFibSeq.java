package study.dynamicPlanning.fibonacciSequence;

/**
 * 基本的FibSeq
 *
 * @author payno
 * @date 2020/07/04
 */
public class BaseFibSeq implements FibonacciSequence{
    /**
     * f(n)=f(n-1)+f(n-2)>2f(n-2)指数级别
     *
     * @param n n
     * @return int
     */
    @Override
    public int fib(int n) {
        if(n == 1|| n == 2){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }
}
