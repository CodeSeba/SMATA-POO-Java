package ar.org.centro8.curso.java.gui;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.repositories.GenericR;
import ar.org.centro8.curso.java.utils.FxTable;
import ar.org.centro8.curso.java.utils.Validator;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
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
    private TableView<Alumno> tblAlumnos;
    @FXML
    private TextField txtBuscarApe;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtTitulo;
    @FXML
    private TextField txtProfesor;
    private TextField txtDia;
    @FXML
    private Button btnAgregarCurso;
    @FXML
    private TableView<Curso> tblCursos;
    @FXML
    private Button btnEliminarCurso;
    @FXML
    private ComboBox<String> cmbTurnos;
    @FXML
    private Label lblInfoCurso;
    @FXML
    private ComboBox<String> cmbDias;
    @FXML
    private TextField txtBuscarTitulo;
    @FXML
    private TextField txtBuscarDia;
    @FXML
    private TextField txtBuscarProfesor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ar = new GenericR(Connector.getConnection(), Alumno.class);
        cr = new GenericR(Connector.getConnection(), Curso.class);
        cargar();
    }
    
    private void cargar() {
        
        // Cargar cmbCursos
        cmbCursos.getItems().clear();
        cmbCursos.getItems().addAll(cr.getAll());
        if (cmbCursos.getItems().size() > 0)
            cmbCursos.setValue(cmbCursos.getItems().get(0));
        
        // Cargar cmbDias
        cmbDias.getItems().clear();
        cmbDias.getItems().addAll("LUNES","MARTES","MIERCOLES","JUEVES","VIERNES");
        cmbDias.setValue("LUNES");
        
        // Cargar cmbTurnos
        cmbTurnos.getItems().clear();
        cmbTurnos.getItems().addAll("MAÑANA","TARDE","NOCHE");
        cmbTurnos.setValue("MAÑANA");
        
        // Cargar Tabla Alumnos
        FxTable<Alumno> fxTable = new FxTable();
        fxTable.cargar(ar.getAll(), tblAlumnos);
        
        // Cargar Tabla Cursos
        FxTable<Curso> fxTableCurso = new FxTable();
        fxTableCurso.cargar(cr.getAll(), tblCursos);
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
        if (cmbCursos.getItems().size() > 0)
            cmbCursos.setValue(cmbCursos.getItems().get(0));
        txtNombre.requestFocus();
    }
    
    private void limpiarCurso() {
        txtTitulo.setText("");
        txtProfesor.setText("");
        cmbDias.setValue("LUNES");
        cmbTurnos.setValue("MAÑANA");
        txtTitulo.requestFocus();
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
        fxTable.cargar(ar.getByFiltro(filtro), tblAlumnos);
    }

    @FXML
    private void eliminar(ActionEvent event) {
        if (tblAlumnos.getSelectionModel().getSelectedItem() == null) return;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Se borrara un alumno");
        alert.setContentText("¿Esta seguro que desea borrar un alumno?");
        if (alert.showAndWait().get().getButtonData() == ButtonData.OK_DONE) {
            ar.remove(tblAlumnos.getSelectionModel().getSelectedItem());
        }
        cargar();
        
    }

    @FXML
    private void agregarCurso(ActionEvent event) {
        if (validarCurso()) {
            Curso curso = new Curso(
                    txtTitulo.getText(),
                    txtProfesor.getText(),
                    cmbDias.getValue(),
                    cmbTurnos.getValue()
            );
            cr.save(curso);
            lblInfoCurso.setText("Se ingreso un curso id " + curso.getId());
            limpiarCurso();
            cargar();
        }
        else lblInfoCurso.setText("No se pudo agregar el curso");
    }
    
    private boolean validarCurso() {
        // Titulo tenga entre 2 y 20 letras
        if ( ! new Validator(txtTitulo.getText()).length(2, 20) )
            return msgError("El titulo debe tener entre 2 y 10 caracteres");
        
        // Profesor tenga entre 2 y 20 letras
        if ( ! new Validator(txtProfesor.getText()).length(2, 20) )
            return msgError("El profesor debe tener entre 2 y 10 caracteres");
        
        return true;
    }

    @FXML
    private void buscarTitulo(KeyEvent event) {
        String filtro = "titulo like '%" + txtBuscarTitulo.getText() + "%'";
        FxTable<Curso> fxTable = new FxTable();
        fxTable.cargar(cr.getByFiltro(filtro), tblCursos);
    }
    
    @FXML
    private void buscarDia(KeyEvent event) {
        String filtro = "dia like '%" + txtBuscarDia.getText() + "%'";
        FxTable<Curso> fxTable = new FxTable();
        fxTable.cargar(cr.getByFiltro(filtro), tblCursos);
    }

    @FXML
    private void buscarProfesor(KeyEvent event) {
        String filtro = "profesor like '%" + txtBuscarProfesor.getText() + "%'";
        FxTable<Curso> fxTable = new FxTable();
        fxTable.cargar(cr.getByFiltro(filtro), tblCursos);
    }

    @FXML
    private void eliminarCurso(ActionEvent event) {
        if (tblCursos.getSelectionModel().getSelectedItem() == null) return;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Se borrara un curso");
        alert.setContentText("¿Esta seguro que desea borrar un curso?");
        if (alert.showAndWait().get().getButtonData() == ButtonData.OK_DONE) {
            cr.remove(tblCursos.getSelectionModel().getSelectedItem());
        }
        cargar();
    }
}
