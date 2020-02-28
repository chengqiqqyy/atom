package bean;

public class Dish {
	public enum Type {
		Meat, Fish, Other
	};
	
	public enum CaloriesLevel {
		Diet, Normal, Fat
	};

	// Food Name
	public final String name;

	// Is Vegetarian
	public final boolean vegetarian;

	// Calories
	public final int calories;

	// Type
	public final Type type;

	public Dish(String name, boolean vegetarian, int calories, Type type) {
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	
	

	@Override
	public String toString() {
		return this.getName();
	}



	public String getName() {
		return name;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public int getCalories() {
		return calories;
	}

	public Type getType() {
		return type;
	}
	
}
