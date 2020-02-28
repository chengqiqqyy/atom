package functionalInterface;

import bean.Apple;

@FunctionalInterface
public interface AppleFilter {
	boolean appleFilter(Apple apple);
}
