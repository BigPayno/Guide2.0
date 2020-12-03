package study.dynamicPlanning.fibonacciSequence;

/**
 * 备忘录fib seq
 *
 * @author payno
 * @date 2020/07/04
 */
public class MementoFibSeq implements FibonacciSequence{

    static int[] memento = new int[1024];

    static{
        memento[1]=1;
        memento[2]=1;
    }

    @Override
    public int fib(int n) {
        if(memento[n]!=0){
            return memento[n];
        }else{
            int result = fib(n-1)+fib(n-2);
            memento[n] = result;
            return result;
        }
    }
}
