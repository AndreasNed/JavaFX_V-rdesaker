
package värdesaker;


public class Apparater extends Värdesak{
	
	private int buyPrice;
	private int slitage;
	private double price;
	
	public Apparater (String name, int buyPrice, int slitage) {
		this.name = name;
		this.buyPrice = buyPrice;
		this.slitage = slitage;
		calculateWorth();
	}

	private void calculateWorth() {
		price = buyPrice * slitage / 10;
	}
	
	public String getName() {
		return name;
	}
	public int getbuyPrice() {
		return buyPrice;
	}
	public int getSlitage() {
		return slitage;
	}
	public double getPrice() {
		return price;
	}
}
