package tardeclase10fx;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class FXMLDocumentController implements Initializable {
    
    private List<CheckBox> listaCheck;
    
    @FXML
    private TextField txtNombre;
    @FXML
    private CheckBox chkBici;
    @FXML
    private CheckBox chkMoto;
    @FXML
    private CheckBox chkAuto;
    @FXML
    private TextArea txaTexto;
    
    @FXML
    public void aceptar(ActionEvent e) {
        //JOptionPane.showMessageDialog(null, "Hola "+txtNombre.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Hola " + txtNombre.getText());
        alert.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listaCheck = new ArrayList();
        Field[] fields = this.getClass().getDeclaredFields();
        try {
            for (Field f:fields) if (f.getName().startsWith("chk")) listaCheck.add((CheckBox)f.get(this));
        } catch(Exception e) {
            System.out.println(e);
        }
        listaCheck.forEach(System.out::println);
    }    

    @FXML
    private void agregar(ActionEvent event) {
        if (txtNombre.getText().equals("")) return;
        String texto = "Nombre = " + txtNombre.getText() + ".\n";
        //if (chkBici.isSelected()) texto += "Tiene Bici.\n";
        //if (chkMoto.isSelected()) texto += "Tiene Moto.\n";
        //if (chkAuto.isSelected()) texto += "Tiene Auto.\n";
        for (CheckBox chk:listaCheck) {
            if (chk.isSelected()) texto += "Tiene " + chk.getText() + ".\n";
        }
        
        txaTexto.setText(texto);
    }
    
}
