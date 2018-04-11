package ar.org.centro8.curso.java.entities;
// Generated Apr 9, 2018 3:47:18 PM by Hibernate Tools 4.3.1



/**
 * Cursos generated by hbm2java
 */
public class Curso  implements java.io.Serializable {


     private Integer id;
     private String titulo;
     private String profesor;
     private String dia;
     private String turno;

    public Curso() {
    }

    public Curso(Integer id, String titulo, String profesor, String dia, String turno) {
        this.id = id;
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }

    public Curso(String titulo, String profesor, String dia, String turno) {
       this.titulo = titulo;
       this.profesor = profesor;
       this.dia = dia;
       this.turno = turno;
    }
    
    @Override
    public String toString() {
        return "Curso{" + "id=" + id + ", titulo=" + titulo + ", profesor=" + profesor + ", dia=" + dia + ", turno=" + turno + '}';
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }
    public String getDia() {
        return this.dia;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }
    public String getTurno() {
        return this.turno;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }




}

