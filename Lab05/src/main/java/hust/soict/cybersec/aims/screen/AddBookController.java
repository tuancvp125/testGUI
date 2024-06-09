package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.media.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class AddBookController {

    public AddBookController() {
        super();
    }
    
    @FXML
    private TextField tfTitle;
    
    @FXML
    private TextField tfCategory;
    
    @FXML
    private TextField tfAuthors;
    
    @FXML
    private TextField tfCost;
    
    @FXML
    private Button btnAddBook;
    
    @FXML
    private void addBook() throws IOException {
        String[] authors = tfAuthors.getText().split(", ");
        ArrayList<String> authorsList = new ArrayList<>();
        
        authorsList.addAll(Arrays.asList(authors));
        
        Book book = new Book(tfTitle.getText(), tfCategory.getText(), Float.parseFloat(tfCost.getText()), authorsList);
        
        StoreScreenController.store.addMedia(book);
        
        AimsApp.setRoot("store");
    }
    
}
