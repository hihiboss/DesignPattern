package Model;

public class ShowingMovie extends Movie {
	private double dailySales;
	public ShowingMovie(double dailySales){
		setSales(dailySales);
	}

	public double getDailySales() {
		return dailySales;
	}

	public void setDailySales(double dailySales) {
		this.dailySales = dailySales;
	}
}
