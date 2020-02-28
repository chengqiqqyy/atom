package leetcode;

public class A003_palindromeNumber {
	public static void main(String[] args) {
		
		long start1 = System.nanoTime();
		System.out.println(isPalindromeNum(123));
		System.out.println(isPalindromeNum(-123));
		System.out.println(isPalindromeNum(121));
		System.out.println(isPalindromeNum(1221));
		System.out.println(isPalindromeNum(12321));
		System.out.println(isPalindromeNum(-1223));
		System.out.println(isPalindromeNum(0));
		System.out.println(isPalindromeNum(2147483647));
		long finish1 = System.nanoTime();
		System.out.println(finish1-start1);
		
		
		System.out.println("*******************************************************");
		

		long start3 = System.nanoTime();
		System.out.println(IsPalindrome(123));
		System.out.println(IsPalindrome(-123));
		System.out.println(IsPalindrome(121));
		System.out.println(IsPalindrome(1221));
		System.out.println(IsPalindrome(12321));
		System.out.println(IsPalindrome(-1223));
		System.out.println(IsPalindrome(0));
		System.out.println(IsPalindrome(2147483647));
		long finish3 = System.nanoTime();
		System.out.println(finish3-start3);
		
/*		StringBuffer sb = new StringBuffer();
		String a = "123";
		String b = sb.append("123").toString();
		System.out.println(a == b);*/

		
	}
	
	
	public static boolean isPalindromeNum(int num) {
		if(num < 0) return false;
		StringBuilder sb = new StringBuilder();
		try {
			return num == Integer.parseInt(sb.append(num+"").reverse().toString());
		} catch (NumberFormatException e) {
			return false;
		}	
	}
	
	    public static boolean IsPalindrome(int x) {
	        // Special cases:
	        // As discussed above, when x < 0, x is not a palindrome.
	        // Also if the last digit of the number is 0, in order to be a palindrome,
	        // the first digit of the number also needs to be 0.
	        // Only 0 satisfy this property.
	        if(x < 0 || (x % 10 == 0 && x != 0)) {
	            return false;
	        }

	        int revertedNumber = 0;
	        while(x > revertedNumber) {
	            revertedNumber = revertedNumber * 10 + x % 10;
	            x /= 10;
	        }

	        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
	        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
	        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
	        return x == revertedNumber || x == revertedNumber/10;
	    }

	
	    
	    
	    
	    
}
