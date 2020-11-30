package java.dynamicPlanning.fibonacciSequence;

/**
 * 主要测试
 *
 * @author payno
 * @date 2020/07/04
 */
public class MainTest {

    public static void main(String[] args) {
        FibonacciSequence fib1= new BaseFibSeq();
        System.out.println(fib1.fib(15));
        FibonacciSequence fib2= new MementoFibSeq();
        System.out.println(fib2.fib(15));
        FibonacciSequence fib3= new IterationFibSeq();
        System.out.println(fib3.fib(15));
        FibonacciSequence fib4 = new IterationFibSeq2();
        System.out.println(fib4.fib(15));
    }
}
