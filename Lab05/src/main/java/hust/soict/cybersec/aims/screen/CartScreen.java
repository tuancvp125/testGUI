package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.test.cart.CartTest;
import java.io.IOException;
import java.net.URL;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javax.swing.JFrame;

public class CartScreen extends JFrame {

    private Cart cart;

    public CartScreen(Cart cart) {
        super();

        this.cart = cart;
        
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1024, 768);
        this.setTitle("Cart");
        this.setVisible(true);
        
        Platform.runLater(new Runnable() {
            public void run() {
                try {
                    URL location = getClass().getResource("cart.fxml");
                    FXMLLoader loader = new FXMLLoader(location);
                    
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public static void main(String[] args) {
        CartTest test = new CartTest();
        new CartScreen(test.createCart());
    }
}
