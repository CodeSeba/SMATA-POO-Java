/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.org.centro8.curso.java.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author seba
 */
@Embeddable
public class InscripcionPK implements Serializable {

	@Basic(optional = false)
    @Column(name = "idCurso")
	private int idCurso;
	@Basic(optional = false)
    @Column(name = "idAlumno")
	private int idAlumno;

	public InscripcionPK() {
	}

	public InscripcionPK(int idCurso, int idAlumno) {
		this.idCurso = idCurso;
		this.idAlumno = idAlumno;
	}

	public int getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (int) idCurso;
		hash += (int) idAlumno;
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof InscripcionPK)) {
			return false;
		}
		InscripcionPK other = (InscripcionPK) object;
		if (this.idCurso != other.idCurso) {
			return false;
		}
		if (this.idAlumno != other.idAlumno) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ar.org.centro8.curso.java.entities.InscripcionPK[ idCurso=" + idCurso + ", idAlumno=" + idAlumno + " ]";
	}
	
}
