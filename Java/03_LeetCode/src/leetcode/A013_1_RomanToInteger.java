package leetcode;

import java.util.HashMap;
import java.util.Map;

public class A013_1_RomanToInteger {
	public static void main(String[] args) {
		//I:1, V:5, X:10, L:50, C:100, D:500, M:1000
		Map<String,Integer> roman = new HashMap<>();
		roman.put("I", 1);
		roman.put("V", 5);
		roman.put("X", 10);
		roman.put("L", 50);
		roman.put("C", 100);
		roman.put("D", 500);
		roman.put("M", 1000);
		
		String[] str = {"III","IV","IX","LVIII","MCMXCIV"};
		
		for (String string : str) {
			System.out.println(romanToInt(string, roman));
			System.out.println(romanToInt(string));
			System.out.println(romanToInt2(string));
		}
		
		
	}
	
	public static int romanToInt(String s,Map<String,Integer> roman) {
		int ret = 0;
		String[] ro = s.split("");

		for (int i = 0; i < ro.length; i++) {
			if(i == 0) {
				ret += roman.get(ro[i]);
			}else {
				if(roman.get(ro[i-1]) < roman.get(ro[i])) {
					ret = ret + roman.get(ro[i]) - roman.get(ro[i-1])*2;
				}else {
					ret += roman.get(ro[i]);
				}
			}
			
		}
		
		return ret;
	}
	
	
	public static int romanToInt(String s) {
		int ret = 0;
		String[] ro = s.split("");
		
		for (int i = 0; i < ro.length; i++) {
			String be = ro[i];
			String af = "";
			if(i == ro.length-1) {
				af = "";
			}else {
				af = ro[i+1];
			}
			if(be.equals("I")) {
				ret += af.equals("V") || af.equals("X") ? -1 : 1;
			}else if(be.equals("X")) {
				ret += af.equals("L") || af.equals("C") ? -10 : 10;
			}else if(be.equals("C")) {
				ret += af.equals("D") || af.equals("M") ? -100 : 100;
			}else if(be.equals("V")) {
				ret += 5;
			}else if(be.equals("L")) {
				ret += 50;
			}else if(be.equals("D")) {
				ret += 500;
			}else if(be.equals("M")) {
				ret += 1000;
			}
		}
		
		return ret;
	}
	
	public static int romanToInt2(String s) {
		int ret = 0;
		
		for (int i = 0; i < s.length(); i++) {
			char be = s.charAt(i);
			char af = 'Z';
			if(i == s.length()-1) {
				af = 'Z';
			}else {
				af = s.charAt(i+1);
			}
			if(be == 'I') {
				ret += af == 'V' || af == 'X' ? -1 : 1;
			}else if(be == 'X') {
				ret += af == 'L' || af == 'C' ? -10 : 10;
			}else if(be == 'C') {
				ret += af == 'D' || af == 'M' ? -100 : 100;
			}else if(be == 'V') {
				ret += 5;
			}else if(be == 'L') {
				ret += 50;
			}else if(be == 'D') {
				ret += 500;
			}else if(be == 'M') {
				ret += 1000;
			}
		}
		
		return ret;
	}
	
	
}
