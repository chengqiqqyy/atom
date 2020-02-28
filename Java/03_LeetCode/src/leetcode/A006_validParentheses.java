package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class A006_validParentheses {

	public static void main(String[] args) {
		String str = "()";
		String str1 = "{({()()})}{[]}";
		String str2 = "{]}";
		String str3 = "{}[][](())[[]]{[]()}";
		String str4 = "";
		String str5 = "{{";
		String str6 = "}{";

//		long start1 = System.nanoTime();
//		System.out.println(ValidParentheses(str));
//		System.out.println(ValidParentheses(str1));
//		System.out.println(ValidParentheses(str2));
//		System.out.println(ValidParentheses(str3));
//		System.out.println(ValidParentheses(str4));
//		System.out.println(ValidParentheses(str5));
//		System.out.println(ValidParentheses(str6));
//		long finish1 = System.nanoTime();
//		System.out.println(finish1 - start1);
//		System.out.print("\n*********************************************************\n\n");
		long start2 = System.nanoTime();
		System.out.println(isValid(str));
		System.out.println(isValid(str1));
		System.out.println(isValid(str2));
		System.out.println(isValid(str3));
		System.out.println(isValid(str4));
		System.out.println(isValid(str5));
		System.out.println(isValid(str6));
		long finish2 = System.nanoTime();
		System.out.println(finish2 - start2);
	}

	public static boolean ValidParentheses(String str) {
		if(str.length() == 0 || str.length() % 2 != 0) return false;
		String[] s = str.split("");
		String x = "{";
		String y = "[";
		String z = "(";
		Stack<String> st = new Stack<>();
		for (int i = 0; i < s.length; i++) {
			if(s[i].equals(x) || s[i].equals(y) || s[i].equals(z)) {
				st.push(s[i]);
			}else {
				if(st.lastElement().equals(x) && s[i].equals("}")) {
					st.pop();
					continue;
				}
				if(st.lastElement().equals(y) && s[i].equals("]")) {
					st.pop(); 
					continue;
				}
				if(st.lastElement().equals(z) && s[i].equals(")")) {
					st.pop(); 
					continue;
				}
				st.push(s[i]);
			}	
		}
		
		return st.isEmpty();
	}
	
	


	  public static boolean isValid(String s) {
		 // Hash table that takes care of the mappings.
		  HashMap<Character, Character> mappings = new HashMap<>();;
		  mappings.put(')', '(');
		  mappings.put('}', '{');
		  mappings.put(']', '[');
		  
	    // Initialize a stack to be used in the algorithm.
	    Stack<Character> stack = new Stack<Character>();

	    for (int i = 0; i < s.length(); i++) {
	      char c = s.charAt(i);

	      // If the current character is a closing bracket.
	      if (mappings.containsKey(c)) {

	        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
	        char topElement = stack.empty() ? '#' : stack.pop();

	        // If the mapping for this bracket doesn't match the stack's top element, return false.
	        if (topElement != mappings.get(c)) {
	          return false;
	        }
	      } else {
	        // If it was an opening bracket, push to the stack.
	        stack.push(c);
	      }
	    }

	    // If the stack still contains elements, then it is an invalid expression.
	    return stack.isEmpty();
	  }
	
	
}
