package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.conectors.Connector;
import java.sql.Connection;
import java.sql.Statement;

public class TestConnector {
    public static void main(String[] args) throws Exception {
        Connection conn = Connector.getConnection();
        String query = "insert into alumnos(nombre,apellido,edad,idcurso) values "
                + "('Juan','Perez',23,1)";
        Statement st = conn.createStatement();
        st.execute(query);
        st.close();
        //conn.close();
        
        Connector.getConnection().createStatement().execute(
            "insert into alumnos(nombre,apellido,edad,idcurso) values "
                + "('Laura','Moretti',22,1)"
        );
    }
    
}
