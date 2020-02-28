package leetcode;

public class A007_mergeTwoLists {

	public static void main(String[] args) {
		
		
	}
	
	public static A007_ListNode MergeTwoLists(A007_ListNode one, A007_ListNode two) {
		A007_ListNode res = new A007_ListNode(0);
		A007_ListNode current = res;
		
		if(one == null) return two;
		if(two == null) return one;
		
		while(one != null && two != null) {
			if(one.val <= two.val) {
				current.next = one;
				one = one.next;
			}else {
				current.next = two;
				two = two.next;
			}
			current = current.next;
		}
		
		while(one != null) {
			current.next = one;
			current = current.next;
			one = one.next;
		}
		
		while(two != null) {
			current.next = two;
			current = current.next;
			two = two.next;
		}
		
		return res.next;
	}
	
}
