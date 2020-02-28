package leetcode;

public class A002_reverseNum {
	public static void main(String[] args) {
		/*^
		 *  传入 -2^32 ~ 2^32-1 的整数，将整数反转，如果目标数超出范围，返回 0
		 *  Min : -2147483648 Max :2147483647
		 *  [123] => [321]
		 *  [110] => [11]
		 *  [-245] => [-542]
		 */
		System.out.println("Min : "+Integer.MIN_VALUE+" Max :"+Integer.MAX_VALUE);
		A002_reverseNum rn = new A002_reverseNum();
		int num = -2147;
		System.out.println((num+"").length());
		System.out.println(rn.reverse(num));
		System.out.println(rn.reverseNew(num));
		
	}
	
	public int reverse(int x) {
		int res = 0;
		while(x != 0) {
			int tem = x%10;
			x /= 10;
			res = res*10 + tem;			
		}
		return res;
	}
	
	public int reverseNew(int x) {
		StringBuilder sb = new StringBuilder();
		try {
			if(x >= 0) return Integer.parseInt(sb.append(x).reverse().toString());
			return -Integer.parseInt(sb.append(-x).reverse().toString());			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	
}
