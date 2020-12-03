package study.dynamicPlanning.fibonacciSequence;

/**
 * 迭代fib seq2
 *
 * @author payno
 * @date 2020/07/04
 */
public class IterationFibSeq2 implements FibonacciSequence{
    @Override
    public int fib(int n) {
        if(n == 1 || n == 2){
            return 1;
        }else{
            int pre2 = 1,pre = 1,cur = -1;
            for (int i = 3; i < n+1; i++) {
                cur = pre + pre2;
                pre2 = pre;
                pre = cur;
            }
            return cur;
        }
    }
}
