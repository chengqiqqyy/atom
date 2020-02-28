package leetcode;

public class A008_StringToInteger {
	public static void main(String[] args) {
		
	}
	
	public static int myAtoi(String str) {
		// 1ms
        boolean isNonWhitespaceCharacterExpected = false, isPositiveNumber = true;
        int number = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                isNonWhitespaceCharacterExpected = true;
                final int digit = str.charAt(i) - '0';
                if ((Integer.MAX_VALUE - digit) / 10 < number) {
                    return isPositiveNumber ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                number *= 10;
                number += digit;
            } else if (!isNonWhitespaceCharacterExpected && str.charAt(i) == '+') {
                isNonWhitespaceCharacterExpected = true;
                isPositiveNumber = true;
            } else if (!isNonWhitespaceCharacterExpected && str.charAt(i) == '-') {
                isNonWhitespaceCharacterExpected = true;
                isPositiveNumber = false;
            } else if (isNonWhitespaceCharacterExpected || str.charAt(i) != ' ') {
                break;
            }
        }
        return isPositiveNumber ? number : -number;
    }
}
