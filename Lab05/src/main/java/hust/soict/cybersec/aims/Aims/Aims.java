package hust.soict.cybersec.Aims;

import javax.swing.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.*;

public class Aims extends Media {
	
	private static Scanner input = new Scanner(System.in);
	private static List<Media> mediae;
	private static Cart anOrdered;
	private static JFrame frmOpt;

	private static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}

	private static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}

	private static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
	}
	
	private static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter media in cart");
		System.out.println("2. Sort media in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
	}

	private static int availableItems(String mS) {
		int dem = 0;
		for (Media m : mediae) {
			dem++;
			System.out.print(String.valueOf(dem) + ". ");
			m.show(m);
		}
		System.out.println(mS);
		return dem;
	}
	
	private static int Choose_Menu_Detail(String m) {
		int dem = availableItems(m);
		int User_Opt_Detail_Choice = input.nextInt();
		
		while (User_Opt_Detail_Choice > dem || User_Opt_Detail_Choice < 1) {
			JOptionPane.showMessageDialog(frmOpt, "Non matching items!!");
			dem = availableItems(m);
			User_Opt_Detail_Choice = input.nextInt();
		}
		return User_Opt_Detail_Choice;
	}
	
	private static void addMediaCart() {
		int User_Opt_Detail_Choice = Choose_Menu_Detail("Enter (number) you wanna add to cart: ");
		Media item = mediae.get(User_Opt_Detail_Choice - 1);
		int success = anOrdered.addMedia(mediae.get(User_Opt_Detail_Choice - 1));
		if (success > 0) JOptionPane.showMessageDialog(frmOpt, "Added " + item.showType(item) + " successfully");
	}
	
	private static void Func_DetailsMenu() {
		while (true) {
			if (mediae.isEmpty()) {
				JOptionPane.showMessageDialog(frmOpt, "Store is empty!!");
				break;
			}
			mediaDetailsMenu();
			int User_Opt_Menu_Detail = input.nextInt();
			if (User_Opt_Menu_Detail == 1) {
				// Add to Cart
				addMediaCart();
			}
			else if (User_Opt_Menu_Detail == 2) {
				int pos = Choose_Menu_Detail("Enter (number) demo you wanna play : ");
				Media item = mediae.get(pos - 1);
				if (item.showType(item) == "Book") {
					JOptionPane.showMessageDialog(frmOpt, "Playing option is just only available with DVD and CD");
				}
				else JOptionPane.showMessageDialog(frmOpt, item.showType(item) + " is playing right now!");
			}
			else if (User_Opt_Menu_Detail == 0) {
				break;
			}
		}
	}
	
	private static void showCart() {
		System.out.println("Media in Cart: ");
		anOrdered.showMedia();
	}
	
	private static void showStore() {
		System.out.println("Media in Store: ");
		availableItems("Enter (number) you wanna add to cart: ");
	}

	private static void Func_ViewStore() {
		while (true) {
			storeMenu();
			int User_Opt_Menu = input.nextInt();
			if (User_Opt_Menu == 1) {
				// See media's details 	
				Func_DetailsMenu();
			}
			else if (User_Opt_Menu == 4) {
				// See current cart
				System.out.println("Current cart is here: ");
				anOrdered.showMedia();
			}
			else if (User_Opt_Menu == 2) {
				// Add a media to cart
				addMediaCart();
			}
			else if (User_Opt_Menu == 3) {
				playMedia();
			}
			else if (User_Opt_Menu == 0) break;
		}
	}
	
	private static void cartFilter() {
		while (true) {
			System.out.println("Choose which method to filter: ");
			System.out.println("1. By id");
			System.out.println("2. By Title");
			System.out.println("0. Back");
		}
	}
	
	private static void sortCart() {
		while (true) {
			System.out.println("Choose which method to sort cart: ");
			System.out.println("1. Sort by title");
			System.out.println("2. Sort by cost");
			System.out.println("0. Back");
			int Opt_sortChoice = input.nextInt();
			if (Opt_sortChoice == 1) {
				anOrdered.SortByTitle();
			}
			else if (Opt_sortChoice == 2) {
				anOrdered.SortByCost();
			}
			else if (Opt_sortChoice == 0) break;
		}
	}
	
	private static void removeCart() {
		if (anOrdered.qEmpty()) {
			JOptionPane.showMessageDialog(frmOpt, "Cart is empty!!");
		}
		showCart();
		System.out.println("Please choose (number) media you wanna remove: ");
		int Opt_rmMed = input.nextInt();
		anOrdered.removeMediaPos(Opt_rmMed);
	}
	
	private static void playMedia() {
		showCart();
		System.out.println("Please choose (number) media you favor: ");
		int Opt_playMed = input.nextInt();
		anOrdered.playing_CartMed(Opt_playMed - 1);
	}
	
	private static void placeOrder() {
		JOptionPane.showMessageDialog(frmOpt, "An order has been created. Check it out!!!");
		anOrdered.emptyMedia();
	}
	
	private static void Func_cartMenu() {
		while (true) {
			cartMenu();
			int Opt_cartMenu = input.nextInt();
			if (Opt_cartMenu == 0) break;
			else if (Opt_cartMenu == 1) {
				cartFilter();
			}
			else if (Opt_cartMenu == 2) {
				sortCart();
			}
			else if (Opt_cartMenu == 3) {
				removeCart();
			}
			else if (Opt_cartMenu == 4) {
				playMedia();
			}
			else if (Opt_cartMenu == 5) {
				placeOrder();
			}
		}
	}
	
	private static void list_Type() {
		System.out.println("----------");
		System.out.println("1. DVD");
		System.out.println("2. Book");
		System.out.println("3. CD");
		System.out.println("----------");
		System.out.println("What type do you wanna choose: ");
	}

	public static void main(String[] args) {
		frmOpt = new JFrame();
		//frmOpt.setVisible(true);
		frmOpt.setLocation(700, 400);
		//frmOpt.setAlwaysOnTop(true);
		
                anOrdered = new Cart();
		mediae = new ArrayList<Media>();

		CompactDisc cd = new CompactDisc("99%", "R&B", "MCK", 60, (float) 100.23);
		DigitalVideoDisc dvd = new DigitalVideoDisc("The Queen", "Adult", "Le Anh Nam", 120, (float) 10.45);
		List<String> author = new ArrayList<String>();
		author.add("Le Anh Lam");
		Book book = new Book("Fuck tonight", "Adult", (float) 100.87, author);

		mediae.add(cd);
		mediae.add(dvd);
		mediae.add(book);

		while (true) {
			showMenu();
			int User_Opt_Aims;
			User_Opt_Aims = input.nextInt();
			if (User_Opt_Aims == 1) {
				// View Store
				Func_ViewStore();

			}
			else if (User_Opt_Aims == 0) {
				break;
			}
			else if (User_Opt_Aims == 2) {
				// Update Store
				if (mediae.isEmpty()) {
					JOptionPane.showMessageDialog(frmOpt, "Store is empty!!");
					continue;
				}
				System.out.println("Right now we already have : ");
				availableItems("Which do you wanna remove: ");
				int rmIt = input.nextInt();
				mediae.remove(rmIt - 1);
				JOptionPane.showMessageDialog(frmOpt, "Remove successfully!!!");
			}
			else if (User_Opt_Aims == 3) {
				// See current cart
				Func_cartMenu();
			}
		}

	}
}
