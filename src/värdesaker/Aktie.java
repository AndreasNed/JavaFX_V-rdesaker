package värdesaker;


public class Aktie extends Värdesak{
	private int amount;
	private int stockPrice;
	private int price;
	
	public Aktie (String name, int amount, int stockPrice) {
		this.name = name;
		this.amount = amount;
		this.stockPrice = stockPrice;
		calculateWorth();
	}
	
	public void krasch() {
		this.price = 0;
	}
	
	private void calculateWorth() {
		price = amount * stockPrice;
	}
	
	public String toString() {
		return "Name: "+name+" Amount: "+amount+" Price: "+price;
	}
	
	public String getName() {
		return name;
	}
	public int getAmount() {
		return amount;
	}

	public int getStockPrice() {
		return stockPrice;
	}

	public int getPrice() {
		return price;
	}
	
}
