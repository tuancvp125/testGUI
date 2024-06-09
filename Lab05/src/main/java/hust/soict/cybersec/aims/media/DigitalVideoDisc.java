package hust.soict.cybersec.aims.media;

import hust.soict.cybersec.aims.media.Playable;

public class DigitalVideoDisc extends Disc implements Playable{
	private String director;
	private int length;
	private int nbDigitalVideoDiscs = 0;
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	
	
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		setId();
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
}
