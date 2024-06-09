package hust.soict.cybersec.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}
	
	public Disc(String title, String category, String director, int length, float cost) {
		setTitle(title);
		setCategory(category);
		this.director = director;
		this.length = length;
		setCost(cost);
	}
}
