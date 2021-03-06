package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

public class itemTratamientoPK implements Serializable {
	
	private Integer patologiaCodigo;
	
	private Integer tratamientoCodigo;
	
	public itemTratamientoPK() {
		// TODO Auto-generated constructor stub
	}

	public itemTratamientoPK(Integer patologiaCodigo, Integer tratamientoCodigo) {
		super();
		this.patologiaCodigo = patologiaCodigo;
		this.tratamientoCodigo = tratamientoCodigo;
	}

	
	
	public Integer getPatologiaCodigo() {
		return patologiaCodigo;
	}

	public void setPatologiaCodigo(Integer patologiaCodigo) {
		this.patologiaCodigo = patologiaCodigo;
	}

	public Integer getTratamientoCodigo() {
		return tratamientoCodigo;
	}

	public void setTratamientoCodigo(Integer tratamientoCodigo) {
		this.tratamientoCodigo = tratamientoCodigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((patologiaCodigo == null) ? 0 : patologiaCodigo.hashCode());
		result = prime * result + ((tratamientoCodigo == null) ? 0 : tratamientoCodigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		itemTratamientoPK other = (itemTratamientoPK) obj;
		if (patologiaCodigo == null) {
			if (other.patologiaCodigo != null)
				return false;
		} else if (!patologiaCodigo.equals(other.patologiaCodigo))
			return false;
		if (tratamientoCodigo == null) {
			if (other.tratamientoCodigo != null)
				return false;
		} else if (!tratamientoCodigo.equals(other.tratamientoCodigo))
			return false;
		return true;
	}
	
	

}
