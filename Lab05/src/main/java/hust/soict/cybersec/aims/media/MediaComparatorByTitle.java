package hust.soict.cybersec.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitle implements Comparator<Media>{
	
	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		String s1 = o1.getTitle();
		String s2 = o2.getTitle();
		
		int num1 = s1.charAt(0) - 'a';
		int num2 = s2.charAt(0) - 'a';
		
		if (num1 > num2)
			return 1;
		return -1;
	}
	
}
