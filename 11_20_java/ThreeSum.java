import java.util.*;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets
 * in the array which gives the sum of zero.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j){
                    int complement = 0 - nums[i] - nums[j];
                    if(map.containsKey(complement) && map.get(complement) != i && map.get(complement) != j){
                        List<Integer> numList = Arrays.asList(nums[i], nums[j], complement);
                        Collections.sort(numList);
                        if(!list.contains(numList)){ list.add(numList); }
                    }
                }
            }
        }
        return list;
    }
}
