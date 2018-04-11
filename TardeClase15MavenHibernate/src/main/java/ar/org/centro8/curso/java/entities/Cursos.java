package ar.org.centro8.curso.java.entities;
// Generated Apr 11, 2018 3:49:28 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Cursos generated by hbm2java
 */
@Entity
@Table(name="cursos"
    ,catalog="colegio"
)
public class Cursos  implements java.io.Serializable {


     private Integer id;
     private String titulo;
     private String profesor;
     private String dia;
     private String turno;

    public Cursos() {
    }

    public Cursos(String titulo, String profesor, String dia, String turno) {
       this.titulo = titulo;
       this.profesor = profesor;
       this.dia = dia;
       this.turno = turno;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="titulo", nullable=false, length=20)
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    @Column(name="profesor", nullable=false, length=20)
    public String getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    
    @Column(name="dia", nullable=false, length=20)
    public String getDia() {
        return this.dia;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }

    
    @Column(name="turno", nullable=false, length=20)
    public String getTurno() {
        return this.turno;
    }
    
    public void setTurno(String turno) {
        this.turno = turno;
    }




}

