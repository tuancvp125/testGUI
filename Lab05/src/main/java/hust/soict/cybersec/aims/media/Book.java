package hust.soict.cybersec.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	private List<String> authors = new ArrayList<String>();
	public void AddAuthor(String authorName) {
		int len = this.authors.size();
		boolean ck_Same = false;
		for (int i = 0; i < len; ++i) 
			if (this.authors.get(i) == authorName) {
				ck_Same = true;
				break;
			}
		if (!ck_Same) this.authors.add(authorName);
	}
		
	public void RemoveAuthor(String authorName) {
		int len = this.authors.size();
		for (int i = 0; i < len; ++i) 
			if (this.authors.get(i) == authorName) {
				this.authors.remove(i);
				break;
			}
	}
	
	public Book(String title, String category, float cost, List author) {
		super();
		setTitle(title);
		setCategory(category);
		setCost(cost);
		setId();
		this.authors = author;
	}
	
}
