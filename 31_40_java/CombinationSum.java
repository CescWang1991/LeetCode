import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Combination Sum:
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target. The same repeated number may be chosen from
 * candidates unlimited number of times.
 *
 * Combination Sum II:
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in
 * candidates where the candidate numbers sums to target.Each number in candidates may only be used once in the combination.
 */
public class CombinationSum {

    public static void main(String[] args){
        int[] candidates = new int[]{2, 3, 5};
        int target = 8;
        System.out.println(Arrays.toString(new CombinationSum().combinationSum(candidates, target).toArray()));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();

        for(int i = 0; i < candidates.length; i++){
            if(candidates[i] == target){
                List<Integer> list = new ArrayList<Integer>();
                list.add(candidates[i]);
                lists.add(list);
            } else {
                if(target - candidates[i] > 0){
                    List<List<Integer>> sub = combinationSum(candidates, target - candidates[i]);
                    if(!sub.isEmpty()){
                        for(int j = 0; j< sub.size(); j++){
                            sub.get(j).add(candidates[i]);
                            lists.add(sub.get(j));
                        }
                    }
                }
            }
        }
        lists.forEach(list -> list.sort(Comparator.naturalOrder()));

        return lists.stream().distinct().collect(Collectors.toList());
    }
}
