package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.Media;
import hust.soict.cybersec.aims.media.Playable;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MediaStore extends VBox {

    private Media media;
    private Label lblTitle, lblCost;
    private HBox hBox;
    private Button btnAddToCart, btnPlay;

    public MediaStore(Media media) {
        this.media = media;

        lblTitle = new Label(media.getTitle());
        lblTitle.setAlignment(Pos.CENTER);
        lblTitle.setFont(new Font(lblTitle.getFont().getName(), 20));

        lblCost = new Label("" + media.getCost() + " $");
        lblCost.setAlignment(Pos.CENTER);
        lblCost.setFont(new Font(lblCost.getFont().getName(), 15));

        btnAddToCart = new Button("Add to Cart");

        hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        hBox.getChildren().add(btnAddToCart);
        
        if (media instanceof Playable) {
            btnPlay = new Button("Play");
            hBox.getChildren().add(btnPlay);
        }
        
        this.getChildren().addAll(lblTitle, lblCost, hBox);

        setMinSize(511, 211);
        setSpacing(10);
        setAlignment(Pos.CENTER);
    }

    public Button getBtnAddToCart() {
        return this.btnAddToCart;
    }
}
