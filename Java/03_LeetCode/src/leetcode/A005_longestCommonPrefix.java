package leetcode;

public class A005_longestCommonPrefix {

	public static void main(String[] args) {
		String[] str = {"apple","anna","abosed","append"};
		String[] str1 = {"apple","applepen","applepine","append"};
		String[] str2 = {"apple","applepen","applepine"};
		String[] str3 = {"applepen","apple","applepine","app"};
		String[] str4 = {};
		
		long start1 = System.nanoTime();
		System.out.println(LongestCommonPrefix(str));
		System.out.println(LongestCommonPrefix(str1));
		System.out.println(LongestCommonPrefix(str2));
		System.out.println(LongestCommonPrefix(str3));
		System.out.println(LongestCommonPrefix(str4));
		long finish1 = System.nanoTime();
		System.out.println(finish1 - start1);
		System.out.println("************************************************");
		
		long start2 = System.nanoTime();
		System.out.println(LongestCommonPrefixLeet(str));
		System.out.println(LongestCommonPrefixLeet(str1));
		System.out.println(LongestCommonPrefixLeet(str2));
		System.out.println(LongestCommonPrefixLeet(str3));
		System.out.println(LongestCommonPrefixLeet(str4));
		long finish2 = System.nanoTime();
		System.out.println(finish2 - start2);
	}

	
	public static String LongestCommonPrefix(String[] str) {
		if(str.length == 0) return "";
		String res = "";
		boolean flag = false;
		
		for (int i = 0; i < str[0].length(); i++) {
			String temp = str[0].substring(0, i+1);
			for (int j = 1; j < str.length; j++) {
				if(!str[j].contains(temp)) {
					flag = true;
					break;
				}
				if(j == str.length-1) res = temp;
			}
			if(flag) break;
		}
		return res;
	}
	
	
	public static String LongestCommonPrefixLeet(String[] str) {
		if(str.length == 0) return "";
		String res = str[0];
		for (int i = 1; i < str.length; i++) {
			while(str[i].indexOf(res) != 0) {
				res = res.substring(0, res.length()-1);
				if(res.isEmpty()) return "";
			}
		}
		return res;
	}
	
	
}
