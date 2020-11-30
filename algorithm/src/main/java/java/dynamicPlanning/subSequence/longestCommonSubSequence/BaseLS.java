package java.dynamicPlanning.subSequence.longestCommonSubSequence;

import com.google.common.collect.Lists;
import com.google.common.collect.Streams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 基本的ls
 *
 * @author payno
 * @date 2020/07/05
 */
public class BaseLS implements LongestCommonSubsequence {

    Integer hash(int x,int y,int base){
        return Integer.valueOf(x*base + y);
    }

    @Override

    public int[][] of(String str1, String str2) {
        int base = str1.length()+str2.length();
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        Map<Integer,List<char[]>> lcs = new HashMap<>();
        for (int i = 0; i < str1.length()+1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 1; j < str2.length()+1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i < str1.length()+1; i++) {
            for (int j=1; j< str2.length()+1;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    List<char[]> pre = lcs.get(hash(i-1,j-1,base));
                    final char newChar = str1.charAt(i-1);
                    if(pre==null){
                        lcs.put(hash(i,j,base),Lists.newArrayList(new char[]{newChar}));
                    }else{
                        lcs.put(hash(i,j,base),pre.stream().map(oldChars->{
                            char[] newChars = Arrays.copyOf(oldChars,oldChars.length+1);
                            newChars[oldChars.length] = newChar;
                            return newChars;
                        }).collect(Collectors.toList()));
                    }
                }else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                    final int longestLength = dp[i][j];
                    if(dp[i][j-1]>dp[i-1][j]){
                        lcs.put(hash(i,j,base), lcs.get(hash(i,j-1,base)));
                    }else if(dp[i][j-1]<dp[i-1][j]){
                        lcs.put(hash(i,j,base), lcs.get(hash(i-1,j,base)));
                    }else if(dp[i][j-1]==dp[i-1][j]){
                        List<char []> preA = lcs.get(hash(i-1,j,base));
                        List<char []> preB = lcs.get(hash(i,j-1,base));
                        if(preA!=null||preB!=null){
                            lcs.put(hash(i,j,base), Streams.concat(
                                    lcs.get(hash(i-1,j,base)).stream(),
                                    lcs.get(hash(i,j-1,base)).stream()
                            ).distinct().filter(chars -> chars.length==longestLength).collect(Collectors.toList()));
                        }else{
                            lcs.put(hash(i,j,base),preA==null?preB:preA);
                        }
                    }
                }
            }
        }
        lcs.get(hash(str1.length(),str2.length(),base)).stream().forEach(chars->{
            System.err.println();
            for (int i = 0; i < chars.length; i++) {
                System.err.print(chars[i]);
            }
        });
        return dp;
    }
}
