package co.edu.eam.ingesoft.hospital.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "AFILIACION")
@NamedQueries({
	@NamedQuery(name=Afiliacion.LISTAR,query= "Select c from Afiliacion c")
})
public class Afiliacion implements Serializable {
	
	public static final String LISTAR = "Afiliacion.listaAfi";

	@Id
	@Column(name = "codigo")
	private Integer codigo;
	@Column(name = "nombre", length = 30,nullable = false)
	private String nombre;

	@Column(name = "telefono", length = 30,nullable = false)
	private String telefono;

	//tabla intermedia
	@Column(name = "ServiciosIncluidos", length = 2000, nullable=false)
	private String serviciosIncluidos;
	
	public Afiliacion() {
		super();
	}
	
	public Afiliacion(Integer codigo, String nombre, String telefono, String serviciosIncluidos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.telefono = telefono;
		this.serviciosIncluidos = serviciosIncluidos;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public String getServiciosIncluidos() {
		return serviciosIncluidos;
	}

	public void setServiciosIncluidos(String serviciosIncluidos) {
		this.serviciosIncluidos = serviciosIncluidos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Afiliacion other = (Afiliacion) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	
	
}
