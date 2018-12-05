package Model;

import Controller.*;

public class PreShowingMovie extends Movie {
	private double genre;
	private double age;
	private double expect;
	private double country;
	private double point;
	private String releaseDate;
	
	public double getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		int point;
		switch(genre){
		case"Action":
			point = 24;
			break;
		case"Thriller":
			point = 9;
			break;
		case"Drama":
			point = 14;
			break;
		case"SF":
			point = 13;
			break;
		case"Adventure":
			point = 12;
			break;
		case"Fantasy":
			point = 8;
			break;
		case"Romance":
			point = 5;
			break;
		case"Crime":
			point = 5;
			break;
		case"Comedy":
			point = 3;
			break;
		case"Mystery":
			point = 3;
			break;
		case"Animation":
			point = 1;
			break;
		case"War":
			point = 1;
			break;
		case"Horror":
			point = 1;
			break;
		default:
			point = 0;
			break;
		}
		this.genre = point * 0.844;
	}
	public double getAge() {
		return age;
	}
	public void setAge(int age) {
		double point;
		switch(age){
		case 15:
			point = 41.5;
			break;
		case 12:
			point = 37.6;
			break;
		case 19:
			point = 8.7;
			break;
		case 1:
			point = 12.2;
			break;
		default:
			point = 0;
			break;
		}
		this.age = point * 0.285;
	}
	public double getExpect() {
		return expect;
	}
	public void setExpect(double expect) {
		this.expect = expect / 300.0 * 0.574;
	}
	public double getCountry() {
		return country;
	}
	public void setCountry(String country) {
		double point;
		switch(country){
		case"Korea":
			point = 52.6;
			break;
		case"USA":
			point = 29.2;
			break;
		case"Europe":
			point = 1.7;
			break;
		case"China":
			point = 0.8;
			break;
		case"Japan":
			point = 0.7;
			break;
		default:
			point = 0;
			break;
		}
		this.country = point * 34.0;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint() {
		this.point = this.age + this.country + this.expect + this.genre;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void pointToSales() {
		if (releaseDate == "수요일"){
			setSales((this.point * 3 * 100000000 - 7 * 1000000000) * 0.1263);
		}
		else if (releaseDate == "목요일"){
			setSales((this.point * 3 * 100000000 - 7 * 1000000000) * 0.1097);
		}
		else{
			
		}
	}
	
	public PreShowingMovie(String genre, int age, double expect, String country, String releaseDate) {
		setGenre(genre);
		setAge(age);
		setExpect(expect);
		setCountry(country);
		setReleaseDate(releaseDate);
		setPoint();
		pointToSales();
	}
}
