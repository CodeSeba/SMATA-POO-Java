package ar.org.centro8.curso.java.entities;
// Generated Apr 11, 2018 3:49:28 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Alumnos generated by hbm2java
 */
@Entity
@Table(name="alumnos"
    ,catalog="colegio"
)
public class Alumnos  implements java.io.Serializable {


     private Integer id;
     private String nombre;
     private String apellido;
     private int edad;
     private int idCurso;

    public Alumnos() {
    }

    public Alumnos(String nombre, String apellido, int edad, int idCurso) {
       this.nombre = nombre;
       this.apellido = apellido;
       this.edad = edad;
       this.idCurso = idCurso;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nombre", nullable=false, length=20)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    @Column(name="apellido", nullable=false, length=20)
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    
    @Column(name="edad", nullable=false)
    public int getEdad() {
        return this.edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }

    
    @Column(name="idCurso", nullable=false)
    public int getIdCurso() {
        return this.idCurso;
    }
    
    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }




}

