package leetcode;

import java.util.LinkedList;

public class A273_IntegerToEnglishWords {
	public static void main(String[] args) {
		System.out.println((long)(Math.pow(2, 32) - 1 ));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Long.MAX_VALUE);
		System.out.println(Boolean.valueOf("True") == true);
		LinkedList<Integer> a = new LinkedList<>();
		a.add(5);
		a.add(10);
		System.out.println(a.getFirst());
		System.out.println(a.set(0, 3));
		System.out.println(a.getFirst());
		
		ListNode b = new ListNode(1); 
		ListNode b1 = b;
		b1.next = new ListNode(2);
		b1 = b1.next;
		System.out.println(b.value + " " + b1.value);
		
		int[][][] c = {{{1,2},{3,4}},{{5,6},{7,8}}};
		System.out.println(c[0][0][0]);
		
		//new StringBuffer(int x);  x is the length of StringBuffer.
		StringBuffer sb = new StringBuffer(121);
		sb.append(121);
		System.out.println(sb.charAt(0) == sb.charAt(2));
		
	}
	
	public static String numToWords(int num) {
		return null;
	}
	
}



class ListNode {
	int value;
	ListNode next;
	ListNode(int x){ value = x; }
}