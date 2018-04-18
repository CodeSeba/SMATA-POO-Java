/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.centro8.curso.java.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author seba
 */
@Entity
@Table(name = "inscripciones")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "Inscripcion.findAll", query = "SELECT i FROM Inscripcion i")
	, @NamedQuery(name = "Inscripcion.findByIdCurso", query = "SELECT i FROM Inscripcion i WHERE i.inscripcionPK.idCurso = :idCurso")
	, @NamedQuery(name = "Inscripcion.findByIdAlumno", query = "SELECT i FROM Inscripcion i WHERE i.inscripcionPK.idAlumno = :idAlumno")})
public class Inscripcion implements Serializable {

	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected InscripcionPK inscripcionPK;

	public Inscripcion() {
	}

	public Inscripcion(InscripcionPK inscripcionPK) {
		this.inscripcionPK = inscripcionPK;
	}

	public Inscripcion(int idCurso, int idAlumno) {
		this.inscripcionPK = new InscripcionPK(idCurso, idAlumno);
	}

	public InscripcionPK getInscripcionPK() {
		return inscripcionPK;
	}

	public void setInscripcionPK(InscripcionPK inscripcionPK) {
		this.inscripcionPK = inscripcionPK;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (inscripcionPK != null ? inscripcionPK.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Inscripcion)) {
			return false;
		}
		Inscripcion other = (Inscripcion) object;
		if ((this.inscripcionPK == null && other.inscripcionPK != null) || (this.inscripcionPK != null && !this.inscripcionPK.equals(other.inscripcionPK))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ar.org.centro8.curso.java.entities.Inscripcion[ inscripcionPK=" + inscripcionPK + " ]";
	}
	
}
