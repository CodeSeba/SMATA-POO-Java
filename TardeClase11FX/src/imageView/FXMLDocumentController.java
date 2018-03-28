package imageView;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField txtFile;
    @FXML
    private Button btnExplorar;
    @FXML
    private ImageView imgFoto;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void explorar(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Documents"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg", "*.jpg"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpeg", "*.jpeg"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("png", "*.png"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("bmp", "*.bmp"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("gif", "*.gif"));
        File file = fc.showOpenDialog(null);
        if (file==null) return;
        txtFile.setText(file.toString());
        try {
            imgFoto.setImage(new Image(new FileInputStream(file)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}
