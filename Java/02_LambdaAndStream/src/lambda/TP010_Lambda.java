package lambda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import bean.User;



public class TP010_Lambda {
	@Test
	public void testIterate() {
		System.out.println("\n********************* Iterate *********************");
		Stream.iterate(0, i -> i).limit(5).forEach(System.out::print);
		Stream.iterate(0, i -> i += 1).limit(5).forEach(System.out::print);
		System.out.println("\n********************* Iterate *********************");
	}
	
	@Test
	public void testRange() {
		System.out.println("\n********************* Range *********************");
		// startInclusive(int) must be larger than endExclusive(int)
		// It's produced like a for loop : for (int i = startInclusive; i < endExclusive ; i++) { ... }
		IntStream.range(3, 1).forEach(System.out::print);
		System.out.println("\n********************* Range *********************");
	}
	
	@Test
	public void testOptionalInt() {
		System.out.println("********************* OptionalInt *********************");
		// int can't "==" to null
//		OptionalInt.empty().getAsInt() == null;
		OptionalInt oi = OptionalInt.of(0);
		System.out.println(oi.getAsInt() == 0);
		System.out.println("********************* OptionalInt *********************");
	}
	
	@Test
	public void testOptional() {
		System.out.println("********************* Optional *********************");
		List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");
		list.add("c");
		
		Optional<String> opstr = list.stream().sorted().findFirst();
		System.out.println(opstr.get());
		System.out.println("********************* Optional *********************");
	}
	
	@Test
	public void testGenerate() {
		System.out.println("********************* Generate *********************");
		Stream.generate(() -> 0).limit(5).forEach(System.out::println);
		Stream.generate(() -> 4).limit(5).forEach(System.out::println);
		System.out.println("********************* Generate *********************");
	}
	
	@Test
	public void testSupplier() {
		System.out.println("********************* Supplier *********************");
		Supplier<String> sp = () -> String.valueOf("fuck");
		Supplier<String> sp1 = () -> "fuck";
		System.out.println(sp.get());
		System.out.println(sp1.get());
		System.out.println("********************* Supplier *********************");
	}

		
	@Test
	public void testForEach() {
		System.out.println("********************* ForEach *********************");
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		list.stream().forEach(System.out::println);
		System.out.println("********************* ForEach *********************");
	}
	
	@Test
	public void testConsumer() {
		System.out.println("********************* Consumer *********************");
		Consumer<String> co = x -> x.substring(0,2);
		String x = "fuck";
		co.accept(x);
		System.out.println(x);
		System.out.println("********************* Consumer *********************");
	}
	
	@Test
	public void testStream() {
		// n注意执行顺序
		Stream<String> s = Stream.of("apple","banana","cherry","dargon fruit")
								 .filter(f -> f.length()>5)
								 .peek(System.out::println)
								 .map(f -> f.toUpperCase())
								 .peek(System.out::println);
		System.out.println(s.count());
	}
	
	@Test
	public void testStream2() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		float a = 3.0f / 10;
		System.out.println(a);
		
		Stream<Integer> is = list.stream();
		is.filter(n -> n > 1).forEach(n -> System.out.println(n));
		
		int i = 1;
		System.out.println((++i)+(++i));
	}
	
	@Test
	public void testStreamA() {
		List<User> userList = Arrays.asList(new User("Anna",22,"Femal"),new User("Bom", 19, "Man"),new User("Carl", 30, "Man"),new User("Danny", 25, "Man"));
		int totalAge = userList.stream().reduce(0, (sum,u) -> sum + u.getAge(), Integer::sum);
		System.out.println(totalAge);
	}
	
	@Test
	public void testLong() {
		long num = 10;
		num += (int)num * 2;
		num = 2l;
		System.out.println(num == 2);
		Long num2 = 1l;
		num2.intValue();
		
		System.out.println("Byte min:" + Byte.MIN_VALUE + "\t\t\tByte max:" + Byte.MAX_VALUE);
		System.out.println("Short min:" + Short.MIN_VALUE + "\t\tShort max:" + Short.MAX_VALUE);
		System.out.println("Integer min:" + Integer.MIN_VALUE + "\t\tInteger max:" + Integer.MAX_VALUE);
		System.out.println("Long min:" + Long.MIN_VALUE + "	Long max:" + Long.MAX_VALUE);
		System.out.println("Double min:" + Double.MIN_VALUE + "\t\tDouble max:" + Double.MAX_VALUE);
		System.out.println("Float min:" + Float.MIN_VALUE + "\t\tFloat max:" + Float.MAX_VALUE);
		
		int a = 1,b = 1;
		System.out.println(a + b == 2);
		System.out.println(a += b++);
		
	}
	
	@Test
	public void testa() {
		Map<String, String> map = new HashMap<>();
		
		map.put("A", "a");
		map.compute("A", (s1,s2) -> s1.toLowerCase());
		map.computeIfAbsent("B", s -> s.toLowerCase());
		map.computeIfPresent("A", (s1,s2) -> s1.toLowerCase());
		
		System.out.println(map);
		
		
	}
	
	@Test
	public void strRepate() {
		List<String> list = Arrays.asList("","s","ss","sb","sef","sjkdjsk","sssjjkljdjflssss","pwwkew","abcabcbb","abcabcbb");
		long start1 = System.currentTimeMillis();
		list.stream().forEach(s -> System.out.println(strRe(s)));
		long finish1 = System.currentTimeMillis();
		
		System.out.println("=============================================");
		
		long start2 = System.currentTimeMillis();
		list.stream().forEach(s -> System.out.println(strRep(s)));
		long finish2 = System.currentTimeMillis();

		System.out.println("Time: " + (finish1 - start1));
		System.out.println("Time: " + (finish2 - start2));
	}
	
	public static int strRe(String s) {
		if(s.length() < 2) return s.length();
		int count = 1, cal = 1, index = 1, len = s.length();
		String to = "";
		StringBuffer sb = new StringBuffer();
		sb.append(s.charAt(0));
		while(index < len) {
			to = String.valueOf(s.charAt(index));
			if(sb.indexOf(to) != -1) {
				count = count < cal ? cal : count;
				if(sb.indexOf(to)+1 < sb.length()) {
					sb.replace(0, sb.length(), sb.substring(sb.indexOf(to)+1));
					cal = sb.length()+1;
				}else {
					sb.delete(0, sb.length());
					cal = 1;
				}
			}else {
				cal++;
			}
			sb.append(s.charAt(index));
			index++;
		}
		return count < cal ? cal : count;
	}
	
	public static int strRep(String s) {
		if(s.length() < 2) return s.length();
		int count = 1, cal = 1, start = 0, index = 1, len = s.length();
		String to = "";
		StringBuffer sb = new StringBuffer();
		sb.append(s.charAt(0));
		while(index < len) {
			to = String.valueOf(s.charAt(index));
			if(sb.lastIndexOf(to) != -1 && sb.lastIndexOf(to) >= start) {
				count = count < cal ? cal : count;
				start = sb.lastIndexOf(to) + 1;
				cal = sb.length() - start + 1;
			}else {
				cal++;
			}
			sb.append(s.charAt(index));
			index++;
		}
		return count < cal ? cal : count;
	}
	
	@Test
	public void testLocalDate() {
		LocalDateTime ldt = LocalDateTime.of(2020, 3, 3, 3, 3);
		ldt = ldt.plusMonths(2);
		ldt = ldt.minusDays(-16);
		System.out.println(ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		
		String[] s = {"a","b","c","d"};
		List<String> sList = new ArrayList<>(Arrays.asList(s));
		List<String> tList = Arrays.asList(s);
		List<String> cList = Arrays.asList(s);
		sList.stream().forEach(System.out::println);
		tList.stream().forEach(System.out::println);
		System.out.println(sList == tList);
		System.out.println(cList == tList);
		
		int[] num1 = {1,2,3,4};
		int[] num2 = {5,6,7,8};
		int[][] num3 = {num1,num2};
		Stream<int[]> nList = Arrays.stream(num3);
		IntStream nlist = nList.flatMapToInt(x -> Arrays.stream(x));
		int[] num4 = nlist.toArray();
		double med = (num4.length & 1) == 1 ? num4[num4.length/2] : (num4[num4.length/2]+num4[num4.length/2-1])/2.0;
		System.out.println(med);
	}
	
	@Test
	public void testMedian() {
		int[] num1 = {1,3,5,9,11,15,19,22,26,36,45,55,78,99,123,132,145,165,189,199}, num2 = {2,15,22,26,31,35,45,65,99,105,222,333,444,555,666,777};
//		int[] num1 = {1,2}, num2 = {3,4};
		System.out.println(medianNum(num1, num2));
		System.out.println(medianNums(num1, num2));
	}
	
	public static double medianNum(int[] num1, int[] num2) {
		int[][] tem = {num1,num2};
		int[] num3 = Arrays.stream(tem).flatMapToInt(x -> Arrays.stream(x)).sorted().toArray();
		int len = num3.length;
		return (len & 1) == 1 ? num3[len/2] : (num3[len/2] + num3[len/2-1]) / 2.0;
	}
	
	public static double medianNums(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length, len3 = len1 + len2, mid = (len1+len2)/2, end = mid + 1, count = 0, i = 0, j = 0;
		int[] res = new int[end];
		
		while(i<len1 && j<len2 && count < end) {
			if(nums1[i] < nums2[j]) {
				res[count] = nums1[i];
				i++;
			}else {
				res[count] = nums2[j];
				j++;
			}
			count++;
		}
		
		if(i<len1 && count!=end) System.arraycopy(nums1, i, res, count, end-count);
		if(j<len2 && count!=end) System.arraycopy(nums2, j, res, count, end-count);
		
		return (len3&1) == 1 ? res[mid] : (res[mid]+res[mid-1])/2.0;
	}
	
	@Test
	public void testToInt() {
//		char[] a = {'0','1','2','3','4','5','6','7','8','9','-','+'};
//		char[] b = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
//		char[] c = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
//		char[] d = {'!',' ','@','#','$','%','^','&','*','(',')','_','-','+','=','~','`',',','<','.','>','/','?',';',':','\'','"','\\','|','[',']','{','}','*'};
//		for(char x : d) {
//			System.out.println(x + " => " + Character.getDirectionality(x));
//		}
		
		String[] sa = {"+","+46","6546484645648646","8","-128641514","-6546464465464645646456","      ","   5555","+      555","words and 987"};
		
		for(String s : sa) {
			System.out.println(sToInt2(s));
		}
	}
	
	public static int sToInt(String s) {
		s = s.trim();
		s = s.replaceAll(" ", "x");
		if(s.equals("")) return 0;
		int len = s.length();
		if(len == 1) {
			if(Character.getDirectionality(s.charAt(0)) != 3) return 0;
			else return Integer.parseInt(s);
		}
		if(Character.getDirectionality(s.charAt(0)) != 3 && Character.getDirectionality(s.charAt(0)) != 4) return 0;
		if(Character.getDirectionality(s.charAt(0)) == 4 && Character.getDirectionality(s.charAt(1)) != 3) return 0;
		boolean flag = false;
		if(s.charAt(0) == '+') s = s.substring(1);
		if(s.charAt(0) == '-') {
			flag = !flag;
			s = s.substring(1);
		}
		
		int count = 0, ret;
		len = s.length();
		for(int i=0; i<len; i++) {
			if(Character.getDirectionality(s.charAt(i)) != 3) break;
			count++;
		}
		
		if(flag && s.substring(0, count).equals("2147483648")) return -2147483648;
		
		try {
			ret = Integer.parseInt(s.substring(0, count));
		} catch (Exception e) {
			return flag ? -2147483648 : 2147483647;
		}
		
		return flag ? -ret : ret;
	}
	
	
	public static int sToInt2(String s) {
		s = s.trim();
		if(s == null ||  s.length() == 0) return 0;
		int i = 0, first = 0, count = 0, len = s.length();
		boolean flag = false;
		if(s.charAt(0) == '-') {
			i++;
			flag = !flag;
		}
		if(s.charAt(0) == '+') {
			i++;
		}
		
		while(i<len) {
			if(!Character.isDigit(s.charAt(i))) break;
			i++;
			count++;
		}
		
		if(count == 0) return 0;
		
		try {
			Integer.parseInt(s.substring(first, count));
		} catch (Exception e) {
			return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		
		return flag ? -(Integer.parseInt(s.substring(first, count))) : Integer.parseInt(s.substring(first, count)); 
	}
	
	@Test
	public void testString() {
		String s = "  ";
		System.out.println("[" + s.substring(s.lastIndexOf(" ")+1, s.length()) + "]");
		System.out.println(s.substring(s.lastIndexOf(" ")+1, s.length()).length());
		System.out.println(s.trim().equals(""));
	}
	
	@Test
	public void testReverse() {
		int[] n = {-2147483648,2147483647,234,-123};
		for(int x : n) {
//			System.out.println(rever(x));
//			System.out.println(revers(x));
			System.out.println(reveri(x));
		}
	}
	
	public static int rever(int num) {
		int flag = 1;
		if(num<0) flag = -1;
		StringBuffer sb = new StringBuffer(num*flag+"");
		try {
			return Integer.parseInt(sb.reverse().toString()) * flag;
		} catch (Exception e) {
			return 0;
		}
	}
	
	public static int revers(int num) {
		int ret = 0, max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
		boolean flag =true;
		if(num<0) flag = !flag;
		
		if(flag) {
			while(num!=0) {
				if(ret > max/10) return 0;
				ret = ret*10 + num%10;
				num /= 10;
			}
			return ret;
		}
		
		while(num!=0) {
			if(-ret < min/10) return 0;
			ret = ret*10 - num%10;
			num /= 10;
		}
		return -ret;
	}
	
	public static int reveri(int x) {
		long ret = 0;
		
		while(x != 0) {
			ret = ret*10 + x%10;
			x /= 10;
		}
		
		if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) return 0;
		
		return (int)ret;
		
	}
	
	@Test
	public void testPre() {
		String[] strs = {};
		System.out.println("[" + pre(strs) + "]");
	}
	
	public static String pre(String[] strs) {
		if(strs.length == 0) return "";
		char[] first = strs[0].toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < first.length; i++) {
			for(int j = 0; j < strs.length; j++) {
				if(i >= strs[j].length()) return sb.toString();
				if(first[i] == strs[j].charAt(i)) continue;
				return sb.toString();
			}
			sb.append(first[i]);
		}
		return sb.toString();
	}
	
	@Test
	public void testRemoveNum() {
		
	}
	
	public static int remove(int[] nums) {
		if(nums.length < 2) return nums.length;
		int index = 0;
		
		for(int i = 1; i < nums.length; i++) {
			if(nums[index] == nums[i]) continue;
			index++;
			nums[index] = nums[i];
		}
		
		return index + 1;
	}
	
	@Test
	public void testStr() {
		for(int n=1; n<31; n++) System.out.println(n + "=>" + countSay(n));
//		System.out.println("2 => " + countSay(2));
	}
	
	public static String countSay(int n) {
		 if(n==1) return "1";
		String s = "1";
		StringBuffer sb = new StringBuffer();
		while(n>1) {
			int count = 1;
            for(int i=0; i<s.length()-1; i++) {
                if(s.charAt(i) == s.charAt(i+1)) {
                    count++;
                }else {
                    sb.append(count);
                    sb.append(s.charAt(i));
                    count = 1;
                }
            }
			sb.append(count);
			sb.append(s.charAt(s.length()-1));
			s = sb.toString();
			sb.delete(0, sb.length());
			n--;
		}
		return s;
	}
	
	public static String countSays(int n) {
		if(n==1) return "1";
		String s = "1";
		
		while(n>1) {
			s = countSayc(s);
			n--;
		}
		return s;
	}
	
	public static String countSayc(String s) {
		StringBuffer sb = new StringBuffer();
		int count = 1, len = s.length();
		char t = s.charAt(0);
		for(int i=1; i<len; i++) {
			if(t == s.charAt(i)) {
                count++;
            }else {
                sb.append(count).append(t);
                t = s.charAt(i);
                count = 1;
            }
		}
		
		sb.append(count).append(t);
		
		return sb.toString();
	}
	
	@Test
	public void testInt() {
		int[] a = {9,8,9};
		int[] b = plusInts(a);
		
		for(int n : b) System.out.println(n);
		
		
	}
	
	public static int[] plusInt(int[] a) {
		if(a.length == 0) return new int[] {1};
		int f = 0, temp = 0;
		for(int i=a.length-1; i>=0; i--) {
			if(i == a.length-1) a[i] += 1;
			temp = a[i] + f;
			a[i] = temp % 10; 
			f = temp / 10;
		}
		
		if(f == 1) {
			int[] ret = new int[a.length+1];
//			System.arraycopy(a, 0, ret, 1, a.length);
			ret[0] = f;
			return ret;
		};
		
		return a;
	}
	
	public static int[] plusInts(int[] a) {
		if(a.length == 0) return new int[] {1};
		int f = 1, temp = 0;
		for(int i=a.length-1; i>=0; i--) {
			temp = a[i] + f;
			a[i] = temp % 10; 
			f = temp / 10;
			if(f == 0) return a;
		}
		
		int[] ret = new int[a.length+1];
		ret[0] = f;
		return ret;
	}
	
	@Test
	public void testBinary() {
		String a = "11";
		int b = 3;
		System.out.println(Integer.toBinaryString(b));
	}
	
	
	
	@Test
	public void bottom() {
		System.out.println((int)'0');
		System.out.println('9');
		System.out.println((int)'a');
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.parseInt("+555"));
		System.out.println(Integer.parseInt("-555"));
		String s = null;
		System.out.println(s == null);
		
	}
}
