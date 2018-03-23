package ar.org.centro8.curso.java.repositories;

import ar.org.centro8.curso.java.entities.Curso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CursoR {
    
    private Connection conn;

    public CursoR(Connection conn) {
        this.conn = conn;
    }
    
    public void save(Curso curso) {
        try {
            PreparedStatement ps = conn.prepareStatement(
                    "insert into cursos (titulo,profesor,dia,turno) values (?,?,?,?)", 1
            );
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getProfesor());
            ps.setString(3, curso.getDia());
            ps.setString(4, curso.getTurno());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) curso.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private List<Curso> getByFiltro(String filtro) {
        List<Curso> lista = new ArrayList();
        try {
            ResultSet rs = conn.createStatement().executeQuery(
                    "select * from cursos where " + filtro
            );
            while(rs.next()) {
                lista.add(
                        new Curso(
                                rs.getInt("id"),
                                rs.getString("titulo"),
                                rs.getString("profesor"),
                                rs.getString("dia"),
                                rs.getString("turno")
                        )
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }
    
    public List<Curso> getAll() {
        return getByFiltro("1=1");
    }
    
    public Curso getById(int id) {
        List<Curso> lista = getByFiltro("id=" + id);
        return (lista == null || lista.isEmpty())? null:lista.get(0);
    }
    
    public List<Curso> getByTitulo(String titulo) {
        return getByFiltro("titulo='" + titulo + "'");
    }
    
    public List<Curso> getByProfesor(String profesor) {
        return getByFiltro("profesor='" + profesor + "'");
    }
    
    public List<Curso> getByDia(String dia) {
        return getByFiltro("dia='" + dia + "'");
    }
    
    public List<Curso> getByTurno(String turno) {
        return getByFiltro("turno='" + turno + "'");
    }
}
