package leetcode;


import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class A026_removeDuplicatesFromSortedArray {
	public static void main(String[] args) {
		int[] tem = new int[100000];
		for (int i = 0; i < tem.length; i++) {
			tem[i] = (int) Math.round((Math.random()*100000000));
		}
		Arrays.sort(tem);
		
//		int[] x = {1,1,2,2,2,3,3,3,4,4,4,4,4};
		int[] x = Arrays.copyOf(tem, tem.length);
//		int[] nums = {1,1,2,2,2,3,3,3,4,4,4};
		int[] nums = Arrays.copyOf(tem, tem.length);
		
		
//		long start1 = System.nanoTime();
		long start1 = System.currentTimeMillis();
		int len = RemoveDuplicates(x);
		System.out.println(len);
//		for (int i = 0; i <len ; i++) {
//			System.out.print(x[i] + " ");
//		}
//		long finish1 = System.nanoTime();
		long finish1 = System.currentTimeMillis();
		System.out.println("\n"+(finish1 - start1));
		
		System.out.println("***********************************");
		
//		long start2 = System.nanoTime();
		long start2 = System.currentTimeMillis();
		int len1 = removeDuplicates(nums);
		System.out.println(len1);
//		for (int i = 0; i <len1 ; i++) {
//			System.out.print(nums[i] + " ");
//		}
//		long finish2 = System.nanoTime();
		long finish2 = System.currentTimeMillis();
		System.out.println("\n"+(finish2 - start2));
		
		

		
	}
	
	public static int RemoveDuplicates(int[] x) {
		Set<Integer> se = new HashSet<>();
		int count = 0;
		for (int i = 0; i < x.length; i++) {
			if(se.add(x[i])) {
				se.add(x[i]);
				x[count] = x[i];
				count++;
			}
		}
		return se.size();
	}
	
	public static int removeDuplicates(int[] nums) {
	    if (nums.length == 0) return 0;
	    int i = 0;
	    for (int j = 1; j < nums.length; j++) {
	        if (nums[j] != nums[i]) {
	            i++;
	            nums[i] = nums[j];
	        }
	    }
	    return i + 1;
	}
	
	
	
}
