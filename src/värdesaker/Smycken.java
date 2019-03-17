
package värdesaker;


public class Smycken extends Värdesak {
	private int stones;
	private boolean isGold;
	private int price;
	
	public Smycken (String name, int stones, boolean isGold) {
		this.name = name;
		this.stones = stones;
		this.isGold = isGold;
		calculateWorth();
	}	
	
	private void calculateWorth() {
		if(isGold) {
			price = 2000+(500*stones);
		}
		else price = 700+(500*stones);
	}

	public int getStones() {
		return stones;
	}

	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return "Name: "+name+" Stones: "+stones+" Price: "+price;
	}
		
}
