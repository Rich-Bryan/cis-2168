import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums , int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)){
                return new int[] {map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return null ;
    }

    public static void main(String[] args) {
        TwoSum answer = new TwoSum();
        int[] a = {2,7,11,15};
        int target = 9;

        System.out.println(Arrays.toString(answer.twoSum(a,target)));

        a = new int[] {2,1,6};
        target = 8;
        System.out.println(Arrays.toString(answer.twoSum(a,target)));
    }
}
