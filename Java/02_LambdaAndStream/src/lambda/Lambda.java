package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import bean.Apple;
import bean.Dish;
import bean.Dish.CaloriesLevel;
import bean.Dish.Type;
import functionalInterface.AppleFilter;
import functionalInterface.Greeting;

public class Lambda {
	
	@Test
	public void testEqualsIgnoreCase() {
		String[] str = {"red","blue","orange","black","red","white","black","blue","pink"};
		List<String> list = new ArrayList<>();
		for(String x : str) {
			if(!"red".equalsIgnoreCase(x)) continue;
			list.add(x);
			System.out.println(x);
		}			
	}
	
	@Test
	public void testLambda() {
		//Filter apple by color
		List<Apple> listApple = new ArrayList<>();
		String[] colors = {"red","blue","orange","black","red","white","black","blue","pink"};
		for(String color : colors) {
			listApple.add(new Apple(color));
		}
		
		List<Apple> afterFilterApple = filterApple(listApple, (apple) -> "blue".equalsIgnoreCase(apple.getColor()));
		for(Apple apple : afterFilterApple) {
			System.out.println(apple.getColor());
		}
	}
	/**
	 * @param listApple
	 * @param filter
	 * @return
	 */
	public static List<Apple> filterApple(List<Apple> listApple, AppleFilter filter){
		List<Apple> filterList = new ArrayList<>();
		for(Apple apple : listApple) {
			if(filter.appleFilter(apple)) filterList.add(apple);
		}
		return filterList;
	}
		
	@Test
	public void testPredicate() {
		Predicate<Integer> isEven = x -> x % 2 == 0;
		System.out.println(isEven.test(14));
		System.out.println(isEven.and(x -> x > 30).test(14));
		System.out.println(isEven.negate().test(14));
	}
	
	@Test
	public void testConsumer() {
		Consumer<Apple> printAppleColor = (a) -> System.out.print(a.getColor());		
		printAppleColor.accept(new Apple("Red"));
		System.out.println();
		printAppleColor.andThen((a) -> System.out.println(" is the apple's color.")).accept(new Apple("White"));
		
		Consumer<Apple> changeAppleColor = (a) -> a.setColor("Orange");
		Apple apple = new Apple("Red");
		printAppleColor.andThen((a) -> System.out.println(" is the apple's color.")).accept(apple);
		changeAppleColor.andThen((a) -> System.out.println("Apple's color has changed.")).accept(apple);
		printAppleColor.andThen((a) -> System.out.println(" is the apple's color.")).accept(apple);
		
	}
	
	@Test
	public void testSupplier() {
		Supplier<Apple> appleSupplier = Apple::new;
		Apple a = appleSupplier.get();
		a.setColor("Red");
		a.setWeight("1kg");
		
		Consumer<Apple> printAppeleInfo = (x) -> System.out.println("Apple's color is " + x.getColor() + " and weight is " + x.getWeight() + ".");
		printAppeleInfo.accept(a);
	}
	
	@Test
	public void testFunctions() {
		BiFunction<Apple, String, Apple> setAppleWeight = (Apple a, String b) -> { a.setWeight(b); return a; };
		Apple apple = setAppleWeight.apply(new Apple("Pink"), "1kg");
		System.out.println("Apple's color is " + apple.getColor() + " and weight is " + apple.getWeight() + "."); 
	}


	@Test
	public void testComparator() {
		List<String> strList = new ArrayList<>();
		strList.add("Apple");
		strList.add("Absort");
		strList.add("Cat");
		strList.add("Food");
		strList.add("Dog");
		
		strList.sort(String::compareTo);
		for (String str : strList) {
			System.out.println(str);
		}
		
		System.out.println("-----------------------------------------");
		
		Comparator<String> compare = (a,b) -> a.compareTo(b);
		strList.sort(compare.reversed());
		for (String str : strList) {
			System.out.println(str);
		}
	}
	
	@Test
	public void greeting() {
		Greeting greet = System.out::println;
		greet.greet("What the hell.");
	}
	
		/*
		 * 
		   *        操作		类型		返回类型			使用的类型/函数式接口			函数描述符
		 *	filter 		中间 		Stream<T> 		Predicate<T> 				T -> boolean 
		 *	distinct 	中间 		Stream<T>   
		 *	skip 		中间 		Stream<T> 		long  
		 *	limit 		中间 		Stream<T> 		long  
		 *	map 		中间 		Stream<R> 		Function<T, R> 				T -> R 
		 *	flatMap 	中间 		Stream<R> 		Function<T, Stream<R>> 		T -> Stream<R> 
		 *	sorted 		中间 		Stream<T> 		Comparator<T> 				(T, T) -> int 
		 *	anyMatch 	终端 		boolean 		Predicate<T> 				T -> boolean 
		 *	noneMatch 	终端 		boolean 		Predicate<T> 				T -> boolean 
		 *	allMatch 	终端 		boolean 		Predicate<T> 				T -> boolean 
		 *	findAny 	终端 		Optional<T>   
		 *	findFirst 	终端 		Optional<T>   
		 *	forEach 	终端 		void 			Consumer<T> 				T -> void 
		 *	collect 	终端 		R 				Collector<T, A, R>  
		 *	reduce 		终端 		Optional<T> 	BinaryOperator<T> 			(T, T) -> T 
		 *	count 		终端 		long   
		 */
	@Test
	public void testStreamBasic() {
		//Notice ： 数组没有stream()方法 需要用静态方法Arrays.stream(数组)方法来创建流
		//String[] str = {"Dog","Flower","home","computer","Apple","bottle","hair","clock","money"};
		List<String> strList = new ArrayList<>();
		strList.addAll(Arrays.asList("Dog","Flower","home","computer","Apple","bottle","hair","clock","money"));
		Collections.addAll(strList, "egg","Fire","dog","apple","keyboard","cat");
		strList.stream().map(x -> x.toUpperCase()).forEach(x -> System.out.print(x+" "));
		System.out.println();
		strList.stream().map(x -> x.toUpperCase()).sorted().forEach(x -> System.out.print(x+" "));
		System.out.println();
		strList.stream().map(x -> x.toUpperCase()).sorted().distinct().forEach(x -> System.out.print(x+" "));
		System.out.println();
		strList.stream().filter(x -> x.startsWith("a")).map(x -> x.toLowerCase()).sorted().forEach(x -> System.out.print(x+" "));
		System.out.println();
		//map(x.split(""))执行后，返回了Stream(String[])字符串数组流，所以打印的是数组的引用地址
		strList.stream().map(x -> x.split("")).forEach(x -> System.out.print("{"+x+"} ・ "));
		System.out.println();
		//map(Arrays::stream)执行后，将Stream(String[])转换为了Stream(String)[]字符串流数组，所以打印的是各个流的句柄
		strList.stream().map(x -> x.split("")).map(Arrays::stream).forEach(x -> System.out.print("{"+x+"} ・ "));
		System.out.println();
		//flatMap()可以使新流数组连接成一个流，flatMap(Arrays::stream)执行后，将Stream(String[])连接为Stream(String)流
		strList.stream().map(x -> x.split("")).flatMap(Arrays::stream).forEach(x -> System.out.print("{"+x+"} ・ "));
		System.out.println();
		strList.stream().filter(x -> x.length()>5).forEach(x -> System.out.print(x+" "));
		System.out.println();
		
		//000000000000000000000000000000000000000000  终端操作  000000000000000000000000000000000000000000
		//anyMatch 返回 boolean 类型
		System.out.println("strList中至少有一个元素是以'z'开头的 ："+strList.stream().anyMatch(x -> x.startsWith("z")));
		
		//allMatch 返回 boolean 类型
		System.out.println("strList中所有元素都包含'oo':"+strList.stream().allMatch(x -> x.contains("oo")));
		
		//noneMatch 返回 boolean 类型
		System.out.println("strList中没有一个元素的长度大于10 ："+strList.stream().noneMatch(x -> x.length()>10));
		
		//findAny findAny方法用于返回流中的任意元素的Optional类型，例如筛选出list中任意一个以c开头的元素，如果存在，则输出它 
		strList.stream().filter(x -> x.startsWith("c")).findAny().ifPresent(System.out::println);
		
		//findFirst findFirst方法用于返回流中的第一个元素的Optional类型，例如筛选出list中长度大于5的元素，如果存在，则输出第一个
		// findAny 和 findFirst 的区别目前的例子看不出来
		strList.stream().filter(x -> x.length()>5).findAny().ifPresent(System.out::println);
		strList.stream().filter(x -> x.length()>5).findFirst().ifPresent(System.out::println);
		
		//reduce reduce函数从字面上来看就是压缩，缩减的意思，它可以用于数字类型的流的求和，求最大值和最小值
		//Notice: 此方法声明List的为固定长度，之后再add元素时会保错
		List<Integer> numList = Arrays.asList(5,12,3,45,88,59,26,17,13,23); 
		System.out.println("numList求和 ："+numList.stream().reduce(0,Integer::sum));
		numList.stream().reduce(Integer::max).ifPresent(x -> System.out.println("numList最大值 ："+x));
		numList.stream().reduce(Integer::min).ifPresent(x -> System.out.println("numList最小值 ："+x));
		
		//count count方法用于统计流中元素的个数
		System.out.println("strList元素个数 ："+strList.stream().count());
		System.out.println("strList中以'c'开头的元素个数 ："+strList.stream().filter(x -> x.startsWith("c")).count());
		
		//collect collect方法用于收集流中的元素，并放到不同类型的结果中，比如List、Set或者Map
		// Collectors.toList  Collectors.toSet  Collectors.toMap
		List<String> filterStrList = strList.stream().filter(x -> x.length()>4).collect(Collectors.toList());
		filterStrList.stream().forEach(x -> System.out.print(x+" "));
		System.out.println();
		
		//000000000000000000000000000000000000000000  流的创建  000000000000000000000000000000000000000000
		// 1.数值范围构建
		// IntStream和LongStream对象支持range和rangeClosed方法来构建数值流。这两个方法都是第一个参数接受起始值，第二个参数接受结束值。但range是不包含结束值的，而
		// rangeClosed则包含结束值
		System.out.println("range:"+IntStream.range(0, 100).sum());
		System.out.println("rangeClosed:"+IntStream.rangeClosed(0, 100).sum());
		
		// 2.由值构建
		// Stream.of(静态方法)可以显式值创建一个流。它可以接受任意数量的参数
		Stream<String> s = Stream.of("Java","Javascript","Python");
		s.forEach(x -> System.out.print(x+" "));
		System.out.println();
		// Stream.empty可以构建一个空流
		Stream<Object> emptyStream = Stream.empty();
		emptyStream.close();
		
		// 3.由数组构建
		// Arrays.stream(静态方法)可以通过数组创建一个流。它接受一个数组作为参数
		String[] strArr = {"Java","Javascript","Python"};
		Stream<String> strStream = Arrays.stream(strArr);
		strStream.forEach(x -> System.out.print(x+" "));
		System.out.println();
		
		// 4.由函数构造
		// Stream API提供了两个静态方法来从函数生成流：Stream.iterate和Stream.generate。这两个操作可以创建所谓的无限流
		// iterate方法接受一个初始值（在这里是0），还有一个依次应用在每个产生的新值上的Lambda（UnaryOperator类型）。这里，我们使用Lambda n -> n + 2，返回的是前一个元 素加上2。因此，
		// iterate方法生成了一个所有正偶数的流：流的第一个元素是初始值0。然后加上2来生成新的值2，再加上2来得到新的值4，以此类推。
		Stream.iterate(0, x -> x+2).limit(10).forEach(x -> System.out.print(x+" "));
		System.out.println();
		// generate方法与iterate方法类似，也可让你按需生成一个无限流。但generate不是依次对每个新生成的值应用函数，比如下面的例子生成了5个0到1之间的随机双精度数
		Stream.generate(Math::random).limit(10).forEach(x -> System.out.print(x+" "));
		System.out.println();
		
		// 5.由文件生成流
		// java.nio.file.Files中的很多静态方法都会返回一个流。例如Files.lines方法会返回一个由指定文件中的各行构成的字符串流
		// E.g : 统计一个文件中共有多少个字
		long wordCount = 0L;
		try {
			Stream<String> lines = Files.lines(Paths.get("D:/Users/chengqi/Desktop/Work/2.xml"));
			wordCount = lines.map(x -> x.split("")).flatMap(Arrays::stream).count();
			System.out.println(wordCount);
			lines.close();
		} catch (IOException e) {
			System.out.println("Read file failed.");
		}
	}
	
	
	@Test
	public void testStreamCollect() {
		/*
		 * 1  创建 Dish(菜谱) 类
		 * 2  生成 Dish List
		 */
		List<Dish> dishList = new ArrayList<>();
		dishList.add(new Dish("pork", false, 800, Dish.Type.Meat));
		dishList.add(new Dish("beef", false, 700, Dish.Type.Meat));
		dishList.add(new Dish("chicken", false, 400, Dish.Type.Meat));
		dishList.add(new Dish("french fries", true, 530, Dish.Type.Other));
		dishList.add(new Dish("rice", true, 350, Dish.Type.Other));
		dishList.add(new Dish("season fruit", true, 120, Dish.Type.Other));
		dishList.add(new Dish("pizza", true, 550, Dish.Type.Other));
		dishList.add(new Dish("prawns", false, 300, Dish.Type.Fish));
		dishList.add(new Dish("salmon", false, 450, Dish.Type.Fish));
		
		/*
		 * 	# 规约与汇总
		 * 	1.最大值 最小值
		 *  2.汇总
		 *  3.拼接
		 *  4.reducing
		 */
		
		// 1.Maximum and Minimum 
		// 输出卡路里最高的菜品
		dishList.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))).ifPresent(System.out::println);
		
		// 2.汇总	
		// Collectors.summingInt可以用于求和，参数类型为int类型。相应的基本类型对应的方法还有Collectors.summingLong和Collectors.summingDouble
		int sumCalories = dishList.stream().collect(Collectors.summingInt(Dish::getCalories));
		System.out.println("Sum Calories : " + sumCalories);
		
		// Collectors.averagingInt方法用于求平均值，参数类型为int类型。相应的基本类型对应的方法还有Collectors.averagingLong和Collectors.averagingDouble
		Double avgCalories = dishList.stream().collect(Collectors.averagingInt(Dish::getCalories));
		System.out.println("Average Calories : " + avgCalories);
		
		// Collectors.summarizingInt方法可以一次性返回元素个数，最大值，最小值，平均值和总和。相应的summarizingLong和summarizingDouble方法有相关的
		// LongSummaryStatistics和DoubleSummaryStatistics类型
		IntSummaryStatistics summaryCalories = dishList.stream().collect(Collectors.summarizingInt(Dish::getCalories));
		System.out.println("Summary Calories : " + summaryCalories);
		
		// 3.拼接
		// Collectors.joining方法会把流中每一个对象应用toString方法得到的所有字符串连接成一个字符串
		String nameStr = dishList.stream().map(Dish::getName).collect(Collectors.joining());
		System.out.println("Dish Name joining : " + nameStr);
		nameStr = dishList.stream().map(Dish::getName).collect(Collectors.joining(","));
		System.out.println("Dish Name joining by ',' : " + nameStr);
		
		// 4.Reducing
		// Collectors.reducing方法可以实现求和，最大值最小值筛选，拼接等操作。上面介绍的方法在编程上更方便快捷，但reducing的可读性更高
		// 实际使用哪种我觉得还是看个人喜好
		// Max  Minimum
		int reduceInt1 = dishList.stream().collect(Collectors.reducing(0,Dish::getCalories,Integer::max));
		int reduceInt2 = dishList.stream().map(Dish::getCalories).collect(Collectors.reducing(0,Integer::max));
		System.out.println("reduceInt1 : " + reduceInt1 + "\nreduceInt2 : " + reduceInt2);
		
		
		/*
		 * # 分组
		 * 1.普通分组
		 * 2.多级分组
		 */
		
		// 1.普通分组
		// Collectors.groupingBy方法可以轻松的完成分组操作
		// Group by Type
		System.out.println("------------------------------------- Group by Type -------------------------------------");
		Map<Type, List<Dish>> groupByType = dishList.stream().collect(Collectors.groupingBy(Dish::getType));
		System.out.println(groupByType);
		groupByType.forEach((type,dish) -> System.out.println(type + " => " + dish.toString()));
		
		//Group by Calories
		System.out.println("------------------------------------- Group by Calories -------------------------------------");
		Map<CaloriesLevel, List<Dish>> groupByClories = dishList.stream().collect(Collectors.groupingBy( d -> {
			if(d.getCalories() < 400) return CaloriesLevel.Diet;
			if(d.getCalories() < 700) return CaloriesLevel.Normal;
			return CaloriesLevel.Fat;
		}));
		System.out.println(groupByClories);
		groupByClories.forEach((cl,d) -> System.out.println(cl.toString() + " => " + d.toString()));
		
		// 2.多级分组
		// Collectors.groupingBy 支持<嵌套>实现多级分组
		// 一级分组：类型	二级分组：卡路里
		System.out.println("------------------------------------- Group by Type and Calories -------------------------------------");
		Map<Type, Map<CaloriesLevel, List<Dish>>> groupByTypeAndCalories = dishList.stream().collect(Collectors.groupingBy(
				Dish::getType,Collectors.groupingBy(d -> {
					if(d.getCalories() < 300) return CaloriesLevel.Diet;
					if(d.getCalories() < 700) return CaloriesLevel.Normal;
					return CaloriesLevel.Fat;
				})));
		System.out.println(groupByTypeAndCalories);
		groupByTypeAndCalories.forEach((t,c) -> System.out.println(t + " => " + c.toString()));
		
		//Collectors.groupingBy的第二个参数除了Collectors.groupingBy外，也可以传递其他规约操作，规约的结果类型对应Map里的第二个泛型
		//e.g 将食材按照类型分，然后统计各个类型对应的数量
		//PS Collectors.counting方法返回Long类型，所以Map第二个泛型也必须指定为Long
		System.out.println("------------------------------------- Count by Type -------------------------------------");
		Map<Type, Long> countByType = dishList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
		System.out.println(countByType);
		countByType.forEach((t,c) -> System.out.println(t + " => " + c));
		
		//e.g 将食材按照类型分，然后选出卡路里最高的菜品
		System.out.println("------------------------------------- Pick Max Calories Dish by Type (Optional) -------------------------------------");
		Map<Type, Optional<Dish>> maxCaloriesDish = dishList.stream().collect(Collectors.groupingBy(
																	Dish::getType, Collectors.maxBy(Comparator.comparing(Dish::getCalories))
															));
		System.out.println(maxCaloriesDish);
		//PS 如果不希望输出结果包含Optional，可以使用Collectors.collectingAndThen方法
		System.out.println("------------------------------------- Pick Max Calories Dish by Type (Clear Optional) -------------------------------------");
		Map<Type, Object> maxCaloriesDish2 = dishList.stream().collect(Collectors.groupingBy(
																			Dish::getType, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)
																		));
		System.out.println(maxCaloriesDish2);
		
		
		//Collectors.groupingBy组合使用的方法还有Collectors.mapping
		//Collectors.mapping方法接受两个参数：一个函数对流中的元素做变换，另一个则将变换的结果对象收集起来
		//e.g 对食材按照类型分类，然后输出各种类型食材下卡路里等级情况
		//PS 转换成ArrayList不会处理重复情况 => {Fish=[Diet, Normal], Meat=[Fat, Fat, Normal], Other=[Normal, Diet, Diet, Normal]}
		System.out.println("------------------------------------- CaloriesLevel by Type -------------------------------------");
		Map<Type, HashSet<CaloriesLevel>> caloriesOfType = dishList.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.mapping(d -> {
													if(d.getCalories() < 400) return CaloriesLevel.Diet;
													if(d.getCalories() < 700) return CaloriesLevel.Normal;
													return CaloriesLevel.Fat;
												}, Collectors.toCollection(HashSet::new))));
		System.out.println(caloriesOfType);
		
		
		
		/*
		 * # 分区
		 * 分区类似于分组，只不过分区最多两种结果
		 * Collectors.partitioningBy方法用于分区操作，接收一个Predicate<T>类型的Lambda表达式作为参数
		 */
		//e.g 将食材按照素食与否分类
		System.out.println("------------------------------------- Partition by isVegetarian -------------------------------------");
		Map<Boolean, List<Dish>> isVegetarian = dishList.stream().collect(Collectors.partitioningBy(Dish::isVegetarian));
		System.out.println(isVegetarian);
		
		//e.g 将食材按照素食与否分类，然后按照类型分组
		System.out.println("------------------------------------- Partition by isVegetarian then Group by Type -------------------------------------");
		Map<Boolean, Map<Type, List<Dish>>> typeOfIsVegetarian = dishList.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.groupingBy(Dish::getType)));
		System.out.println(typeOfIsVegetarian);
		
		//e.g 将食材按照素食与否分类，然后按照类型筛选出卡路里最低的菜品
		System.out.println("------------------------------------- Partition by isVegetarian then Get Min Calories Dish -------------------------------------");
		Map<Boolean, Object> minCaloriesbyIsVegetarian = dishList.stream().collect(Collectors.partitioningBy(Dish::isVegetarian, Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
		System.out.println(minCaloriesbyIsVegetarian);
		
	}
	
	
	
	
	
	
	
	
	
	
}
