package hust.soict.cybersec.aims.screen;

import hust.soict.cybersec.aims.media.CompactDisc;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class AddCDController {

    public AddCDController() {
        super();
    }
    
    @FXML
    private TextField tfTitle;
    
    @FXML
    private TextField tfCategory;
    
    @FXML
    private TextField tfDirector;
    
    @FXML
    private TextField tfArtist;
    
    @FXML
    private TextField tfLength;
    
    @FXML
    private TextField tfCost;
            
    @FXML
    private Button btnAddCD;
    
    @FXML
    private void addCD() throws IOException {
        CompactDisc CD = new CompactDisc(tfTitle.getText(), tfCategory.getText(), tfDirector.getText(), Integer.parseInt(tfLength.getText()), Float.parseFloat(tfCost.getText()));
        
        StoreScreenController.store.addMedia(CD);
        
        AimsApp.setRoot("store");
    }
    
}
