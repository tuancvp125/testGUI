package hust.soict.cybersec.aims.media;

import java.util.ArrayList;
import java.util.List;
import hust.soict.cybersec.aims.media.Playable;

import javax.swing.JOptionPane;

public class CompactDisc extends Disc implements Playable{
	private String artist;
	private List<Track> tracks = new ArrayList <Track>();
	
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		setId();
	}
	
	private int FindTrack(Track newTrack) {
		int len = tracks.size();
		for (int i = 0; i < len; ++i) 
			if (tracks.get(i).getTitle() == newTrack.getTitle()) {
				return i;
			}
		return -1;
	}
	
	public void addTrack(Track newTrack) {
		if (FindTrack(newTrack) == -1) {
			tracks.add(newTrack);
			JOptionPane.showMessageDialog(null, "The track has been inserted successfully!!!");
		}
		else {
			JOptionPane.showMessageDialog(null, "The track has been already!!");
			return ;
		}
	}
	
	public void removeTrack(Track newTrack) {
		int tmp;
		if ((tmp = FindTrack(newTrack)) == -1) {
			JOptionPane.showMessageDialog(null, "The track has not been inserted!!!");
		}
		else {
			tracks.remove(tmp);
			JOptionPane.showMessageDialog(null, "The track has been removed successfully!!!");
		}
	}
	
	public int getLength() {
		int res = 0;
		for (int i = 0; i < tracks.size(); ++i)
			res += tracks.get(i).getLength();
		return res;
	}
	
	public void play() {
		for (int i = 0; i < tracks.size(); ++i) {
			tracks.get(i).play();
			System.out.println();
		}
	}
}
