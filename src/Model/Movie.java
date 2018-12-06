package Model;

public class Movie {
	private String name;
	private int time;
	private double sales;
	private static double totalSales;
	private double percentSales;
	
	public double getPercentSales() {
		return percentSales;
	}
	public void setPercentSales() {
		this.percentSales = this.sales / Movie.totalSales;
	}
	public static double getTotalSales() {
		return totalSales;
	}
	public static void setTotalSales(double totalSales) {
		Movie.totalSales = totalSales;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
		Movie.totalSales += sales;
	}
}
