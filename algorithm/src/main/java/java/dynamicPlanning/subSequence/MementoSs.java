package java.dynamicPlanning.subSequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 *
 * @author payno
 * @date 2020/07/05
 */
public class MementoSs implements Subsequence{

    Subsequence subsequence;
    String mementoSource;
    Map<String,int[]> memento = new HashMap<>();

    public MementoSs(Subsequence subsequence,String mementoSource) {
        super();
        this.subsequence = Objects.requireNonNull(subsequence);
        this.mementoSource = Objects.requireNonNull(mementoSource);
        for (int i = mementoSource.length()-1; i >= 0; i--) {
            String baseSubSequence = Character.toString(mementoSource.charAt(i));
            int [] indexs = memento.get(baseSubSequence);
            if(indexs==null){
                memento.put(baseSubSequence,new int[]{i});
            }else{
                int [] newIndexs = Arrays.copyOf(indexs,indexs.length+1);
                newIndexs[indexs.length] = i;
                memento.put(baseSubSequence, newIndexs);
            }
        }
    }

    @Override
    public boolean exist(String source, String sub) {
        return mementoSource.equals(source)?existMemento(sub):subsequence.exist(source, sub);
    }

    private boolean existMemento(String sub){
        if(sub.length()==1){
            return memento.get(sub)!=null;
        }
        for (int i = 1; i < sub.length(); i++) {
            String preSub = sub.substring(0,i);
            String endChar = Character.toString(sub.charAt(i));
            int [] preSubIndexs = memento.get(preSub);
            int [] newCharIndexs = memento.get(endChar);
            if(preSubIndexs==null||newCharIndexs==null){
                return false;
            }else{
                int target = preSubIndexs[preSubIndexs.length-1];
                int low=0,high=newCharIndexs.length-1,mid;
                while (low<=high){
                    mid = (low+high)>>>1;
                    if (newCharIndexs[mid]<target){
                        low = mid +1;
                    }else if(newCharIndexs[mid]>target){
                        if(low == high){
                            break;
                        }else{
                            high = mid;
                        }
                    }else{
                        low = mid;
                        break;
                    }
                }
                if(low<=high){
                    memento.put(sub.substring(0,i+1),new int[]{low});
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}
