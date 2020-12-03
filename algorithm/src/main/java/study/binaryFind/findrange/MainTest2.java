package study.binaryFind.findrange;

public class MainTest2 {

    private static void test(BinaryFind find,FindContext context){
        System.out.println(find.binaryFind(context));
    }

    public static void main(String[] args) {
        BinaryFind find = new FirstNumberBiggerThanFind();
        test(find,FindContext.of(new int[]{1,1,1,2,2,3},1,0,5));
        test(find,FindContext.of(new int[]{1,1,1,1,1,1,2,2,2,2,3},2,0,10));
        test(find,FindContext.of(new int[]{1,1,1,2,2,3},3,0,5));
    }
}
