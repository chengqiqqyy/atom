package leetcode;

public class A013_2_IntegerToRoman {
	public static void main(String[] args) {
		int[] nums = {3,4,9,58,1994,1400};
		
		for (int i : nums) {
			String str1 = integerToRoman(i);
			String str2 = integerToRomanSb(i);
			String str3 = intToRoman(i);
			String str4 = intToRoman2(i);
			System.out.println(str1);
			System.out.println(str2);
			System.out.println(str3);
			System.out.println(str4);
		}
		
	}
	
	public static String integerToRoman(int num) {
		String roman = "";
		
		while(num > 0) {
			if(num >= 1000) {
				num -= 1000;
				roman += "M";
				continue;
			}
			if(num >= 900) {
				num -= 900;
				roman += "CM";
				continue;
			}
			if(num >= 500) {
				num -= 500;
				roman += "D";
				continue;
			}
			if(num >= 400) {
				num -= 400;
				roman += "CD";
				continue;
			}
			if(num >= 100) {
				num -= 100;
				roman += "C";
				continue;
			}
			if(num >= 90) {
				num -= 90;
				roman += "XC";
				continue;
			}
			if(num >= 50) {
				num -= 50;
				roman += "L";
				continue;
			}
			if(num >= 40) {
				num -= 40;
				roman += "XL";
				continue;
			}
			if(num >= 10) {
				num -= 10;
				roman += "X";
				continue;
			}
			if(num >= 9) {
				num -= 9;
				roman += "IX";
				continue;
			}
			if(num >= 5) {
				num -= 5;
				roman += "V";
				continue;
			}
			if(num >= 4) {
				num -= 4;
				roman += "IV";
				continue;
			}
			if(num >= 1) {
				num -= 1;
				roman += "I";
				continue;
			}
		}
		
		return roman;
	}
	
	public static String integerToRomanSb(int num) {
		StringBuffer sb = new StringBuffer();
		
		while(num > 0) {
			if(num >= 1000) {
				num -= 1000;
				sb.append("M");
				continue;
			}
			if(num >= 900) {
				num -= 900;
				sb.append("CM");
				continue;
			}
			if(num >= 500) {
				num -= 500;
				sb.append("D");
				continue;
			}
			if(num >= 400) {
				num -= 400;
				sb.append("CD");
				continue;
			}
			if(num >= 100) {
				num -= 100;
				sb.append("C");
				continue;
			}
			if(num >= 90) {
				num -= 90;
				sb.append("XC");
				continue;
			}
			if(num >= 50) {
				num -= 50;
				sb.append("L");
				continue;
			}
			if(num >= 40) {
				num -= 40;
				sb.append("XL");
				continue;
			}
			if(num >= 10) {
				num -= 10;
				sb.append("X");
				continue;
			}
			if(num >= 9) {
				num -= 9;
				sb.append("IX");
				continue;
			}
			if(num >= 5) {
				num -= 5;
				sb.append("V");
				continue;
			}
			if(num >= 4) {
				num -= 4;
				sb.append("IV");
				continue;
			}
			if(num >= 1) {
				num -= 1;
				sb.append("I");
				continue;
			}
		}
		
		return sb.toString();
	}

	public static String intToRoman(int num) {
        if (num <= 0) return null;
        
        StringBuilder roman = new StringBuilder();
        int place = 0;
        for(; num > 0; num /= 10)
            roman.insert(0, romanOf(num%10, place++) );
        
        return roman.toString();
    }
	
	public static String intToRoman2(int num) {
        if (num <= 0) return null;
        
        StringBuilder roman = new StringBuilder();
        int place = 0;
        for(; num > 0; num /= 10) {
        	StringBuilder roman2 = new StringBuilder();
        	String oneDigit = "";
            String fiveDigit = "";
            String tenDigit = "";
            int digit = num%10;
            
            switch(place) {
                case 0:
                    oneDigit = "I";
                    fiveDigit = "V";
                    tenDigit = "X";
                    break;
                case 1:
                    oneDigit = "X";
                    fiveDigit = "L";
                    tenDigit = "C";
                    break;
                case 2:
                    oneDigit = "C";
                    fiveDigit = "D";
                    tenDigit = "M";
                    break;
                case 3:
                    oneDigit = "M";
                    break;
            }        
            
            if (digit <= 3) 
                for (int i=0; i<digit; i++) roman2.append(oneDigit);
            else if (digit == 4) 
                roman2.append(oneDigit + fiveDigit);
            else if (digit <= 8) {
                roman2.append(fiveDigit);
                for (int i=0; i<digit-5; i++) roman2.append(oneDigit);
            }
            else 
                roman2.append(oneDigit + tenDigit);
            
        	roman.insert(0, roman2.toString() );
        	place++;
        }
        
        return roman.toString();
    }
	
	private static String romanOf(int digit, int place) {
        StringBuilder roman = new StringBuilder();
        String oneDigit = "";
        String fiveDigit = "";
        String tenDigit = "";
        
        switch(place) {
            case 0:
                oneDigit = "I";
                fiveDigit = "V";
                tenDigit = "X";
                break;
            case 1:
                oneDigit = "X";
                fiveDigit = "L";
                tenDigit = "C";
                break;
            case 2:
                oneDigit = "C";
                fiveDigit = "D";
                tenDigit = "M";
                break;
            case 3:
                oneDigit = "M";
                break;
        }        
        
        if (digit <= 3) 
            for (int i=0; i<digit; i++) roman.append(oneDigit);
        else if (digit == 4) 
            roman.append(oneDigit + fiveDigit);
        else if (digit <= 8) {
            roman.append(fiveDigit);
            for (int i=0; i<digit-5; i++) roman.append(oneDigit);
        }
        else 
            roman.append(oneDigit + tenDigit);
        
        return roman.toString();
    }
}
