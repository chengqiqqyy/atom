package leetcode;

import java.util.HashMap;
import java.util.Map;

public class A001_twoSum {
	public static void main(String[] args) {
		/*
		 * 传入整数数组，和目标总合(target)。寻找符合 x + y = target 的两个数，并以数组形式返回两个数的 index，无结果返回 [-1,-1]
		 * [14,7,17,3,6],10 => [1,3]
		 * [7,55,22,88,35,16],23 => [0,5]
		 * [13,25,4,13,2,7],55 => 0
		 */
		A001_twoSum ts = new A001_twoSum();
		int[] x = {25,4,66,78,4,45,55};
		int[] res = ts.twoSums(x, 100);
		for (int i : res) {
			System.out.println(i);
		}
		
	}
	
	public int[] twoSum(int[] x, int target) {
		int[] re = {-1,-1};
		Map<Integer,Integer> temp = new HashMap<>();
		for (int i = 0; i < x.length; i++) {
			int res = target - x[i];
			if(temp.containsKey(res)) {
				re[0] = temp.get(res);
				re[1] = i;
				return re;
			}
			temp.put(x[i]	, i);
		}
		return re;
	}
	
	public int[] twoSums(int[] nums, int target) {
        int[] res = {-1,-1};
        for(int i=0; i<nums.length-1; i++){
            for(int j = i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }
}
