package ar.org.centro8.curso.java.gui;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.GenericR;
import ar.org.centro8.curso.java.utils.FxTable;
import ar.org.centro8.curso.java.utils.Validator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class FXMLDocumentController implements Initializable {

    private GenericR<Alumno> ar;
    private GenericR<Curso> cr;

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtEdad;
    @FXML
    private Button btnAgregar;
    @FXML
    private Label lblInfo;
    @FXML
    private ComboBox<Curso> cmbCursos;
    @FXML
    private TableView<Alumno> tblAlumno;
    @FXML
    private TextField txtBuscarApe;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ar = new GenericR(Connector.getConnection(), Alumno.class);
        cr = new GenericR(Connector.getConnection(), Curso.class);
        cargar();
    }
    
    private void cargar() {
        cmbCursos.getItems().clear();
        cmbCursos.getItems().addAll(cr.getAll());
        cmbCursos.setValue(cmbCursos.getItems().get(0));
        
        //
        FxTable<Alumno> fxTable = new FxTable();
        fxTable.cargar(ar.getAll(), tblAlumno);
    }

    @FXML
    private void agregar(ActionEvent event) {
        if (validar()) {
            Alumno alumno = new Alumno(
                    txtNombre.getText(),
                    txtNombre.getText(),
                    Integer.parseInt(txtEdad.getText()),
                    cmbCursos.getValue().getId()
            );
            ar.save(alumno);
            lblInfo.setText("Se ingreso un alumno id " + alumno.getId());
            limpiar();
        }
        else lblInfo.setText("No se pudo agregar el alumno");
    }

    private boolean validar() {
        // Validar nombre entre 2 y 20 caracteres
        if ( ! new Validator(txtNombre.getText()).length(2, 20) )
            return msgError("El nombre debe tener entre 2 y 10 caracteres");
        
        // Validar apellido entre 2 y 20 caracteres
        if ( ! new Validator(txtApellido.getText()).length(2, 20) )
            return msgError("El apellido debe tener entre 2 y 20 caracateres");
        
        // Validar edad entero entre 18 y 120
        if ( ! new Validator(txtEdad.getText()).isInteger(18, 120) )
            return msgError("La edad debe ser entre 18 y 120 años");
        return true;
    }

    private void limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtEdad.setText("");
        cmbCursos.setValue(cmbCursos.getItems().get(0));
        txtNombre.requestFocus();
    }
    
    private boolean msgError(String texto) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(texto);
        alert.show();
        return false;
    }

    @FXML
    private void buscarApe(KeyEvent event) {
        String filtro = "apellido like '%" + txtBuscarApe.getText() + "%'";
        FxTable<Alumno> fxTable = new FxTable();
        fxTable.cargar(ar.getByFiltro(filtro), tblAlumno);
    }
}
