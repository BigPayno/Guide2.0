package study.dynamicPlanning.chipCoins;

public class MainTest {
    public static void main(String[] args) {
        ChipCoins chipCoins = new BaseChipCoins();
        System.out.println(
                chipCoins.coinsChange(new int[]{1,2,5,10},25)
        );
    }
}
