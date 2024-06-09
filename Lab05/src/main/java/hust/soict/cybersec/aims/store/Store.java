package hust.soict.cybersec.aims.store;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.media.Media;

public class Store {
	private int len = 0;
	private List<Media> itemsInStore = new ArrayList<Media> ();
	
	private int findMed(Media newMed) {
		for (int i = 0; i < itemsInStore.size(); ++i)
			if (itemsInStore.get(i).getTitle() == newMed.getTitle()) {
				return i;
			}
		return -1;
	}
	
	public void addMedia(Media newMed) {
		if (findMed(newMed) == -1) {
			itemsInStore.add(newMed);
			JOptionPane.showMessageDialog(null, "The item has been added successfully!!!");
		}
		else {
			JOptionPane.showMessageDialog(null, "The item is already in the cart!!!");
			return ;
		}
	}
	
	public void removeMedia(Media newMed) {
		if (findMed(newMed) != -1) {
			int tmp = findMed(newMed);
			itemsInStore.remove(tmp);
			JOptionPane.showMessageDialog(null, "The item has been removed successfully!!!");
		}
		else {
			JOptionPane.showMessageDialog(null, "The item is not in the cart!!!");
			return ;
		}
	}
        
        public List<Media> getItemsInStore() {
            return itemsInStore;
        }
        
        public int getSize() {
            return itemsInStore.size();
        }
}
