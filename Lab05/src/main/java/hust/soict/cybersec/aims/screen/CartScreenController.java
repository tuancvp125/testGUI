package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Playable;
import java.io.IOException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    public static Cart cart = new Cart();

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterID;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label total;
    
    @FXML
    private MenuItem menuItemViewStore;

    public CartScreenController() {
        super();
    }

    @FXML
    public void initialize() {
        colMediaTitle.setCellValueFactory(
                new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(
                new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(
                new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        total.setText(cart.totalCost() + " $");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        btnRemove.setOnAction(new EventHandler() {

            public void handle(Event e) {
                Media selectedItem = tblMedia.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    cart.removeMedia(selectedItem);
                    tblMedia.getItems().remove(selectedItem);
                }
                total.setText("" + cart.totalCost());
            }
        });

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {

            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                if (newValue != null) {
                    updateButtonBar(newValue);
                }
            }
        });

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                showFilterMedia(newValue);
            }
        });
    }

    @FXML
    public void viewStore() throws IOException {
        AimsApp.setRoot("store");
    }
    
    void showFilterMedia(String str) {
        if (str.equals("")) {
            tblMedia.setItems(cart.getItemsOrdered());
        } else {
            if (radioBtnFilterTitle.isSelected()) {
                cart.searchTitle(str);
                tblMedia.setItems(cart.getItemsFiltered());
            } else {
                cart.searchId(Integer.parseInt(str));
                tblMedia.setItems(cart.getItemsFiltered());
            }
        }
    }

    void updateButtonBar(Media media) {
        btnRemove.setVisible(true);
        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
        }
    }
}
