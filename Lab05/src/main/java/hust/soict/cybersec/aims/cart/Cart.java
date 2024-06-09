package hust.soict.cybersec.aims.cart;
import hust.soict.cybersec.aims.media.Book;
import hust.soict.cybersec.aims.media.CompactDisc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JOptionPane;

import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.MediaComparatorByCost;
import hust.soict.cybersec.aims.media.MediaComparatorByTitle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private ObservableList<Media> itemsFiltered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return this.itemsOrdered;
    }
    
    public ObservableList<Media> getItemsFiltered() {
        return this.itemsFiltered;
    }
	private int len = 0;
	//private List<Media> itemsOrdered = new ArrayList<Media> ();
	
	private int findMed(Media newMed) {
		for (int i = 0; i < itemsOrdered.size(); ++i)
			if (itemsOrdered.get(i).getTitle() == newMed.getTitle()) {
				return i;
			}
		return -1;
	}
	
	public int addMedia(Media newMed) {
		if (findMed(newMed) == -1) {
			itemsOrdered.add(newMed);
			//JOptionPane.showMessageDialog(null, "The item has been added successfully!!!");
			return 1;
		}
		else {
			JOptionPane.showMessageDialog(null, "The item is already in the cart!!!");
			return 0;
		}
	}
	
	public int removeMedia(Media newMed) {
		if (findMed(newMed) != -1) {
			int tmp = findMed(newMed);
			itemsOrdered.remove(tmp);
			JOptionPane.showMessageDialog(null, "The item has been removed successfully!!!");
			return 1;
		}
		else {
			JOptionPane.showMessageDialog(null, "The item is not in the cart!!!");
			return 0;
		}
	}
	
	public int removeMediaPos(int pos) {
		int tmp;
		if ((tmp = findMed(itemsOrdered.get(pos))) != -1) {
			itemsOrdered.remove(tmp);
			JOptionPane.showMessageDialog(null, "The item has been removed successfully!!!");
			return 1;
		}
		else {
			JOptionPane.showMessageDialog(null, "The item is not in the cart!!!");
			return 0;
		}
	}
	
	public void SortByTitle() {
		Collections.sort(itemsOrdered, new MediaComparatorByTitle());
		JOptionPane.showMessageDialog(null, "Sorted by title successfully");
	}
	
	public void SortByCost() {
		Collections.sort(itemsOrdered, new MediaComparatorByCost());
		JOptionPane.showMessageDialog(null, "Sorted by cost successfully");
	}
	
	public boolean qEmpty() {
		return itemsOrdered.isEmpty();
	}
	
	public void playing_CartMed(int pos) {
		Media tmp = itemsOrdered.get(pos);
		String head = tmp.showType(tmp);
		if (head == "Book") {
			JOptionPane.showMessageDialog(null, "Playing option is just only available for DVD and CD");
		}
		else {
			JOptionPane.showMessageDialog(null, head + " " + String.valueOf(pos) + " is now playing!!!");
		}
	}
	
	public void showMedia() {
		int cnt = 0;
		for (Media m : itemsOrdered) {
			cnt++;
			System.out.print(String.valueOf(cnt) + ". ");
			m.show(m);
		}
	}
	
	public void emptyMedia() {
		for (Media M : itemsOrdered)
			itemsOrdered.remove(M);
	}

    public void searchId(int id) {
        itemsFiltered.clear();
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                    itemsFiltered.add(media);
                    return;
                } else if (media instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) media;
                    itemsFiltered.add(media);
                    return;
                } else if (media instanceof Book) {
                    Book b = (Book) media;
                    itemsFiltered.add(media);
                    return;
                }
            }
        }
        System.out.println("No match is found");
    }

    public void searchTitle(String title) {
        itemsFiltered.clear();
        for (Media media : itemsOrdered) {
            if (media.getTitle().contains(title)) {
                if (media instanceof DigitalVideoDisc) {
                    DigitalVideoDisc dvd = (DigitalVideoDisc) media;
                    itemsFiltered.add(media);
                } else if (media instanceof CompactDisc) {
                    CompactDisc cd = (CompactDisc) media;
                    itemsFiltered.add(media);
                } else if (media instanceof Book) {
                    Book b = (Book) media;
                    itemsFiltered.add(media);
                }
            }
        }
        System.out.println("No match is found");
    }
	public float totalCost() {
		// Return total Costs of the current Cart
		float sum = 0;
		for (int i = 0; i < itemsOrdered.size(); ++i) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
}
