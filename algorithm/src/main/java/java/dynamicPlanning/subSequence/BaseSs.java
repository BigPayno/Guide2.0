package java.dynamicPlanning.subSequence;

public class BaseSs implements Subsequence{

    @Override
    public boolean exist(String source, String sub) {
        int i=0,j=0;
        while(i<sub.length()&&j<source.length()){
            if(sub.charAt(i)==source.charAt(j)){
                i++;
            }
            j++;
        }
        return i==sub.length();
    }
}
