package study.dynamicPlanning.subSequence;

public class MainTest {
    public static void main(String[] args) {
        Subsequence subsequence = new BaseSs();
        System.out.println(subsequence.exist("abcdf","ade"));
        String source = "abcdefghijk";
        Subsequence subsequence1 = new MementoSs(subsequence,source);
        System.out.println(subsequence1.exist(source,"t"));
        System.out.println(subsequence1.exist(source,"abc"));
        System.out.println(subsequence1.exist(source,"abcgh"));
        System.out.println(subsequence1.exist(source,"abcghm"));
    }
}
