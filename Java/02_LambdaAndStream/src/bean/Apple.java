package bean;

public class Apple {
	public Apple() {
		super();
	}
	
	public Apple(String color) {
		this.color = color;
	}

	private String color;
	private String weight;

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	
}
