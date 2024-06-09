package hust.soict.cybersec.test.cart;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Book;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;
import java.util.ArrayList;
import java.util.List;

public class CartTest {
    
    public Cart createCart() {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger Aller", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "Thomas Edison", 120, 18.99f);
        cart.addMedia(dvd3);
        
        List<String> author = new ArrayList<String>();
        author.add("Le Anh Lam");
        Book book1 = new Book("Doc vi bat ki ai", "PTBT", 4.5f, author);
        cart.addMedia(book1);
        
        return cart;
    }
        

    /*public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Lion King", "Animation", "Roger Aller", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        cart.print();
        cart.searchId(1);
        cart.searchId(4);
        cart.searchTitle("Lion King");
        cart.searchTitle("Doraemon");
    }*/
}
