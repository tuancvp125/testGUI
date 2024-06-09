package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.store.Store;
import hust.soict.cybersec.aims.screen.MediaStore;
//import hust.soict.cybersec.test.store.StoreTest;
import java.io.IOException;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

public class StoreScreenController {
    public static Store store = new Store();
    
    public StoreScreenController() {
        super();
    }
    
    @FXML
    private MenuItem menuItemViewCart;
    
    @FXML
    private MenuItem menuItemAddDVD;
    
    @FXML
    private MenuItem menuItemAddCD;
    
    @FXML
    private MenuItem menuItemAddBook;
    
    @FXML
    private GridPane gridPane;
    
    @FXML
    public void initialize() {
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            Media media = store.getItemsInStore().get(i);
            MediaStore cell = new MediaStore(media);
            cell.getBtnAddToCart().setOnAction(new EventHandler() {
                @Override
                public void handle(Event t) {
                    CartScreenController.cart.addMedia(media);
                }
            });
            gridPane.add(cell, i % 2, i / 2);
        }
    }
    
    @FXML
    public void viewCart() throws IOException {
        AimsApp.setRoot("cart");
    }
    
    @FXML
    public void addDVD() throws IOException {
        AimsApp.setRoot("addDVD");
    }
    
    @FXML
    private void addCD() throws IOException {
        AimsApp.setRoot("addCD");
    }
    
    @FXML
    private void addBook() throws IOException {
        AimsApp.setRoot("addBook");
    }
}
