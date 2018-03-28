package notepad;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FXMLDocumentController implements Initializable {

    @FXML
    private TextArea txaTexto;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void nuevo(ActionEvent event) {
        if (txaTexto.getText().isEmpty()) return;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setContentText("Esta seguro que desea borrar el texto ?");
        if(alert.showAndWait().get().getButtonData() == ButtonData.OK_DONE)
            txaTexto.setText("");
    }

    @FXML
    private void abrir(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Documents"));
        fc.getExtensionFilters().add(new ExtensionFilter("Archivos de texto","*.txt"));
        File file = fc.showOpenDialog(null);
        if (file==null) return;
        txaTexto.setText("");
        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            in.lines().forEach(item -> txaTexto.appendText(item + "\n"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void guardar(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "/Documents"));
        fc.getExtensionFilters().add(new ExtensionFilter("Archivos de texto","*.txt"));
        File file = fc.showSaveDialog(null);
        if (file==null) return;
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(txaTexto.getText());
            out.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void acerca(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Centro de Formación Profesional Nro 8.");
        alert.setContentText("Bloc de Notas +o-\nCurso de Java Objetos.");
        alert.show();
    }

    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }
    
}
