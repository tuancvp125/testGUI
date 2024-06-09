package hust.soict.cybersec.aims.media;

public class Track implements Playable{
	private String title;
	private int length; 
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object o) {
		Track other = (Track) o;
		if (other.getTitle() == this.getTitle() && other.getLength() == this.getLength()) {
			return true;
		}
		else return false;
	}
}
