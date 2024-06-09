package hust.soict.cybersec.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title, category;
	private float cost;
	private int cnt = 0;
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setId() {
		++cnt;
		this.id = cnt;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	
	public static final Comparator<Media> COMPARE_BY_TITLE = new MediaComparatorByTitle();
	public static final Comparator<Media> COMPARE_BY_COST = new MediaComparatorByCost();
	
	
	@Override 
	public boolean equals(Object o) {
		Media other = (Media) o;
		
		if (other.getTitle() == this.getTitle()) {
			return true;
		}
		else return false;
	}
	
	public String showType(Object o) {
		String Type = "";
		if (o instanceof Book) Type = "Book";
		else if (o instanceof DigitalVideoDisc) Type = "DVD";
		else if (o instanceof CompactDisc) Type = "CD";
		return Type;
	}
	
	public void show(Object o) {
		String Type = showType(o);
		System.out.print(Type + " - ");
		System.out.println(this.getTitle() + " - " + this.getCategory() + " - " + String.valueOf(this.getCost()));
	}
	
}
