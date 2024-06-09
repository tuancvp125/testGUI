package hust.soict.cybersec.aims.media;

import java.util.Comparator;

public class MediaComparatorByCost implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
		if (o1.getCost() > o2.getCost())
			return 1;
		else if (o1.getCost() == o2.getCost())
			return 0;
		return -1;
	}

}
